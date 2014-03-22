package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PullSupplier.
 * 
 * @author OpenORB Compiler
 */
public interface PullSupplierOperations
{
    /**
     * Operation pull
     */
    public org.omg.CORBA.Any pull()
        throws mtds.alicaldam.eventservice.CosEventComm.Disconnected;

    /**
     * Operation try_pull
     */
    public org.omg.CORBA.Any try_pull(org.omg.CORBA.BooleanHolder has_event)
        throws mtds.alicaldam.eventservice.CosEventComm.Disconnected;

    /**
     * Operation disconnect_pull_supplier
     */
    public void disconnect_pull_supplier();

}
