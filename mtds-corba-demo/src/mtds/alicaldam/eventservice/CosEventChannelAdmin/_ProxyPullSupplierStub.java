package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPullSupplier.
 * 
 * @author OpenORB Compiler
 */
public class _ProxyPullSupplierStub extends org.omg.CORBA.portable.ObjectImpl
        implements ProxyPullSupplier
{
    static final String[] _ids_list =
    {
        "IDL:CosEventChannelAdmin/ProxyPullSupplier:1.0", 
        "IDL:CosEventComm/PullSupplier:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierOperations.class;

    /**
     * Operation connect_pull_consumer
     */
    public void connect_pull_consumer(mtds.alicaldam.eventservice.CosEventComm.PullConsumer pull_consumer)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("connect_pull_consumer",true);
                    mtds.alicaldam.eventservice.CosEventComm.PullConsumerHelper.write(_output,pull_consumer);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connect_pull_consumer",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullSupplierOperations) _so.servant;
                try
                {
                    _self.connect_pull_consumer( pull_consumer);
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
     * Operation pull
     */
    public org.omg.CORBA.Any pull()
        throws mtds.alicaldam.eventservice.CosEventComm.Disconnected
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("pull",true);
                    _input = this._invoke(_output);
                    org.omg.CORBA.Any _arg_ret = _input.read_any();
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("pull",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventComm.PullSupplierOperations _self = (mtds.alicaldam.eventservice.CosEventComm.PullSupplierOperations) _so.servant;
                try
                {
                    return _self.pull();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation try_pull
     */
    public org.omg.CORBA.Any try_pull(org.omg.CORBA.BooleanHolder has_event)
        throws mtds.alicaldam.eventservice.CosEventComm.Disconnected
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("try_pull",true);
                    _input = this._invoke(_output);
                    org.omg.CORBA.Any _arg_ret = _input.read_any();
                    has_event.value = _input.read_boolean();
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("try_pull",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventComm.PullSupplierOperations _self = (mtds.alicaldam.eventservice.CosEventComm.PullSupplierOperations) _so.servant;
                try
                {
                    return _self.try_pull( has_event);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation disconnect_pull_supplier
     */
    public void disconnect_pull_supplier()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("disconnect_pull_supplier",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("disconnect_pull_supplier",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventComm.PullSupplierOperations _self = (mtds.alicaldam.eventservice.CosEventComm.PullSupplierOperations) _so.servant;
                try
                {
                    _self.disconnect_pull_supplier();
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
