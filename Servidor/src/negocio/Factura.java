package negocio;


import java.util.*;

import dao.FacturaDao;
import dto.FacturaDTO;
import dto.ItemFacturaDTO;
import entities.FacturaEntity;
import entities.ItemFacturaEntity;

import excepciones.FacturaException;

public class Factura {

	private int nroFactura;
	private Date fecha;
	private Pedido pedido;
	private Cliente cliente;
	private float totalFact;
	private String estado;
	private List<ItemFactura> itemsFact;

	public Factura(Date fecha, Pedido pedido, Cliente cliente, float totalFact, String estado) {
		super();
		this.fecha = fecha;
		this.pedido = pedido;
		this.cliente = cliente;
		this.totalFact = totalFact;
		this.estado=estado;
		this.itemsFact = new ArrayList<ItemFactura>();
	}

	public Factura(int nroFactura, Date fecha, Pedido pedido, Cliente cliente, float totalFact, String estado,
			List<ItemFactura> itemsFact) {
		super();
		this.nroFactura = nroFactura;
		this.fecha = fecha;
		this.pedido = pedido;
		this.cliente = cliente;
		this.totalFact = totalFact;
		this.estado = estado;
		this.itemsFact = itemsFact;
	}

	public Factura() {
		// TODO Auto-generated constructor stub
	}

	public float totalFactura(){
		return 123456;
	}
	public void nuevoItemFact(Articulo articulo, int cant, float precio) throws FacturaException{	
		ItemFactura item = new ItemFactura(this,cant, articulo ,precio, this.getNroFactura());
		int id = item.save();
		item.setIdItemFact(id);
		itemsFact.add(item);
	}

	public void pagar() throws FacturaException{
		if (this.estado.equals("IMPAGA")){
			this.estado = "PAGADA";
			cliente.restarSaldo(this.totalFactura());
		}else
			throw new FacturaException("La factura ya se encuentra paga");
	}

	public int save() throws FacturaException {
		return FacturaDao.getInstancia().save(this);

	}

	public void update() throws FacturaException{
		FacturaDao.getInstancia().update(this);
	}


	public FacturaEntity toEntityUpdate(){
		FacturaEntity aux = new FacturaEntity();
		aux.setCliente(this.getCliente().toEntity());
		aux.setEstado(this.getEstado());
		aux.setFecha(this.getFecha());
		aux.setItems(this.getItemsFactEntity());
		aux.setNroFactura(this.getNroFactura());
		aux.setPedido(this.getPedido().toEntityUpdate());
		aux.setTotalFact(this.getTotalFact());
		return aux;
	}
	
	
	public FacturaEntity toEntitySave(){
		FacturaEntity aux = new FacturaEntity();
		aux.setCliente(this.getCliente().toEntity());
		aux.setEstado(this.getEstado());
		aux.setFecha(this.getFecha());
		aux.setItems(this.getItemsFactEntity());
		aux.setPedido(this.getPedido().toEntityUpdate());
		aux.setTotalFact(this.getTotalFact());
		return aux;
	}
	


	public FacturaDTO toDTO (){
		FacturaDTO aux = new FacturaDTO();
		aux.setCliente(this.getCliente().toDTO());
		aux.setEstado(this.getEstado());
		aux.setFecha(this.getFecha());
		aux.setItemsFact(this.getItemsFactDTO());
		aux.setNroFactura(this.getNroFactura());
		aux.setPedido(this.getPedido().toDTO());
		aux.setTotalFact(this.getTotalFact());
		return aux;
	}



	//Getters y Setters

	public int getNroFactura() {
		return nroFactura;
	}
	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public float getTotalFact() {
		return totalFact;
	}
	public void setTotalFact(float totalFact) {
		this.totalFact = totalFact;
	}
	public List<ItemFactura> getItemsFact() {
		return itemsFact;
	}

	public List<ItemFacturaEntity> getItemsFactEntity(){
		List<ItemFacturaEntity> aux = new ArrayList<ItemFacturaEntity>();
		for(ItemFactura item: itemsFact)
		{
			aux.add(item.toEntityUpdate());
		}
		return aux;

	}

	public List<ItemFacturaDTO> getItemsFactDTO(){
		List<ItemFacturaDTO> aux = new ArrayList<ItemFacturaDTO>();
		for(ItemFactura item: itemsFact)
		{
			aux.add(item.toDTO());
		}
		return aux;

	}


	public void setItemsFact(List<ItemFactura> itemsFact) {
		this.itemsFact = itemsFact;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


}
