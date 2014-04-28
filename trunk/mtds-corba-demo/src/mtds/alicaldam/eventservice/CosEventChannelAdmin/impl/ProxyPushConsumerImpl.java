package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import org.omg.CORBA.Any;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerPOA;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PushSupplier;

public class ProxyPushConsumerImpl extends ProxyPushConsumerPOA {
	private boolean connected=false;
	EventChannelImpl eventChannel;
	PushSupplier supplier;
	public ProxyPushConsumerImpl(EventChannelImpl eventChannel) {
		this.eventChannel=eventChannel;
	}

	@Override
	public void connect_push_supplier(PushSupplier push_supplier)
			throws AlreadyConnected {
		if (this.supplier!=null){
			throw new AlreadyConnected();
		}
		this.supplier=push_supplier;
		connected=true;
	}

	@Override
	public void push(Any data) throws Disconnected {
		System.out.println("a proxy push consumer: data received!");
		if (!connected){
			throw new Disconnected();
		}
		try {
			eventChannel.supplyEvent(data);
		} catch (InterruptedException e) {
			disconnect_push_consumer();
			throw new Disconnected();
		}

	}

	@Override
	public void disconnect_push_consumer() {

		connected=false;	

		if (eventChannel!=null){
			eventChannel.remove(this);
			eventChannel=null;
		}
	
		if (supplier!=null){
			supplier.disconnect_push_supplier();
			supplier=null;
		}
		
	}

}
