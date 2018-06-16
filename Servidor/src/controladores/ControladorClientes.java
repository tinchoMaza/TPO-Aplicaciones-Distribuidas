package controladores;
import negocio.Pedido;
import java.util.*;

import javax.swing.JOptionPane;

import dao.ArticuloDao;
import dao.ClienteDao;
import dao.PedidoDao;
import dto.ClienteDTO;
import dto.FacturaDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import excepciones.ArticuloException;
import excepciones.ClienteException;
import excepciones.CuentaCorrienteException;
import excepciones.FacturaException;
import excepciones.OrdenDeCompraException;
import excepciones.OrdenDePedidoException;
import excepciones.PedidoException;
import excepciones.ProveedorException;
import excepciones.RemitoException;
import negocio.Articulo;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.Factura;

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

	public Cliente buscarClienteByDni(int dni) throws ClienteException{
		for (Cliente c : misClientes){
			if (c.getDni() == dni)
				return c;
		}
		
		Cliente cliente = ClienteDao.getInstancia().buscarClienteByDni(dni);
		misClientes.add(cliente);
		return cliente;
	}

	public List<PedidoDTO> buscarPedidosByEstado(String estado) throws PedidoException{
		List<PedidoDTO> devolver = new ArrayList<PedidoDTO>();
		List<Pedido> pedidos = PedidoDao.getInstancia().buscarPedidosByEstado(estado);
		for(Pedido pedido : pedidos){
			devolver.add(pedido.toDTO());
		}
		return devolver;
	}
	
	public Pedido buscarPedidoById(int nroPedido) throws PedidoException {
		return PedidoDao.getInstancia().buscarPedidoById(nroPedido);
	}


	

	public void altaPedido(List<ItemPedidoDTO> itemsPedido, String estado, ClienteDTO clienteDTO, String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio, int cpDirecEnvio) throws ClienteException, ArticuloException, PedidoException, OrdenDePedidoException, ProveedorException, OrdenDeCompraException, FacturaException, RemitoException, CuentaCorrienteException{
		if (itemsPedido.size()<=0)
			throw new PedidoException("El pedido no tiene items asociados");
		int id;
		Date fechaGeneracion = Calendar.getInstance().getTime();
		Date fechaDespacho = Calendar.getInstance().getTime(); // ponemos null o que inicialice todo en el dia de hoy?
		Date fechaEntregaEsperada = Calendar.getInstance().getTime();
		Date fechaEntrega = Calendar.getInstance().getTime();
		float precioTotalBruto = 0;
		float precioTotalFinal = 0;
		Cliente cliente = null;
		cliente = buscarClienteByDni(clienteDTO.getDni());
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
		pedidosRealizados.add(pedido);
		autorizarPedido(true, pedido.toDTO()); //no va a estar mas aca
		//justo despues de autorizarlo, hay que facturarlo porque se pierde la cantidad de cada item ya que se va restando y muestra la cantidad pendiente
	}

	public void autorizarPedido(boolean autorizado, PedidoDTO pedido) throws PedidoException, ArticuloException, OrdenDePedidoException, ProveedorException, OrdenDeCompraException, ClienteException, FacturaException, RemitoException, CuentaCorrienteException{
		if (autorizado) {
			ControladorFacturacion.getInstancia().facturarPedido(ControladorClientes.getInstancia().buscarPedidoById(pedido.getNroPedido()));
			ControladorFacturacion.getInstancia().generarRemito(ControladorClientes.getInstancia().buscarPedidoById(pedido.getNroPedido()));
		}
		boolean memoria = false;
		for (Pedido p : pedidosRealizados){
			if (p.getNroPedido() == pedido.getNroPedido() && memoria == false){
				memoria = true;
				if (autorizado==true){
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
		}
		if (memoria == false){
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
	}
	
	//cambiar a objetos facturadto y clientedto
	public void pagarFactura(int facturaDTO, int clienteDTO) throws FacturaException, ClienteException, CuentaCorrienteException {
		Factura f = ControladorFacturacion.getInstancia().buscarFacturaById(facturaDTO);
		Cliente c = this.buscarClienteByDni(clienteDTO);
		c.pagarFactura(f);
	}
	//cambiar a objeto clientedto
	public void cargarSaldoCliente(int clienteDTO, float monto) throws ClienteException, CuentaCorrienteException {
		Cliente c = this.buscarClienteByDni(clienteDTO);
		c.cargarSaldo(monto);
		JOptionPane.showMessageDialog(null, "Carga de saldo exitosa por un monto de " + monto);
	}
	//cambiar a objeto clientedto
	public void pagoDeFacturas(int clienteDTO) throws ClienteException, FacturaException, CuentaCorrienteException {
		Cliente c = this.buscarClienteByDni(clienteDTO);
		c.pagoDeFacturas();
	}
}