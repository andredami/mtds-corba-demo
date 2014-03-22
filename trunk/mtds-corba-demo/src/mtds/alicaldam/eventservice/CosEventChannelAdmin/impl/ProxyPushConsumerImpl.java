package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import org.omg.CORBA.Any;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerPOA;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PushSupplier;

public class ProxyPushConsumerImpl extends ProxyPushConsumerPOA {

	public ProxyPushConsumerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect_push_supplier(PushSupplier push_supplier)
			throws AlreadyConnected {
		// TODO Auto-generated method stub

	}

	@Override
	public void push(Any data) throws Disconnected {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnect_push_consumer() {
		// TODO Auto-generated method stub

	}

}
