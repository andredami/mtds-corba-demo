package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Holder class for : PullConsumer
 * 
 * @author OpenORB Compiler
 */
final public class PullConsumerHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal PullConsumer value
     */
    public mtds.alicaldam.eventservice.CosEventComm.PullConsumer value;

    /**
     * Default constructor
     */
    public PullConsumerHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PullConsumerHolder(mtds.alicaldam.eventservice.CosEventComm.PullConsumer initial)
    {
        value = initial;
    }

    /**
     * Read PullConsumer from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PullConsumerHelper.read(istream);
    }

    /**
     * Write PullConsumer into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PullConsumerHelper.write(ostream,value);
    }

    /**
     * Return the PullConsumer TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PullConsumerHelper.type();
    }

}
