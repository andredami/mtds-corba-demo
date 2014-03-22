package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPushConsumer.
 * 
 * @author OpenORB Compiler
 */
public class ProxyPushConsumerPOATie extends ProxyPushConsumerPOA
{

    //
    // Private reference to implementation object
    //
    private ProxyPushConsumerOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ProxyPushConsumerPOATie(ProxyPushConsumerOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ProxyPushConsumerPOATie(ProxyPushConsumerOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ProxyPushConsumerOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ProxyPushConsumerOperations delegate_)
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
     * Operation connect_push_supplier
     */
    public void connect_push_supplier(mtds.alicaldam.eventservice.CosEventComm.PushSupplier push_supplier)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected
    {
        _tie.connect_push_supplier( push_supplier);
    }

    /**
     * Operation push
     */
    public void push(org.omg.CORBA.Any data)
        throws mtds.alicaldam.eventservice.CosEventComm.Disconnected
    {
        _tie.push( data);
    }

    /**
     * Operation disconnect_push_consumer
     */
    public void disconnect_push_consumer()
    {
        _tie.disconnect_push_consumer();
    }

}
