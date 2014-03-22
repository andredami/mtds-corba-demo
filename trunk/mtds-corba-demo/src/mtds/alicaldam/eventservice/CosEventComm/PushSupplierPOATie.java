package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PushSupplier.
 * 
 * @author OpenORB Compiler
 */
public class PushSupplierPOATie extends PushSupplierPOA
{

    //
    // Private reference to implementation object
    //
    private PushSupplierOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public PushSupplierPOATie(PushSupplierOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public PushSupplierPOATie(PushSupplierOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public PushSupplierOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(PushSupplierOperations delegate_)
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
     * Operation disconnect_push_supplier
     */
    public void disconnect_push_supplier()
    {
        _tie.disconnect_push_supplier();
    }

}
