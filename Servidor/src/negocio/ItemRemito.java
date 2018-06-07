package negocio;

import dao.ItemPedidoDao;
import dao.ItemRemitoDao;
import dto.ItemRemitoDTO;
import entities.ItemRemitoEntity;
import excepciones.PedidoException;
import excepciones.RemitoException;

public class ItemRemito {

	private Remito remito;
	private Integer idItemRemito;
	private int cant;
	private Articulo articulo;
	private float precio;


	public ItemRemito(Remito remito, Integer idItemRemito, int cant, Articulo articulo, float precio) {
		super();
		this.remito = remito;
		this.idItemRemito = idItemRemito;
		this.cant = cant;
		this.articulo = articulo;
		this.precio = precio;
	}

	public ItemRemito(Remito remito, int cant, Articulo articulo, float precio) {
		super();
		this.remito = remito;
		this.cant = cant;
		this.articulo = articulo;
		this.precio = precio;
	}


	public ItemRemitoEntity toEntity() {
		ItemRemitoEntity aux = new ItemRemitoEntity();
		aux.setArticulo(this.getArticulo().toEntity());
		aux.setCantidad(this.getCant());
		aux.setIdItemRemito(this.getIdItemRemito());
		aux.setPrecio(this.getPrecio());
		aux.setRemito(this.getRemito().toEntity());
		return aux;
	}


	public ItemRemitoDTO toDTO() {
		ItemRemitoDTO aux = new ItemRemitoDTO();
		aux.setArticulo(this.getArticulo().toDTO());
		aux.setCant(this.getCant());
		aux.setIdItemRemito(this.getIdItemRemito());
		aux.setPrecio(this.getPrecio());
		aux.setRemito(this.getRemito().toDTO());
		return aux;
	}

	
	public void save() throws RemitoException  {
		ItemRemitoDao.getInstancia().save(this);;

	}

	public void update() throws RemitoException{
		ItemRemitoDao.getInstancia().update(this);;
	}


	public void delete() throws  RemitoException{
		ItemRemitoDao.getInstancia().delete(this);;
	}


	//GETTERS Y SETTERS

	public Integer getIdItemRemito() {
		return idItemRemito;
	}
	public void setIdItemRemito(Integer idItemRemito) {
		this.idItemRemito = idItemRemito;
	}
	public Remito getRemito() {
		return remito;
	}
	public void setRemito(Remito remito) {
		this.remito = remito;
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}


}
