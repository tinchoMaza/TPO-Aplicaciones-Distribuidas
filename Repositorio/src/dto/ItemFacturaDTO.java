package dto;

import java.io.Serializable;

public class ItemFacturaDTO implements Serializable{

	private static final long serialVersionUID = 8442881024540887594L;
	
	private ArticuloDTO articulo;
	private int cantidad;
	private float precio;
	private FacturaDTO factura;
	private int idItemFact;
	
	
	public ItemFacturaDTO(ArticuloDTO articulo, int cantidad, float precio, FacturaDTO factura, int idItemFact) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.precio = precio;
		this.factura = factura;
		this.idItemFact = idItemFact;
	}
	public ItemFacturaDTO() {}
	
	//Getters y Setters

	public ArticuloDTO getArticulo() {
		return articulo;
	}
	
	public FacturaDTO getFactura() {
		return factura;
	}

	public void setFactura(FacturaDTO factura) {
		this.factura = factura;
	}

	public int getIdItemFact() {
		return idItemFact;
	}

	public void setIdItemFact(int idItemFact) {
		this.idItemFact = idItemFact;
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
	public int getidItemFact() {
		return idItemFact;
	}

}
