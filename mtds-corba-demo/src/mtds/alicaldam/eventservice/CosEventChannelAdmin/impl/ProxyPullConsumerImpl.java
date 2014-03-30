package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerPOA;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError;
import mtds.alicaldam.eventservice.CosEventComm.PullSupplier;

public class ProxyPullConsumerImpl extends ProxyPullConsumerPOA {
	EventChannelImpl eventChannel;
	private boolean disconnected = true;
	private PullSupplier supplier=null;
	
	public ProxyPullConsumerImpl(EventChannelImpl eventChannel) {
		this.eventChannel=eventChannel;
	}

	@Override
	public void connect_pull_supplier(PullSupplier pull_supplier)
			throws AlreadyConnected, TypeError {
		if(supplier!=null){
			throw new AlreadyConnected();
		}
		supplier=pull_supplier;
		disconnected=false;
		eventChannel.add(this);

	}

	@Override
	public void disconnect_pull_consumer() {
		if(disconnected){
			return;
		}
		
		disconnected=true;
		eventChannel.remove(this);
		
		if(supplier!=null){
			supplier.disconnect_pull_supplier();
			supplier=null;
		}
		
		
	}

}
