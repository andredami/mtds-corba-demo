package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: SupplierAdmin.
 * 
 * @author OpenORB Compiler
 */
public class SupplierAdminPOATie extends SupplierAdminPOA
{

    //
    // Private reference to implementation object
    //
    private SupplierAdminOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public SupplierAdminPOATie(SupplierAdminOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public SupplierAdminPOATie(SupplierAdminOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public SupplierAdminOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(SupplierAdminOperations delegate_)
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
     * Operation obtain_push_consumer
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer obtain_push_consumer()
    {
        return _tie.obtain_push_consumer();
    }

    /**
     * Operation obtain_pull_consumer
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer obtain_pull_consumer()
    {
        return _tie.obtain_pull_consumer();
    }

}
