package dto;

import java.io.Serializable;

public class MovimientoAjusteDTO implements Serializable{

	private static final long serialVersionUID = 8558888602244826288L;
	
	private String encargado;
	private String descripcion;
	
	public MovimientoAjusteDTO (String encargado, String descripcion){
		super();
		this.encargado = encargado;
		this.descripcion = descripcion;
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
