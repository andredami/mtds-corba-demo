package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import org.omg.CORBA.Any;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerPOA;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PushSupplier;

public class ProxyPushConsumerImpl extends ProxyPushConsumerPOA {
	private boolean connected = false;
	EventChannelImpl eventChannel;
	PushSupplier supplier;

	public ProxyPushConsumerImpl(EventChannelImpl eventChannel) {
		this.eventChannel = eventChannel;
	}

	@Override
	public void connect_push_supplier(PushSupplier push_supplier)
			throws AlreadyConnected {
		synchronized (this) {
			if (!connected) {
				if (eventChannel != null) {
					this.supplier = push_supplier;
					connected = true;
				}else{
					throw new OBJECT_NOT_EXIST();
				}
			} else {
				throw new AlreadyConnected();
			}
		}
	}

	@Override
	public void push(Any data) throws Disconnected {
		System.out.println("a proxy push consumer: data received!");
		EventChannelImpl eventChannelTmp = null;
		synchronized (this) {
			if (!connected) {
				throw new Disconnected();
			}
			eventChannelTmp = eventChannel;
		}
		try {
			eventChannelTmp.supplyEvent(data);
		} catch (InterruptedException e1) {
			disconnect_push_consumer();
			throw new Disconnected();
		}
	}

	@Override
	public void disconnect_push_consumer() {
		EventChannelImpl ecTmp = null;
		PushSupplier sTmp = null;

		synchronized (this) {
			connected = false;
			if (eventChannel != null) {
				eventChannel.remove(this);// TODO think about moving it in tmp
											// like supplier
				eventChannel = null;
			}
			if (supplier != null) {
				sTmp = supplier;
				supplier = null;
			}
		}
		if (sTmp != null) {
			sTmp.disconnect_push_supplier();
		}

	}

}
