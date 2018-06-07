package negocio;

import java.util.Date;

public class MovimientoDaño extends MovimientoStock{

	private String destino;
	private String encargado;
	private String descripcion;
	private String autorizante;

	public MovimientoDaño(int idMov, Date fecha, Articulo articulo, String tipoMovimiento, String destino, String encargado, String descripcion, String autorizante) {
		super(idMov, fecha, articulo, tipoMovimiento);
		this.destino = destino;
		this.encargado = encargado;
		this.descripcion = descripcion;
		this.autorizante = autorizante;
	}

	public void save(){

	}

	//Getters y Setters

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
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
