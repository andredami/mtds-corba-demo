package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import java.util.LinkedList;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierPOA;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullConsumer;
import mtds.alicaldam.eventservice.CosEventComm.PushConsumer;

public class ProxyPullSupplierImpl extends ProxyPullSupplierPOA {

	private boolean connected = false;
	private PullConsumer consumer = null;
	private LinkedList<Any> queue = new LinkedList<>();
	private EventChannelImpl eventChannel;

	public ProxyPullSupplierImpl(EventChannelImpl ec) {
		this.eventChannel = ec;
	}

	@Override
	public void connect_pull_consumer(PullConsumer pull_consumer)
			throws AlreadyConnected {
		synchronized (this) {
			if (connected) {
				throw new AlreadyConnected();
			} else {
				eventChannel.add(this);
				this.consumer = pull_consumer;
				connected = true;
			}
		}

	}

	

	@Override
	public void disconnect_pull_supplier() {
		PullConsumer stmp = null;
		synchronized (this) {
			if (!connected) {
				return;
			} else {
				connected = false;
				eventChannel.remove(this);
				stmp = consumer;
				consumer = null;
			}
		}
		if (stmp != null) {
			stmp.disconnect_pull_consumer();
		}
	}

	@Override
	public Any pull() throws Disconnected {
		if (!connected) {
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
		if (!connected) {
			throw new Disconnected();
		}
		Any elem = null;
		synchronized (queue) {
			if (!queue.isEmpty()) {
				elem = queue.poll();
				has_event.value = true;
			} else {
				has_event.value = false;
				elem = _orb().create_any();
			}
		}
		return elem;
	}
	
	public void put(Any a) {
		if (!connected) {
			return;
		}
		synchronized (queue) {
			queue.addLast(a);
		}
	}
}
