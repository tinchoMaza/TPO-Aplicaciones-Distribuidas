package delegado;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import dto.ArticuloDTO;
import dto.ClienteDTO;
import dto.FacturaDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import dto.UbicacionDTO;
import excepciones.ArticuloException;
import excepciones.ClienteException;
import excepciones.CuentaCorrienteException;
import excepciones.FacturaException;
import excepciones.LoteException;
import excepciones.OrdenDeCompraException;
import excepciones.OrdenDePedidoException;
import excepciones.PedidoException;
import excepciones.ProveedorException;
import excepciones.RemitoException;
import excepciones.UbicacionException;
import interfazRemota.InterfazRemota;

public class BusinessDelegate {
	
	private static BusinessDelegate instancia;
	private InterfazRemota ir;
	
	public static BusinessDelegate getInstancia() {
		if (instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	private BusinessDelegate() {
		try {
			ir = (InterfazRemota) Naming.lookup ("rmi://localhost/circuitoPedidos");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*************************************************** PEDIDOS 
	 * @throws ArticuloException 
	 * @throws ClienteException 
	 * @throws OrdenDePedidoException 
	 * @throws OrdenDeCompraException 
	 * @throws ProveedorException 
	 * @throws RemitoException 
	 * @throws FacturaException 
	 * @throws CuentaCorrienteException ************************************************************************************/
	
	public void altaPedido(List<ItemPedidoDTO> items, String estado, ClienteDTO cliente, String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio, int cpDirecEnvio) throws RemoteException, PedidoException, ClienteException, ArticuloException, OrdenDePedidoException, ProveedorException, OrdenDeCompraException, FacturaException, RemitoException, CuentaCorrienteException {
		ir.altaPedido(items,  estado,  cliente,  formaDePago,  calleDireccEnvio,  nroDireccEnvio,  localidadDireccEnvio,  cpDirecEnvio);		
	}
	
	public List<PedidoDTO> buscarPedidosByEstado(String estado) throws RemoteException, PedidoException{
		return ir.buscarPedidosByEstado(estado);
		
	}
	
	/*************************************************** ARTICULOS ************************************************************************************/

	
	public ArticuloDTO buscarArticuloById(int idArticulo) throws RemoteException, ArticuloException {
		return ir.buscarArticuloById(idArticulo);
	}

	public void cargarTodasUbicacionesYArticulos() throws RemoteException{
		ir.cargarTodasUbicacionesYArticulos();
		
	}

	public List<UbicacionDTO> getUbicaciones() throws RemoteException {
		return ir.getUbicaciones();
	}

	public void procesarOC(int idOC) throws RemoteException, PedidoException, SQLException, ArticuloException, LoteException, OrdenDeCompraException, UbicacionException {
		ir.procesarOC(idOC);
		
	}

	public ClienteDTO buscarClienteByDni(int dni) throws RemoteException, ClienteException {
		return ir.buscarClienteByDni(dni);
		
	}

}
