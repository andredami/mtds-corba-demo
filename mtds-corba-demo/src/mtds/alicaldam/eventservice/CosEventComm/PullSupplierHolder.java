package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Holder class for : PullSupplier
 * 
 * @author OpenORB Compiler
 */
final public class PullSupplierHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal PullSupplier value
     */
    public mtds.alicaldam.eventservice.CosEventComm.PullSupplier value;

    /**
     * Default constructor
     */
    public PullSupplierHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PullSupplierHolder(mtds.alicaldam.eventservice.CosEventComm.PullSupplier initial)
    {
        value = initial;
    }

    /**
     * Read PullSupplier from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PullSupplierHelper.read(istream);
    }

    /**
     * Write PullSupplier into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PullSupplierHelper.write(ostream,value);
    }

    /**
     * Return the PullSupplier TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PullSupplierHelper.type();
    }

}
