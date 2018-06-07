package dto;

import java.io.Serializable;
import java.util.List;

public class UbicacionDTO implements Serializable{

	private static final long serialVersionUID = 6070127083219230240L;
	
	private String idUbicacion;
	private String estado;
	private List<ArticuloDepositoDTO> articulos;
	private int capacidad;
	private int cantidadAlmacenada;

	public UbicacionDTO (String idUbicacion, String estado, List<ArticuloDepositoDTO> articulos, int capacidad, int cantidadAlmacenada) {
		super();
		this.idUbicacion = idUbicacion;
		this.estado = estado;
		this.articulos = articulos;
		this.capacidad = capacidad;
		this.cantidadAlmacenada = cantidadAlmacenada;
	}

	public UbicacionDTO() {}

	//Getters y Setters

	public String getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(String idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<ArticuloDepositoDTO> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<ArticuloDepositoDTO> list) {
		this.articulos = list;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCantidadAlmacenada() {
		return cantidadAlmacenada;
	}

	public void setCantidadAlmacenada(int cantidadAlmacenada) {
		this.cantidadAlmacenada = cantidadAlmacenada;
	}


}
