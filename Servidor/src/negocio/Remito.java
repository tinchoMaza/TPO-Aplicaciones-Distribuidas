package negocio;


import java.util.*;

import dao.RemitoDao;
import dto.ItemRemitoDTO;
import dto.RemitoDTO;
import entities.ItemRemitoEntity;
import entities.RemitoEntity;
import excepciones.RemitoException;

public class Remito {

	private Integer nroRemito;
	private Date fechaRemito;
	private Cliente cliente;
	private Pedido pedido;
	private List<ItemRemito> itemsRemito;

	public Remito(Integer nroRemito, Date fechaRemito, Cliente cliente, Pedido pedido) {
		super();
		this.nroRemito = nroRemito;
		this.fechaRemito = fechaRemito;
		this.cliente = cliente;
		this.pedido = pedido;
		this.itemsRemito = new ArrayList<ItemRemito>();
	}

	public Remito(Integer nroRemito, Date fechaRemito, Cliente cliente, Pedido pedido, List<ItemRemito> itemsRemito) {
		super();
		this.nroRemito = nroRemito;
		this.fechaRemito = fechaRemito;
		this.cliente = cliente;
		this.pedido = pedido;
		this.itemsRemito = itemsRemito;
	}

	public Remito(Date fechaRemito, Cliente cliente, Pedido pedido, List<ItemRemito> itemsRemito) {
		super();
		this.fechaRemito = fechaRemito;
		this.cliente = cliente;
		this.pedido = pedido;
		this.itemsRemito = itemsRemito;
	}

	public RemitoEntity toEntity() {
		RemitoEntity aux = new RemitoEntity();
		aux.setCliente(this.getCliente().toEntity());
		aux.setFechaRemito(this.getFechaRemito());
		aux.setItemsRemito(this.getItemsRemitoEntity());
		aux.setNroRemito(this.getNroRemito());
		aux.setPedido(this.getPedido().toEntity());
		return aux;

	}

	public RemitoDTO toDTO() {
		RemitoDTO aux = new RemitoDTO();
		aux.setClienteDTO(this.getCliente().toDTO());
		aux.setFechaRemito(this.getFechaRemito());
		aux.setItemsRemitoDTO(this.getItemsRemitoDTO());
		aux.setNroRemito(this.getNroRemito());
		aux.setPedidoDTO(this.getPedido().toDTO());
		return aux;
	}

	public Remito() {
		// TODO Auto-generated constructor stub
	}

	public float total(){
		return 0;
	}

	public void nuevoItemRem(Articulo articulo, int cant, float precio){
		itemsRemito.add(new ItemRemito(this,cant,articulo,precio));

	}

	public void save() throws RemitoException{
		RemitoDao.getInstancia().save(this);
	}

	//Getters y Setters

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<ItemRemito> getItemsRemito() {
		return itemsRemito;
	}

	public List<ItemRemitoEntity> getItemsRemitoEntity() {
		List<ItemRemitoEntity> it = new ArrayList<ItemRemitoEntity>();
		for (ItemRemito a : this.getItemsRemito()){
			it.add(a.toEntity());
		}
		return it;
	}

	public List<ItemRemitoDTO> getItemsRemitoDTO() {
		List<ItemRemitoDTO> it = new ArrayList<ItemRemitoDTO>();
		for (ItemRemito a : this.getItemsRemito()){
			it.add(a.toDTO());
		}
		return it;
	}

	public void setItemsRemito(List<ItemRemito> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}



}
