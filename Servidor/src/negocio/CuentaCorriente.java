package negocio;

import java.util.*;

import dto.CuentaCorrienteDTO;
import dto.MovimientoCtaCteDTO;
import entities.CuentaCorrienteEntity;
import entities.MovimientoCtaCteEntity;

public class CuentaCorriente {

	private int idCuentaCorriente;
	private Date fecha;
	private String especie;
	private float saldo;
	private List<MovimientoCtaCte> movimientos;

	public CuentaCorriente(){};

	public CuentaCorriente(int idCuentaCorriente, Date fecha, String especie, float saldo,
			List<MovimientoCtaCte> movimientos) {
		super();
		this.idCuentaCorriente = idCuentaCorriente;
		this.fecha = fecha;
		this.especie = especie;
		this.saldo = saldo;
		this.movimientos = movimientos;
	}
	
	public CuentaCorriente(int idCuentaCorriente, Date fecha, String especie, float saldo) {
		super();
		this.idCuentaCorriente = idCuentaCorriente;
		this.fecha = fecha;
		this.especie = especie;
		this.saldo = saldo;
		this.movimientos = new ArrayList<MovimientoCtaCte>();
	}

	public void agregarSaldo(float monto){

	}
	public void restarSaldo(float monto){
		this.saldo = this.saldo - monto;
	}
	public float consultarSaldo(){
		return 123456;
	}

	public CuentaCorrienteEntity toEntitySave() {
		CuentaCorrienteEntity cuentaentity = new CuentaCorrienteEntity(this.fecha, this.especie, this.saldo);
		if(!this.movimientos.isEmpty() || this.movimientos != null) {
			for(MovimientoCtaCte m : this.movimientos){
				MovimientoCtaCteEntity moventity = m.toEntityUpdate();
				moventity.setCuentaCorriente(cuentaentity);
				cuentaentity.getMovimientos().add(moventity);
			}
		}
		return cuentaentity;
	}
	

	public CuentaCorrienteEntity toEntityUpdate() {
		CuentaCorrienteEntity cuentaentity = new CuentaCorrienteEntity(this.idCuentaCorriente, this.fecha, this.especie, this.saldo);
		if(!this.movimientos.isEmpty() || this.movimientos != null) {
			for(MovimientoCtaCte m : this.movimientos){
				MovimientoCtaCteEntity moventity = m.toEntityUpdate();
				moventity.setCuentaCorriente(cuentaentity);
				cuentaentity.getMovimientos().add(moventity);
			}
		}
		return cuentaentity;
	}

	public CuentaCorrienteDTO toDTO(){
		CuentaCorrienteDTO cuentadto = new CuentaCorrienteDTO(this.idCuentaCorriente, this.fecha, this.especie, this.saldo);
		if(!this.movimientos.isEmpty() || this.movimientos != null) {
			for(MovimientoCtaCte m : this.movimientos) {
				MovimientoCtaCteDTO movdto = m.toDTO();
				movdto.setCuentaCorriente(cuentadto);
				cuentadto.getMovimientos().add(movdto);
			}	
		}
		return cuentadto;
	}

	//Getters y Setters

	public Date getFecha() {
		return fecha;
	}
	public int getidCuentaCorriente() {
		return idCuentaCorriente;
	}
	public void setidCuentaCorriente(int idCtaCte) {
		this.idCuentaCorriente = idCtaCte;
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

	public List<MovimientoCtaCte> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoCtaCte> movimientos) {
		this.movimientos = movimientos;
	}


}
