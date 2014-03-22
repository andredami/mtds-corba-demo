package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPushConsumer.
 * 
 * @author OpenORB Compiler
 */
public class _ProxyPushConsumerStub extends org.omg.CORBA.portable.ObjectImpl
        implements ProxyPushConsumer
{
    static final String[] _ids_list =
    {
        "IDL:CosEventChannelAdmin/ProxyPushConsumer:1.0", 
        "IDL:CosEventComm/PushConsumer:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerOperations.class;

    /**
     * Operation connect_push_supplier
     */
    public void connect_push_supplier(mtds.alicaldam.eventservice.CosEventComm.PushSupplier push_supplier)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("connect_push_supplier",true);
                    mtds.alicaldam.eventservice.CosEventComm.PushSupplierHelper.write(_output,push_supplier);
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

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connect_push_supplier",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPushConsumerOperations) _so.servant;
                try
                {
                    _self.connect_push_supplier( push_supplier);
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
     * Operation push
     */
    public void push(org.omg.CORBA.Any data)
        throws mtds.alicaldam.eventservice.CosEventComm.Disconnected
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("push",true);
                    _output.write_any(data);
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
                    if (_exception_id.equals(mtds.alicaldam.eventservice.CosEventComm.DisconnectedHelper.id()))
                    {
                        throw mtds.alicaldam.eventservice.CosEventComm.DisconnectedHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("push",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventComm.PushConsumerOperations _self = (mtds.alicaldam.eventservice.CosEventComm.PushConsumerOperations) _so.servant;
                try
                {
                    _self.push( data);
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
     * Operation disconnect_push_consumer
     */
    public void disconnect_push_consumer()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("disconnect_push_consumer",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("disconnect_push_consumer",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventComm.PushConsumerOperations _self = (mtds.alicaldam.eventservice.CosEventComm.PushConsumerOperations) _so.servant;
                try
                {
                    _self.disconnect_push_consumer();
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
