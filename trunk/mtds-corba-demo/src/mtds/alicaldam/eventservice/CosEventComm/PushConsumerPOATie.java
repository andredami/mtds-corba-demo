package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PushConsumer.
 * 
 * @author OpenORB Compiler
 */
public class PushConsumerPOATie extends PushConsumerPOA
{

    //
    // Private reference to implementation object
    //
    private PushConsumerOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public PushConsumerPOATie(PushConsumerOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public PushConsumerPOATie(PushConsumerOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public PushConsumerOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(PushConsumerOperations delegate_)
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
