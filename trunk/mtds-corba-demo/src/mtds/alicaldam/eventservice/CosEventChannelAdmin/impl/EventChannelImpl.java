package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.Any;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelPOA;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin;

public class EventChannelImpl extends EventChannelPOA {
	private boolean destroyed = false;
	private ConsumerAdminImpl consumer_admin;
	private SupplierAdminImpl supplier_admin;

	private LinkedBlockingQueue<Any> eventsQueue = new LinkedBlockingQueue<>();
	
	private ArrayList<ProxyPullSupplierImpl> pull_suppliers = new ArrayList<ProxyPullSupplierImpl>();
	private ArrayList<ProxyPushSupplierImpl> push_suppliers=new ArrayList<ProxyPushSupplierImpl>();

	private ArrayList<ProxyPullConsumerImpl> pull_consumers = new ArrayList<ProxyPullConsumerImpl>();
	private ArrayList<ProxyPushConsumerImpl> push_consumers = new ArrayList<ProxyPushConsumerImpl>();
	
	private ExecutorService executorService= Executors.newCachedThreadPool();
	
	private Runnable dispatcher = new Runnable() {

		@Override
		public void run() {
			while (true) {
				try {
					Any data = eventsQueue.take();
					ArrayList<ProxyPullSupplierImpl> pull_suppliers_tmp;
					synchronized (pull_suppliers) {
						pull_suppliers_tmp = (ArrayList<ProxyPullSupplierImpl>) pull_suppliers.clone();
					}
					for (ProxyPullSupplierImpl ppi : pull_suppliers_tmp = new ArrayList<ProxyPullSupplierImpl>(
							pull_suppliers_tmp)) {
						ppi.put(data);
					}
					ArrayList<ProxyPushSupplierImpl> push_suppliers_tmp;
					synchronized (push_suppliers) {
						push_suppliers_tmp = (ArrayList<ProxyPushSupplierImpl>) push_suppliers.clone();
					}
					for (ProxyPushSupplierImpl ppi : push_suppliers_tmp ) {
						ppi.put(data);
					}
				} catch (InterruptedException e) {
					// TODO
				}

			}

		}
	};

	public EventChannelImpl() {
		this.consumer_admin = new ConsumerAdminImpl(this);
		this.supplier_admin = new SupplierAdminImpl(this);
	}

	@Override
	public ConsumerAdmin for_consumers() {
		if (destroyed) {
			return null;
		}
		return (ConsumerAdmin) consumer_admin;
	}

	@Override
	public SupplierAdmin for_suppliers() {
		if (destroyed) {
			return null;
		}
		return (SupplierAdmin) supplier_admin;
	}

	@Override
	public void destroy() {
		destroyed=true;
	}

	public void supplyEvent(Any data) throws InterruptedException {

		eventsQueue.put(data);

	}

	protected void remove(ProxyPullConsumerImpl proxyPullConsumerImpl) {
		synchronized (pull_consumers) {
			pull_consumers.remove(proxyPullConsumerImpl);
		}

	}

	public void remove(ProxyPushConsumerImpl proxyPushConsumerImpl) {
		synchronized (push_consumers) {
			push_consumers.remove(proxyPushConsumerImpl);
		}

	}

	public void remove(ProxyPushSupplierImpl proxyPushSupplierImpl) {
		synchronized (push_suppliers) {
			push_suppliers.remove(proxyPushSupplierImpl);
		}

	}
	
	public void remove( ProxyPullSupplierImpl proxyPullSupplierImpl){
		synchronized (pull_suppliers) {
			pull_suppliers.remove(proxyPullSupplierImpl);
		}
	}

	public void add(ProxyPushSupplierImpl proxyPushSupplierImpl) {
		synchronized (push_suppliers) {
			if (destroyed) return;
			push_suppliers.add(proxyPushSupplierImpl);
		}

	}

	public void add(ProxyPushConsumerImpl proxyPushConsumerImpl) {
		synchronized (push_consumers) {
			if (destroyed) return;
			push_consumers.add(proxyPushConsumerImpl);
		}
	}

	public void add(ProxyPullConsumerImpl proxyPullConsumerImpl) {
		synchronized (pull_consumers) {
			if (destroyed) return;
			pull_consumers.add(proxyPullConsumerImpl);
		}

	}

	public void add(ProxyPullSupplierImpl proxyPullSupplierImpl) {
		synchronized (pull_suppliers) {
			if (destroyed) return;
			pull_suppliers.add(proxyPullSupplierImpl);
		}

	}

}
