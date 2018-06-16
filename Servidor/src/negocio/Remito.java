package negocio;


import java.util.*;

import javax.swing.JOptionPane;

import dao.RemitoDao;
import dto.ItemRemitoDTO;
import dto.RemitoDTO;
import entities.FacturaEntity;
import entities.ItemFacturaEntity;
import entities.ItemRemitoEntity;
import entities.RemitoEntity;
import excepciones.RemitoException;

public class Remito {

	private Integer nroRemito;
	private Date fechaRemito;
	private Cliente cliente;
	private Pedido pedido;
	private List<ItemRemito> itemsRemito;

	public Remito(Date fechaRemito, Cliente cliente, Pedido pedido) {
		super();
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
	
	public RemitoEntity toEntitySave() {		
		RemitoEntity aux = new RemitoEntity();
		aux.setCliente(this.cliente.toEntity());
		aux.setFechaRemito(this.fechaRemito);
		aux.setItemsRemito(this.getItemsRemitoEntity());
		aux.setPedido(this.pedido.toEntityUpdate());
		return aux;

	}

	public RemitoEntity toEntityUpdate() {
		RemitoEntity aux = new RemitoEntity();
		aux.setCliente(this.cliente.toEntity());
		aux.setFechaRemito(this.fechaRemito);
		aux.setItemsRemito(this.getItemsRemitoEntity());
		aux.setNroRemito(this.nroRemito);
		aux.setPedido(this.pedido.toEntityUpdate());
		return aux;

	}
	
	public RemitoDTO toDTO() {
		RemitoDTO aux = new RemitoDTO();
		aux.setClienteDTO(this.cliente.toDTO());
		aux.setFechaRemito(this.fechaRemito);
		aux.setItemsRemitoDTO(this.getItemsRemitoDTO());
		aux.setNroRemito(this.nroRemito);
		aux.setPedidoDTO(this.pedido.toDTO());
		return aux;
	}

	public Remito() {
		super();
	}

	public float total(){
		float total = 0;
		for (ItemRemito it : this.itemsRemito)
			total += (it.getCant() * it.getArticulo().getPrecioVentaUnitario());
		return total;
	}

	public void nuevoItemRem(Articulo articulo, int cant, float precio) throws RemitoException{
		ItemRemito item = new ItemRemito(this,cant,articulo,precio);
		int id = item.save();
		item.setIdItemRemito(id);
		itemsRemito.add(item);
	}

	public int save() throws RemitoException{
		return RemitoDao.getInstancia().save(this);
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
		List<ItemRemitoEntity> items = new ArrayList<ItemRemitoEntity>();
		ItemRemitoEntity aux = new ItemRemitoEntity();
		for(ItemRemito item: itemsRemito){
			aux.setArticulo(item.getArticulo().toEntityUpdate());
			aux.setCantidad(item.getCant());
			aux.setPrecio(item.getPrecio());
			aux.setIdItemRemito(item.getIdItemRemito());
			RemitoEntity remEntity = new RemitoEntity(this.nroRemito, this.fechaRemito, this.cliente.toEntity(), this.pedido.toEntityUpdate());
			aux.setRemito(remEntity);
			items.add(aux);
		}
		return items;
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
