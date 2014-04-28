package mtds.alicaldam.eventservice.CosEventComm.impl;

import java.util.LinkedList;
import org.omg.CORBA.Any;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PushConsumerPOA;
import mtds.alicaldam.eventservice.CosEventComm.PushSupplier;

public class PushConsumerImpl extends PushConsumerPOA {

	private PushSupplier push_supplier;
	private LinkedList<Any> queue=new LinkedList<Any>();
	private boolean connected=true;
	
	@Override
	public synchronized void push(Any data) throws Disconnected {
		if(!connected){
			push_supplier=null;
			throw new Disconnected();
		}
		queue.add(data);
		notifyAll();
	}

	@Override
	public void disconnect_push_consumer() {
		
		if(push_supplier!=null&&connected){
			PushSupplier tmp=push_supplier;
			synchronized (this) {
				connected=false;
				push_supplier=null;
				notifyAll();
			}
			tmp.disconnect_push_supplier();
		}
	}
	
	public synchronized Any read() throws InterruptedException{
		while (queue.isEmpty()&&connected){
			wait();
		}
		return queue.poll();
	}
	
	public boolean isConnected(){
		return connected;
	}
	
	public void setPushSupplier(PushSupplier push_supplier){
		this.push_supplier=push_supplier;
	}
	

}
