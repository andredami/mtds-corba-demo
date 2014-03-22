package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Exception definition: AlreadyConnected.
 * 
 * @author OpenORB Compiler
 */
public final class AlreadyConnected extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public AlreadyConnected()
    {
        super(AlreadyConnectedHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public AlreadyConnected(String orb_reason)
    {
        super(AlreadyConnectedHelper.id() +" " +  orb_reason);
    }

}
