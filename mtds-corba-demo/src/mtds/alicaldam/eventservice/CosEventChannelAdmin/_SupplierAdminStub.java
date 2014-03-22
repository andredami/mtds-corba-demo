package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: SupplierAdmin.
 * 
 * @author OpenORB Compiler
 */
public class _SupplierAdminStub extends org.omg.CORBA.portable.ObjectImpl
        implements SupplierAdmin
{
    static final String[] _ids_list =
    {
        "IDL:CosEventChannelAdmin/SupplierAdmin:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminOperations.class;

    /**
     * Operation obtain_push_consumer
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer obtain_push_consumer()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("obtain_push_consumer",true);
                    _input = this._invoke(_output);
                    mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumer _arg_ret = mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("obtain_push_consumer",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminOperations) _so.servant;
                try
                {
                    return _self.obtain_push_consumer();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation obtain_pull_consumer
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer obtain_pull_consumer()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("obtain_pull_consumer",true);
                    _input = this._invoke(_output);
                    mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumer _arg_ret = mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("obtain_pull_consumer",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminOperations) _so.servant;
                try
                {
                    return _self.obtain_pull_consumer();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
