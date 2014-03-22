package mtds.alicaldam.eventservice.CosEventComm;

import org.omg.CORBA.Any;

/** 
 * Helper class for : Disconnected
 *  
 * @author OpenORB Compiler
 */ 
public class DisconnectedHelper
{
    private static final boolean HAS_OPENORB;
    static
    {
        boolean hasOpenORB = false;
        try
        {
            Thread.currentThread().getContextClassLoader().loadClass( "org.openorb.orb.core.Any" );
            hasOpenORB = true;
        }
        catch ( ClassNotFoundException ex )
        {
            // do nothing
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert Disconnected into an any
     * @param a an any
     * @param t Disconnected value
     */
    public static void insert(org.omg.CORBA.Any a, mtds.alicaldam.eventservice.CosEventComm.Disconnected t)
    {
        a.insert_Streamable(new mtds.alicaldam.eventservice.CosEventComm.DisconnectedHolder(t));
    }

    /**
     * Extract Disconnected from an any
     *
     * @param a an any
     * @return the extracted Disconnected value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.Disconnected extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        if (HAS_OPENORB && a instanceof Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            Any any = (Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if ( s instanceof mtds.alicaldam.eventservice.CosEventComm.DisconnectedHolder )
                    return ( ( mtds.alicaldam.eventservice.CosEventComm.DisconnectedHolder ) s ).value;
            }
            catch ( org.omg.CORBA.BAD_INV_ORDER ex )
            {
            }
            mtds.alicaldam.eventservice.CosEventComm.DisconnectedHolder h = new mtds.alicaldam.eventservice.CosEventComm.DisconnectedHolder( read( a.create_input_stream() ) );
            a.insert_Streamable( h );
            return h.value;
        }
        return read( a.create_input_stream() );
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the Disconnected TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember _members[] = new org.omg.CORBA.StructMember[ 0 ];

                _tc = orb.create_exception_tc( id(), "Disconnected", _members );
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Disconnected IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CosEventComm/Disconnected:1.0";

    /**
     * Read Disconnected from a marshalled stream
     * @param istream the input stream
     * @return the readed Disconnected value
     */
    public static mtds.alicaldam.eventservice.CosEventComm.Disconnected read(org.omg.CORBA.portable.InputStream istream)
    {
        mtds.alicaldam.eventservice.CosEventComm.Disconnected new_one = new mtds.alicaldam.eventservice.CosEventComm.Disconnected();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();

        return new_one;
    }

    /**
     * Write Disconnected into a marshalled stream
     * @param ostream the output stream
     * @param value Disconnected value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, mtds.alicaldam.eventservice.CosEventComm.Disconnected value)
    {
        ostream.write_string(id());
    }

}
