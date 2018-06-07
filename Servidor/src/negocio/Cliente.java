package negocio;

import dao.ClienteDao;
import dto.ClienteDTO;
import entities.ClienteEntity;
import excepciones.ClienteException;

public class Cliente {

	private int dni;
	private String nombre;
	private String razonSocial;
	private int cuit;
	private float limiteCredito;
	private CuentaCorriente cuentaCorriente;
	private String condEspPago;
	private String notasAdv;
	private String calleDom;
	private int nroDom;
	private String localidadDom;
	private int cpDom;

	public Cliente(int dni, String nombre, String razonSocial, int cuit, float limiteCredito,
			CuentaCorriente cuentaCorriente, String condEspPago, String notasAdv, String calleDom, int nroDom,
			String localidadDom, int cpDom) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.limiteCredito = limiteCredito;
		this.cuentaCorriente = cuentaCorriente;
		this.condEspPago = condEspPago;
		this.notasAdv = notasAdv;
		this.calleDom = calleDom;
		this.nroDom = nroDom;
		this.localidadDom = localidadDom;
		this.cpDom = cpDom;
	}
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public float consultarSaldo(){
		return 123456;
	}
	public void agregarSaldo(float monto){

	}
	public void restarSaldo(float monto){
		this.cuentaCorriente.restarSaldo(monto);
	}

	public ClienteEntity toEntity(){
		ClienteEntity aux = new ClienteEntity();
		aux.setDni(this.dni);
		aux.setNombre(this.nombre);
		aux.setRazonSocial(this.razonSocial);
		aux.setCuit(this.cuit);
		aux.setLimiteCredito(this.limiteCredito);
		aux.setCuentaCorrienteEntity(this.cuentaCorriente.toEntity());
		aux.setCondEspPago(this.condEspPago);
		aux.setNotasAdv(this.notasAdv);
		aux.setCalleDom(this.calleDom);
		aux.setNroDom(this.nroDom);
		aux.setLocalidadDom(this.localidadDom);
		aux.setCpDom(this.cpDom);
		return aux;
	}

	public ClienteDTO toDTO (){
		ClienteDTO cliD = new ClienteDTO();
		cliD.setDni(this.dni);
		cliD.setNombre(this.nombre);
		cliD.setRazonSocial(this.razonSocial);
		cliD.setCuit(this.cuit);
		cliD.setLimiteCredito(this.limiteCredito);
		cliD.setCuentaCorrienteDTO(this.cuentaCorriente.toDTO());
		cliD.setCondEspPago(this.condEspPago);
		cliD.setNotasAdv(this.notasAdv);
		cliD.setCalleDom(this.calleDom);
		cliD.setNroDom(this.nroDom);
		cliD.setLocalidadDom(this.localidadDom);
		cliD.setCpDom(this.cpDom);
		return cliD;
	}

	public void save() throws ClienteException {
		ClienteDao.getInstancia().save(this);

	}
	//Getters y Setters

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
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}
	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
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


}
