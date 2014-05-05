package mtds.alicaldam.corba.eventservice.clients;

import java.util.Scanner;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelHelper;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin;
import mtds.alicaldam.eventservice.CosEventComm.impl.PullSupplierImpl;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Data.Event;
import Data.EventHelper;

public class PullSupplierClient {

	public static final String ADDRESS="localhost";
	public static void main(String args[]){
		
		try{

			ORB orb = ORB.init(args,null);

			//create the remote push supplier
			PullSupplierImpl pull_supplier_impl=new PullSupplierImpl();
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(pull_supplier_impl);

			//take a ref to the event channel
			org.omg.CORBA.Object sRef = orb.string_to_object("corbaname::"+ADDRESS+"::1050#DemoChannel");
			EventChannel event_channel = EventChannelHelper.narrow(sRef);
						
			//connect consumer and supplier
			SupplierAdmin supplierAdmin=event_channel.for_suppliers();
			ProxyPullConsumer proxy_pull_consumer=supplierAdmin.obtain_pull_consumer();
			pull_supplier_impl.setPullConsumer(proxy_pull_consumer);
			proxy_pull_consumer.connect_pull_supplier(pull_supplier_impl._this());
			
			//TODO: receive and print data 
			Scanner scanner= new Scanner(System.in);
			String dataString=scanner.nextLine();
			while(!dataString.equalsIgnoreCase("q")){
				System.out.println("sending the message...");
				Any data= orb.create_any();
				EventHelper.insert(data, new Event(0,dataString));
				pull_supplier_impl.send(data);
				System.out.println("message sent!");
				dataString=scanner.nextLine();
			}
			proxy_pull_consumer.disconnect_pull_consumer();
			scanner.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
