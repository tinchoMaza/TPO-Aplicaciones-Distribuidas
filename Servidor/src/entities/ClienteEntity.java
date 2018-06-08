package entities;

import java.io.Serializable;

import javax.persistence.*;

import entities.CuentaCorrienteEntity;
import negocio.Cliente;

@Entity
@Table(name="Cliente")

public class ClienteEntity implements Serializable {
	private static final long serialVersionUID = 3523307646994482451L;
	
	@Id
	private Integer dni;
	private int cuit;
	private String nombre;
	private String razonSocial;
	private float limiteCredito;
	
	@OneToOne (cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="cuentaCorriente")
	private CuentaCorrienteEntity cuentaCorriente;
	
	@Column (name = "conEspPago")
	private String condEspPago;
	private String notasAdv;
	private String calleDom;
	private int nroDom;
	private String localidadDom;
	private int cpDom;
	
	public ClienteEntity(){
	}

	public ClienteEntity(Integer dni, int cuit, String nombre, String razonSocial, float limiteCredito,
			CuentaCorrienteEntity cuentaCorriente, String condEspPago, String notasAdv, String calleDom, int nroDom,
			String localidadDom, int cpDom) {
		super();
		this.dni = dni;
		this.cuit = cuit;
		this.nombre = nombre;
		this.razonSocial = razonSocial;
		this.limiteCredito = limiteCredito;
		this.cuentaCorriente = cuentaCorriente;
		this.condEspPago = condEspPago;
		this.notasAdv = notasAdv;
		this.calleDom = calleDom;
		this.nroDom = nroDom;
		this.localidadDom = localidadDom;
		this.cpDom = cpDom;
	}

	public Cliente toNegocio() {
		Cliente aux = new Cliente();
		aux.setDni(this.dni);
		aux.setCuit(this.cuit);
		aux.setNombre(this.nombre);
		aux.setRazonSocial(this.razonSocial);
		aux.setLimiteCredito(this.limiteCredito);
		aux.setCondEspPago(this.condEspPago);
		aux.setNotasAdv(this.notasAdv);
		aux.setCalleDom(this.calleDom);
		aux.setNroDom(this.nroDom);
		aux.setLocalidadDom(this.localidadDom);
		aux.setCpDom(this.cpDom);
		aux.setCuentaCorriente(cuentaCorriente.toNegocio());
		return aux;
	}
	
	//GETTERS Y SETTERS
	
	public CuentaCorrienteEntity getCuentaCorriente() {
		return cuentaCorriente;
	}


	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public CuentaCorrienteEntity getCuentaCorrienteEntity() {
		return cuentaCorriente;
	}

	public void setCuentaCorrienteEntity(CuentaCorrienteEntity cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getCondEspPago() {
		return condEspPago;
	}

	public void setCondEspPago(String condEspPago) {
		this.condEspPago = condEspPago;
	}

	public String getNotasAdv() {
		return notasAdv;
	}

	public void setNotasAdv(String notasAdv) {
		this.notasAdv = notasAdv;
	}

	public String getCalleDom() {
		return calleDom;
	}

	public void setCalleDom(String calleDom) {
		this.calleDom = calleDom;
	}

	public int getNroDom() {
		return nroDom;
	}

	public void setNroDom(int nroDom) {
		this.nroDom = nroDom;
	}

	public String getLocalidadDom() {
		return localidadDom;
	}

	public void setLocalidadDom(String localidadDom) {
		this.localidadDom = localidadDom;
	}

	public int getCpDom() {
		return cpDom;
	}

	public void setCpDom(int cpDom) {
		this.cpDom = cpDom;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
}

