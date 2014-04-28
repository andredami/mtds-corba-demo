package mtds.alicaldam.corba.eventservice.clients;

import java.util.Scanner;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelHelper;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier;
import mtds.alicaldam.eventservice.CosEventComm.impl.PullConsumerImpl;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Data.Event;
import Data.EventHelper;

public class PullConsumerClient {
	public static final String ADDRESS = "localhost";

	public static void main(String args[]){
		
		try{

			ORB orb = ORB.init(args,null);

			//create the remote pull consumer
			final PullConsumerImpl pull_consumer_impl=new PullConsumerImpl();
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(pull_consumer_impl);

			//take a ref to the event channel
			org.omg.CORBA.Object sRef = orb.string_to_object("corbaname::"+ADDRESS+"::1050#DemoChannel");
			EventChannel event_channel = EventChannelHelper.narrow(sRef);
						
			//connect consumer and supplier
			ConsumerAdmin consumerAdmin=event_channel.for_consumers();
			ProxyPullSupplier proxy_pull_supplier=consumerAdmin.obtain_pull_supplier();
			pull_consumer_impl.setPullSupplier(proxy_pull_supplier);
			proxy_pull_supplier.connect_pull_consumer(pull_consumer_impl._this());
			
			//TODO: receive and print data 
			Runnable r=new Runnable(){
				public void run(){
					
					try{
					while(true){
						Event data=readDataFromSupplier(pull_consumer_impl);
					}
					}catch(Exception e){
						e.printStackTrace();
					}			
				}
			};
			
			Thread t=new Thread(r);
			t.setDaemon(true);
			t.start();
			Scanner scanner= new Scanner(System.in);
			while(!scanner.nextLine().equalsIgnoreCase("q")){
			}
			System.out.println("Disconnecting supplier...");
			pull_consumer_impl.disconnect_pull_consumer();
			scanner.close();
			System.out.println("EXIT OK");	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Event readDataFromSupplier(final PullConsumerImpl push_consumer_impl)
			throws InterruptedException {
		System.out.println("Waiting for new data...");
		Any data = push_consumer_impl.read();
		if (data == null) {
			System.out.println("!!!!!!data is null!!!!!!!");
			return null;
		} else {
			Event dataEvent = EventHelper.extract(data);
			System.out.println(dataEvent.number + dataEvent.description);
			return dataEvent;
		}
	}

}
