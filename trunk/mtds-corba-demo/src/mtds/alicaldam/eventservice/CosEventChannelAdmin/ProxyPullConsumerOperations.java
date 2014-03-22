package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPullConsumer.
 * 
 * @author OpenORB Compiler
 */
public interface ProxyPullConsumerOperations extends mtds.alicaldam.eventservice.CosEventComm.PullConsumerOperations
{
    /**
     * Operation connect_pull_supplier
     */
    public void connect_pull_supplier(mtds.alicaldam.eventservice.CosEventComm.PullSupplier pull_supplier)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected, mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError;

}
