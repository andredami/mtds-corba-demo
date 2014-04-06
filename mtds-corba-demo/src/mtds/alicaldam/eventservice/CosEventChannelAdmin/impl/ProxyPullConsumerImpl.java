package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerPOA;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullSupplier;

public class ProxyPullConsumerImpl extends ProxyPullConsumerPOA {
	private static final int POLLING_INTERVAL_MILLIS = 1000;
	EventChannelImpl eventChannel;
	private boolean disconnected = true;
	private PullSupplier supplier=null;
	
	public ProxyPullConsumerImpl(EventChannelImpl eventChannel) {
		this.eventChannel=eventChannel;
	}

	@Override
	public void connect_pull_supplier(PullSupplier pull_supplier)
			throws AlreadyConnected, TypeError {
		if(supplier!=null){
			throw new AlreadyConnected();
		}
		supplier=pull_supplier;
		disconnected=false;
		eventChannel.add(this);
		t=new Thread(pullThread);
		t.start();
		
	}
	
	private Thread t;
	private Runnable pullThread = new Runnable() {
		
		@Override
		public void run() {
			BooleanHolder has_event=new BooleanHolder(false);
			while(!disconnected){
				try {
					Any event=supplier.try_pull(has_event);
					if(has_event.value==true){
						eventChannel.supplyEvent(event);
					}else{
						Thread.sleep(POLLING_INTERVAL_MILLIS);
					}
				} catch (Disconnected | InterruptedException e) {
					disconnect_pull_consumer();
				}
				
			}
			
		}
	};

	@Override
	public void disconnect_pull_consumer() {
		if(disconnected){
			return;
		}
		
		disconnected=true;
		eventChannel.remove(this);
		
		if(supplier!=null){
			supplier.disconnect_pull_supplier();
			supplier=null;
		}
	}

}
