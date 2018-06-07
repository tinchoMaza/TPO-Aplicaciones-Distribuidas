package negocio;

import java.util.*;

import dao.UbicacionDao;
import dto.ArticuloDTO;
import dto.ArticuloDepositoDTO;
import dto.UbicacionDTO;
import entities.ArticuloDepositoEntity;
import entities.ArticuloEntity;
import entities.UbicacionEntity;
import excepciones.RemitoException;
import excepciones.UbicacionException;

public class Ubicacion {

	private String idUbicacion;
	private String estado;
	private List<ArticuloDeposito> articulos;
	private int capacidad;

	public Ubicacion(String idUbicacion) {
		super();
		this.idUbicacion = idUbicacion;
		this.estado = "LIBRE";
		this.articulos = new ArrayList<ArticuloDeposito>();
	}

	public Ubicacion() {
		super();
		this.articulos = new ArrayList<ArticuloDeposito>();
	}

	public boolean estaDisponible(){
		return this.estado.equals("LIBRE");
	}

	public float capacidadDisponible(){
		return capacidad-this.articulos.size();
	}
	public int getCantidadAlmacenada() {
		return this.articulos.size();
	}

	public void agregarArticulo(ArticuloDeposito a) {
		this.articulos.add(a);
		capacidad--;
	}
	public void setCapacidad(int capacidad) {
		//la capacidad deberia ser articulo.getCantidadDeStock()
		this.capacidad = capacidad;
	}
	public ArticuloDeposito retirarArticulo () {
		//este metodo es para cuando salen a despacho, agarro el primero total son todos del mismo tipo, solo cambiaria el ID
		this.capacidad++; //no deberia usarse porque no se vuelven a poner nuevos articulos porque serian de otro lote pero por las dudas..
		return articulos.get(0);
	}

	public UbicacionEntity toEntity() {
		UbicacionEntity aux = new UbicacionEntity();
		aux.setArticulos(this.getArticulosEntity());
		aux.setCapacidad(this.getCapacidad());
		aux.setEstado(this.getEstado());
		aux.setIdUbicacion(this.getIdUbicacion());
		return aux;
	}

	public UbicacionDTO toDTO() {
		UbicacionDTO aux = new UbicacionDTO();
		aux.setArticulos(this.getArticulosDTO());
		aux.setCapacidad(this.getCapacidad());
		aux.setEstado(this.getEstado());
		aux.setIdUbicacion(this.getIdUbicacion());
		return aux;
	}

	public void save() throws UbicacionException {
		UbicacionDao.getInstancia().save(this);
		
	}

	
	//Getters y Setters

	public String getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(String idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public Integer getLote() {
		return this.articulos.get(0).getLote().getIdLote();
	}

	public List<ArticuloDeposito> getArticulos() {
		return articulos;
	}

	private List<ArticuloDepositoEntity> getArticulosEntity() {
		List<ArticuloDepositoEntity> list = new ArrayList<ArticuloDepositoEntity>();
		for (ArticuloDeposito a : this.getArticulos()){
			list.add(a.toEntity());
		}
		return list;
	}
	private List<ArticuloDepositoDTO> getArticulosDTO() {
		List<ArticuloDepositoDTO> list = new ArrayList<ArticuloDepositoDTO>();
		for (ArticuloDeposito a : this.getArticulos()){
			list.add(a.toDTO());
		}
		return list;
	}


}
