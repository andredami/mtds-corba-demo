package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPullConsumer.
 * 
 * @author OpenORB Compiler
 */
public abstract class ProxyPullConsumerPOA extends org.omg.PortableServer.Servant
        implements ProxyPullConsumerOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ProxyPullConsumer _this()
    {
        return ProxyPullConsumerHelper.narrow(_this_object());
    }

    public ProxyPullConsumer _this(org.omg.CORBA.ORB orb)
    {
        return ProxyPullConsumerHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CosEventChannelAdmin/ProxyPullConsumer:1.0", 
        "IDL:CosEventComm/PullConsumer:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("connect_pull_supplier")) {
                return _invoke_connect_pull_supplier(_is, handler);
        } else if (opName.equals("disconnect_pull_consumer")) {
                return _invoke_disconnect_pull_consumer(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_connect_pull_supplier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        mtds.alicaldam.eventservice.CosEventComm.PullSupplier arg0_in = mtds.alicaldam.eventservice.CosEventComm.PullSupplierHelper.read(_is);

        try
        {
            connect_pull_supplier(arg0_in);

            _output = handler.createReply();

        }
        catch (mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected _exception)
        {
            _output = handler.createExceptionReply();
            mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnectedHelper.write(_output,_exception);
        }
        catch (mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError _exception)
        {
            _output = handler.createExceptionReply();
            mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeErrorHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_disconnect_pull_consumer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        disconnect_pull_consumer();

        _output = handler.createReply();

        return _output;
    }

}
