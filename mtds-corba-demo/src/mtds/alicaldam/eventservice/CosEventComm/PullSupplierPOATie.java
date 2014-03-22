package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PullSupplier.
 * 
 * @author OpenORB Compiler
 */
public class PullSupplierPOATie extends PullSupplierPOA
{

    //
    // Private reference to implementation object
    //
    private PullSupplierOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public PullSupplierPOATie(PullSupplierOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public PullSupplierPOATie(PullSupplierOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public PullSupplierOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(PullSupplierOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation pull
     */
    public org.omg.CORBA.Any pull()
        throws mtds.alicaldam.eventservice.CosEventComm.Disconnected
    {
        return _tie.pull();
    }

    /**
     * Operation try_pull
     */
    public org.omg.CORBA.Any try_pull(org.omg.CORBA.BooleanHolder has_event)
        throws mtds.alicaldam.eventservice.CosEventComm.Disconnected
    {
        return _tie.try_pull( has_event);
    }

    /**
     * Operation disconnect_pull_supplier
     */
    public void disconnect_pull_supplier()
    {
        _tie.disconnect_pull_supplier();
    }

}
