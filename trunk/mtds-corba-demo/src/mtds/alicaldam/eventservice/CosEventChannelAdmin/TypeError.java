package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Exception definition: TypeError.
 * 
 * @author OpenORB Compiler
 */
public final class TypeError extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public TypeError()
    {
        super(TypeErrorHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public TypeError(String orb_reason)
    {
        super(TypeErrorHelper.id() +" " +  orb_reason);
    }

}
