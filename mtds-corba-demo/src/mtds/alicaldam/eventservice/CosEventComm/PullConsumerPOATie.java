package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PullConsumer.
 * 
 * @author OpenORB Compiler
 */
public class PullConsumerPOATie extends PullConsumerPOA
{

    //
    // Private reference to implementation object
    //
    private PullConsumerOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public PullConsumerPOATie(PullConsumerOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public PullConsumerPOATie(PullConsumerOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public PullConsumerOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(PullConsumerOperations delegate_)
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
     * Operation disconnect_pull_consumer
     */
    public void disconnect_pull_consumer()
    {
        _tie.disconnect_pull_consumer();
    }

}
