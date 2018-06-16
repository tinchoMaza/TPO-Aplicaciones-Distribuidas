package negocio;

import java.util.*;

import dao.PedidoDao;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import entities.ItemPedidoEntity;
import entities.PedidoEntity;
import excepciones.PedidoException;

public class Pedido {

	private Integer nroPedido;
	private String estado;
	private Cliente cliente;
	private Date fechaGeneracion;
	private Date fechaDespacho;
	private Date fechaEntregaEsperada;
	private Date fechaEntrega;
	private float precioTotalBruto;
	private float precioTotalFinal;
	private String formaDePago;
	private String calleDireccEnvio;
	private int nroDireccEnvio;
	private String localidadDireccEnvio;
	private int cpDirecEnvio;
	private List<ItemPedido> itemsPedido;


	public Pedido(Integer nroPedido, String estado, Cliente cliente, Date fechaGeneracion, Date fechaDespacho,
			Date fechaEntregaEsperada, Date fechaEntrega, float precioTotalBruto, float precioTotalFinal,
			String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio,
			int cpDirecEnvio) {
		super();
		this.nroPedido = nroPedido;
		this.estado = estado;
		this.cliente = cliente;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaDespacho = fechaDespacho;
		this.fechaEntregaEsperada = fechaEntregaEsperada;
		this.fechaEntrega = fechaEntrega;
		this.precioTotalBruto = precioTotalBruto;
		this.precioTotalFinal = precioTotalFinal;
		this.formaDePago = formaDePago;
		this.calleDireccEnvio = calleDireccEnvio;
		this.nroDireccEnvio = nroDireccEnvio;
		this.localidadDireccEnvio = localidadDireccEnvio;
		this.cpDirecEnvio = cpDirecEnvio;
	}	

	public Pedido(String estado, Cliente cliente, Date fechaGeneracion, Date fechaDespacho,
			Date fechaEntregaEsperada, Date fechaEntrega, float precioTotalBruto, float precioTotalFinal,
			String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio,
			int cpDirecEnvio) {
		super();
		this.estado = estado;
		this.cliente = cliente;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaDespacho = fechaDespacho;
		this.fechaEntregaEsperada = fechaEntregaEsperada;
		this.fechaEntrega = fechaEntrega;
		this.precioTotalBruto = precioTotalBruto;
		this.precioTotalFinal = precioTotalFinal;
		this.formaDePago = formaDePago;
		this.calleDireccEnvio = calleDireccEnvio;
		this.nroDireccEnvio = nroDireccEnvio;
		this.localidadDireccEnvio = localidadDireccEnvio;
		this.cpDirecEnvio = cpDirecEnvio;
		this.itemsPedido = new ArrayList<ItemPedido>();
	}	

	public Pedido(Integer nroPedido, String estado, Date fechaGeneracion, Date fechaDespacho,
			Date fechaEntregaEsperada, Date fechaEntrega, float precioTotalBruto, float precioTotalFinal,
			String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio,
			int cpDirecEnvio, Cliente cliente, List<ItemPedido> itemsPedido) {
		//se usa para pasar la entity a negocio
		super();
		this.nroPedido = nroPedido;
		this.estado = estado;
		this.cliente = cliente;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaDespacho = fechaDespacho;
		this.fechaEntregaEsperada = fechaEntregaEsperada;
		this.fechaEntrega = fechaEntrega;
		this.precioTotalBruto = precioTotalBruto;
		this.precioTotalFinal = precioTotalFinal;
		this.formaDePago = formaDePago;
		this.calleDireccEnvio = calleDireccEnvio;
		this.nroDireccEnvio = nroDireccEnvio;
		this.localidadDireccEnvio = localidadDireccEnvio;
		this.cpDirecEnvio = cpDirecEnvio;
		this.itemsPedido = itemsPedido;
	}

	public Pedido(Integer nroPedido, String estado, Date fechaGeneracion, Date fechaDespacho,
			Date fechaEntregaEsperada, Date fechaEntrega, float precioTotalBruto, float precioTotalFinal,
			String formaDePago, String calleDireccEnvio, int nroDireccEnvio, String localidadDireccEnvio,
			int cpDirecEnvio, Cliente cliente) {
		//se usa para pasar la entity a negocio
		super();
		this.nroPedido = nroPedido;
		this.estado = estado;
		this.cliente = cliente;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaDespacho = fechaDespacho;
		this.fechaEntregaEsperada = fechaEntregaEsperada;
		this.fechaEntrega = fechaEntrega;
		this.precioTotalBruto = precioTotalBruto;
		this.precioTotalFinal = precioTotalFinal;
		this.formaDePago = formaDePago;
		this.calleDireccEnvio = calleDireccEnvio;
		this.nroDireccEnvio = nroDireccEnvio;
		this.localidadDireccEnvio = localidadDireccEnvio;
		this.cpDirecEnvio = cpDirecEnvio;
		this.itemsPedido = new ArrayList<ItemPedido>();
	}


	public PedidoEntity toEntitySave() {
		PedidoEntity aux = new PedidoEntity(this.getEstado(), this.getFechaGeneracion(), 
				this.getFechaDespacho(),this.getFechaEntregaEsperada(), this.getFechaEntrega(), 
				this.getPrecioTotalBruto(), this.getPrecioTotalFinal(), this.getFormaDePago(), 
				this.getCalleDireccEnvio(), this.getNroDireccEnvio(), 
				this.getLocalidadDireccEnvio(), this.getCpDirecEnvio(), this.getCliente().toEntity(), this.getItemsPedidoEntity() );
		return aux;
	}
	
