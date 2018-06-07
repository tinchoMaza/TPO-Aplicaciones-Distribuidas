package entities;

import java.io.Serializable;
import javax.persistence.*;

import negocio.Factura;
import negocio.ItemFactura;

@Entity
@Table(name="ItemsFactura")
public class ItemFacturaEntity implements Serializable{
	
	private static final long serialVersionUID = -2737130191882322593L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idItemFactura;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idFactura") //si no funciona con (name = idFactura), es (name = nroFactura)
	private FacturaEntity factura;
	
	@OneToOne
	@JoinColumn(name="idArticulo")
	private ArticuloEntity articulo;

	private int cantidad;
	private float precio;
	
	public ItemFacturaEntity(){}
	
	
	public ItemFactura toNegocio(Factura fac) {
		ItemFactura aux = new ItemFactura(fac,this.getCantidad(), this.getArticulo().toNegocio(), this.getPrecio(), this.getIdItemFactura());
		return aux;
	}

	
	//GETTERS Y SETTERS
	
	public Integer getIdItemFactura() {
		return idItemFactura;
	}

	public void setIdItemFactura(Integer idItemFactura) {
		this.idItemFactura = idItemFactura;
	}

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}

	public ArticuloEntity getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloEntity articulo) {
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
