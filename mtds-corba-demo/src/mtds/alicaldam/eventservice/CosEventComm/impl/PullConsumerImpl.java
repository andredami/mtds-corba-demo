package mtds.alicaldam.eventservice.CosEventComm.impl;

import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullConsumerPOA;
import mtds.alicaldam.eventservice.CosEventComm.PullSupplier;

public class PullConsumerImpl extends PullConsumerPOA {
	private static final int POLLING_INTERVAL_MILLIS = 1000;
	private LinkedBlockingQueue<Any> queue=new LinkedBlockingQueue<Any>(); 
	boolean connected = true;
	private PullSupplier supplier;
	private Thread t;
	private Runnable pullThread = new Runnable() {

		@Override
		public void run() {
			try {
				while (connected) {
					PullSupplier stmp = null;
					synchronized (this) {
						if (connected)
							stmp = supplier;
					}

					if (stmp != null) {
						BooleanHolder has_event = new BooleanHolder(false);
						Any event = stmp.try_pull(has_event);
						if (has_event.value == true) {
							queue.add(event);
						} else {
							Thread.sleep(POLLING_INTERVAL_MILLIS);
						}
					}
				}
			} catch (Disconnected | InterruptedException e) {
				disconnect_pull_consumer();
			}
		}
	};

	public PullConsumerImpl() {
		
	}

	@Override
	public void disconnect_pull_consumer() {
		PullSupplier sTmp = null;

		synchronized (this) {
			if (connected) {
				connected = false;
				sTmp = supplier;
				supplier = null;
				t.interrupt();
			}else{
				return;
			}
		}
		if (sTmp != null) {
			sTmp.disconnect_pull_supplier();
		}

	}

	public void setPullSupplier(PullSupplier supplier) {
		this.supplier = supplier;
	}
	
	public void init(){
		t=new Thread(pullThread);
		t.start();
		
	}

	public Any read() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