	public PedidoEntity toEntityUpdate() {
		PedidoEntity aux = new PedidoEntity(this.getNroPedido(), this.getEstado(), this.getFechaGeneracion(), 
				this.getFechaDespacho(),this.getFechaEntregaEsperada(), this.getFechaEntrega(), 
				this.getPrecioTotalBruto(), this.getPrecioTotalFinal(), this.getFormaDePago(), 
				this.getCalleDireccEnvio(), this.getNroDireccEnvio(), 
				this.getLocalidadDireccEnvio(), this.getCpDirecEnvio(), this.getCliente().toEntity(), this.getItemsPedidoEntity() );
		return aux;
	}



	public PedidoDTO toDTO() {	
		return new PedidoDTO(this.nroPedido, this.estado, this.cliente.toDTO(), this.fechaGeneracion, 
				this.fechaDespacho,this.fechaEntregaEsperada, this.fechaEntrega, 
				this.precioTotalBruto, this.precioTotalFinal, this.formaDePago, 
				this.calleDireccEnvio, this.nroDireccEnvio, 
				this.localidadDireccEnvio, this.cpDirecEnvio, this.getItemsPedidoDTO());
	}

	//Getters y Setters

	public Integer getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(Integer nroPedido) {
		this.nroPedido = nroPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaDespacho() {
		return fechaDespacho;
	}

	public void setFechaDespacho(Date fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}

	public Date getFechaEntregaEsperada() {
		return fechaEntregaEsperada;
	}

	public void setFechaEntregaEsperada(Date fechaEntregaEsperada) {
		this.fechaEntregaEsperada = fechaEntregaEsperada;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public float getPrecioTotalBruto() {
		float total = 0;
		for (ItemPedido it : this.itemsPedido) {
			total += (it.getCant() * it.getArticulo().getPrecioVentaUnitario());
		}
		return total;
	}

	public float getPrecioTotalFinal() {
		float total = 0;
		for (ItemPedido it : this.itemsPedido) {
			total += (it.getCant() * it.getArticulo().getPrecioVentaUnitario());
		}
		return total;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public String getCalleDireccEnvio() {
		return calleDireccEnvio;
	}

	public void setCalleDireccEnvio(String calleDireccEnvio) {
		this.calleDireccEnvio = calleDireccEnvio;
	}

	public int getNroDireccEnvio() {
		return nroDireccEnvio;
	}

	public void setNroDireccEnvio(int nroDireccEnvio) {
		this.nroDireccEnvio = nroDireccEnvio;
	}

	public String getLocalidadDireccEnvio() {
		return localidadDireccEnvio;
	}

	public void setLocalidadDireccEnvio(String localidadDireccEnvio) {
		this.localidadDireccEnvio = localidadDireccEnvio;
	}

	public int getCpDirecEnvio() {
		return cpDirecEnvio;
	}

	public void setCpDirecEnvio(int cpDirecEnvio) {
		this.cpDirecEnvio = cpDirecEnvio;
	}

	public List<ItemPedido> getItemsPedido() {
		return itemsPedido;
	}


	public List<ItemPedidoEntity> getItemsPedidoEntity() {
		List<ItemPedidoEntity> items = new ArrayList<ItemPedidoEntity>();
		ItemPedidoEntity aux = new ItemPedidoEntity();
		for (ItemPedido it: itemsPedido) {
			aux.setArticulo(it.getArticulo().toEntityUpdate());
			aux.setCantidad(it.getCant());
			aux.setIdItemPedido(it.getIdItemPedido());
			PedidoEntity pedentity = new PedidoEntity(it.getPedido().getNroPedido(), it.getPedido().getEstado(), it.getPedido().getFechaGeneracion(), 
					it.getPedido().getFechaDespacho(),it.getPedido().getFechaEntregaEsperada(), it.getPedido().getFechaEntrega(), 
					it.getPedido().getPrecioTotalBruto(), it.getPedido().getPrecioTotalFinal(), it.getPedido().getFormaDePago(), 
					it.getPedido().getCalleDireccEnvio(), it.getPedido().getNroDireccEnvio(), 
					it.getPedido().getLocalidadDireccEnvio(), it.getPedido().getCpDirecEnvio(), it.getPedido().getCliente().toEntity());
			aux.setPedido(pedentity);
			items.add(aux);
		}
		return items;
	}

	public List<ItemPedidoDTO> getItemsPedidoDTO() {
		List<ItemPedidoDTO> items = new ArrayList<ItemPedidoDTO>();
		ItemPedidoDTO aux = new ItemPedidoDTO();
		for (ItemPedido it: itemsPedido) {
			aux.setArticulo(it.getArticulo().toDTO());
			aux.setCant(it.getCant());
			aux.setIdItemPedido(it.getIdItemPedido());
			PedidoDTO pedidoDto = new PedidoDTO(nroPedido, estado, cliente.toDTO(), fechaGeneracion, fechaDespacho, fechaEntregaEsperada, fechaEntrega, precioTotalBruto, precioTotalFinal, formaDePago, calleDireccEnvio, nroDireccEnvio, localidadDireccEnvio, cpDirecEnvio);
			aux.setPedidoDTO(pedidoDto);
			items.add(aux);
		}
		return items;
	}
	public void setItemsPedido(List<ItemPedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}

	public int save() throws PedidoException {
		return PedidoDao.getInstancia().save(this);	
	}

	public void update() throws PedidoException{
		PedidoDao.getInstancia().update(this);
	}

	public void nuevoItemPedido(int cant, Articulo articulo) throws PedidoException {
		ItemPedido item = new ItemPedido(this, cant, articulo);
		int id = item.save();
		item.setIdItemPedido(id);
		this.itemsPedido.add(item);
	}

}
