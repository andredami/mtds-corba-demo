package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PullSupplier.
 * 
 * @author OpenORB Compiler
 */
public abstract class PullSupplierPOA extends org.omg.PortableServer.Servant
        implements PullSupplierOperations, org.omg.CORBA.portable.InvokeHandler
{
    public PullSupplier _this()
    {
        return PullSupplierHelper.narrow(_this_object());
    }

    public PullSupplier _this(org.omg.CORBA.ORB orb)
    {
        return PullSupplierHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CosEventComm/PullSupplier:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("disconnect_pull_supplier")) {
                return _invoke_disconnect_pull_supplier(_is, handler);
        } else if (opName.equals("pull")) {
                return _invoke_pull(_is, handler);
        } else if (opName.equals("try_pull")) {
                return _invoke_try_pull(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_pull(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        try
        {
            org.omg.CORBA.Any _arg_result = pull();

            _output = handler.createReply();
            _output.write_any(_arg_result);

        }
        catch (mtds.alicaldam.eventservice.CosEventComm.Disconnected _exception)
        {
            _output = handler.createExceptionReply();
            mtds.alicaldam.eventservice.CosEventComm.DisconnectedHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_try_pull(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        org.omg.CORBA.BooleanHolder arg0_out = new org.omg.CORBA.BooleanHolder();

        try
        {
            org.omg.CORBA.Any _arg_result = try_pull(arg0_out);

            _output = handler.createReply();
            _output.write_any(_arg_result);

            _output.write_boolean(arg0_out.value);
        }
        catch (mtds.alicaldam.eventservice.CosEventComm.Disconnected _exception)
        {
            _output = handler.createExceptionReply();
            mtds.alicaldam.eventservice.CosEventComm.DisconnectedHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_disconnect_pull_supplier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        disconnect_pull_supplier();

        _output = handler.createReply();

        return _output;
    }

}
