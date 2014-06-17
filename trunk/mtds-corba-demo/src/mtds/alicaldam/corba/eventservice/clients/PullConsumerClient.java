package mtds.alicaldam.corba.eventservice.clients;

import java.util.Scanner;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelHelper;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier;
import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.impl.PullConsumerImpl;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Data.Event;
import Data.EventHelper;

public class PullConsumerClient {
	
	public static void main(String args[]){
		
		try{
			if(args.length==0){
				System.err.println("No server IP supplied");
				return;
			}
			
			String ADDRESS=args[0];
			ORB orb = ORB.init(args,null);

			//create the remote pull consumer
			final PullConsumerImpl pull_consumer_impl=new PullConsumerImpl(PullConsumerImpl.IS_TRY_PULL);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(pull_consumer_impl);

			//take a ref to the event channel
			org.omg.CORBA.Object sRef = orb.string_to_object("corbaname::"+ADDRESS+"::1050#DemoChannel");
			EventChannel event_channel = EventChannelHelper.narrow(sRef);
						
			//connect consumer and supplier
			ConsumerAdmin consumerAdmin;
			try{
				consumerAdmin=event_channel.for_consumers();
			}catch(Exception e ){
				System.out.println("Server not available");
				return;
			}
			ProxyPullSupplier proxy_pull_supplier=consumerAdmin.obtain_pull_supplier();
			pull_consumer_impl.setPullSupplier(proxy_pull_supplier);
			proxy_pull_supplier.connect_pull_consumer(pull_consumer_impl._this());
			
			
			Event data=readDataFromSupplier(pull_consumer_impl);
			Scanner scanner= new Scanner(System.in);
			System.out.println("press enter to pull... ");
			try{
				while(!scanner.nextLine().equalsIgnoreCase("q")){
					readDataFromSupplier(pull_consumer_impl);
					System.out.println("press enter to pull... ");
				}
					
			}catch(Disconnected e){
				System.out.println("Server disconnected");
			}finally{
			System.out.println("Disconnecting consumer...");
			pull_consumer_impl.disconnect_pull_consumer();
			scanner.close();
			System.out.println("EXIT OK");	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Event readDataFromSupplier(final PullConsumerImpl push_consumer_impl)
			throws InterruptedException, Disconnected {
		System.out.println("Waiting for new data...");
		Any data = push_consumer_impl.read();
		if (data == null) {
			System.out.println("no data available");
			return null;
		} else {
			Event dataEvent = EventHelper.extract(data);
			System.out.println(dataEvent.number + dataEvent.description);
			return dataEvent;
		}
	}

}
