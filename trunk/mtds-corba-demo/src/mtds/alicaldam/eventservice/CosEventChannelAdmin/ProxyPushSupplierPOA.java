package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPushSupplier.
 * 
 * @author OpenORB Compiler
 */
public abstract class ProxyPushSupplierPOA extends org.omg.PortableServer.Servant
        implements ProxyPushSupplierOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ProxyPushSupplier _this()
    {
        return ProxyPushSupplierHelper.narrow(_this_object());
    }

    public ProxyPushSupplier _this(org.omg.CORBA.ORB orb)
    {
        return ProxyPushSupplierHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CosEventChannelAdmin/ProxyPushSupplier:1.0", 
        "IDL:CosEventComm/PushSupplier:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("connect_push_consumer")) {
                return _invoke_connect_push_consumer(_is, handler);
        } else if (opName.equals("disconnect_push_supplier")) {
                return _invoke_disconnect_push_supplier(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_connect_push_consumer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        mtds.alicaldam.eventservice.CosEventComm.PushConsumer arg0_in = mtds.alicaldam.eventservice.CosEventComm.PushConsumerHelper.read(_is);

        try
        {
            connect_push_consumer(arg0_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_disconnect_push_supplier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        disconnect_push_supplier();

        _output = handler.createReply();

        return _output;
    }

}
