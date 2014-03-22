package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Holder class for : ConsumerAdmin
 * 
 * @author OpenORB Compiler
 */
final public class ConsumerAdminHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ConsumerAdmin value
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin value;

    /**
     * Default constructor
     */
    public ConsumerAdminHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ConsumerAdminHolder(mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin initial)
    {
        value = initial;
    }

    /**
     * Read ConsumerAdmin from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ConsumerAdminHelper.read(istream);
    }

    /**
     * Write ConsumerAdmin into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ConsumerAdminHelper.write(ostream,value);
    }

    /**
     * Return the ConsumerAdmin TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ConsumerAdminHelper.type();
    }

}
