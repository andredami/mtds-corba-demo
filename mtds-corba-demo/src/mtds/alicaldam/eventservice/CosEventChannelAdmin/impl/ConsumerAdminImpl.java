package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminPOA;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierHelper;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplierHelper;

public class ConsumerAdminImpl extends ConsumerAdminPOA {
	EventChannelImpl eventChannel;
	private ORB orb;

	public ConsumerAdminImpl() {
		// TODO Auto-generated constructor stub
	}

	public ConsumerAdminImpl(EventChannelImpl eventChannelImpl) {;
		
		this.eventChannel = eventChannelImpl;
	}

	@Override
	public ProxyPushSupplier obtain_push_supplier() {
		ProxyPushSupplierImpl proxy_push_supplier = new ProxyPushSupplierImpl(
				eventChannel);
		org.omg.CORBA.Object refProxyPushSupplier=null;
		try {
			refProxyPushSupplier = _poa()
					.servant_to_reference(proxy_push_supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ProxyPushSupplierHelper.narrow(refProxyPushSupplier);
	}

	@Override
	public ProxyPullSupplier obtain_pull_supplier() {
		ProxyPullSupplierImpl proxy_pull_supplier = new ProxyPullSupplierImpl(
				eventChannel);
		org.omg.CORBA.Object refConsumerAdmin=null;
		try {
			refConsumerAdmin = _poa()
					.servant_to_reference(proxy_pull_supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ProxyPullSupplierHelper.narrow(refConsumerAdmin);
	}

}
