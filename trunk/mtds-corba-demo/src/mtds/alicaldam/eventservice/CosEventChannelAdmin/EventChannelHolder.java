package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Holder class for : EventChannel
 * 
 * @author OpenORB Compiler
 */
final public class EventChannelHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EventChannel value
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel value;

    /**
     * Default constructor
     */
    public EventChannelHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EventChannelHolder(mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannel initial)
    {
        value = initial;
    }

    /**
     * Read EventChannel from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EventChannelHelper.read(istream);
    }

    /**
     * Write EventChannel into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EventChannelHelper.write(ostream,value);
    }

    /**
     * Return the EventChannel TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EventChannelHelper.type();
    }

}
