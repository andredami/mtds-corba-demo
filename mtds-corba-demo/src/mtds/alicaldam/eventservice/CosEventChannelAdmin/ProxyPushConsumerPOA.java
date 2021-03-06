package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPushConsumer.
 * 
 * @author OpenORB Compiler
 */
public abstract class ProxyPushConsumerPOA extends org.omg.PortableServer.Servant
        implements ProxyPushConsumerOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ProxyPushConsumer _this()
    {
        return ProxyPushConsumerHelper.narrow(_this_object());
    }

    public ProxyPushConsumer _this(org.omg.CORBA.ORB orb)
    {
        return ProxyPushConsumerHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CosEventChannelAdmin/ProxyPushConsumer:1.0", 
        "IDL:CosEventComm/PushConsumer:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("connect_push_supplier")) {
                return _invoke_connect_push_supplier(_is, handler);
        } else if (opName.equals("disconnect_push_consumer")) {
                return _invoke_disconnect_push_consumer(_is, handler);
        } else if (opName.equals("push")) {
                return _invoke_push(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_connect_push_supplier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        mtds.alicaldam.eventservice.CosEventComm.PushSupplier arg0_in = mtds.alicaldam.eventservice.CosEventComm.PushSupplierHelper.read(_is);

        try
        {
            connect_push_supplier(arg0_in);

            _output = handler.createReply();

        }
        catch (mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected _exception)
        {
            _output = handler.createExceptionReply();
            mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnectedHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_push(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        org.omg.CORBA.Any arg0_in = _is.read_any();

        try
        {
            push(arg0_in);

            _output = handler.createReply();

        }
        catch (mtds.alicaldam.eventservice.CosEventComm.Disconnected _exception)
        {
            _output = handler.createExceptionReply();
            mtds.alicaldam.eventservice.CosEventComm.DisconnectedHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_disconnect_push_consumer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        disconnect_push_consumer();

        _output = handler.createReply();

        return _output;
    }

}
