package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: EventChannel.
 * 
 * @author OpenORB Compiler
 */
public class EventChannelPOATie extends EventChannelPOA
{

    //
    // Private reference to implementation object
    //
    private EventChannelOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EventChannelPOATie(EventChannelOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EventChannelPOATie(EventChannelOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EventChannelOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EventChannelOperations delegate_)
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
     * Operation for_consumers
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin for_consumers()
    {
        return _tie.for_consumers();
    }

    /**
     * Operation for_suppliers
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin for_suppliers()
    {
        return _tie.for_suppliers();
    }

    /**
     * Operation destroy
     */
    public void destroy()
    {
        _tie.destroy();
    }

}
