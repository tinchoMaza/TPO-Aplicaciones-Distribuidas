package entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import negocio.Factura;
import negocio.ItemFactura;

@Entity
@Table(name="Factura")
public class FacturaEntity implements Serializable{
	
	private static final long serialVersionUID = 833600540003777158L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer nroFactura;
	private Date fecha;
	private String estado;
	private float totalFact;
	
	@ManyToOne (cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="dniCliente")
	private ClienteEntity cliente;
	
	@OneToOne
	@JoinColumn(name="idPedido")
	private PedidoEntity pedido;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "factura")
	private List<ItemFacturaEntity> items;
	
	public FacturaEntity() {}
	
	public FacturaEntity(Integer nroFactura, Date fecha, float totalFact, ClienteEntity cliente, PedidoEntity pedido) {
		super();
		this.nroFactura = nroFactura;
		this.fecha = fecha;
		this.totalFact = totalFact;
		this.cliente = cliente;
		this.pedido = pedido;
		this.estado = "IMAPGA";
		this.items = new ArrayList<ItemFacturaEntity>();
	}
	
	public FacturaEntity(Integer nroFactura, Date fecha, String estado, float totalFact, ClienteEntity cliente,
			PedidoEntity pedido, List<ItemFacturaEntity> items) {
		super();
		this.nroFactura = nroFactura;
		this.fecha = fecha;
		this.estado = estado;
		this.totalFact = totalFact;
		this.cliente = cliente;
		this.pedido = pedido;
		this.items = items;
	}

	public Factura toNegocio() {
		Factura factura = new Factura();
		factura.setCliente(this.cliente.toNegocio());
		factura.setEstado(this.estado);
		factura.setFecha(this.fecha);
		factura.setNroFactura(this.nroFactura);
		factura.setPedido(this.pedido.toNegocio());
		factura.setTotalFact(this.totalFact);
		factura.setItemsFact(this.getItemsNegocio(factura));
		return factura;
	}
	
	private List<ItemFactura> getItemsNegocio(Factura fac) {
		List<ItemFactura> list = new ArrayList<ItemFactura>();
		for (ItemFacturaEntity it : this.items) {
			list.add(it.toNegocio(fac));
		}
		return list;
	}

	// GETTERS Y SETTERS

	public Integer getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(Integer nroFactura) {
		this.nroFactura = nroFactura;
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

	public float getTotalFact() {
		return totalFact;
	}

	public void setTotalFact(float totalFact) {
		this.totalFact = totalFact;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public List<ItemFacturaEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemFacturaEntity> items) {
		this.items = items;
	}
	
}