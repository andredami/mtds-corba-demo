package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPullConsumer.
 * 
 * @author OpenORB Compiler
 */
public class ProxyPullConsumerPOATie extends ProxyPullConsumerPOA
{

    //
    // Private reference to implementation object
    //
    private ProxyPullConsumerOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ProxyPullConsumerPOATie(ProxyPullConsumerOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ProxyPullConsumerPOATie(ProxyPullConsumerOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ProxyPullConsumerOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ProxyPullConsumerOperations delegate_)
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
     * Operation connect_pull_supplier
     */
    public void connect_pull_supplier(mtds.alicaldam.eventservice.CosEventComm.PullSupplier pull_supplier)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected, mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError
    {
        _tie.connect_pull_supplier( pull_supplier);
    }

    /**
     * Operation disconnect_pull_consumer
     */
    public void disconnect_pull_consumer()
    {
        _tie.disconnect_pull_consumer();
    }

}
