package controladores;

import java.util.*;
import dao.ArticuloDao;
import dao.PedidoDao;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import excepciones.ArticuloException;
import excepciones.ClienteException;
import excepciones.FacturaException;
import excepciones.PedidoException;
import excepciones.RemitoException;
import excepciones.UbicacionException;
import negocio.Pedido;

public class ControladorDespacho {

	private static ControladorDespacho instancia;

	public static ControladorDespacho getInstancia() {
		if(instancia==null) {
			instancia = new ControladorDespacho();
		}
		return instancia;
	}

	public void despachar(PedidoDTO pedido) throws UbicacionException, PedidoException, ArticuloException, ClienteException, FacturaException, RemitoException {
		ControladorDeposito.getInstancia().retirar(pedido);
		ControladorFacturacion.getInstancia().emitirComprobantes(pedido);	
	}

	public List<PedidoDTO> listarPedidosDespacho() throws PedidoException{
		List<PedidoDTO> devolver = new ArrayList<PedidoDTO>();
		List<Pedido> pedidos = PedidoDao.getInstancia().buscarPedidosByEstado("APROBADO_EN_ESPERA_DESPACHO");
		for(Pedido pedido : pedidos){
			devolver.add(pedido.toDTO());
		}
		return devolver;
	}

	public void actualizarEstadoDelPedido(String estado, PedidoDTO pedidoDTO) throws PedidoException{
		Pedido pedido = null;
		pedido = PedidoDao.getInstancia().buscarPedidoById(pedidoDTO.getNroPedido());
		pedido.setEstado(estado);
		PedidoDao.getInstancia().update(pedido);
		//modificar el array pedidosRealizados en ControladorClientes
	}

	public  void actualizarFechaDespachoPedido(PedidoDTO pedidoDTO, java.util.Date fechaDespacho) throws PedidoException {
		Pedido pedido = null;
		pedido = PedidoDao.getInstancia().buscarPedidoById(pedidoDTO.getNroPedido());
		pedido.actualizarFechaDespachoPedido(fechaDespacho);
		pedido.update();
		//modificar el array pedidosRealizados en ControladorClientes
	}

	public  void actualizarFechaEntregaEsperada(PedidoDTO pedidoDTO, java.util.Date fechaEntregaEsperada) throws PedidoException {
		Pedido pedido = null;
		pedido = PedidoDao.getInstancia().buscarPedidoById(pedidoDTO.getNroPedido());
		pedido.actualizarFechaEntregaEsperada(fechaEntregaEsperada);
		pedido.update();
		//modificar el array pedidosRealizados en ControladorClientes

	}

	public  void actualizarFechaEntrega(PedidoDTO pedidoDTO, java.util.Date fechaEntrega) throws PedidoException  {
		Pedido pedido = null;
		pedido = PedidoDao.getInstancia().buscarPedidoById(pedidoDTO.getNroPedido());
		pedido.actualizarFechaEntrega(fechaEntrega);
		pedido.update();
		//modificar el array pedidosRealizados en ControladorClientes


	}

}
