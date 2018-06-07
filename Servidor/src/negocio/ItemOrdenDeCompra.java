package negocio;

import dto.ItemOrdenDeCompraDTO;
import entities.ItemOrdenDeCompraEntity;

public class ItemOrdenDeCompra {

	private OrdenDeCompra Oc;
	private int idItemOC;
	private Articulo articulo;
	private int cantidad;
	private float precio;

	public ItemOrdenDeCompra(OrdenDeCompra oc, int idItemOC, Articulo articulo, int cantidad, float precio) {
		super();
		Oc = oc;
		this.idItemOC = idItemOC;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public float subtotal() {
		return cantidad * precio;
	}

	public ItemOrdenDeCompraEntity toEntity() {
		ItemOrdenDeCompraEntity aux = new ItemOrdenDeCompraEntity();
		aux.setArticulo(this.getArticulo().toEntity());
		aux.setCantidad(this.getCantidad());
		aux.setOc(this.getOc().toEntity());
		aux.setItemOC(this.getIdItemOC());
		aux.setPrecio(this.getPrecio());
		return aux;
	}

	public ItemOrdenDeCompraDTO toDTO() {
		ItemOrdenDeCompraDTO aux = new ItemOrdenDeCompraDTO();
		aux.setArticulo(this.getArticulo().toDTO());
		aux.setCantidad(this.getCantidad());
		aux.setIdItemOC(this.getIdItemOC());
		aux.setOc(this.getOc().toDTO());
		aux.setPrecio(this.getPrecio());
		return aux;
	}

	//Getters y Setters

	public void setIdItemOC(int idItemOC) {
		this.idItemOC = idItemOC;
	}


	public int getIdItemOC() {
		return idItemOC;
	}

	public OrdenDeCompra getOc() {
		return Oc;
	}

	public void setOc(OrdenDeCompra oc) {
		Oc = oc;
	}


	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
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
