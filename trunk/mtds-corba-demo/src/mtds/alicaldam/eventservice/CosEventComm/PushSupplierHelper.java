package mtds.alicaldam.eventservice.CosEventComm;

/** 
 * Helper class for : PushSupplier
 *  
 * @author OpenORB Compiler
 */ 
public class PushSupplierHelper
{
    /**
     * Insert PushSupplier into an any
     * @param a an any
     * @param t PushSupplier value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventComm.PushSupplier t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract PushSupplier from an any
     *
     * @param a an any
     * @return the extracted PushSupplier value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.PushSupplier extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventComm.PushSupplierHelper.narrow( a.extract_Object() );
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
     * Return the PushSupplier TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "PushSupplier" );
        }
        return _tc;
    }

    /**
     * Return the PushSupplier IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventComm/PushSupplier:1.0";

    /**
     * Read PushSupplier from a marshalled stream
     * @param istream the input stream
     * @return the readed PushSupplier value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.PushSupplier read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventComm.PushSupplier)istream.read_Object(mtds.alicaldam.eventservice.CosEventComm._PushSupplierStub.class);
    }

    /**
     * Write PushSupplier into a marshalled stream
     * @param ostream the output stream
     * @param value PushSupplier value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventComm.PushSupplier value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to PushSupplier
     * @param obj the CORBA Object
     * @return PushSupplier Object
     */
    public static PushSupplier narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof PushSupplier)
            return (PushSupplier)obj;

        if (obj._is_a(id()))
        {
            _PushSupplierStub stub = new _PushSupplierStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to PushSupplier
     * @param obj the CORBA Object
     * @return PushSupplier Object
     */
    public static PushSupplier unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof PushSupplier)
            return (PushSupplier)obj;

        _PushSupplierStub stub = new _PushSupplierStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
