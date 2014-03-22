package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: EventChannel.
 * 
 * @author OpenORB Compiler
 */
public class _EventChannelStub extends org.omg.CORBA.portable.ObjectImpl
        implements EventChannel
{
    static final String[] _ids_list =
    {
        "IDL:CosEventChannelAdmin/EventChannel:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelOperations.class;

    /**
     * Operation for_consumers
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin for_consumers()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("for_consumers",true);
                    _input = this._invoke(_output);
                    mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdmin _arg_ret = mtds.alicaldam.eventservice.CosEventChannelAdmin.ConsumerAdminHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("for_consumers",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelOperations) _so.servant;
                try
                {
                    return _self.for_consumers();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation for_suppliers
     */
    public mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin for_suppliers()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("for_suppliers",true);
                    _input = this._invoke(_output);
                    mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdmin _arg_ret = mtds.alicaldam.eventservice.CosEventChannelAdmin.SupplierAdminHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("for_suppliers",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelOperations) _so.servant;
                try
                {
                    return _self.for_suppliers();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation destroy
     */
    public void destroy()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("destroy",true);
                    _input = this._invoke(_output);
                    return;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("destroy",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.EventChannelOperations) _so.servant;
                try
                {
                    _self.destroy();
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
