package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Holder class for : TypeError
 * 
 * @author OpenORB Compiler
 */
final public class TypeErrorHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal TypeError value
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError value;

    /**
     * Default constructor
     */
    public TypeErrorHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public TypeErrorHolder(mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError initial)
    {
        value = initial;
    }

    /**
     * Read TypeError from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = TypeErrorHelper.read(istream);
    }

    /**
     * Write TypeError into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        TypeErrorHelper.write(ostream,value);
    }

    /**
     * Return the TypeError TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return TypeErrorHelper.type();
    }

}
