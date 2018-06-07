package dto;

import java.io.Serializable;
import java.util.*;

public class MovimientoCtaCteDTO  implements Serializable  {

	private static final long serialVersionUID = 4562306019235112661L;
	
	private CuentaCorrienteDTO cuentaCorriente;
	private int nroMov;
	private Date fecha;
	private float monto;
	private String descripcion;
	
	public MovimientoCtaCteDTO() {
	}

	public MovimientoCtaCteDTO(CuentaCorrienteDTO cuentaCorriente, int nroMov, Date fecha, float monto, String descripcion) {
		super();
		this.cuentaCorriente = cuentaCorriente;
		this.nroMov = nroMov;
		this.fecha = fecha;
		this.monto = monto;
		this.descripcion = descripcion;
	}

	//Getters y setters

	public CuentaCorrienteDTO getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorrienteDTO cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	
	public int getNroMov() {
		return nroMov;
	}

	public void setNroMov(int nroMov) {
		this.nroMov = nroMov;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
