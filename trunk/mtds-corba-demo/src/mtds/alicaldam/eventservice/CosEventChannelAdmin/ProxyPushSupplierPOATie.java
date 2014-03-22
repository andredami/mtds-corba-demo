package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPushSupplier.
 * 
 * @author OpenORB Compiler
 */
public class ProxyPushSupplierPOATie extends ProxyPushSupplierPOA
{

    //
    // Private reference to implementation object
    //
    private ProxyPushSupplierOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ProxyPushSupplierPOATie(ProxyPushSupplierOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ProxyPushSupplierPOATie(ProxyPushSupplierOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ProxyPushSupplierOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ProxyPushSupplierOperations delegate_)
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
     * Operation connect_push_consumer
     */
    public void connect_push_consumer(mtds.alicaldam.eventservice.CosEventComm.PushConsumer push_consumer)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected, mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError
    {
        _tie.connect_push_consumer( push_consumer);
    }

    /**
     * Operation disconnect_push_supplier
     */
    public void disconnect_push_supplier()
    {
        _tie.disconnect_push_supplier();
    }

}
