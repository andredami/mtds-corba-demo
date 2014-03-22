package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Holder class for : AlreadyConnected
 * 
 * @author OpenORB Compiler
 */
final public class AlreadyConnectedHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AlreadyConnected value
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected value;

    /**
     * Default constructor
     */
    public AlreadyConnectedHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AlreadyConnectedHolder(mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected initial)
    {
        value = initial;
    }

    /**
     * Read AlreadyConnected from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AlreadyConnectedHelper.read(istream);
    }

    /**
     * Write AlreadyConnected into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AlreadyConnectedHelper.write(ostream,value);
    }

    /**
     * Return the AlreadyConnected TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AlreadyConnectedHelper.type();
    }

}
