package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/** 
 * Helper class for : ProxyPushSupplier
 *  
 * @author OpenORB Compiler
 */ 
public class ProxyPushSupplierHelper
{
    /**
     * Insert ProxyPushSupplier into an any
     * @param a an any
     * @param t ProxyPushSupplier value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ProxyPushSupplier from an any
     *
     * @param a an any
     * @return the extracted ProxyPushSupplier value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplierHelper.narrow( a.extract_Object() );
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
     * Return the ProxyPushSupplier TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "ProxyPushSupplier" );
        }
        return _tc;
    }

    /**
     * Return the ProxyPushSupplier IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventChannelAdmin/ProxyPushSupplier:1.0";

    /**
     * Read ProxyPushSupplier from a marshalled stream
     * @param istream the input stream
     * @return the readed ProxyPushSupplier value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier)istream.read_Object(mtds.alicaldam.eventservice.CosEventChannelAdmin._ProxyPushSupplierStub.class);
    }

    /**
     * Write ProxyPushSupplier into a marshalled stream
     * @param ostream the output stream
     * @param value ProxyPushSupplier value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ProxyPushSupplier
     * @param obj the CORBA Object
     * @return ProxyPushSupplier Object
     */
    public static ProxyPushSupplier narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ProxyPushSupplier)
            return (ProxyPushSupplier)obj;

        if (obj._is_a(id()))
        {
            _ProxyPushSupplierStub stub = new _ProxyPushSupplierStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ProxyPushSupplier
     * @param obj the CORBA Object
     * @return ProxyPushSupplier Object
     */
    public static ProxyPushSupplier unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ProxyPushSupplier)
            return (ProxyPushSupplier)obj;

        _ProxyPushSupplierStub stub = new _ProxyPushSupplierStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
