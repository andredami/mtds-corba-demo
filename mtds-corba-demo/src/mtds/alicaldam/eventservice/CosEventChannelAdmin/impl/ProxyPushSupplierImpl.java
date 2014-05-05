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
import mtds.alicaldam.eventservice.CosEventComm.PushSupplier;

public class ProxyPushSupplierImpl extends ProxyPushSupplierPOA {
	private boolean connected = false;
	private EventChannelImpl eventChannel;
	private PushConsumer push_consumer;
	private LinkedBlockingQueue<Any> queue = new LinkedBlockingQueue<Any>();
	private Thread pusherThread;
	private Runnable pusherRunnable = new Runnable() {

		@Override
		public void run() {
			try {
				while (connected) {
					Any data = null;
					data = queue.take();
					if (data != null) {
						System.out.println("A proxy push supplier: sending data!");
						push_consumer.push(data);
					}
				}
			} catch (InterruptedException e) {

			} catch (Disconnected e) {

			}

		}
	};

	public ProxyPushSupplierImpl(EventChannelImpl eventChannel) {
		this.eventChannel = eventChannel;
	}

	@Override
	public void connect_push_consumer(PushConsumer push_consumer)
			throws AlreadyConnected, TypeError {
		synchronized (this) {
			if (connected) {
				throw new AlreadyConnected();
			} else {
				eventChannel.add(this);
				this.push_consumer = push_consumer;
				connected = true;
				pusherThread = new Thread(pusherRunnable);
			}
		}

		pusherThread.start();
	}

	@Override
	public void disconnect_push_supplier() {
		PushConsumer stmp = null;
		synchronized (this) {
			if (!connected) {
				return;
			} else {
				connected = false;
				eventChannel.remove(this);
				stmp = push_consumer;
				push_consumer = null;
				pusherThread.interrupt();
			}
		}
		if (stmp != null) {
			stmp.disconnect_push_consumer();
		}

	}

	public void put(Any data) {
		if (!connected) {
			return;
		}
		System.out.println("A proxy push supplier: new data in the queue!");
		queue.add(data);
	}

}
