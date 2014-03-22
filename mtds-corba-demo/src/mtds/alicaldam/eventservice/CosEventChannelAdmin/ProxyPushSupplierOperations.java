package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPushSupplier.
 * 
 * @author OpenORB Compiler
 */
public interface ProxyPushSupplierOperations extends mtds.alicaldam.eventservice.CosEventComm.PushSupplierOperations
{
    /**
     * Operation connect_push_consumer
     */
    public void connect_push_consumer(mtds.alicaldam.eventservice.CosEventComm.PushConsumer push_consumer)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected, mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError;

}
