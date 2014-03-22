package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ConsumerAdmin.
 * 
 * @author OpenORB Compiler
 */
public class _ConsumerAdminStub extends org.omg.CORBA.portable.ObjectImpl
        implements ConsumerAdmin
{
    static final String[] _ids_list =
    {
        "IDL:CosEventChannelAdmin/ConsumerAdmin:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminOperations.class;

    /**
     * Operation obtain_push_supplier
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier obtain_push_supplier()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("obtain_push_supplier",true);
                    _input = this._invoke(_output);
                    mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplier _arg_ret = mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplierHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("obtain_push_supplier",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminOperations) _so.servant;
                try
                {
                    return _self.obtain_push_supplier();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation obtain_pull_supplier
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier obtain_pull_supplier()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("obtain_pull_supplier",true);
                    _input = this._invoke(_output);
                    mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplier _arg_ret = mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("obtain_pull_supplier",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminOperations) _so.servant;
                try
                {
                    return _self.obtain_pull_supplier();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
