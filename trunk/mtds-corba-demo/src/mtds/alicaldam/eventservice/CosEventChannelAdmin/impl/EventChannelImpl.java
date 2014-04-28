package mtds.alicaldam.eventservice.CosEventChannelAdmin.impl;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminHelper;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelPOA;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminHelper;
import mtds.alicaldam.eventservice.CosEventComm.impl.PushSupplierImpl;

public class EventChannelImpl extends EventChannelPOA {
	
	private boolean destroyed = false;
	private ConsumerAdmin consumer_admin;
	private SupplierAdmin supplier_admin;

	private LinkedBlockingQueue<Any> eventsQueue = new LinkedBlockingQueue<>();

	private ArrayList<ProxyPullSupplierImpl> pull_suppliers = new ArrayList<ProxyPullSupplierImpl>();
	private ArrayList<ProxyPushSupplierImpl> push_suppliers = new ArrayList<ProxyPushSupplierImpl>();

	private ArrayList<ProxyPullConsumerImpl> pull_consumers = new ArrayList<ProxyPullConsumerImpl>();
	private ArrayList<ProxyPushConsumerImpl> push_consumers = new ArrayList<ProxyPushConsumerImpl>();

	private ExecutorService executorService = Executors.newCachedThreadPool();

	private Runnable dispatcher = new Runnable() {

		@Override
		public void run() {
			while (!destroyed) {
				try {
					Any data = eventsQueue.take();
					System.out.println("EventChannel dispatch thread is dispatching...");
					
					ArrayList<ProxyPullSupplierImpl> pull_suppliers_tmp;
					synchronized (pull_suppliers) {
						pull_suppliers_tmp = (ArrayList<ProxyPullSupplierImpl>) pull_suppliers
								.clone();
					}
					for (ProxyPullSupplierImpl ppulli : pull_suppliers_tmp = new ArrayList<ProxyPullSupplierImpl>(
							pull_suppliers_tmp)) {
						ppulli.put(data);
					}
					
					ArrayList<ProxyPushSupplierImpl> push_suppliers_tmp;
					synchronized (push_suppliers) {
						push_suppliers_tmp = (ArrayList<ProxyPushSupplierImpl>) push_suppliers.clone();
					}
					for (ProxyPushSupplierImpl ppushi : push_suppliers_tmp) {
						ppushi.put(data);
					}
				} catch (InterruptedException e) {
					// TODO
				}

			}

		}
	};
	private Thread t;

	public EventChannelImpl() throws Exception, WrongPolicy {
		super();
	}
	
	public void init() throws ServantNotActive, WrongPolicy{
		this.consumer_admin = ConsumerAdminHelper.narrow(_poa().servant_to_reference(new ConsumerAdminImpl(this)));
		this.supplier_admin = SupplierAdminHelper.narrow(_poa().servant_to_reference(new SupplierAdminImpl(this)));
		t=new Thread(dispatcher);
		t.run();
	}

	@Override
	public ConsumerAdmin for_consumers() {
		if (destroyed) {
			return null;
		}
		return consumer_admin;
	}

	@Override
	public SupplierAdmin for_suppliers() {
		if (destroyed) {
			return null;
		}
		return supplier_admin;
	}

	@Override
	public void destroy() {
		destroyed = true;
		t.interrupt();
	}

	public void supplyEvent(Any data) throws InterruptedException {
		
		eventsQueue.put(data);
		System.out.println("EventChannel: eventsQueue.put(data)");

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

	public void remove(ProxyPullSupplierImpl proxyPullSupplierImpl) {
		synchronized (pull_suppliers) {
			pull_suppliers.remove(proxyPullSupplierImpl);
		}
	}

	public void add(ProxyPushSupplierImpl proxyPushSupplierImpl) {
		synchronized (push_suppliers) {
			if (destroyed)
				return;
			push_suppliers.add(proxyPushSupplierImpl);
		}

	}

	public void add(ProxyPushConsumerImpl proxyPushConsumerImpl) {
		synchronized (push_consumers) {
			if (destroyed)
				return;
			push_consumers.add(proxyPushConsumerImpl);
		}
	}

	public void add(ProxyPullConsumerImpl proxyPullConsumerImpl) {
		synchronized (pull_consumers) {
			if (destroyed)
				return;
			pull_consumers.add(proxyPullConsumerImpl);
		}

	}

	public void add(ProxyPullSupplierImpl proxyPullSupplierImpl) {
		synchronized (pull_suppliers) {
			if (destroyed)
				return;
			pull_suppliers.add(proxyPullSupplierImpl);
		}

	}

}
