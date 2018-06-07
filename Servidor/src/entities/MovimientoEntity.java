package entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="MovimientoStock")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipoMovimiento",discriminatorType=DiscriminatorType.STRING, length=10)

public abstract class MovimientoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer idMov;
	protected Date fecha;
	
	@Column (insertable = false, updatable = false)
	protected String tipoMovimiento; //DAÑO, AJUSTE O SIMPLE
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idArticulo")
	protected ArticuloEntity articulo;
	
	public MovimientoEntity(){}
	
	public MovimientoEntity(Integer idMov, Date fecha, String tipoMovimiento, ArticuloEntity articulo) {
		super();
		this.idMov = idMov;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.articulo = articulo;
	}

	//GETTERS Y SETTERS

	public Integer getIdMov() {
		return idMov;
	}

	public void setIdMov(Integer idMov) {
		this.idMov = idMov;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public ArticuloEntity getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloEntity articulo) {
		this.articulo = articulo;
	}
	
}
