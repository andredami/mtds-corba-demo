package mtds.alicaldam.eventservice.CosEventComm;

/** 
 * Helper class for : PullConsumer
 *  
 * @author OpenORB Compiler
 */ 
public class PullConsumerHelper
{
    /**
     * Insert PullConsumer into an any
     * @param a an any
     * @param t PullConsumer value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventComm.PullConsumer t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract PullConsumer from an any
     *
     * @param a an any
     * @return the extracted PullConsumer value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.PullConsumer extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return mtds.alicaldam.eventservice.CosEventComm.PullConsumerHelper.narrow( a.extract_Object() );
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
     * Return the PullConsumer TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "PullConsumer" );
        }
        return _tc;
    }

    /**
     * Return the PullConsumer IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventComm/PullConsumer:1.0";

    /**
     * Read PullConsumer from a marshalled stream
     * @param istream the input stream
     * @return the readed PullConsumer value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.PullConsumer read(org.omg.CORBA.portable.InputStream istream)
    {
        return(mtds.alicaldam.eventservice.CosEventComm.PullConsumer)istream.read_Object(mtds.alicaldam.eventservice.CosEventComm._PullConsumerStub.class);
    }

    /**
     * Write PullConsumer into a marshalled stream
     * @param ostream the output stream
     * @param value PullConsumer value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventComm.PullConsumer value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to PullConsumer
     * @param obj the CORBA Object
     * @return PullConsumer Object
     */
    public static PullConsumer narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof PullConsumer)
            return (PullConsumer)obj;

        if (obj._is_a(id()))
        {
            _PullConsumerStub stub = new _PullConsumerStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to PullConsumer
     * @param obj the CORBA Object
     * @return PullConsumer Object
     */
    public static PullConsumer unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof PullConsumer)
            return (PullConsumer)obj;

        _PullConsumerStub stub = new _PullConsumerStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
