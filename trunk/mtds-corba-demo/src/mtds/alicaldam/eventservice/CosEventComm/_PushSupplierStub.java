package mtds.alicaldam.eventservice.CosEventComm;

/**
 * Interface definition: PushSupplier.
 * 
 * @author OpenORB Compiler
 */
public class _PushSupplierStub extends org.omg.CORBA.portable.ObjectImpl
        implements PushSupplier
{
    static final String[] _ids_list =
    {
        "IDL:CosEventComm/PushSupplier:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = mtds.alicaldam.eventservice.CosEventComm.PushSupplierOperations.class;

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
