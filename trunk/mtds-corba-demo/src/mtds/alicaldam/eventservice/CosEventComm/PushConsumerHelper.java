package mtds.alicaldam.eventservice.CosEventComm;

/** 
 * Helper class for : PushConsumer
 *  
 * @author OpenORB Compiler
 */ 
public class PushConsumerHelper
{
    /**
     * Insert PushConsumer into an any
     * @param a an any
     * @param t PushConsumer value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventComm.PushConsumer t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract PushConsumer from an any
     *
     * @param a an any
     * @return the extracted PushConsumer value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.PushConsumer extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventComm.PushConsumerHelper.narrow( a.extract_Object() );
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
     * Return the PushConsumer TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "PushConsumer" );
        }
        return _tc;
    }

    /**
     * Return the PushConsumer IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventComm/PushConsumer:1.0";

    /**
     * Read PushConsumer from a marshalled stream
     * @param istream the input stream
     * @return the readed PushConsumer value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.PushConsumer read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventComm.PushConsumer)istream.read_Object(mtds.alicaldam.eventservice.CosEventComm._PushConsumerStub.class);
    }

    /**
     * Write PushConsumer into a marshalled stream
     * @param ostream the output stream
     * @param value PushConsumer value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventComm.PushConsumer value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to PushConsumer
     * @param obj the CORBA Object
     * @return PushConsumer Object
     */
    public static PushConsumer narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof PushConsumer)
            return (PushConsumer)obj;

        if (obj._is_a(id()))
        {
            _PushConsumerStub stub = new _PushConsumerStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to PushConsumer
     * @param obj the CORBA Object
     * @return PushConsumer Object
     */
    public static PushConsumer unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof PushConsumer)
            return (PushConsumer)obj;

        _PushConsumerStub stub = new _PushConsumerStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
