package dto;

import java.io.Serializable;
import java.util.List;

public class ProveedorDTO implements Serializable{

	private static final long serialVersionUID = 886145659436236561L;
	
	private int idProv;
	private String nombre;
	private int cuit;
	private String descripcion;
	private String direccion;
	private String telefonoContacto;
	private List<ArticuloDTO> articulos;
	
	public ProveedorDTO(){}
	
	public ProveedorDTO(int idProv, String nombre, int cuit, String descripcion, String direccion, String telefonoContacto, List<ArticuloDTO> articulos){
		super();
		this.idProv = idProv;
		this.nombre = nombre;
		this.cuit = cuit;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.telefonoContacto = telefonoContacto;
		this.articulos = articulos;
	}
	
	//Getters y setters

	public int getIdProv() {
		return idProv;
	}
	public void setIdProv(int idProv) {
		this.idProv = idProv;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	public List<ArticuloDTO> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<ArticuloDTO> articulos) {
		this.articulos = articulos;
	}
	
}
