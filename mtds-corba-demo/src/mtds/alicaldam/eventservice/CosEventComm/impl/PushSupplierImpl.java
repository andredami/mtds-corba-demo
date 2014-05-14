package mtds.alicaldam.eventservice.CosEventComm.impl;

import org.omg.CORBA.Any;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PushConsumer;
import mtds.alicaldam.eventservice.CosEventComm.PushSupplierPOA;

public class PushSupplierImpl extends PushSupplierPOA {
	
	private PushConsumer push_consumer;
	private boolean connected=false;
	
	@Override
	public void disconnect_push_supplier() {
		PushConsumer stmp = null;
		synchronized (this) {
			if (!connected) {
				return;
			} else {
				connected = false;
				stmp = push_consumer;
				push_consumer = null;
			}
		}
		if (stmp != null) {
			stmp.disconnect_push_consumer();
		}

	}
	
	public void send(Any data) throws Disconnected{
		PushConsumer ctmp=null;
		synchronized (this) {
			if(connected){
				ctmp=push_consumer;
			}else{
				throw new Disconnected();
			}
		}
		ctmp.push(data);
	}
	
	public void setPushConsumer(PushConsumer push_consumer){
		connected=true;
		this.push_consumer=push_consumer;
		
	}
	

}
