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
	private Integer idLote;	
	private Date fechaVenc;

	public LoteEntity(){}

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
