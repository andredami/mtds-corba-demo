package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplierPOA;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PushConsumer;

public class ProxyPushSupplierImpl extends ProxyPushSupplierPOA {
	private boolean connected = false;
	private EventChannelImpl eventChannel;
	private PushConsumer push_consumer;
	private LinkedBlockingQueue<Any> queue = new LinkedBlockingQueue<Any>();
	private Thread pusherThread;
	private Runnable pusherRunnable= new Runnable() {
		
		@Override
		public void run() {
			while(connected){
				Any data;
				try {
					data = queue.poll(1, TimeUnit.SECONDS);
					if(data!=null){
						System.out.println("A proxy push supplier: sending data!");
						push_consumer.push(data);
					}
				} catch (InterruptedException  e) {
				
				} catch (Disconnected e) {
					connected=false;
					push_consumer=null;
				}
			}
			
		}
	};

	public ProxyPushSupplierImpl(EventChannelImpl eventChannel) {
		this.eventChannel = eventChannel;
	}

	@Override
	public void connect_push_consumer(PushConsumer push_consumer)
			throws AlreadyConnected, TypeError {
		
		if (this.push_consumer != null) {
			throw new AlreadyConnected();
		}
		
		if(push_consumer!=null){
			connected=true;
			eventChannel.add(this);
			this.push_consumer = push_consumer;
			pusherThread=new Thread(pusherRunnable);
			pusherThread.start();
		}else{
			throw new BAD_PARAM("arg push_consumer is null");
		}
	}

	@Override
	public void disconnect_push_supplier() {
		if (!connected) {
			return;
		}
		connected=false;
		eventChannel.remove(this);
		if (push_consumer!=null){
			push_consumer.disconnect_push_consumer();
			push_consumer=null;
		}
		pusherThread.interrupt();
	}

	public void put(Any data) {
		if (!connected){
			return;
		}
		System.out.println("A proxy push supplier: new data in the queue!");
		queue.add(data);
	}

}
