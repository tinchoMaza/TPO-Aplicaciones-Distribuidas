package entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="OrdenDeCompra")
public class OrdenDeCompraEntity implements Serializable{

	private static final long serialVersionUID = 2563836357407046817L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOC;
	private Date fecha;
	private String estado;

	@OneToOne (cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="prov")
	private ProveedorEntity proveedor;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional = false)
	@JoinColumn (name="idOp")
	private OrdenDePedidoEntity OP;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "oc")
	private List<ItemOrdenDeCompraEntity> items;
	
	public OrdenDeCompraEntity(){}

	public OrdenDeCompraEntity(Integer idOC, Date fecha, String comentario, String estado, ProveedorEntity proveedor,
			OrdenDePedidoEntity oP, List<ItemOrdenDeCompraEntity> items) {
		super();
		this.idOC = idOC;
		this.fecha = fecha;
		this.estado = estado;
		this.proveedor = proveedor;
		OP = oP;
		this.items = items;
	}
	
	//GETTERS Y SETTERS

	public Integer getIdOC() {
		return idOC;
	}

	public void setIdOC(Integer idOC) {
		this.idOC = idOC;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}

	public OrdenDePedidoEntity getOP() {
		return OP;
	}

	public void setOP(OrdenDePedidoEntity oP) {
		OP = oP;
	}

	public List<ItemOrdenDeCompraEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemOrdenDeCompraEntity> items) {
		this.items = items;
	}

}
