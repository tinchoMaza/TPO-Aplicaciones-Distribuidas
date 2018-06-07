package dto;

import java.io.Serializable;

public class ItemRemitoDTO implements Serializable{
	private static final long serialVersionUID = 2309577159897706502L;
	
	private RemitoDTO remito;
	private int idItemRemito;
	private int cant;
	private ArticuloDTO articulo;
	private float precio;

	public ItemRemitoDTO (RemitoDTO remito, int idItemRemito, int cant, ArticuloDTO articulo, float precio){
		super();
		this.remito = remito;
		this.idItemRemito = idItemRemito;
		this.cant = cant;
		this.articulo = articulo;
		this.precio = precio;
	}

	public ItemRemitoDTO() {}
	
	//Getters y setters

	public int getIdItemRemito() {
		return idItemRemito;
	}

	public RemitoDTO getRemito() {
		return remito;
	}

	public void setRemito(RemitoDTO remito) {
		this.remito = remito;
	}

	public void setIdItemRemito(int idItemRemito) {
		this.idItemRemito = idItemRemito;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}