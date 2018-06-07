package negocio;

import java.util.*;

import dao.LoteDao;
import dto.LoteDTO;
import entities.LoteEntity;
import excepciones.LoteException;

public class Lote {

	private Integer idLote;
	private Date fechaVenc;

	public Lote(Integer idLote, Date fechaVenc) {
		super();
		this.idLote = idLote;
		this.fechaVenc = fechaVenc;
	}

	public Lote(Date fechaVenc) {
		super();
		this.fechaVenc = fechaVenc;
	}


	public int cantDiasAVencer(){

		return 0;

	}

	public LoteEntity toEntity() {
		LoteEntity aux = new LoteEntity();
		aux.setFechaVenc(this.getFechaVenc());
		aux.setIdLote(this.getIdLote());
		return aux;
	}

	public LoteDTO toDTO() {
		LoteDTO aux = new LoteDTO();
		aux.setFechaVenc(this.getFechaVenc());
		aux.setIdLote(this.getIdLote());
		return aux;
	}

	//Getters y Setters

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

	public void save() throws LoteException {
		LoteDao.getInstancia().save(this);
		
	}





}
