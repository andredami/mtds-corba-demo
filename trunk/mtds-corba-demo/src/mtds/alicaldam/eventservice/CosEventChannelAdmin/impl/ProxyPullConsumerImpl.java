package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerPOA;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullSupplier;
import mtds.alicaldam.eventservice.CosEventComm.PushSupplier;

public class ProxyPullConsumerImpl extends ProxyPullConsumerPOA {
	private static final int POLLING_INTERVAL_MILLIS = 1000;
	EventChannelImpl eventChannel;
	private boolean connected = false;
	private PullSupplier supplier=null;
	
	public ProxyPullConsumerImpl(EventChannelImpl eventChannel) {
		this.eventChannel=eventChannel;
	}

	@Override
	public void connect_pull_supplier(PullSupplier pull_supplier)
			throws AlreadyConnected, TypeError {		
		synchronized (this) {
			if (connected) {
				throw new AlreadyConnected();
			} else {
				eventChannel.add(this);
				this.supplier = pull_supplier;
				connected = true;
				pullerThread = new Thread(pullRunnable);
			}
		}

		pullerThread.start();
		
	}
	
	private Thread pullerThread;
	private Runnable pullRunnable = new Runnable() {
		
		@Override
		public void run() {
			BooleanHolder has_event=new BooleanHolder(false);
			while(connected){
				try {
					Any event=supplier.try_pull(has_event);
					if(has_event.value==true){
						eventChannel.supplyEvent(event);
					}else{
						Thread.sleep(POLLING_INTERVAL_MILLIS);
					}
				} catch (Disconnected | InterruptedException e) {
					
				}
				
			}
			
		}
	};

	@Override
	public void disconnect_pull_consumer() {
		PullSupplier sTmp = null;

		synchronized (this) {
			if(connected){
				connected = false;
				eventChannel.remove(this);// TODO think about moving it in tmp
				sTmp = supplier;
				supplier = null;
				pullerThread.interrupt();
			}
		}
		if (sTmp != null) {
			sTmp.disconnect_pull_supplier();
		}

	}

}
