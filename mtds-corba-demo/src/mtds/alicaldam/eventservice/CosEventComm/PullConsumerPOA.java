package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PullConsumer.
 * 
 * @author OpenORB Compiler
 */
public abstract class PullConsumerPOA extends org.omg.PortableServer.Servant
        implements PullConsumerOperations, org.omg.CORBA.portable.InvokeHandler
{
    public PullConsumer _this()
    {
        return PullConsumerHelper.narrow(_this_object());
    }

    public PullConsumer _this(org.omg.CORBA.ORB orb)
    {
        return PullConsumerHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
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

        if (opName.equals("disconnect_pull_consumer")) {
                return _invoke_disconnect_pull_consumer(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_disconnect_pull_consumer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        disconnect_pull_consumer();

        _output = handler.createReply();

        return _output;
    }

}
