package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPullSupplier.
 * 
 * @author OpenORB Compiler
 */
public interface ProxyPullSupplierOperations extends mtds.alicaldam.eventservice.CosEventComm.PullSupplierOperations
{
    /**
     * Operation connect_pull_consumer
     */
    public void connect_pull_consumer(mtds.alicaldam.eventservice.CosEventComm.PullConsumer pull_consumer)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected;

}
