package dto;

import java.io.Serializable;
import java.util.*;

public class LoteDTO implements Serializable{

	private static final long serialVersionUID = 141846054077814589L;

	private int idLote;
	private Date fechaVenc;

	public LoteDTO() {}

	public LoteDTO(int idLote, Date fechaVenc) {
		super();
		this.idLote = idLote;
		this.fechaVenc = fechaVenc;
	}

	//Getters y Setters

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public Date getFechaVenc() {
		return fechaVenc;
	}

	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
