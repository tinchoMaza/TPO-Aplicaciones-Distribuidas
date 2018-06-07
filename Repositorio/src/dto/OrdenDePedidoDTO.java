package dto;

import java.io.Serializable;
import java.util.List;

public class OrdenDePedidoDTO implements Serializable{

	private static final long serialVersionUID = -3982683559497357647L;
	
	private int idOp;
	private PedidoDTO pedido;
	private String estado;
	private List<OrdenDeCompraDTO> ordenesDeCompra;
	private List<ItemOrdenDePedidoDTO> articulos;
	
	public OrdenDePedidoDTO(){}
	
	public OrdenDePedidoDTO(int idOp, PedidoDTO pedido, String estado, List<OrdenDeCompraDTO> ordenesDeCompra, List<ItemOrdenDePedidoDTO> articulos){
		super();
		this.idOp = idOp;
		this.pedido = pedido;
		this.estado = estado;
		this.ordenesDeCompra = ordenesDeCompra;
		this.articulos = articulos;
	}
	
	// GETTERS Y SETTERS
	
	public int getIdOp() {
		return idOp;
	}

	public void setIdOp(int idOp) {
		this.idOp = idOp;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<OrdenDeCompraDTO> getOrdenesDeCompra() {
		return ordenesDeCompra;
	}

	public void setOrdenesDeCompra(List<OrdenDeCompraDTO> ordenesDeCompra) {
		this.ordenesDeCompra = ordenesDeCompra;
	}

	public List<ItemOrdenDePedidoDTO> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<ItemOrdenDePedidoDTO> articulos) {
		this.articulos = articulos;
	}
}
