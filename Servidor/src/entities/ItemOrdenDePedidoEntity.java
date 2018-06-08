package entities;

import java.io.*;
import javax.persistence.*;

import negocio.ItemOrdenDePedido;
import negocio.OrdenDePedido;

@Entity
@Table (name = "ItemOrdenDePedido")

public class ItemOrdenDePedidoEntity implements Serializable{
	
	private static final long serialVersionUID = -4154892290747192721L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idItemOp;
	private int cant;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idOp")
	private OrdenDePedidoEntity Op;
	
	@OneToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="idArticulo")
	private ArticuloEntity articulo;
	
	public ItemOrdenDePedidoEntity() {}

	public ItemOrdenDePedidoEntity(Integer idItemOp, int cant, OrdenDePedidoEntity op, ArticuloEntity articulo) {
		super();
		this.idItemOp = idItemOp;
		this.cant = cant;
		Op = op;
		this.articulo = articulo;
	}
	
	//GETTERS Y SETTERS

	public Integer getIdItemOp() {
		return idItemOp;
	}

	public void setIdItemOp(Integer idItemOp) {
		this.idItemOp = idItemOp;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public OrdenDePedidoEntity getOp() {
		return Op;
	}

	public void setOp(OrdenDePedidoEntity op) {
		Op = op;
	}

	public ArticuloEntity getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloEntity articulo) {
		this.articulo = articulo;
	}

	public ItemOrdenDePedido toNegocio(OrdenDePedido p) {
		return new ItemOrdenDePedido(p, this.articulo.toNegocio(), this.cant);
	}	

}
