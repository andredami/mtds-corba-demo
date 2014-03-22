package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/** 
 * Helper class for : ConsumerAdmin
 *  
 * @author OpenORB Compiler
 */ 
public class ConsumerAdminHelper
{
    /**
     * Insert ConsumerAdmin into an any
     * @param a an any
     * @param t ConsumerAdmin value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ConsumerAdmin from an any
     *
     * @param a an any
     * @return the extracted ConsumerAdmin value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminHelper.narrow( a.extract_Object() );
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
     * Return the ConsumerAdmin TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "ConsumerAdmin" );
        }
        return _tc;
    }

    /**
     * Return the ConsumerAdmin IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventChannelAdmin/ConsumerAdmin:1.0";

    /**
     * Read ConsumerAdmin from a marshalled stream
     * @param istream the input stream
     * @return the readed ConsumerAdmin value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin)istream.read_Object(mtds.alicaldam.eventservice.CosEventChannelAdmin._ConsumerAdminStub.class);
    }

    /**
     * Write ConsumerAdmin into a marshalled stream
     * @param ostream the output stream
     * @param value ConsumerAdmin value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ConsumerAdmin
     * @param obj the CORBA Object
     * @return ConsumerAdmin Object
     */
    public static ConsumerAdmin narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ConsumerAdmin)
            return (ConsumerAdmin)obj;

        if (obj._is_a(id()))
        {
            _ConsumerAdminStub stub = new _ConsumerAdminStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ConsumerAdmin
     * @param obj the CORBA Object
     * @return ConsumerAdmin Object
     */
    public static ConsumerAdmin unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ConsumerAdmin)
            return (ConsumerAdmin)obj;

        _ConsumerAdminStub stub = new _ConsumerAdminStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
