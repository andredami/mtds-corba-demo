package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/** 
 * Helper class for : SupplierAdmin
 *  
 * @author OpenORB Compiler
 */ 
public class SupplierAdminHelper
{
    /**
     * Insert SupplierAdmin into an any
     * @param a an any
     * @param t SupplierAdmin value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract SupplierAdmin from an any
     *
     * @param a an any
     * @return the extracted SupplierAdmin value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminHelper.narrow( a.extract_Object() );
        }
        catch ( final org.omg.CORBA.BAD_PARAM e )
        {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the SupplierAdmin TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "SupplierAdmin" );
        }
        return _tc;
    }

    /**
     * Return the SupplierAdmin IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventChannelAdmin/SupplierAdmin:1.0";

    /**
     * Read SupplierAdmin from a marshalled stream
     * @param istream the input stream
     * @return the readed SupplierAdmin value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin)istream.read_Object(mtds.alicaldam.eventservice.CosEventChannelAdmin._SupplierAdminStub.class);
    }

    /**
     * Write SupplierAdmin into a marshalled stream
     * @param ostream the output stream
     * @param value SupplierAdmin value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to SupplierAdmin
     * @param obj the CORBA Object
     * @return SupplierAdmin Object
     */
    public static SupplierAdmin narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof SupplierAdmin)
            return (SupplierAdmin)obj;

        if (obj._is_a(id()))
        {
            _SupplierAdminStub stub = new _SupplierAdminStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to SupplierAdmin
     * @param obj the CORBA Object
     * @return SupplierAdmin Object
     */
    public static SupplierAdmin unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof SupplierAdmin)
            return (SupplierAdmin)obj;

        _SupplierAdminStub stub = new _SupplierAdminStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
