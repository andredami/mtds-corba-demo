package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Holder class for : Disconnected
 * 
 * @author OpenORB Compiler
 */
final public class DisconnectedHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Disconnected value
     */
    public mtds.alicaldam.eventservice.CosEventComm.Disconnected value;

    /**
     * Default constructor
     */
    public DisconnectedHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DisconnectedHolder(mtds.alicaldam.eventservice.CosEventComm.Disconnected initial)
    {
        value = initial;
    }

    /**
     * Read Disconnected from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DisconnectedHelper.read(istream);
    }

    /**
     * Write Disconnected into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DisconnectedHelper.write(ostream,value);
    }

    /**
     * Return the Disconnected TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DisconnectedHelper.type();
    }

}
