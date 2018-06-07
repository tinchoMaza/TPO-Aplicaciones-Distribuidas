package negocio;

import java.util.*;

import dao.ArticuloDao;
import dao.OrdenDeCompraDao;
import dto.ItemOrdenDeCompraDTO;
import dto.OrdenDeCompraDTO;
import entities.ItemOrdenDeCompraEntity;
import entities.OrdenDeCompraEntity;
import excepciones.ArticuloException;
import excepciones.OrdenDeCompraException;

public class OrdenDeCompra {

	private int idOc;
	private Date fecha;
	private Proveedor prov;
	private OrdenDePedido ordenPedido;
	private String estado;
	private List<ItemOrdenDeCompra> items;

	public float total(){
		float total = 0;
		for (ItemOrdenDeCompra item : items){
			total += item.subtotal();
		}
		return total;
	}

	public void actualizarEstado(String estado){
		this.estado=estado;
	}

	public void nuevoItemOC(ItemOrdenDeCompra itemOrdenDeCompra){
		this.items.add(itemOrdenDeCompra);
	}
	
	public void save() throws ArticuloException, OrdenDeCompraException {
		OrdenDeCompraDao.getInstancia().save(this);	
	}

	public void update() throws ArticuloException, OrdenDeCompraException{
		OrdenDeCompraDao.getInstancia().update(this);
	}

	public OrdenDeCompraEntity toEntity(){
		OrdenDeCompraEntity oc = new OrdenDeCompraEntity();
		oc.setEstado(this.getEstado());
		oc.setFecha(this.getFecha());
		oc.setIdOC(this.getIdOc());
		oc.setItems(this.getItemsEntity(oc));
		oc.setOP(this.getOrdenPedido().toEntity());
		oc.setProveedor(this.getProv().toEntity());
		return oc;
	}

	public OrdenDeCompraDTO toDTO(){
		OrdenDeCompraDTO oc = new OrdenDeCompraDTO();
		oc.setEstado(this.getEstado());
		oc.setFecha(this.getFecha());
		oc.setIdOc(this.getIdOc());
		oc.setItems(this.getItemsDTO());
		oc.setOrdenPedidoDTO(this.getOrdenPedido().toDTO());
		oc.setProv(this.getProv().toDTO());
		return oc;
	}

	//Getters y Setters

	public int getIdOc() {
		return idOc;
	}

	public void setIdOc(int idOc) {
		this.idOc = idOc;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Proveedor getProv() {
		return prov;
	}

	public void setProv(Proveedor prov) {
		this.prov = prov;
	}

	public OrdenDePedido getOrdenPedido() {
		return ordenPedido;
	}

	public void setOrdenPedido(OrdenDePedido ordenPedido) {
		this.ordenPedido = ordenPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ItemOrdenDeCompra> getItems() {
		return items;
	}

	public List<ItemOrdenDeCompraEntity> getItemsEntity(OrdenDeCompraEntity oc) {
		List<ItemOrdenDeCompraEntity> list = new ArrayList<ItemOrdenDeCompraEntity>();
		for (ItemOrdenDeCompra o: this.getItems()){
			ItemOrdenDeCompraEntity aux = new ItemOrdenDeCompraEntity();
			aux.setArticulo(o.getArticulo().toEntity());
			aux.setCantidad(o.getCantidad());
			aux.setOc(oc);
			aux.setItemOC(o.getIdItemOC());
			aux.setPrecio(o.getPrecio());			
			list.add(aux);
		}
		return list;
	}

	public List<ItemOrdenDeCompraDTO> getItemsDTO() {
		List<ItemOrdenDeCompraDTO> list = new ArrayList<ItemOrdenDeCompraDTO>();
		for (ItemOrdenDeCompra o: this.getItems()){
			list.add(o.toDTO());
		}
		return list;
	}

	public void setItems(List<ItemOrdenDeCompra> items) {
		this.items = items;
	}

}
