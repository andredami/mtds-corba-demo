package mtds.alicaldam.eventservice.CosEventComm.impl;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullConsumer;
import mtds.alicaldam.eventservice.CosEventComm.PullSupplierPOA;

public class PullSupplierImpl extends PullSupplierPOA {

	private LinkedList<Any> queue = new LinkedList<Any>();
	boolean connected = true;
	PullConsumer pull_consumer;

	@Override
	public Any pull() throws Disconnected {
		if (!connected) {
			throw new Disconnected();
		}
		Any data = null;
		try {
			synchronized (queue) {
				while (queue.isEmpty() && connected) {
					queue.wait();
				}
				data = queue.poll();
			}

		} catch (InterruptedException e) {
			throw new Disconnected();
		}

		if (data == null) {
			throw new Disconnected();
		}

		return data;
	}

	@Override
	public Any try_pull(BooleanHolder has_event) throws Disconnected {
		if (!connected) {
			throw new Disconnected();
		}
		Any data = null;
		synchronized (queue) {
			data = queue.poll();
		}
		if (data == null) {
			has_event.value = false;
			data = _orb().create_any();
		} else {
			has_event.value = true;
		}
		return data;
	}

	@Override
	public void disconnect_pull_supplier() {
		PullConsumer stmp = null;
		synchronized (this) {
			if (!connected) {
				return;
			} else {
				connected = false;
				stmp = pull_consumer;
				pull_consumer = null;
			}
		}
		if (stmp != null) {
			stmp.disconnect_pull_consumer();
		}
		synchronized (queue) {
			queue.notifyAll();
		}
		System.out.println("PullSupplierImpl: disconnected");
	}

	public void setPullConsumer(PullConsumer consumer) {
		pull_consumer = consumer;
	}

	public void send(Any data) throws Disconnected {
		if (connected) {
			synchronized (queue) {
				queue.add(data);
				queue.notifyAll();
			}
		} else {
			throw new Disconnected();
		}
	}

}
