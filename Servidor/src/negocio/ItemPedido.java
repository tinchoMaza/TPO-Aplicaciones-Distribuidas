package negocio;

import dao.ItemPedidoDao;
import dto.ItemPedidoDTO;
import entities.ItemPedidoEntity;
import excepciones.PedidoException;

public class ItemPedido {

	private Pedido pedido;
	private int idItemPedido;
	private int cant;
	private Articulo articulo;

	public ItemPedido(Pedido pedido, int idItemPedido, int cant, Articulo articulo) {
		super();
		this.pedido = pedido;
		this.idItemPedido = idItemPedido;
		this.cant = cant;
		this.articulo = articulo;
	}

	public ItemPedido(Pedido pedido, int cant, Articulo articulo) {
		super();
		this.pedido = pedido;
		this.cant = cant;
		this.articulo = articulo;
	}

	public ItemPedido() {
		// TODO Auto-generated constructor stub
	}

	public ItemPedidoEntity toEntitySave() {
		ItemPedidoEntity aux = new ItemPedidoEntity();
		aux.setArticulo(this.getArticulo().toEntityUpdate());
		aux.setCantidad(this.getCant());
		aux.setPedido(this.getPedido().toEntityUpdate());
		return aux;

	}	
	
	public ItemPedidoEntity toEntityUpdate() {
		ItemPedidoEntity aux = new ItemPedidoEntity();
		aux.setArticulo(this.getArticulo().toEntityUpdate());
		aux.setCantidad(this.getCant());
		aux.setIdItemPedido(this.getIdItemPedido());
		aux.setPedido(this.getPedido().toEntityUpdate());
		return aux;

	}	


	public ItemPedidoDTO toDTO() {
		ItemPedidoDTO aux = new ItemPedidoDTO();
		aux.setArticulo(this.getArticulo().toDTO());
		aux.setCant(this.getCant());
		aux.setIdItemPedido(this.getIdItemPedido());
		aux.setPedidoDTO(this.getPedido().toDTO());
		return aux;
	}	

	public int save() throws PedidoException  {
		return ItemPedidoDao.getInstancia().save(this);

	}

	public void update() throws PedidoException{
		ItemPedidoDao.getInstancia().update(this);
	}


	public void delete() throws PedidoException{
		ItemPedidoDao.getInstancia().delete(this);
	}

	
	
	//GETTERS Y SETTERS

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}


}
