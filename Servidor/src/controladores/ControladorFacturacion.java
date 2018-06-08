package controladores;

import java.util.*;

import dao.ArticuloDao;
import dao.ClienteDao;
import dao.FacturaDao;
import dao.PedidoDao;
import dto.ClienteDTO;
import dto.FacturaDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import excepciones.ArticuloException;
import excepciones.ClienteException;
import excepciones.FacturaException;
import excepciones.PedidoException;
import excepciones.RemitoException;
import negocio.Articulo;
import negocio.Cliente;
import negocio.Factura;
import negocio.Pedido;
import negocio.Remito;
public class ControladorFacturacion {

	private static ControladorFacturacion instancia;

	public static ControladorFacturacion getInstancia() {
		if(instancia==null) {
			instancia = new ControladorFacturacion();
		}
		return instancia;
	}

	public void despachar(Pedido pedido){

	}

	private List<Factura> misFacturas;
	private List<Remito> misRemitos;

	public void emitirComprobantes(PedidoDTO pedido) throws PedidoException, ArticuloException, ClienteException, FacturaException, RemitoException{
		Pedido pedidoNegocio = PedidoDao.getInstancia().buscarPedidoById(pedido.getNroPedido());
		ControladorFacturacion.getInstancia().facturarPedido(pedidoNegocio);
		ControladorFacturacion.getInstancia().generarRemito(pedidoNegocio);
	}

	public void facturarPedido(Pedido pedido) throws PedidoException, ArticuloException, FacturaException{
		Date fecha = new Date();
		Pedido pedidoNegocio = PedidoDao.getInstancia().buscarPedidoById(pedido.getNroPedido());
		Factura factura = new Factura(0, fecha, pedidoNegocio, pedidoNegocio.getCliente(), pedidoNegocio.getPrecioTotalFinal(), "IMPAGA");
		for(ItemPedidoDTO item : pedido.getItemsPedidoDTO()){
			Articulo art = ArticuloDao.getInstancia().buscarArticuloById(item.getArticulo().getIdArticulo()); 
			factura.nuevoItemFact(art, item.getCant(), item.getArticulo().getPrecioVentaUnitario());
		}
		factura.save();
		misFacturas.add(factura);
	}
	
	
	public void generarRemito(Pedido pedido) throws PedidoException, ClienteException, ArticuloException, RemitoException{
		Date fecha = new Date();
		Pedido pedidoNegocio = PedidoDao.getInstancia().buscarPedidoById(pedido.getNroPedido());
		Cliente clienteNegocio = null;
		clienteNegocio = ClienteDao.getInstancia().buscarClienteByDni(pedido.getCliente().getDni());
		Remito remito = new Remito(fecha, clienteNegocio, pedidoNegocio, null);
		for(ItemPedidoDTO item : pedido.getItemsPedidoDTO()) {
			Articulo art = ArticuloDao.getInstancia().buscarArticuloById(item.getArticulo().getIdArticulo()); 
			remito.nuevoItemRem(art, item.getCant(), item.getArticulo().getPrecioVentaUnitario());
		}
		remito.save();
		misRemitos.add(remito);
	}


	public List<FacturaDTO> buscarFacturaByEstado(String estado) throws FacturaException{
		List<FacturaDTO> devolver = new ArrayList<FacturaDTO>();
		List<Factura> facturas = FacturaDao.getInstancia().buscarFacturasByEstado(estado);
		for(Factura fac : facturas){
			devolver.add(fac.toDTO());
		}
		return devolver;
	}


	public float limiteCreditoDisponible(ClienteDTO clienteDTO) throws ClienteException{
		float saldoDisponible = 0;
		Cliente cliente = ClienteDao.getInstancia().buscarClienteByDni(clienteDTO.getDni());
		saldoDisponible = cliente.consultarSaldo();
		return saldoDisponible;
	}

	public void pagar(FacturaDTO facturaDTO) throws FacturaException {
		int nroFactura = facturaDTO.getNroFactura();
		int flag = 0;
		for(Factura fac : misFacturas) {
			if(fac.getNroFactura() == nroFactura) {
				flag = 1;
				fac.pagar();
				fac.update();
				break;
			}
		}
		if(flag == 0) {
			Factura factura = FacturaDao.getInstancia().buscarFacturaById(nroFactura);
			factura.pagar();
			misFacturas.add(factura);
			factura.update();
		}
	}

}
