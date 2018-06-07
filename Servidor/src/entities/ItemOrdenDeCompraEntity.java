package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ItemsOrdenDeCompra")
public class ItemOrdenDeCompraEntity implements Serializable{

	private static final long serialVersionUID = 857145141644426144L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idItemOC;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idOC")
	private OrdenDeCompraEntity oc;
	
	@OneToOne
	@JoinColumn(name="idArticulo")
	private ArticuloEntity articulo;

	private int cantidad;
	private float precio;
	
	public ItemOrdenDeCompraEntity(){}
		
	public ItemOrdenDeCompraEntity(Integer idItemOC, OrdenDeCompraEntity oc, ArticuloEntity articulo, int cantidad,
			float precio) {
		super();
		this.idItemOC = idItemOC;
		this.oc = oc;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.precio = precio;
	}



	//GETTERS Y SETTERS
	
	public Integer getItemOC() {
		return idItemOC;
	}

	public void setItemOC(Integer idOC) {
		this.idItemOC = idOC;
	}
	

	public OrdenDeCompraEntity getOc() {
		return oc;
	}

	public void setOc(OrdenDeCompraEntity oc) {
		this.oc = oc;
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