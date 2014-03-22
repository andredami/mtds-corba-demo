package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: EventChannel.
 * 
 * @author OpenORB Compiler
 */
public interface EventChannelOperations
{
    /**
     * Operation for_consumers
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin for_consumers();

    /**
     * Operation for_suppliers
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin for_suppliers();

    /**
     * Operation destroy
     */
    public void destroy();

}
