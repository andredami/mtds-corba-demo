package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/** 
 * Helper class for : ProxyPullConsumer
 *  
 * @author OpenORB Compiler
 */ 
public class ProxyPullConsumerHelper
{
    /**
     * Insert ProxyPullConsumer into an any
     * @param a an any
     * @param t ProxyPullConsumer value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ProxyPullConsumer from an any
     *
     * @param a an any
     * @return the extracted ProxyPullConsumer value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerHelper.narrow( a.extract_Object() );
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
     * Return the ProxyPullConsumer TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "ProxyPullConsumer" );
        }
        return _tc;
    }

    /**
     * Return the ProxyPullConsumer IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventChannelAdmin/ProxyPullConsumer:1.0";

    /**
     * Read ProxyPullConsumer from a marshalled stream
     * @param istream the input stream
     * @return the readed ProxyPullConsumer value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer)istream.read_Object(mtds.alicaldam.eventservice.CosEventChannelAdmin._ProxyPullConsumerStub.class);
    }

    /**
     * Write ProxyPullConsumer into a marshalled stream
     * @param ostream the output stream
     * @param value ProxyPullConsumer value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ProxyPullConsumer
     * @param obj the CORBA Object
     * @return ProxyPullConsumer Object
     */
    public static ProxyPullConsumer narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ProxyPullConsumer)
            return (ProxyPullConsumer)obj;

        if (obj._is_a(id()))
        {
            _ProxyPullConsumerStub stub = new _ProxyPullConsumerStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ProxyPullConsumer
     * @param obj the CORBA Object
     * @return ProxyPullConsumer Object
     */
    public static ProxyPullConsumer unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ProxyPullConsumer)
            return (ProxyPullConsumer)obj;

        _ProxyPullConsumerStub stub = new _ProxyPullConsumerStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
