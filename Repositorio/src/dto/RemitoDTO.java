package dto;

import java.io.Serializable;
import java.util.*;

public class RemitoDTO implements Serializable{
	private static final long serialVersionUID = 4938602603852250741L;
	
	private int nroRemito;
	private Date fechaRemito;
	private ClienteDTO cliente;
	private PedidoDTO pedido;
	private List<ItemRemitoDTO> itemsRemito;

	public RemitoDTO (int nroRemito, Date fechaRemito, ClienteDTO cliente, PedidoDTO pedido, List<ItemRemitoDTO> itemsRemito){
		super();
		this.nroRemito = nroRemito;
		this.fechaRemito = fechaRemito;
		this.cliente = cliente;
		this.pedido = pedido;
		this.itemsRemito = itemsRemito;
	}

	public RemitoDTO() {}

	//Getters y Setters


	public int getNroRemito() {
		return nroRemito;
	}

	public void setNroRemito(int nroRemito) {
		this.nroRemito = nroRemito;
	}

	public Date getFechaRemito() {
		return fechaRemito;
	}

	public void setFechaRemito(Date fechaRemito) {
		this.fechaRemito = fechaRemito;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setClienteDTO(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedidoDTO(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public List<ItemRemitoDTO> getItemsRemitoDTO() {
		return itemsRemito;
	}

	public void setItemsRemitoDTO(List<ItemRemitoDTO> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}
}
