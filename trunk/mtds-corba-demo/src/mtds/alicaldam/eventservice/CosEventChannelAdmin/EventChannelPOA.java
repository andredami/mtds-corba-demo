package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: EventChannel.
 * 
 * @author OpenORB Compiler
 */
public abstract class EventChannelPOA extends org.omg.PortableServer.Servant
        implements EventChannelOperations, org.omg.CORBA.portable.InvokeHandler
{
    public EventChannel _this()
    {
        return EventChannelHelper.narrow(_this_object());
    }

    public EventChannel _this(org.omg.CORBA.ORB orb)
    {
        return EventChannelHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CosEventChannelAdmin/EventChannel:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("destroy")) {
                return _invoke_destroy(_is, handler);
        } else if (opName.equals("for_consumers")) {
                return _invoke_for_consumers(_is, handler);
        } else if (opName.equals("for_suppliers")) {
                return _invoke_for_suppliers(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_for_consumers(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin _arg_result = for_consumers();

        _output = handler.createReply();
        mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_for_suppliers(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin _arg_result = for_suppliers();

        _output = handler.createReply();
        mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_destroy(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        destroy();

        _output = handler.createReply();

        return _output;
    }

}
