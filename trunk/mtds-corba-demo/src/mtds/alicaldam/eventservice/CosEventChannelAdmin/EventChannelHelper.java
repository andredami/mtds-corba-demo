package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/** 
 * Helper class for : EventChannel
 *  
 * @author OpenORB Compiler
 */ 
public class EventChannelHelper
{
    /**
     * Insert EventChannel into an any
     * @param a an any
     * @param t EventChannel value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract EventChannel from an any
     *
     * @param a an any
     * @return the extracted EventChannel value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelHelper.narrow( a.extract_Object() );
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
     * Return the EventChannel TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "EventChannel" );
        }
        return _tc;
    }

    /**
     * Return the EventChannel IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventChannelAdmin/EventChannel:1.0";

    /**
     * Read EventChannel from a marshalled stream
     * @param istream the input stream
     * @return the readed EventChannel value
     */
    public static mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel)istream.read_Object(mtds.alicaldam.eventservice.CosEventChannelAdmin._EventChannelStub.class);
    }

    /**
     * Write EventChannel into a marshalled stream
     * @param ostream the output stream
     * @param value EventChannel value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to EventChannel
     * @param obj the CORBA Object
     * @return EventChannel Object
     */
    public static EventChannel narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EventChannel)
            return (EventChannel)obj;

        if (obj._is_a(id()))
        {
            _EventChannelStub stub = new _EventChannelStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to EventChannel
     * @param obj the CORBA Object
     * @return EventChannel Object
     */
    public static EventChannel unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EventChannel)
            return (EventChannel)obj;

        _EventChannelStub stub = new _EventChannelStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
