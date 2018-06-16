package negocio;

import java.util.*;

import dao.MovimientoCtaCteDao;
import dto.MovimientoCtaCteDTO;
import entities.ItemRemitoEntity;
import entities.MovimientoCtaCteEntity;
import excepciones.CuentaCorrienteException;

public class MovimientoCtaCte {

	private CuentaCorriente cuentaCorriente;
	private int nroMov;
	private Date fecha;
	private float monto;
	private String descripcion;

	public MovimientoCtaCte(CuentaCorriente cuentaCorriente, int nroMov, Date fecha, float monto, String descripcion) {
		super();
		this.cuentaCorriente = cuentaCorriente;
		this.nroMov = nroMov;
		this.fecha = fecha;
		this.monto = monto;
		this.descripcion = descripcion;
	}

	public MovimientoCtaCte(CuentaCorriente cuentaCorriente, Date fecha, float monto, String descripcion) {
		super();
		this.cuentaCorriente = cuentaCorriente;
		this.fecha = fecha;
		this.monto = monto;
		this.descripcion = descripcion;
	}

	//Getters y Setters

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

	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	
	public MovimientoCtaCteEntity toEntitySave() {
		return new MovimientoCtaCteEntity(this.cuentaCorriente.toEntityUpdate(), this.fecha, this.monto, this.descripcion);
	}

	public MovimientoCtaCteEntity toEntityUpdate() {
		return new MovimientoCtaCteEntity(this.cuentaCorriente.toEntityUpdate(), this.nroMov, this.fecha, this.monto, this.descripcion);
	}

	public MovimientoCtaCteDTO toDTO() {		
		return new MovimientoCtaCteDTO(null, this.nroMov, this.fecha, this.monto, this.descripcion);
	}

	public int save() throws CuentaCorrienteException {
		return MovimientoCtaCteDao.getInstancia().save(this);
	}
}