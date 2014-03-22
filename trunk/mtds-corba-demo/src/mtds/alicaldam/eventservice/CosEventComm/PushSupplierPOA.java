package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PushSupplier.
 * 
 * @author OpenORB Compiler
 */
public abstract class PushSupplierPOA extends org.omg.PortableServer.Servant
        implements PushSupplierOperations, org.omg.CORBA.portable.InvokeHandler
{
    public PushSupplier _this()
    {
        return PushSupplierHelper.narrow(_this_object());
    }

    public PushSupplier _this(org.omg.CORBA.ORB orb)
    {
        return PushSupplierHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
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

        if (opName.equals("disconnect_push_supplier")) {
                return _invoke_disconnect_push_supplier(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_disconnect_push_supplier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        disconnect_push_supplier();

        _output = handler.createReply();

        return _output;
    }

}
