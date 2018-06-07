package entities;

import java.util.*;
import javax.persistence.*;

import negocio.MovimientoDa�o;

@Entity
@DiscriminatorValue("DA�O")

public class MovimientoDa�oEntity extends MovimientoEntity{
	
	private String destino;
	private String encargado;
	private String autorizante;
	private String descripcion;

	public MovimientoDa�oEntity() {
		super();
	}

	public MovimientoDa�oEntity(Integer idMov, Date fecha, String tipoMovimiento, ArticuloEntity articulo, String destino, String encargado, String autorizante, String descripcion) {
		super(idMov, fecha, tipoMovimiento, articulo);
		this.destino = destino;
		this.encargado = encargado;
		this.autorizante = autorizante;
		this.descripcion = descripcion;
	}
	
	public MovimientoDa�o toNegocio() {
		return new MovimientoDa�o(this.idMov, this.fecha, this.articulo.toNegocio(), this.autorizante, this.destino, this.encargado, this.descripcion, this.autorizante);
	}
	
	//GETTERS Y SETTERS

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
	public String getAutorizante() {
		return autorizante;
	}
	public void setAutorizante(String autorizante) {
		this.autorizante = autorizante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
