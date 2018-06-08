package objetoRemoto;

import interfazRemota.InterfazRemota;
import negocio.Articulo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
import controladores.ControladorClientes;
import controladores.ControladorCompras;
import controladores.ControladorDeposito;
import controladores.ControladorDespacho;
import controladores.ControladorFacturacion;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfazRemota  {

	private static final long serialVersionUID = 1L;

	public ObjetoRemoto() throws RemoteException {
		super();
	}
	
	
	
	
	/********************************************* CLIENTES *********************************************/
	
	

	public ClienteDTO buscarClienteByDni(int dni) throws RemoteException, ClienteException {
		
		return ControladorClientes.getInstancia().buscarClienteByDni(dni);
	}
	
	public List<PedidoDTO> buscarPedidosByCliente(int cuitCliente) throws RemoteException, PedidoException {
		return ControladorClientes.getInstancia().buscarPedidosByCliente(cuitCliente);
	}
	
	public float limiteCreditoDisponibleCliente(ClienteDTO clienteDTO) throws RemoteException, ClienteException {
		// TODO Auto-generated method stub
		return ControladorFacturacion.getInstancia().limiteCreditoDisponible(clienteDTO);
	}
	
	/********************************************* PEDIDOS 
	 * @throws ArticuloException 
	 * @throws ClienteException 
	 * @throws OrdenDePedidoException 
	 * @throws OrdenDeCompraException 
	 * @throws ProveedorException *********************************************/
	
	
	
	public void altaPedido(List<ItemPedidoDTO> items, String estado, ClienteDTO cliente, String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio, int cpDirecEnvio)
			throws RemoteException, PedidoException, ClienteException, ArticuloException, OrdenDePedidoException, ProveedorException, OrdenDeCompraException {
				ControladorClientes.getInstancia().altaPedido(items, estado, cliente, formaDePago, calleDireccEnvio, nroDireccEnvio, localidadDireccEnvio, cpDirecEnvio);
			}

	public void actualizarEstadoPedido(PedidoDTO pedidoDTO, String estado) throws RemoteException, PedidoException {
		ControladorDespacho.getInstancia().actualizarEstadoDelPedido(estado, pedidoDTO);
	}
	
	
	public void actualizarFechaDespachoPedido(PedidoDTO pedidoDTO, Date fechaDespacho)
			throws RemoteException, PedidoException {
		ControladorDespacho.getInstancia().actualizarFechaDespachoPedido(pedidoDTO, fechaDespacho);
		
	}

	public void actualizarFechaEntregaEsperada(PedidoDTO pedidoDTO, Date fechaEntregaEsperada)
			throws RemoteException, PedidoException {
		ControladorDespacho.getInstancia().actualizarFechaEntregaEsperada(pedidoDTO, fechaEntregaEsperada);
		
	}

	public void actualizarFechaEntrega(PedidoDTO pedidoDTO, Date fechaEntrega) throws RemoteException, PedidoException {
		ControladorDespacho.getInstancia().actualizarFechaEntrega(pedidoDTO, fechaEntrega);
		
	}
	
	public List<PedidoDTO> buscarPedidosByEstado(String estado) throws RemoteException, PedidoException{
		return ControladorClientes.getInstancia().buscarPedidosByEstado(estado);
	}
	
	
	/********************************************* COMPROBANTES 
	 * @throws RemitoException 
	 * @throws ClienteException 
	 * @throws ArticuloException *********************************************/
	
	
	public void emitirComprobante(PedidoDTO pedidoDTO) throws RemoteException, PedidoException, FacturaException, ArticuloException, ClienteException, RemitoException{
		ControladorFacturacion.getInstancia().emitirComprobantes(pedidoDTO);
	}
	
	public List<FacturaDTO> buscarFacturaByEstado(String estado) throws RemoteException, FacturaException{
		return ControladorFacturacion.getInstancia().buscarFacturaByEstado(estado);
	}
	
	public void pagarFactura(FacturaDTO facturaDTO) throws RemoteException, ClienteException, FacturaException {
		ControladorFacturacion.getInstancia().pagar(facturaDTO);
		
	}

	/********************************************* ARTICULOS *********************************************/

	public ArticuloDTO buscarArticuloById(int idArticulo) throws RemoteException, ArticuloException {
		return ControladorDeposito.getInstancia().buscarArticuloById(idArticulo);
	}


	public void cargarTodasUbicacionesYArticulos() throws RemoteException{
		ControladorDeposito.getInstancia().cargarTodasUbicacionesYArticulos();
	}

	public List<UbicacionDTO> getUbicaciones() {
		return ControladorDeposito.getInstancia().getUbicaciones();
	}



	/**************************************************************************COMPRAS
	 * @throws UbicacionException 
	 * @throws OrdenDeCompraException 
	 * @throws LoteException 
	 * @throws ArticuloException 
	 * @throws SQLException 
	 * @throws PedidoException ***********************************************************************************************************************************************************************************************************************************************************************************************/
	@Override
	public void procesarOC(int idOC) throws RemoteException, PedidoException, SQLException, ArticuloException, LoteException, OrdenDeCompraException, UbicacionException {
		ControladorCompras.getInstancia().procesarOC(idOC);
		
	}

}
