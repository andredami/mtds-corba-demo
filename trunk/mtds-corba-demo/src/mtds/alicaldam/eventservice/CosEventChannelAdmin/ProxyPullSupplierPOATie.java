package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPullSupplier.
 * 
 * @author OpenORB Compiler
 */
public class ProxyPullSupplierPOATie extends ProxyPullSupplierPOA
{

    //
    // Private reference to implementation object
    //
    private ProxyPullSupplierOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ProxyPullSupplierPOATie(ProxyPullSupplierOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ProxyPullSupplierPOATie(ProxyPullSupplierOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ProxyPullSupplierOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ProxyPullSupplierOperations delegate_)
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
     * Operation connect_pull_consumer
     */
    public void connect_pull_consumer(mtds.alicaldam.eventservice.CosEventComm.PullConsumer pull_consumer)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected
    {
        _tie.connect_pull_consumer( pull_consumer);
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
