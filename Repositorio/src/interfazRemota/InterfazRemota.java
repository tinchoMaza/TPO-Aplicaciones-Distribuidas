package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
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
import excepciones.OrdenDePedidoException;
import excepciones.PedidoException;
import excepciones.RemitoException;

public interface InterfazRemota extends Remote {
	
	/*************************************************** CLIENTES ************************************************************************************/
	
	public abstract ClienteDTO buscarClienteByCuit(int cuit) throws RemoteException, ClienteException;
	
	public abstract float limiteCreditoDisponibleCliente(ClienteDTO clienteDTO) throws RemoteException, ClienteException;
	
	/*************************************************** PEDIDOS 
	 * @throws ArticuloException 
	 * @throws ClienteException 
	 * @throws OrdenDePedidoException ************************************************************************************/
	
	public abstract void altaPedido(List<ItemPedidoDTO> items, String estado, ClienteDTO cliente, String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio, int cpDirecEnvio) throws RemoteException, PedidoException, ClienteException, ArticuloException, OrdenDePedidoException;
	
	public abstract void actualizarEstadoPedido(PedidoDTO pedidoDTO, String estado) throws RemoteException, PedidoException;
	
	public abstract void actualizarFechaDespachoPedido(PedidoDTO pedidoDTO, Date fechaDespacho) throws RemoteException, PedidoException;
	
	public abstract void actualizarFechaEntregaEsperada(PedidoDTO pedidoDTO, Date fechaEntregaEsperada) throws RemoteException, PedidoException;
	
	public abstract void actualizarFechaEntrega(PedidoDTO pedidoDTO, Date fechaEntrega) throws RemoteException, PedidoException;
	
	public abstract List<PedidoDTO> buscarPedidosByCliente(int cuitCliente) throws RemoteException, PedidoException;
	
	public abstract List<PedidoDTO> buscarPedidosByEstado(String estado) throws RemoteException, PedidoException;
	
	
	/*************************************************** COMPROBANTES 
	 * @throws RemitoException 
	 * @throws ClienteException 
	 * @throws ArticuloException ************************************************************************************/
	
	public abstract void emitirComprobante(PedidoDTO pedidoDTO) throws RemoteException, PedidoException, FacturaException, ArticuloException, ClienteException, RemitoException;
	
	public abstract List<FacturaDTO> buscarFacturaByEstado(String estado) throws RemoteException, FacturaException;
	
	public abstract void pagarFactura(FacturaDTO facturaDTO) throws RemoteException, ClienteException, FacturaException;
	
	
	/*************************************************** ARTICULOS ************************************************************************************/

	public abstract ArticuloDTO buscarArticuloById(int idArticulo) throws RemoteException, ArticuloException;

	public abstract void cargarTodasUbicacionesYArticulos() throws RemoteException;

	public abstract List<UbicacionDTO> getUbicaciones() throws RemoteException;
}
