package dto;

import java.io.Serializable;
import java.util.*;

public class FacturaDTO implements Serializable{
	
	private static final long serialVersionUID = -7084338462058375899L;
	
	private int nroFactura;
	private Date fecha;
	private PedidoDTO pedido;
	private ClienteDTO cliente;
	private float totalFact;
	private String estado;
	private List<ItemFacturaDTO> itemsFact;
	
	public FacturaDTO() {}
	
	public FacturaDTO(int nroFactura, Date fecha, PedidoDTO pedido, ClienteDTO cliente, float totalFact, String estado,List<ItemFacturaDTO> itemsFact){
	super();
	this.nroFactura = nroFactura;
	this.fecha = fecha;
	this.pedido = pedido;
	this.cliente = cliente;
	this.totalFact = totalFact;
	this.estado=estado;
	this.itemsFact = itemsFact;
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
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public float getTotalFact() {
		return totalFact;
	}
	public void setTotalFact(float totalFact) {
		this.totalFact = totalFact;
	}
	public List<ItemFacturaDTO> getItemsFact() {
		return itemsFact;
	}
	public void setItemsFact(List<ItemFacturaDTO> itemsFact) {
		this.itemsFact = itemsFact;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}