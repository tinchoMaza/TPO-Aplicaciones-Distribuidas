package controladores;

import java.util.*;
import dao.ArticuloDao;
import dao.ClienteDao;
import dao.FacturaDao;
import excepciones.ArticuloException;
import excepciones.ClienteException;
import excepciones.FacturaException;
import excepciones.PedidoException;
import excepciones.RemitoException;
import negocio.Articulo;
import negocio.Cliente;
import negocio.Factura;
import negocio.ItemPedido;
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

	private List<Factura> misFacturas = new ArrayList<Factura>();
	private List<Remito> misRemitos = new ArrayList<Remito>();


	public void facturarPedido(Pedido pedido) throws PedidoException, ArticuloException, FacturaException, ClienteException{
		Date fecha = Calendar.getInstance().getTime();
		Cliente clienteNegocio = ClienteDao.getInstancia().buscarClienteByDni(pedido.getCliente().getDni());
		Factura factura = new Factura(fecha, pedido, clienteNegocio, pedido.getPrecioTotalFinal());
		int id = factura.save();
		factura.setNroFactura(id);
		for(ItemPedido item : pedido.getItemsPedido()){
			Articulo art = ArticuloDao.getInstancia().buscarArticuloById(item.getArticulo().getIdArticulo()); 
			factura.nuevoItemFact(art, item.getCant(), (art.getPrecioVentaUnitario() * item.getCant()));
		}
		misFacturas.add(factura);
	}


	public void generarRemito(Pedido pedido) throws PedidoException, ClienteException, ArticuloException, RemitoException{
		Date fecha = Calendar.getInstance().getTime();
		Cliente clienteNegocio = ClienteDao.getInstancia().buscarClienteByDni(pedido.getCliente().getDni());
		Remito remito = new Remito(fecha, clienteNegocio, pedido);
		int id = remito.save();
		remito.setNroRemito(id);
		for(ItemPedido item : pedido.getItemsPedido()) {
			Articulo art = ArticuloDao.getInstancia().buscarArticuloById(item.getArticulo().getIdArticulo()); 
			remito.nuevoItemRem(art, item.getCant(), (art.getPrecioVentaUnitario() * item.getCant()));
		}
		misRemitos.add(remito);
	}

	public Factura buscarFacturaById(int nroFactura) throws FacturaException {
		for (Factura f : misFacturas)
			if (f.getNroFactura() == nroFactura)
				return f;
		
		Factura factura = FacturaDao.getInstancia().buscarFacturaById(nroFactura);
		misFacturas.add(factura);
		return factura;
	}
	
	public List<Factura> buscarFacturasByCliente(int dni) throws FacturaException{
		return FacturaDao.getInstancia().buscarFacturasByCliente(dni);
	}
}