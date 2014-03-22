package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/** 
 * Helper class for : ProxyPullSupplier
 *  
 * @author OpenORB Compiler
 */ 
public class ProxyPullSupplierHelper
{
    /**
     * Insert ProxyPullSupplier into an any
     * @param a an any
     * @param t ProxyPullSupplier value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ProxyPullSupplier from an any
     *
     * @param a an any
     * @return the extracted ProxyPullSupplier value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierHelper.narrow( a.extract_Object() );
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
     * Return the ProxyPullSupplier TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "ProxyPullSupplier" );
        }
        return _tc;
    }

    /**
     * Return the ProxyPullSupplier IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventChannelAdmin/ProxyPullSupplier:1.0";

    /**
     * Read ProxyPullSupplier from a marshalled stream
     * @param istream the input stream
     * @return the readed ProxyPullSupplier value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier)istream.read_Object(mtds.alicaldam.eventservice.CosEventChannelAdmin._ProxyPullSupplierStub.class);
    }

    /**
     * Write ProxyPullSupplier into a marshalled stream
     * @param ostream the output stream
     * @param value ProxyPullSupplier value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ProxyPullSupplier
     * @param obj the CORBA Object
     * @return ProxyPullSupplier Object
     */
    public static ProxyPullSupplier narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ProxyPullSupplier)
            return (ProxyPullSupplier)obj;

        if (obj._is_a(id()))
        {
            _ProxyPullSupplierStub stub = new _ProxyPullSupplierStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ProxyPullSupplier
     * @param obj the CORBA Object
     * @return ProxyPullSupplier Object
     */
    public static ProxyPullSupplier unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ProxyPullSupplier)
            return (ProxyPullSupplier)obj;

        _ProxyPullSupplierStub stub = new _ProxyPullSupplierStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
