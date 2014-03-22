package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ConsumerAdmin.
 * 
 * @author OpenORB Compiler
 */
public class ConsumerAdminPOATie extends ConsumerAdminPOA
{

    //
    // Private reference to implementation object
    //
    private ConsumerAdminOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ConsumerAdminPOATie(ConsumerAdminOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ConsumerAdminPOATie(ConsumerAdminOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ConsumerAdminOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ConsumerAdminOperations delegate_)
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
     * Operation obtain_push_supplier
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier obtain_push_supplier()
    {
        return _tie.obtain_push_supplier();
    }

    /**
     * Operation obtain_pull_supplier
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier obtain_pull_supplier()
    {
        return _tie.obtain_pull_supplier();
    }

}
