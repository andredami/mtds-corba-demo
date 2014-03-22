package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PullConsumer.
 * 
 * @author OpenORB Compiler
 */
public class _PullConsumerStub extends org.omg.CORBA.portable.ObjectImpl
        implements PullConsumer
{
    static final String[] _ids_list =
    {
        "IDL:CosEventComm/PullConsumer:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventComm.PullConsumerOperations.class;

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
