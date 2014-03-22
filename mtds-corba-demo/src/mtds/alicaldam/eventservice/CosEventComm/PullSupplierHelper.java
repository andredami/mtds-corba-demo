package mtds.alicaldam.eventservice.CosEventComm;

/** 
 * Helper class for : PullSupplier
 *  
 * @author OpenORB Compiler
 */ 
public class PullSupplierHelper
{
    /**
     * Insert PullSupplier into an any
     * @param a an any
     * @param t PullSupplier value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventComm.PullSupplier t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract PullSupplier from an any
     *
     * @param a an any
     * @return the extracted PullSupplier value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.PullSupplier extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventComm.PullSupplierHelper.narrow( a.extract_Object() );
        }
        catch ( final org.omg.CORBA.BAD_PARAM e )
        {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the PullSupplier TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "PullSupplier" );
        }
        return _tc;
    }

    /**
     * Return the PullSupplier IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventComm/PullSupplier:1.0";

    /**
     * Read PullSupplier from a marshalled stream
     * @param istream the input stream
     * @return the readed PullSupplier value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.PullSupplier read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventComm.PullSupplier)istream.read_Object(mtds.alicaldam.eventservice.CosEventComm._PullSupplierStub.class);
    }

    /**
     * Write PullSupplier into a marshalled stream
     * @param ostream the output stream
     * @param value PullSupplier value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventComm.PullSupplier value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to PullSupplier
     * @param obj the CORBA Object
     * @return PullSupplier Object
     */
    public static PullSupplier narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof PullSupplier)
            return (PullSupplier)obj;

        if (obj._is_a(id()))
        {
            _PullSupplierStub stub = new _PullSupplierStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to PullSupplier
     * @param obj the CORBA Object
     * @return PullSupplier Object
     */
    public static PullSupplier unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof PullSupplier)
            return (PullSupplier)obj;

        _PullSupplierStub stub = new _PullSupplierStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
