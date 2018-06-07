package dto;

import java.io.Serializable;

public class ItemOrdenDeCompraDTO implements Serializable{
	private static final long serialVersionUID = -551360401372050931L;
	
	private OrdenDeCompraDTO oc;
	private int idItemOC;
	private ArticuloDTO articulo;
	private int cantidad;
	private float precio;
	
	public ItemOrdenDeCompraDTO(OrdenDeCompraDTO oc, int idItemOC, ArticuloDTO articulo, int cantidad, float precio){
		super();
		this.oc = oc;
		this.idItemOC = idItemOC;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public ItemOrdenDeCompraDTO() {}
	
	//Getters y setters

	public int getIdItemOC() {
		return idItemOC;
	}

	public OrdenDeCompraDTO getOc() {
		return oc;
	}

	public void setOc(OrdenDeCompraDTO oc) {
		this.oc = oc;
	}

	public void setIdItemOC(int idItemOC) {
		this.idItemOC = idItemOC;
	}

	public ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
