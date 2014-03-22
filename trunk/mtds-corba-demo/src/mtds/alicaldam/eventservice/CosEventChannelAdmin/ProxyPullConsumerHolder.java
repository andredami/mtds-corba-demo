package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Holder class for : ProxyPullConsumer
 * 
 * @author OpenORB Compiler
 */
final public class ProxyPullConsumerHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ProxyPullConsumer value
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer value;

    /**
     * Default constructor
     */
    public ProxyPullConsumerHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ProxyPullConsumerHolder(mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer initial)
    {
        value = initial;
    }

    /**
     * Read ProxyPullConsumer from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ProxyPullConsumerHelper.read(istream);
    }

    /**
     * Write ProxyPullConsumer into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ProxyPullConsumerHelper.write(ostream,value);
    }

    /**
     * Return the ProxyPullConsumer TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ProxyPullConsumerHelper.type();
    }

}
