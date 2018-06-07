package dto;

import java.io.Serializable;
import java.util.*;

public class OrdenDeCompraDTO implements Serializable{

	private static final long serialVersionUID = 4084049256639713263L;
	
	private int idOc;
	private Date fecha;
	private ProveedorDTO prov;
	private OrdenDePedidoDTO ordenPedido;
	private String estado;
	private List<ItemOrdenDeCompraDTO> items;

	public OrdenDeCompraDTO (int idOc, Date fecha, ProveedorDTO prov, OrdenDePedidoDTO ordenPedido, String estado, List<ItemOrdenDeCompraDTO> items){
		super();
		this.idOc = idOc;
		this.fecha = fecha;
		this.prov = prov;
		this.ordenPedido = ordenPedido;
		this.estado = estado;
		this.items = items;
	}

	public OrdenDeCompraDTO() {}

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

	public void setFecha(java.util.Date date) {
		this.fecha = date;
	}

	public ProveedorDTO getProv() {
		return prov;
	}

	public void setProv(ProveedorDTO prov) {
		this.prov = prov;
	}

	public OrdenDePedidoDTO getOrdenPedido() {
		return ordenPedido;
	}

	public void setOrdenPedidoDTO (OrdenDePedidoDTO ordenPedido) {
		this.ordenPedido = ordenPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ItemOrdenDeCompraDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemOrdenDeCompraDTO> items) {
		this.items = items;
	}
}
