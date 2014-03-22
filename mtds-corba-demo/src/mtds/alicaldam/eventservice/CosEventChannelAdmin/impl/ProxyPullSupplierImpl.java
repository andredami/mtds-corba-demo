package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierPOA;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullConsumer;

public class ProxyPullSupplierImpl extends ProxyPullSupplierPOA {

	public ProxyPullSupplierImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect_pull_consumer(PullConsumer pull_consumer)
			throws AlreadyConnected {
		// TODO Auto-generated method stub

	}

	@Override
	public Any pull() throws Disconnected {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Any try_pull(BooleanHolder has_event) throws Disconnected {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disconnect_pull_supplier() {
		// TODO Auto-generated method stub

	}

}
