package entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import negocio.Lote;

@Entity
@Table(name="Lote")
public class LoteEntity implements Serializable{
	private static final long serialVersionUID = -8368090500577751115L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idLote;
	
	private Date fechaVenc;

	public LoteEntity(){}
	
	public LoteEntity(Date fecha) {
		super();
		this.fechaVenc = fecha;
	}

	public LoteEntity(Integer idLote, Date fechaVenc) {
		super();
		this.idLote = idLote;
		this.fechaVenc = fechaVenc;
	}

	public Lote toNegocio() {
		  return new Lote(this.idLote,this.fechaVenc);
		 }
	//GETTERS Y SETTERS
	
	public Integer getIdLote() {
		return idLote;
	}

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}

	public Date getFechaVenc() {
		return fechaVenc;
	}

	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
	}
	

}
