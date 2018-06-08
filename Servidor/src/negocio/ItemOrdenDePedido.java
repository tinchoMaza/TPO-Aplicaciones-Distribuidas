package negocio;

import dao.ItemOrdenDePedidoDao;
import dto.ItemOrdenDePedidoDTO;
import entities.ItemOrdenDePedidoEntity;
import excepciones.PedidoException;

public class ItemOrdenDePedido {

	private Integer idItemOp; 
	private OrdenDePedido Op;
	private Articulo articulo;
	private int cant;

	public void save() throws PedidoException{
		ItemOrdenDePedidoDao.getInstancia().save(this);

	}
	public void delete(){

	}
	public ItemOrdenDePedido(Integer idItemOp, OrdenDePedido Op, Articulo articulo, int cant) {
		super();
		this.idItemOp = idItemOp;
		this.Op = Op;
		this.articulo = articulo;
		this.cant = cant;
	}

	public ItemOrdenDePedido(OrdenDePedido Op, Articulo articulo, int cant) {
		super();
		this.Op = Op;
		this.articulo = articulo;
		this.cant = cant;
	}


	public ItemOrdenDePedidoEntity toEntity() {
		ItemOrdenDePedidoEntity aux = new ItemOrdenDePedidoEntity();
		aux.setArticulo(this.getArticulo().toEntity());
		aux.setCant(this.getCant());
		aux.setOp(this.getOp().toEntity());
		return aux;

	}

	public ItemOrdenDePedidoDTO toDTO() {
		ItemOrdenDePedidoDTO aux = new ItemOrdenDePedidoDTO();
		aux.setArticulo(this.getArticulo().toDTO());
		aux.setCant(this.getCant());
		aux.setIdItemOp(this.getIdItemOp());
		aux.setOp(this.getOp().toDTO());
		return aux;
	}

	//GETTERS Y SETTERS

	public Integer getIdItemOp() {
		return idItemOp;
	}
	public void setIdItemOp(Integer idItemOp) {
		this.idItemOp = idItemOp;
	}
	public OrdenDePedido getOp() {
		return Op;
	}
	public void setOp(OrdenDePedido op) {
		Op = op;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}


}
