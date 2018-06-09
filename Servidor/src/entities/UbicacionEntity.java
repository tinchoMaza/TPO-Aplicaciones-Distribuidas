package entities;

import java.util.*;
import javax.persistence.*;
import negocio.Ubicacion;

import java.io.*;

@Entity
@Table (name = "Ubicacion")

public class UbicacionEntity implements Serializable{

	private static final long serialVersionUID = -849488242783494816L;
	
	@Id
	private String idUbicacion;
	private String estado;
	private int capacidad;
	
	@OneToMany (cascade = CascadeType.MERGE, mappedBy = "ubicacion", fetch = FetchType.LAZY)
	private List<ArticuloDepositoEntity> articulos;

	public UbicacionEntity(String idUbicacion, String estado, int capacidad, List<ArticuloDepositoEntity> articulos) {
		super();
		this.idUbicacion = idUbicacion;
		this.estado = estado;
		this.capacidad = capacidad;
		this.articulos = articulos;
	}

	public UbicacionEntity(String idUbicacion, String estado) {
		super();
		this.idUbicacion = idUbicacion;
		this.estado = estado;
		this.articulos = new ArrayList<ArticuloDepositoEntity>();
	}
	
	public UbicacionEntity() {
		super();
		this.articulos = new ArrayList<ArticuloDepositoEntity>();
	}

	public boolean estaDisponible(){
		return this.estado.equals("LIBRE");
	}
	
	public float capacidadDisponible(){
		return capacidad-this.articulos.size();
	}
	public int getCantidadAlmacenada() {
		return this.articulos.size();
	}
	
	public void agregarArticulo(ArticuloDepositoEntity a) {
		this.articulos.add(a);
		capacidad--;
	}
	public void setCapacidad(int capacidad) {
		//la capacidad deberia ser articuloEntity.getCantidadDeStock()
		this.capacidad = capacidad;
	}

	
	public Ubicacion toNegocio() {
		Ubicacion aux = new Ubicacion();
		aux.setCapacidad(this.getCapacidad());
		aux.setEstado(this.getEstado());
		aux.setIdUbicacion(this.getIdUbicacion());
		return aux;

	}
	
	//GETTERS Y SETTERS
	
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
	public int getCapacidad() {
		return capacidad;
	}
	public List<ArticuloDepositoEntity> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<ArticuloDepositoEntity> list) {
		this.articulos = list;
	}

}
