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
	
	/*************************************************** CLIENTES ************************************************************************************/
	
	public ClienteDTO buscarClienteByDni (int dni) throws RemoteException, ClienteException {
		return ir.buscarClienteByDni(dni);
	}
	
	public float limiteCreditoDisponibleCliente(ClienteDTO clienteDTO) throws RemoteException, ClienteException{
		return ir.limiteCreditoDisponibleCliente(clienteDTO);
	}
	
	
	/*************************************************** PEDIDOS 
	 * @throws ArticuloException 
	 * @throws ClienteException 
	 * @throws OrdenDePedidoException 
	 * @throws OrdenDeCompraException 
	 * @throws ProveedorException ************************************************************************************/
	
	public void altaPedido(List<ItemPedidoDTO> items, String estado, ClienteDTO cliente, String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio, int cpDirecEnvio) throws RemoteException, PedidoException, ClienteException, ArticuloException, OrdenDePedidoException, ProveedorException, OrdenDeCompraException {
		ir.altaPedido(items,  estado,  cliente,  formaDePago,  calleDireccEnvio,  nroDireccEnvio,  localidadDireccEnvio,  cpDirecEnvio);		
	}

	public void actualizarEstadoPedido(PedidoDTO pedidoDTO, String estado) throws RemoteException, PedidoException {
		ir.actualizarEstadoPedido(pedidoDTO, estado);
	}
	
	public void actualizarFechaDespachoPedido(PedidoDTO pedidoDTO, Date fechaDespacho) throws RemoteException, PedidoException {
		ir.actualizarFechaDespachoPedido(pedidoDTO, fechaDespacho);
	}
	
	public void actualizarFechaEntregaEsperada(PedidoDTO pedidoDTO, Date fechaEntregaEsperada) throws RemoteException, PedidoException {
		ir.actualizarFechaEntregaEsperada(pedidoDTO, fechaEntregaEsperada);
	}
	
	public void actualizarFechaEntrega(PedidoDTO pedidoDTO, Date fechaEntrega) throws RemoteException, PedidoException {
		ir.actualizarFechaEntrega(pedidoDTO, fechaEntrega);
	}
	
	public List<PedidoDTO> buscarPedidosByCliente(int cuitCliente) throws RemoteException, PedidoException {
		return ir.buscarPedidosByCliente(cuitCliente);
	}
	
	public List<PedidoDTO> buscarPedidosByEstado(String estado) throws RemoteException, PedidoException{
		return ir.buscarPedidosByEstado(estado);
		
	}
	
	
	
	/*************************************************** COMPROBANTES 
	 * @throws RemitoException 
	 * @throws ClienteException 
	 * @throws ArticuloException ************************************************************************************/
	
	public void emitirComprobante(PedidoDTO pedidoDTO) throws RemoteException, PedidoException, FacturaException, ArticuloException, ClienteException, RemitoException{
		ir.emitirComprobante(pedidoDTO);
	}
	
	public List<FacturaDTO> buscarFacturaByEstado(String estado) throws RemoteException, FacturaException{
		return ir.buscarFacturaByEstado(estado);
	}
	
	public void pagarFactura(FacturaDTO facturaDTO) throws RemoteException, ClienteException, FacturaException{
		ir.pagarFactura(facturaDTO);
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

}
