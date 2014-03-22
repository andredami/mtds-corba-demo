package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PushConsumer.
 * 
 * @author OpenORB Compiler
 */
public class _PushConsumerStub extends org.omg.CORBA.portable.ObjectImpl
        implements PushConsumer
{
    static final String[] _ids_list =
    {
        "IDL:CosEventComm/PushConsumer:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventComm.PushConsumerOperations.class;

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
