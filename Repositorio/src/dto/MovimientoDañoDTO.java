package dto;

import java.io.Serializable;

public class MovimientoDañoDTO implements Serializable{

	private static final long serialVersionUID = -3178642457978171490L;
	
	private String destino;
	private String tipo;
	private String encargado;
	private String descripcion;
	private String autorizante;

	public MovimientoDañoDTO(String destino, String tipo, String encargado, String descripcion, String autorizante){
		super();
		this.destino = destino;
		this.tipo = tipo;
		this.encargado = encargado;
		this.descripcion = descripcion;
		this.autorizante = autorizante;
	}

	//Getters y Setters

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

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

	public String getAutorizante() {
		return autorizante;
	}

	public void setAutorizante(String autorizante) {
		this.autorizante = autorizante;
	}
}
