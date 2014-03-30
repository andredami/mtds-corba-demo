package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminPOA;

public class SupplierAdminImpl extends SupplierAdminPOA {
	
	EventChannelImpl eventChannel;
	
	public SupplierAdminImpl() {
		// TODO Auto-generated constructor stub
	}

	public SupplierAdminImpl(EventChannelImpl ec) {
		this.eventChannel=ec;
	}

	@Override
	public ProxyPushConsumer obtain_push_consumer() {
		ProxyPushConsumerImpl proxy_push_consumer=new ProxyPushConsumerImpl(eventChannel);
		eventChannel.add(proxy_push_consumer);
		return (ProxyPushConsumer) proxy_push_consumer;
	}

	@Override
	public ProxyPullConsumer obtain_pull_consumer() {
		// TODO Auto-generated method stub
		return null;
	}

}
