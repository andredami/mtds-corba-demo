package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: SupplierAdmin.
 * 
 * @author OpenORB Compiler
 */
public abstract class SupplierAdminPOA extends org.omg.PortableServer.Servant
        implements SupplierAdminOperations, org.omg.CORBA.portable.InvokeHandler
{
    public SupplierAdmin _this()
    {
        return SupplierAdminHelper.narrow(_this_object());
    }

    public SupplierAdmin _this(org.omg.CORBA.ORB orb)
    {
        return SupplierAdminHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CosEventChannelAdmin/SupplierAdmin:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("obtain_pull_consumer")) {
                return _invoke_obtain_pull_consumer(_is, handler);
        } else if (opName.equals("obtain_push_consumer")) {
                return _invoke_obtain_push_consumer(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_obtain_push_consumer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer _arg_result = obtain_push_consumer();

        _output = handler.createReply();
        mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_obtain_pull_consumer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer _arg_result = obtain_pull_consumer();

        _output = handler.createReply();
        mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerHelper.write(_output,_arg_result);

        return _output;
    }

}
