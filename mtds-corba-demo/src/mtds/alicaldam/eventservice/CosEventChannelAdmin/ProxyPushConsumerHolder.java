package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Holder class for : ProxyPushConsumer
 * 
 * @author OpenORB Compiler
 */
final public class ProxyPushConsumerHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ProxyPushConsumer value
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer value;

    /**
     * Default constructor
     */
    public ProxyPushConsumerHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ProxyPushConsumerHolder(mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer initial)
    {
        value = initial;
    }

    /**
     * Read ProxyPushConsumer from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ProxyPushConsumerHelper.read(istream);
    }

    /**
     * Write ProxyPushConsumer into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ProxyPushConsumerHelper.write(ostream,value);
    }

    /**
     * Return the ProxyPushConsumer TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ProxyPushConsumerHelper.type();
    }

}
