package mtds.alicaldam.eventservice.CosEventChannelAdmin;

/**
 * Interface definition: ProxyPullConsumer.
 * 
 * @author OpenORB Compiler
 */
public class _ProxyPullConsumerStub extends org.omg.CORBA.portable.ObjectImpl
        implements ProxyPullConsumer
{
    static final String[] _ids_list =
    {
        "IDL:CosEventChannelAdmin/ProxyPullConsumer:1.0", 
        "IDL:CosEventComm/PullConsumer:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerOperations.class;

    /**
     * Operation connect_pull_supplier
     */
    public void connect_pull_supplier(mtds.alicaldam.eventservice.CosEventComm.PullSupplier pull_supplier)
        throws mtds.alicaldam.eventservice.CosEventChannelAdmin.AlreadyConnected, mtds.alicaldam.eventservice.CosEventChannelAdmin.TypeError
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("connect_pull_supplier",true);
                    mtds.alicaldam.eventservice.CosEventComm.PullSupplierHelper.write(_output,pull_supplier);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connect_pull_supplier",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerOperations _self = (mtds.alicaldam.eventservice.CosEventChannelAdmin.ProxyPullConsumerOperations) _so.servant;
                try
                {
                    _self.connect_pull_supplier( pull_supplier);
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
     * Operation disconnect_pull_consumer
     */
    public void disconnect_pull_consumer()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("disconnect_pull_consumer",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("disconnect_pull_consumer",_opsClass);
                if (_so == null)
                   continue;
                mtds.alicaldam.eventservice.CosEventComm.PullConsumerOperations _self = (mtds.alicaldam.eventservice.CosEventComm.PullConsumerOperations) _so.servant;
                try
                {
                    _self.disconnect_pull_consumer();
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
