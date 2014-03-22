package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Holder class for : PushSupplier
 * 
 * @author OpenORB Compiler
 */
final public class PushSupplierHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal PushSupplier value
     */
    public mtds.alicaldam.eventservice.CosEventComm.PushSupplier value;

    /**
     * Default constructor
     */
    public PushSupplierHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PushSupplierHolder(mtds.alicaldam.eventservice.CosEventComm.PushSupplier initial)
    {
        value = initial;
    }

    /**
     * Read PushSupplier from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PushSupplierHelper.read(istream);
    }

    /**
     * Write PushSupplier into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PushSupplierHelper.write(ostream,value);
    }

    /**
     * Return the PushSupplier TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PushSupplierHelper.type();
    }

}
