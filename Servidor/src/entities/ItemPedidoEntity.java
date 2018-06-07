package entities;

import java.io.Serializable;
import javax.persistence.*;

import negocio.ItemPedido;
import negocio.Pedido;

@Entity
@Table(name="ItemPedido")
public class ItemPedidoEntity implements Serializable{
	
	private static final long serialVersionUID = 3708972680536329977L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idItemPedido;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idPedido")
	private PedidoEntity pedido;

	
	
	@OneToOne
	@JoinColumn(name="idArticulo")
	private ArticuloEntity articulo;
	
	@Column (name = "cant")
	private int cantidad;
	
	public ItemPedidoEntity(){}

	public ItemPedido toNegocio(Pedido p) {
		return new ItemPedido(p, this.idItemPedido, this.cantidad, this.articulo.toNegocio());
	}
	
	//GETTERS Y SETTERS
	
	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
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

	

	
}