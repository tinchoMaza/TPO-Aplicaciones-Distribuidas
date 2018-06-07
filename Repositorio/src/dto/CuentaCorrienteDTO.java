package dto;

import java.io.Serializable;
import java.util.*;

public class CuentaCorrienteDTO implements Serializable  {

	private static final long serialVersionUID = -8204715031337076115L;
	
	private int idCtaCte;
	private Date fecha;
	private String especie;
	private float saldo;
	private List<MovimientoCtaCteDTO> movimientos;

	public CuentaCorrienteDTO(int idCtaCte, Date fecha, String especie, float saldo,
			List<MovimientoCtaCteDTO> movimientos) {
		super();
		this.idCtaCte = idCtaCte;
		this.fecha = fecha;
		this.especie = especie;
		this.saldo = saldo;
		this.movimientos = movimientos;
	}
	
	//Getters y Setters

	public CuentaCorrienteDTO(int idCtaCte, Date fecha, String especie, float saldo) {
		super();
		this.idCtaCte = idCtaCte;
		this.fecha = fecha;
		this.especie = especie;
		this.saldo = saldo;
		this.movimientos = new ArrayList<MovimientoCtaCteDTO>();
	}

	public List<MovimientoCtaCteDTO> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoCtaCteDTO> movimientos) {
		this.movimientos = movimientos;
	}

	
	//GETTERS Y SETTERS
	
	public int getIdCtaCte() {
		return idCtaCte;
	}

	public void setIdCtaCte(int idCtaCte) {
		this.idCtaCte = idCtaCte;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
