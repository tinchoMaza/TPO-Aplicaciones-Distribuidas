package objetoRemoto;

import interfazRemota.InterfazRemota;

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
import excepciones.CuentaCorrienteException;
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
	
	
	/********************************************* CLIENTES 
	 * @throws ClienteException *********************************************/
	



	public ClienteDTO buscarClienteByDni(int dni) throws ClienteException {
		return ControladorClientes.getInstancia().buscarClienteByDni(dni).toDTO();
	}
	
	/********************************************* PEDIDOS 
	 * @throws ArticuloException 
	 * @throws ClienteException 
	 * @throws OrdenDePedidoException 
	 * @throws OrdenDeCompraException 
	 * @throws ProveedorException 
	 * @throws RemitoException 
	 * @throws FacturaException 
	 * @throws CuentaCorrienteException *********************************************/
	
	
	
	public void altaPedido(List<ItemPedidoDTO> items, String estado, ClienteDTO cliente, String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio, int cpDirecEnvio)
			throws RemoteException, PedidoException, ClienteException, ArticuloException, OrdenDePedidoException, ProveedorException, OrdenDeCompraException, FacturaException, RemitoException, CuentaCorrienteException {
				ControladorClientes.getInstancia().altaPedido(items, estado, cliente, formaDePago, calleDireccEnvio, nroDireccEnvio, localidadDireccEnvio, cpDirecEnvio);
			}
	
	public List<PedidoDTO> buscarPedidosByEstado(String estado) throws RemoteException, PedidoException{
		return ControladorClientes.getInstancia().buscarPedidosByEstado(estado);
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
