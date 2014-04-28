package mtds.alicaldam.eventservice.CosEventComm.impl;

import org.omg.CORBA.Any;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PushConsumer;
import mtds.alicaldam.eventservice.CosEventComm.PushSupplierPOA;

public class PushSupplierImpl extends PushSupplierPOA {
	
	private PushConsumer push_consumer;
	private boolean connected=true;
	
	@Override
	public void disconnect_push_supplier() {
		connected=false;
		if(push_consumer!=null){
			push_consumer.disconnect_push_consumer();
			push_consumer=null;
		}

	}
	
	public void send(Any data) throws Disconnected{
		if(connected&&push_consumer!=null){
			try{
				push_consumer.push(data);
			}catch(Disconnected e){
				connected=false;
				push_consumer=null;
			}
		}
	}
	
	public void setPushConsumer(PushConsumer push_consumer){
		this.push_consumer=push_consumer;
	}
	

}
