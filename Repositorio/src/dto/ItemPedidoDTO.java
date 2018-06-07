package dto;

import java.io.Serializable;

public class ItemPedidoDTO implements Serializable{

	private static final long serialVersionUID = -7061325374800535362L;
	
	private PedidoDTO pedido;
	private int idItemPedido;
	private int cant;
	private ArticuloDTO articulo;
	
	public ItemPedidoDTO (PedidoDTO pedido, int idItemPedido, int cant, ArticuloDTO articulo){
	super();
	this.pedido = pedido;
	this.idItemPedido = idItemPedido;
	this.cant = cant;
	this.articulo = articulo;
}
	
	public ItemPedidoDTO() {}

	//Getters y setters

	public int getIdItemPedido() {
		return idItemPedido;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedidoDTO(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}
	
}
