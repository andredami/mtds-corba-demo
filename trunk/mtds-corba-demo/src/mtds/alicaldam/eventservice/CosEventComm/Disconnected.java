package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Exception definition: Disconnected.
 * 
 * @author OpenORB Compiler
 */
public final class Disconnected extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public Disconnected()
    {
        super(DisconnectedHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public Disconnected(String orb_reason)
    {
        super(DisconnectedHelper.id() +" " +  orb_reason);
    }

}
