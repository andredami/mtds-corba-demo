package mtds.alicaldam.eventservice.CosEventComm.impl;

import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullConsumer;
import mtds.alicaldam.eventservice.CosEventComm.PullSupplierPOA;

public class PullSupplierImpl extends PullSupplierPOA {
	
	LinkedBlockingQueue<Any> queue=new LinkedBlockingQueue<Any>();
	boolean connected=true;
	PullConsumer pull_consumer;
	
	@Override
	public Any pull() throws Disconnected {
		if(!connected){
			throw new Disconnected();
		}
		Any data=null;
		try {
			data =  queue.take();
		} catch (InterruptedException e) {
			throw new Disconnected();
		}
		
		return data;
	}

	@Override
	public Any try_pull(BooleanHolder has_event) throws Disconnected {
		Any data=queue.poll();
		if(data==null){
			has_event.value=false;
			data=_orb().create_any();
		}else{
			has_event.value=true;
		}
		return data;
	}

	@Override
	public void disconnect_pull_supplier() {
		connected=false;
		if (pull_consumer!=null){
			pull_consumer.disconnect_pull_consumer();
			pull_consumer=null;
		}

	}
	
	public void setPullConsumer(PullConsumer consumer){
		pull_consumer=consumer;
	}
	
	public void send(Any data) throws Disconnected {
		if(connected){
			queue.add(data);
		}else{
			throw new Disconnected();
		}
	}

}
