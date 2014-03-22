package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Holder class for : PushConsumer
 * 
 * @author OpenORB Compiler
 */
final public class PushConsumerHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal PushConsumer value
     */
    public mtds.alicaldam.eventservice.CosEventComm.PushConsumer value;

    /**
     * Default constructor
     */
    public PushConsumerHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PushConsumerHolder(mtds.alicaldam.eventservice.CosEventComm.PushConsumer initial)
    {
        value = initial;
    }

    /**
     * Read PushConsumer from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PushConsumerHelper.read(istream);
    }

    /**
     * Write PushConsumer into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PushConsumerHelper.write(ostream,value);
    }

    /**
     * Return the PushConsumer TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PushConsumerHelper.type();
    }

}
