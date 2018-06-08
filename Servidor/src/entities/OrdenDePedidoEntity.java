package entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import negocio.OrdenDePedido;

@Entity
@Table(name="OrdenDePedido")
public class OrdenDePedidoEntity implements Serializable {

	private static final long serialVersionUID = 6570270862612205100L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idOp")
	private Integer idOP;
	
	@OneToOne (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn (name="nroPedido")
	private PedidoEntity pedido;
	
	private String estado;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "OP")
	private List<OrdenDeCompraEntity> ordenesDeCompra;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "Op")
	private List<ItemOrdenDePedidoEntity> items;
	
	public OrdenDePedidoEntity() {}
		
	public OrdenDePedidoEntity(Integer idOP, PedidoEntity pedido, String estado,
			List<OrdenDeCompraEntity> ordenesDeCompra, List<ItemOrdenDePedidoEntity> items) {
		super();
		this.idOP = idOP;
		this.pedido = pedido;
		this.estado = estado;
		this.ordenesDeCompra = ordenesDeCompra;
		this.items = items;
	}
	
	public OrdenDePedidoEntity(Integer idOP, PedidoEntity pedido, String estado) {
		super();
		this.idOP = idOP;
		this.pedido = pedido;
		this.estado = estado;
		this.ordenesDeCompra = new ArrayList<OrdenDeCompraEntity>();
		this.items = new ArrayList<ItemOrdenDePedidoEntity>();
	}

	//GETTERS Y SETTERS
	
	public Integer getIdOP() {
		return idOP;
	}

	public void setIdOP(Integer idOP) {
		this.idOP = idOP;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<OrdenDeCompraEntity> getOrdenesDeCompra() {
		return ordenesDeCompra;
	}

	public void setOrdenesDeCompra(List<OrdenDeCompraEntity> ordenesDeCompra) {
		this.ordenesDeCompra = ordenesDeCompra;
	}

	public List<ItemOrdenDePedidoEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemOrdenDePedidoEntity> items) {
		this.items = items;
	}

	public OrdenDePedido toNegocio() {
		OrdenDePedido op = new OrdenDePedido();
		op.setPedido(this.pedido.toNegocio());
		op.setEstado(this.estado);
		for (ItemOrdenDePedidoEntity item : this.items) {
			op.getArticulos().add(item.toNegocio(op));
		}
		return op;
	}
}
