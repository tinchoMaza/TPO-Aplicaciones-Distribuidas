package entities;

import java.util.*;
import javax.persistence.*;

import negocio.MovimientoAjuste;

@Entity
@DiscriminatorValue("AJUSTE")

public class MovimientoAjusteEntity extends MovimientoEntity {
	

	private static final long serialVersionUID = 3609250510543411955L;
	private String encargado;
	private String descripcion;
	
	public MovimientoAjusteEntity() {}

	public MovimientoAjusteEntity(Integer idMov, Date fecha, String tipoMovimiento, ArticuloEntity articulo, String encargado, String descripcion) {
		super(idMov, fecha, tipoMovimiento, articulo);
		this.encargado = encargado;
		this.descripcion = descripcion;
	}
	
	public MovimientoAjuste toNegocio() {
		return new MovimientoAjuste(this.idMov, this.fecha, this.articulo.toNegocio(), this.descripcion, this.encargado, this.descripcion);
	}

	//GETTERS Y SETTERS
	
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
