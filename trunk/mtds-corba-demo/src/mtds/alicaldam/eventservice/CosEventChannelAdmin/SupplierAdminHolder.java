package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Holder class for : SupplierAdmin
 * 
 * @author OpenORB Compiler
 */
final public class SupplierAdminHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal SupplierAdmin value
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin value;

    /**
     * Default constructor
     */
    public SupplierAdminHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public SupplierAdminHolder(mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin initial)
    {
        value = initial;
    }

    /**
     * Read SupplierAdmin from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = SupplierAdminHelper.read(istream);
    }

    /**
     * Write SupplierAdmin into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        SupplierAdminHelper.write(ostream,value);
    }

    /**
     * Return the SupplierAdmin TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return SupplierAdminHelper.type();
    }

}
