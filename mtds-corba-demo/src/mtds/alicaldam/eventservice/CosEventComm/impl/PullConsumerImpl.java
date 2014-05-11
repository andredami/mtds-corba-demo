package mtds.alicaldam.eventservice.CosEventComm.impl;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullConsumerPOA;
import mtds.alicaldam.eventservice.CosEventComm.PullSupplier;

public class PullConsumerImpl extends PullConsumerPOA {
	private static final int POLLING_INTERVAL_MILLIS = 1000;
	private LinkedList<Any> queue=new LinkedList<Any>(); 
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
							synchronized (queue) {
								queue.add(event);
								queue.notifyAll();
							}
							
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
		synchronized (queue) {
			queue.notifyAll();
		}
	}

	public void setPullSupplier(PullSupplier supplier) {
		this.supplier = supplier;
	}
	
	public void init(){
		t=new Thread(pullThread);
		t.start();
		
	}

	public Any read() throws InterruptedException,Disconnected {
		synchronized(queue){
			while (queue.isEmpty() && connected) {
				queue.wait();
			}
		}
		Any data= queue.poll();
		if(data==null){
			throw new Disconnected();
		}else{
			return data;
		}
	}
}
