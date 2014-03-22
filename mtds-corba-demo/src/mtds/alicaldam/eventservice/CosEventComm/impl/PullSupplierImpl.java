package mtds.alicaldam.eventservice.CosEventComm.impl;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullSupplierPOA;

public class PullSupplierImpl extends PullSupplierPOA {

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
