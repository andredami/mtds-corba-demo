package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/** 
 * Helper class for : ProxyPushConsumer
 *  
 * @author OpenORB Compiler
 */ 
public class ProxyPushConsumerHelper
{
    /**
     * Insert ProxyPushConsumer into an any
     * @param a an any
     * @param t ProxyPushConsumer value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ProxyPushConsumer from an any
     *
     * @param a an any
     * @return the extracted ProxyPushConsumer value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerHelper.narrow( a.extract_Object() );
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
     * Return the ProxyPushConsumer TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "ProxyPushConsumer" );
        }
        return _tc;
    }

    /**
     * Return the ProxyPushConsumer IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventChannelAdmin/ProxyPushConsumer:1.0";

    /**
     * Read ProxyPushConsumer from a marshalled stream
     * @param istream the input stream
     * @return the readed ProxyPushConsumer value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer)istream.read_Object(mtds.alicaldam.eventservice.CosEventChannelAdmin._ProxyPushConsumerStub.class);
    }

    /**
     * Write ProxyPushConsumer into a marshalled stream
     * @param ostream the output stream
     * @param value ProxyPushConsumer value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ProxyPushConsumer
     * @param obj the CORBA Object
     * @return ProxyPushConsumer Object
     */
    public static ProxyPushConsumer narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ProxyPushConsumer)
            return (ProxyPushConsumer)obj;

        if (obj._is_a(id()))
        {
            _ProxyPushConsumerStub stub = new _ProxyPushConsumerStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ProxyPushConsumer
     * @param obj the CORBA Object
     * @return ProxyPushConsumer Object
     */
    public static ProxyPushConsumer unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ProxyPushConsumer)
            return (ProxyPushConsumer)obj;

        _ProxyPushConsumerStub stub = new _ProxyPushConsumerStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
