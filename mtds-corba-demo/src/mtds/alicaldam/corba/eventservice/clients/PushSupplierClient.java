package mtds.alicaldam.corba.eventservice.clients;

import java.io.Serializable;
import java.util.Scanner;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelHelper;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier;
import mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin;
import mtds.alicaldam.eventservice.CosEventComm.impl.PushConsumerImpl;
import mtds.alicaldam.eventservice.CosEventComm.impl.PushSupplierImpl;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.DATA_CONVERSION;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.StringHolder;
import org.omg.CORBA.StringValueHelper;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Data.Event;
import Data.EventHelper;

public class PushSupplierClient {
	public static final String ADDRESS="localhost";
	public static void main(String args[]){
		
		try{

			ORB orb = ORB.init(args,null);

			//create the remote push supplier
			PushSupplierImpl push_supplier_impl=new PushSupplierImpl();
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(push_supplier_impl);

			//take a ref to the event channel
			org.omg.CORBA.Object sRef = orb.string_to_object("corbaname::"+ADDRESS+"::1050#DemoChannel");
			EventChannel event_channel = EventChannelHelper.narrow(sRef);
						
			//connect consumer and supplier
			SupplierAdmin supplierAdmin=event_channel.for_suppliers();
			ProxyPushConsumer proxy_push_consumer=supplierAdmin.obtain_push_consumer();
			push_supplier_impl.setPushConsumer(proxy_push_consumer);
			proxy_push_consumer.connect_push_supplier(push_supplier_impl._this());
			
			//TODO: receive and print data 
			Scanner scanner= new Scanner(System.in);
			String dataString=scanner.nextLine();
			while(!dataString.equalsIgnoreCase("q")){
				System.out.println("sending the message...");
				Any data= orb.create_any();
				EventHelper.insert(data, new Event(0,"ciao"));
				push_supplier_impl.send(data);
				System.out.println("message sent!");
				dataString=scanner.nextLine();
			}
			scanner.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
