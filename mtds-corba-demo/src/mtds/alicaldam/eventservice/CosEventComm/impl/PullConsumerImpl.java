package mtds.alicaldam.eventservice.CosEventComm.impl;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.Any;
import org.omg.CORBA.BooleanHolder;

import mtds.alicaldam.eventservice.CosEventComm.Disconnected;
import mtds.alicaldam.eventservice.CosEventComm.PullConsumerPOA;
import mtds.alicaldam.eventservice.CosEventComm.PullSupplier;

public class PullConsumerImpl extends PullConsumerPOA {

	boolean connected = true;
	private PullSupplier supplier;
	private int mode;
	public static final int IS_TRY_PULL=1;
	public static final int IS_PULL=0;
		public PullConsumerImpl() {
		this.mode=IS_TRY_PULL;
	}
	
	public PullConsumerImpl(int mode){
		this.mode=mode;
	}
	
	private Any retrieveDataWithTryPull(PullSupplier ps) throws Disconnected{
		BooleanHolder has_event = new BooleanHolder(false);
		Any event = ps.try_pull(has_event);
		if (has_event.value == true) {
			return event;
		}else{
			return null;
		}

	}
	
	private Any retrieveDataWithPull(PullSupplier ps) throws Disconnected{
		Any event=ps.pull();
		return event;
	}

	@Override
	public void disconnect_pull_consumer() {
		PullSupplier sTmp = null;

		synchronized (this) {
			if (connected) {
				connected = false;
				sTmp = supplier;
				supplier = null;
			}else{
				return;
			}
		}
		if (sTmp != null) {
			sTmp.disconnect_pull_supplier();
		}
		
	}

	public void setPullSupplier(PullSupplier supplier) {
		this.supplier = supplier;
	}

	public Any read() throws Disconnected {
		try {
			PullSupplier stmp = null;
			synchronized (this) {
				if (connected)
						stmp = supplier;
			}
		
			if (stmp != null) {
				if (mode==IS_TRY_PULL){
					return retrieveDataWithTryPull(stmp);
				}else{
					return retrieveDataWithPull(stmp);
				}					
			}else{
				throw new Disconnected();
			}
			
		} catch (Disconnected e) {
			disconnect_pull_consumer();
			throw e;
		}
		
	}
}
