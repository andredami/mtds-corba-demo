package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPushConsumer.
 * 
 * @author OpenORB Compiler
 */
public interface ProxyPushConsumerOperations extends mtds.alicaldam.eventservice.CosEventComm.PushConsumerOperations
{
    /**
     * Operation connect_push_supplier
     */
    public void connect_push_supplier(mtds.alicaldam.eventservice.CosEventComm.PushSupplier push_supplier)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;

}
