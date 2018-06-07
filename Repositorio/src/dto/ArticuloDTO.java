package dto;

import java.io.Serializable;

public class ArticuloDTO implements Serializable{
	
	private static final long serialVersionUID = 8452544443407208140L;
	
	private int idArticulo;
	private String nombre;
	private int CapacidadArticulo;
	private String codBarras;
	private String descripcion;
	private String presentacion;
	private String unidadMedida;
	private int cantCompraFija;
	private float precioVentaUnitario;
	
	public ArticuloDTO(){
		
	}
	public ArticuloDTO(int idArticulo, String nombre, int CapacidadArticulo, String codBarras, String descripcion,
			String presentacion, String unidadMedida, int cantCompraFija, float precioVentaUnitario) {
		super();
		this.idArticulo = idArticulo;
		this.nombre = nombre;
		this.CapacidadArticulo = CapacidadArticulo;
		this.codBarras = codBarras;
		this.descripcion = descripcion;
		this.presentacion = presentacion;
		this.unidadMedida = unidadMedida;
		this.cantCompraFija = cantCompraFija;
		this.precioVentaUnitario = precioVentaUnitario;
	}


	//	Getters y Setters
	
	public int getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidadArticulo() {
		return CapacidadArticulo;
	}
	public void setCapacidadArticulo(int CapacidadArticulo) {
		this.CapacidadArticulo = CapacidadArticulo;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public int getCantCompraFija() {
		return cantCompraFija;
	}
	public void setCantCompraFija(int cantCompraFija) {
		this.cantCompraFija = cantCompraFija;
	}
	public float getPrecioVentaUnitario() {
		return precioVentaUnitario;
	}
	public void setPrecioVentaUnitario(float precioVentaUnitario) {
		this.precioVentaUnitario = precioVentaUnitario;
	}

}
