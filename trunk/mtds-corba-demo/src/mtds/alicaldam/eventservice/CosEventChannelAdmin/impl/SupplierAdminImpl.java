package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerHelper;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerHelper;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminPOA;

public class SupplierAdminImpl extends SupplierAdminPOA {
	EventChannelImpl eventChannel;
	private ORB orb;

	public SupplierAdminImpl() {
		// TODO Auto-generated constructor stub
	}

	public SupplierAdminImpl(EventChannelImpl ec) {
		
		this.eventChannel = ec;
	}

	@Override
	public ProxyPushConsumer obtain_push_consumer() {
		ProxyPushConsumerImpl proxy_push_consumer = new ProxyPushConsumerImpl(
				eventChannel);
		org.omg.CORBA.Object refProxyPushConsumer=null;
		try {
			refProxyPushConsumer = _poa()
					.servant_to_reference(proxy_push_consumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ProxyPushConsumerHelper.narrow(refProxyPushConsumer);
	}

	@Override
	public ProxyPullConsumer obtain_pull_consumer() {
		ProxyPullConsumerImpl proxy_pull_consumer = new ProxyPullConsumerImpl(
				eventChannel);
		org.omg.CORBA.Object refProxyPullConsumer=null;
		try {
			refProxyPullConsumer = _poa()
					.servant_to_reference(proxy_pull_consumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ProxyPullConsumerHelper.narrow(refProxyPullConsumer);
	}

}
