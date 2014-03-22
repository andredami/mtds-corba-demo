package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PushConsumer.
 * 
 * @author OpenORB Compiler
 */
public interface PushConsumerOperations
{
    /**
     * Operation push
     */
    public void push(org.omg.CORBA.Any data)
        throws mtds.alicaldam.eventservice.CosEventComm.Disconnected;

    /**
     * Operation disconnect_push_consumer
     */
    public void disconnect_push_consumer();

}
