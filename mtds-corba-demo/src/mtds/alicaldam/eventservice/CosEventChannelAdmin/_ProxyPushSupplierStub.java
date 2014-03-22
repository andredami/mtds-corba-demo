package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPushSupplier.
 * 
 * @author OpenORB Compiler
 */
public class _ProxyPushSupplierStub extends org.omg.CORBA.portable.ObjectImpl
        implements ProxyPushSupplier
{
    static final String[] _ids_list =
    {
        "IDL:CosEventChannelAdmin/ProxyPushSupplier:1.0", 
        "IDL:CosEventComm/PushSupplier:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplierOperations.class;

    /**
     * Operation connect_push_consumer
     */
    public void connect_push_consumer(mtds.alicaldam.eventservice.CosEventComm.PushConsumer push_consumer)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected, mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("connect_push_consumer",true);
                    mtds.alicaldam.eventservice.CosEventComm.PushConsumerHelper.write(_output,push_consumer);
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
                    if (_exception_id.equals(mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnectedHelper.id()))
                    {
                        throw mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnectedHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeErrorHelper.id()))
                    {
                        throw mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeErrorHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connect_push_consumer",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplierOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushSupplierOperations) _so.servant;
                try
                {
                    _self.connect_push_consumer( push_consumer);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation disconnect_push_supplier
     */
    public void disconnect_push_supplier()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("disconnect_push_supplier",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("disconnect_push_supplier",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventComm.PushSupplierOperations _self = (mtds.alicaldam.eventservice.CosEventComm.PushSupplierOperations) _so.servant;
                try
                {
                    _self.disconnect_push_supplier();
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
