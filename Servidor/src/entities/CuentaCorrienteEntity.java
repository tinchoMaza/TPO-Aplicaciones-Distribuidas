package entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import negocio.CuentaCorriente;
import negocio.MovimientoCtaCte;

@Entity
@Table(name="CuentaCorriente")
public class CuentaCorrienteEntity implements Serializable{
	
	private static final long serialVersionUID = -7035154393489168267L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idCuentaCorriente;
	
	private Date fecha;
	private String especie;
	private float saldo;

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cuentaCorriente")
	private List<MovimientoCtaCteEntity> movimientos;
	
	public CuentaCorrienteEntity(){}

	public CuentaCorrienteEntity(int idCuentaCorriente, Date fecha, String especie, float saldo,
			List<MovimientoCtaCteEntity> movimientos) {
		super();
		this.idCuentaCorriente = idCuentaCorriente;
		this.fecha = fecha;
		this.especie = especie;
		this.saldo = saldo;
		this.movimientos = movimientos;
	}
	
	
	public CuentaCorrienteEntity(Integer idCuentaCorriente, Date fecha, String especie, float saldo) {
		super();
		this.idCuentaCorriente = idCuentaCorriente;
		this.fecha = fecha;
		this.especie = especie;
		this.saldo = saldo;
		this.movimientos = new ArrayList<MovimientoCtaCteEntity>();
	}
	
	public CuentaCorrienteEntity(Date fecha, String especie, float saldo) {
		super();
		this.fecha = fecha;
		this.especie = especie;
		this.saldo = saldo;
		this.movimientos = new ArrayList<MovimientoCtaCteEntity>();
	}



	public CuentaCorriente toNegocio() {
		CuentaCorriente ctaCte = new CuentaCorriente();
			ctaCte.setEspecie(this.especie);
			ctaCte.setFecha(this.fecha);
			ctaCte.setidCuentaCorriente(this.idCuentaCorriente);
			ctaCte.setSaldo(this.saldo);
			ctaCte.setMovimientos(this.getMovimientosEntity(ctaCte));	
			return ctaCte;
	}
	
	private List<MovimientoCtaCte> getMovimientosEntity(CuentaCorriente ctaCte) {
		List<MovimientoCtaCte> list = new ArrayList<MovimientoCtaCte>();
		for(MovimientoCtaCteEntity m : this.movimientos) {
			MovimientoCtaCte movCtaCte = new MovimientoCtaCte(ctaCte, m.getNroMov(), m.getFecha(), m.getMonto(), m.getDescripcion());
			list.add(movCtaCte);
		}	
		return list;
	}

	//GETTERS Y SETTERS
	
	public int getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	public void setIdCuentaCorriente(int idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
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
	
	public List<MovimientoCtaCteEntity> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoCtaCteEntity> movimientos) {
		this.movimientos = movimientos;
	}
	
}
