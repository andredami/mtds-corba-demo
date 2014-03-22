package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PushConsumer.
 * 
 * @author OpenORB Compiler
 */
public abstract class PushConsumerPOA extends org.omg.PortableServer.Servant
        implements PushConsumerOperations, org.omg.CORBA.portable.InvokeHandler
{
    public PushConsumer _this()
    {
        return PushConsumerHelper.narrow(_this_object());
    }

    public PushConsumer _this(org.omg.CORBA.ORB orb)
    {
        return PushConsumerHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
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

        if (opName.equals("disconnect_push_consumer")) {
                return _invoke_disconnect_push_consumer(_is, handler);
        } else if (opName.equals("push")) {
                return _invoke_push(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
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
