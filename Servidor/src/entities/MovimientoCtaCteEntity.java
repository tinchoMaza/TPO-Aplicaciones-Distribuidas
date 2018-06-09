package entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import negocio.CuentaCorriente;
import negocio.MovimientoCtaCte;

@Entity
@Table(name="MovimientoCtaCte")
public class MovimientoCtaCteEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7205765250898168265L;
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idCuentaCorriente")
	private CuentaCorrienteEntity cuentaCorriente;
	@Id
	private int nroMov;
	private Date fecha;
	private float monto;
	private String descripcion;
	
	public MovimientoCtaCteEntity(){}

	public MovimientoCtaCteEntity(CuentaCorrienteEntity cuentaCorriente, int nroMov, Date fecha, float monto, String descripcion) {
		super();
		this.cuentaCorriente = cuentaCorriente;
		this.nroMov = nroMov;
		this.fecha = fecha;
		this.monto = monto;
		this.descripcion = descripcion;
	}
	
	public MovimientoCtaCteEntity(CuentaCorrienteEntity cuentaCorriente, Date fecha, float monto, String descripcion) {
		super();
		this.cuentaCorriente = cuentaCorriente;
		this.fecha = fecha;
		this.monto = monto;
		this.descripcion = descripcion;
	}
	
	public MovimientoCtaCte toNegocio(CuentaCorriente ctaCte) {
		return new MovimientoCtaCte(ctaCte, this.nroMov, this.fecha, this.monto, this.descripcion);
	}

	//GETTERS Y SETTERS
	
	public CuentaCorrienteEntity getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorrienteEntity cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
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
	
	public void setNroMov(int nroMov) {
		this.nroMov = nroMov;
	}
	
	public int getNroMov() {
		return nroMov;
	}
	
}
