package mtds.alicaldam.corba.eventservice.clients;

import java.util.Scanner;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelHelper;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin;
import mtds.alicaldam.eventservice.CosEventComm.impl.PushSupplierImpl;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Data.Event;
import Data.EventHelper;

public class PushSupplierClient {

	public static void main(String args[]) {

		try {
			if(args.length==0){
				System.err.println("No server IP supplied");
				return;
			}
			
			String ADDRESS=args[0];
			ORB orb = ORB.init(args, null);

			// create the remote push supplier
			PushSupplierImpl push_supplier_impl = new PushSupplierImpl();
			POA rootpoa = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			org.omg.CORBA.Object ref = rootpoa
					.servant_to_reference(push_supplier_impl);

			// take a ref to the event channel
			org.omg.CORBA.Object sRef = orb.string_to_object("corbaname::"
					+ ADDRESS + "::1050#DemoChannel");
			EventChannel event_channel = EventChannelHelper.narrow(sRef);

			// connect consumer and supplier
			SupplierAdmin supplierAdmin;
			try{
			supplierAdmin= event_channel.for_suppliers();
			}catch(Exception e){
				System.out.println("server not available");
				return;
			}
			
			ProxyPushConsumer proxy_push_consumer = supplierAdmin
					.obtain_push_consumer();
			push_supplier_impl.setPushConsumer(proxy_push_consumer);
			proxy_push_consumer.connect_push_supplier(push_supplier_impl
					._this());

			// TODO: receive and print data
			Scanner scanner = new Scanner(System.in);
			String dataString = scanner.nextLine();
			while (!dataString.equalsIgnoreCase("q")
					&& !dataString.equalsIgnoreCase("d")) {
				System.out.println("sending the message...");
				Any data = orb.create_any();
				EventHelper.insert(data, new Event(0, dataString));
				push_supplier_impl.send(data);
				System.out.println("message sent!");
				dataString = scanner.nextLine();
			}
			if (dataString.equalsIgnoreCase("d")) {
				event_channel.destroy();
			} else {
				proxy_push_consumer.disconnect_push_consumer();
			}
			scanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
