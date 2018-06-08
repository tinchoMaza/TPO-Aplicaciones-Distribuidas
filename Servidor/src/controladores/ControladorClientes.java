package controladores;
import negocio.Pedido;

import java.util.*;
import dao.ArticuloDao;
import dao.ClienteDao;
import dao.PedidoDao;
import dto.ClienteDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import excepciones.ArticuloException;
import excepciones.ClienteException;
import excepciones.OrdenDeCompraException;
import excepciones.OrdenDePedidoException;
import excepciones.PedidoException;
import excepciones.ProveedorException;
import negocio.Articulo;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.ItemPedido;

public class ControladorClientes {

	private static ControladorClientes instancia;

	public static ControladorClientes getInstancia() {
		if(instancia==null) {
			instancia = new ControladorClientes();
		}
		return instancia;
	}

	private List<Pedido> pedidosRealizados = new ArrayList<Pedido>();
	private List<Cliente> misClientes = new ArrayList<Cliente>();

	public void agregarCliente(int dni, String nombre, String rznSoc, int cuit, float limCredito, CuentaCorriente cuentaCorriente, String condEspePago, String notaAdv, String calleDom, int nroDom, String localidadDom, int cpDom) throws ClienteException{

		Cliente c = new Cliente(dni, nombre, rznSoc, cuit, limCredito, cuentaCorriente, condEspePago, notaAdv, calleDom, nroDom, localidadDom, cpDom);
		c.save();
		misClientes.add(c);
	}

	public void borrarCliente(int dni) throws ClienteException{
		ClienteDao.getInstancia().delete(ClienteDao.getInstancia().buscarClienteByDni(dni));
		for(Cliente c : misClientes) {
			if(c.getDni() == dni) {
				misClientes.remove(c);
				break;
			}	
		}
	}

	public ClienteDTO buscarClienteByDni(int dni) throws ClienteException{
		for (Cliente c : misClientes)
		{
		   if (c.getDni() == dni)
		      return c.toDTO();
		}
		
		Cliente cliente = null;
		cliente = ClienteDao.getInstancia().buscarClienteByDni(dni);
		misClientes.add(cliente);
		return cliente.toDTO();
	}

	public List<PedidoDTO> buscarPedidosByCliente(int dni) throws PedidoException{
		List<PedidoDTO> devolver = new ArrayList<PedidoDTO>();

		for (Pedido p : pedidosRealizados)
		{
		   if (p.getCliente().getDni() == dni) {
			   devolver.add(p.toDTO());
		   }
		}
		
		if(!devolver.isEmpty()) {
			return devolver;
		}else {
			List<Pedido> pedidos = null;
			pedidos = PedidoDao.getInstancia().buscarPedidosByCliente(dni);
			for(Pedido pedido : pedidos){
				devolver.add(pedido.toDTO());
				pedidosRealizados.add(pedido);
			}
			return devolver;
		}
	}
	
	public List<PedidoDTO> buscarPedidosByEstado(String estado) throws PedidoException{
		List<PedidoDTO> devolver = new ArrayList<PedidoDTO>();
		List<Pedido> pedidos = PedidoDao.getInstancia().buscarPedidosByEstado(estado);
		for(Pedido pedido : pedidos){
			devolver.add(pedido.toDTO());
		}
		return devolver;
	}

	public void autorizarPedido(boolean autorizado, PedidoDTO pedido) throws PedidoException, ArticuloException, OrdenDePedidoException, ProveedorException, OrdenDeCompraException{
		//poner parte de memoria
		
			Pedido p = PedidoDao.getInstancia().buscarPedidoById(pedido.getNroPedido());
			if (autorizado == true)
			{
				p.setEstado("APROBADO");
				p.update();
				ControladorDeposito.getInstancia().verificarExistenciaStock(p);
			}
			else
			{
				p.setEstado("RECHAZADO");
				p.update();
				
			}
	}






	public void altaPedido(List<ItemPedidoDTO> itemsPedido, String estado, ClienteDTO clienteDTO, String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio, int cpDirecEnvio) throws ClienteException, ArticuloException, PedidoException, OrdenDePedidoException, ProveedorException, OrdenDeCompraException{
		if (itemsPedido.size()<=0)
			throw new PedidoException("El pedido no tiene items asociados");
		int id;
		Date fechaGeneracion = Calendar.getInstance().getTime();
		Date fechaDespacho = Calendar.getInstance().getTime();
		Date fechaEntregaEsperada = Calendar.getInstance().getTime();
		Date fechaEntrega = Calendar.getInstance().getTime();
		float precioTotalBruto = 0;
		float precioTotalFinal = 0;
		Cliente cliente = null;
		cliente = ClienteDao.getInstancia().buscarClienteByDni(clienteDTO.getDni());
		Pedido pedido = new Pedido(estado ,cliente, fechaGeneracion, fechaDespacho,fechaEntregaEsperada, fechaEntrega, precioTotalBruto, precioTotalFinal, formaDePago, calleDireccEnvio, nroDireccEnvio, localidadDireccEnvio, cpDirecEnvio);
		id = pedido.save();
		pedido.setNroPedido(id);
		for(ItemPedidoDTO item : itemsPedido){
			Articulo articulo = null;
			articulo = ArticuloDao.getInstancia().buscarArticuloById(item.getArticulo().getIdArticulo()); 
			if (articulo != null){
				pedido.nuevoItemPedido(item.getCant(),articulo);		
			}
		}
		Pedido pedidoNuevo = PedidoDao.getInstancia().buscarPedidoById(pedido.getNroPedido());
		pedidosRealizados.add(pedidoNuevo);
		
		autorizarPedido(true, pedidoNuevo.toDTO()); //no va a estar mas aca
	}
}