package controladores;

import java.util.*;
import dao.PedidoDao;
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

	public void despachar(PedidoDTO pedidoDTO) throws UbicacionException, PedidoException, ArticuloException, ClienteException, FacturaException, RemitoException {
		//TENGO QUE PASARLES UN PEDIDO Y NO EL PARAMETRO DE ARRIBA QUE ES DTO
		Pedido pedido = ControladorClientes.getInstancia().buscarPedidoById(pedidoDTO.getNroPedido());
		ControladorDeposito.getInstancia().retirar(pedido);
		ControladorFacturacion.getInstancia().generarRemito(pedido);
		//actualizar fechas de despacho y entrega esperada del pedido
		Date fechaDespacho = Calendar.getInstance().getTime();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 20);
		Date fechaEntregaEsperada = c.getTime();
		pedido.setFechaEntregaEsperada(fechaEntregaEsperada);
		pedido.setFechaDespacho(fechaDespacho);
		pedido.update();
	}

	public List<PedidoDTO> listarPedidosDespacho() throws PedidoException{
		List<PedidoDTO> devolver = new ArrayList<PedidoDTO>();
		List<Pedido> pedidos = PedidoDao.getInstancia().buscarPedidosByEstado("APROBADO_EN_ESPERA_DESPACHO");
		for(Pedido pedido : pedidos){
			devolver.add(pedido.toDTO());
		}
		return devolver;
	}

}