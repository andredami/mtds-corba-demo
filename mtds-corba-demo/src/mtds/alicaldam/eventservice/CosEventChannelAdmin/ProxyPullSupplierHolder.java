package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Holder class for : ProxyPullSupplier
 * 
 * @author OpenORB Compiler
 */
final public class ProxyPullSupplierHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ProxyPullSupplier value
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier value;

    /**
     * Default constructor
     */
    public ProxyPullSupplierHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ProxyPullSupplierHolder(mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier initial)
    {
        value = initial;
    }

    /**
     * Read ProxyPullSupplier from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ProxyPullSupplierHelper.read(istream);
    }

    /**
     * Write ProxyPullSupplier into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ProxyPullSupplierHelper.write(ostream,value);
    }

    /**
     * Return the ProxyPullSupplier TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ProxyPullSupplierHelper.type();
    }

}
