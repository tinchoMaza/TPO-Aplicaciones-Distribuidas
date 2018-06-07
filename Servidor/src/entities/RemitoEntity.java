package entities;

import java.util.*;
import java.io.*;
import javax.persistence.*;

@Entity
@Table (name = "Remito")

public class RemitoEntity implements Serializable{

	private static final long serialVersionUID = -7859043147142477560L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer nroRemito;
	private Date fechaRemito;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional = false)
	@JoinColumn (name="idCliente")
	private ClienteEntity cliente;
	
	@OneToOne (cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="idPedido")
	private PedidoEntity pedido;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "remito")
	private List<ItemRemitoEntity> itemsRemito;
	
	public RemitoEntity() {}

	public RemitoEntity(Integer nroRemito, Date fechaRemito, ClienteEntity cliente, PedidoEntity pedido,
			List<ItemRemitoEntity> itemsRemito) {
		super();
		this.nroRemito = nroRemito;
		this.fechaRemito = fechaRemito;
		this.cliente = cliente;
		this.pedido = pedido;
		this.itemsRemito = itemsRemito;
	}

	//GETTERS Y SETTERS
	
	public Integer getNroRemito() {
		return nroRemito;
	}

	public void setNroRemito(Integer nroRemito) {
		this.nroRemito = nroRemito;
	}

	public Date getFechaRemito() {
		return fechaRemito;
	}

	public void setFechaRemito(Date fechaRemito) {
		this.fechaRemito = fechaRemito;
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

	public List<ItemRemitoEntity> getItemsRemito() {
		return itemsRemito;
	}

	public void setItemsRemito(List<ItemRemitoEntity> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}
	
}
