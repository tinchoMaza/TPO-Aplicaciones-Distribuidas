package negocio;

import java.util.*;

public abstract class MovimientoStock {

	protected int idMov;
	protected Date fecha;
	protected Articulo articulo;
	protected String tipoMovimiento;

	public MovimientoStock(int idMov, Date fecha, Articulo articulo, String tipoMovimiento) {
		super();
		this.idMov = idMov;
		this.fecha = fecha;
		this.articulo = articulo;
		this.tipoMovimiento = tipoMovimiento;
	}

	//Getters y Setters

	public int getIdMov() {
		return idMov;
	}

	public void setIdMov(int idMov) {
		this.idMov = idMov;
	}
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

}
