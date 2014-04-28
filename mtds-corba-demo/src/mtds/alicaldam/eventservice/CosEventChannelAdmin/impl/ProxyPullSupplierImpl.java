package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import java.util.LinkedList;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierPOA;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullConsumer;

public class ProxyPullSupplierImpl extends ProxyPullSupplierPOA {

	private boolean disconnected = true;
	private PullConsumer consumer = null;
	private LinkedList<Any> queue = new LinkedList<>();
	private EventChannelImpl eventChannel;
	
	public ProxyPullSupplierImpl(EventChannelImpl ec) {
		this.eventChannel=ec;
	}

	@Override
	public void connect_pull_consumer(PullConsumer pull_consumer)
			throws AlreadyConnected {
		disconnected = false;
		if (consumer != null) {
			throw new AlreadyConnected("a consumer is already connected to this supplier");
		}
		if(pull_consumer!=null){
			this.consumer = pull_consumer;
			eventChannel.add(this);
		} else {
			throw new BAD_PARAM("arg: pull_cosumer is null");
		}
	}

	@Override
	public Any pull() throws Disconnected {
		if (disconnected) {
			throw new Disconnected();
		}
		Any elem;
		synchronized (queue) {
			while (!queue.isEmpty()) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					throw new Disconnected();
				}
			}
			elem = queue.poll();
		}
		return elem;

	}

	@Override
	public Any try_pull(BooleanHolder has_event) throws Disconnected {
		if (disconnected) {
			throw new Disconnected();
		}
		Any elem = null;
		synchronized (queue) {
			if (!queue.isEmpty()) {
				elem = queue.poll();
				has_event.value = true;
			} else {
				has_event.value = false;
			}
		}
		return elem;
	}

	@Override
	public void disconnect_pull_supplier() {
		if (!disconnected) {
			disconnected = true;
			consumer.disconnect_pull_consumer();
			consumer = null;
		}
	}

	public void put(Any a) {
		if (disconnected){return;}
		synchronized (queue) {
			queue.addLast(a);
		}
	}
}
