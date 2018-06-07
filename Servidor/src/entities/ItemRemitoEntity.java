package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ItemRemito")

public class ItemRemitoEntity implements Serializable{

	private static final long serialVersionUID = 6874174887111729933L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idItemRemito;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idRemito")
	private RemitoEntity remito;
	
	@OneToOne
	@JoinColumn(name="idArticulo")
	private ArticuloEntity articulo;

	@Column (name = "cant")
	private int cantidad;
	private float precio;
	
	public ItemRemitoEntity(){}
	
	public ItemRemitoEntity(Integer idItemRemito, RemitoEntity remito, ArticuloEntity articulo, int cantidad,
			float precio) {
		super();
		this.idItemRemito = idItemRemito;
		this.remito = remito;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.precio = precio;
	}


	//GETTERS Y SETTERS

	public RemitoEntity getRemito() {
		return remito;
	}
	
	public void setRemito(RemitoEntity remito) {
		this.remito = remito;
	}
	public Integer getIdItemRemito() {
		return idItemRemito;
	}

	public void setIdItemRemito(Integer idItemRemito) {
		this.idItemRemito = idItemRemito;
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