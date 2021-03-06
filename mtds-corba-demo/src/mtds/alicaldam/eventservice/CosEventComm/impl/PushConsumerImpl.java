package mtds.alicaldam.eventservice.CosEventComm.impl;

import java.util.LinkedList;
import org.omg.CORBA.Any;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PushConsumerPOA;
import mtds.alicaldam.eventservice.CosEventComm.PushSupplier;

public class PushConsumerImpl extends PushConsumerPOA {

	private PushSupplier push_supplier;
	private LinkedList<Any> queue = new LinkedList<Any>();
	private boolean connected = false;

	@Override
	public synchronized void push(Any data) throws Disconnected {
		if (!connected) {
			throw new Disconnected();
		}
		synchronized (queue) {
			queue.add(data);
			queue.notifyAll();	
		}
	}

	@Override
	public void disconnect_push_consumer() {

		PushSupplier sTmp = null;
		synchronized (this) {
			if (connected) {
				connected = false;
				sTmp = push_supplier;
				push_supplier = null;
			}
		}
		if (sTmp != null) {
			sTmp.disconnect_push_supplier();
		}
		synchronized (queue) {
			queue.notifyAll();
		}
		
	}

	public Any read() throws InterruptedException, Disconnected {
		synchronized (queue) {
			while (queue.isEmpty() && connected) {
				queue.wait();
			}
		}
		Any data = queue.poll();
		if (data == null) {
			throw new Disconnected();
		} else {
			return data;
		}
	}

	public boolean isConnected() {
		return connected;
	}

	public void setPushSupplier(PushSupplier push_supplier) {
		connected = true;
		this.push_supplier = push_supplier;
	}

}
