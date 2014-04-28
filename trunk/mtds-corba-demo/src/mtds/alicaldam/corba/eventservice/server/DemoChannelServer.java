package mtds.alicaldam.corba.eventservice.server;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import mtds.alicaldam.eventservice.CosEventChannelAdmin.impl.EventChannelImpl;

public class DemoChannelServer {
	
	public static void main(String[] args) {
		try{
		//
		ORB orb = ORB.init(args,null);
		EventChannelImpl eventChannel= new EventChannelImpl();
		POA rootPOA=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootPOA.the_POAManager().activate();
		org.omg.CORBA.Object ref = rootPOA.servant_to_reference(eventChannel);
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef= NamingContextExtHelper.narrow(objRef);
		NameComponent path[]= ncRef.to_name("DemoChannel");
		ncRef.rebind(path, ref);
		eventChannel.init();
		System.out.println("DemoChannel ready and waiting...");
		orb.run();
		}catch(Exception e ){
			e.printStackTrace();
		}

	}
	
}
