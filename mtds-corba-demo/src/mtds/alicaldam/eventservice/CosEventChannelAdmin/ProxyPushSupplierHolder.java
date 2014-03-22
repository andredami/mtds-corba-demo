package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Holder class for : ProxyPushSupplier
 * 
 * @author OpenORB Compiler
 */
final public class ProxyPushSupplierHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ProxyPushSupplier value
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier value;

    /**
     * Default constructor
     */
    public ProxyPushSupplierHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ProxyPushSupplierHolder(mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier initial)
    {
        value = initial;
    }

    /**
     * Read ProxyPushSupplier from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ProxyPushSupplierHelper.read(istream);
    }

    /**
     * Write ProxyPushSupplier into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ProxyPushSupplierHelper.write(ostream,value);
    }

    /**
     * Return the ProxyPushSupplier TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ProxyPushSupplierHelper.type();
    }

}
