package dto;

import java.io.Serializable;

public class ItemOrdenDePedidoDTO implements Serializable{

	private static final long serialVersionUID = -7364270740981019641L;
	
	private int idItemOp;
	private OrdenDePedidoDTO op;
	private ArticuloDTO articulo;
	private int cant;

	public ItemOrdenDePedidoDTO(){}

	public ItemOrdenDePedidoDTO(int idItemOp, OrdenDePedidoDTO op, ArticuloDTO articulo, int cant){
		super();
		this.idItemOp = idItemOp;
		this.op = op;
		this.articulo = articulo;
		this.cant = cant;
	}

	//Getters y Setters

	public int getIdItemOp() {
		return idItemOp;
	}

	public void setIdItemOp(int idItemOp) {
		this.idItemOp = idItemOp;
	}

	public OrdenDePedidoDTO getOp() {
		return op;
	}

	public void setOp(OrdenDePedidoDTO op) {
		this.op = op;
	}

	public ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
}
