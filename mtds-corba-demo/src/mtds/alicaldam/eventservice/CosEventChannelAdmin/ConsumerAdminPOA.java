package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ConsumerAdmin.
 * 
 * @author OpenORB Compiler
 */
public abstract class ConsumerAdminPOA extends org.omg.PortableServer.Servant
        implements ConsumerAdminOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ConsumerAdmin _this()
    {
        return ConsumerAdminHelper.narrow(_this_object());
    }

    public ConsumerAdmin _this(org.omg.CORBA.ORB orb)
    {
        return ConsumerAdminHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CosEventChannelAdmin/ConsumerAdmin:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("obtain_pull_supplier")) {
                return _invoke_obtain_pull_supplier(_is, handler);
        } else if (opName.equals("obtain_push_supplier")) {
                return _invoke_obtain_push_supplier(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_obtain_push_supplier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier _arg_result = obtain_push_supplier();

        _output = handler.createReply();
        mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplierHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_obtain_pull_supplier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier _arg_result = obtain_pull_supplier();

        _output = handler.createReply();
        mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierHelper.write(_output,_arg_result);

        return _output;
    }

}
