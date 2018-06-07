package negocio;

import java.util.*;

public class MovimientoAjuste extends MovimientoStock {

	private String encargado;
	private String descripcion;

	public MovimientoAjuste(int idMov, Date fecha, Articulo articulo, String tipoMovimiento, String encargado, String descripcion) {
		super(idMov, fecha, articulo, tipoMovimiento);
		this.encargado = encargado;
		this.descripcion = descripcion;
	}

	public void save(){

	}

	//Getters y Setters

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
