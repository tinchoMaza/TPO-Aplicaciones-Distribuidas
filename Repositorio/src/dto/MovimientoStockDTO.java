package dto;
import java.io.Serializable;
import java.util.*;;


public abstract class MovimientoStockDTO implements Serializable{

	private static final long serialVersionUID = 566978255477480772L;
	
	protected int idMov;
	protected Date fecha;
	protected ArticuloDTO articulo;
	protected String tipoMovimiento;

	public MovimientoStockDTO(int idMov, Date fecha, ArticuloDTO articulo, String tipoMovimiento){
		super();
		this.idMov = idMov;
		this.fecha = fecha;
		this.articulo = articulo;
		this.tipoMovimiento = tipoMovimiento;
	}

	//Getters y Setters

	public int getIdMov() {
		return idMov;
	}

	public void setIdMov(int idMov) {
		this.idMov = idMov;
	}
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArticuloDTO getArticuloDTO() {
		return articulo;
	}

	public void setArticuloDTO(ArticuloDTO articulo) {
		this.articulo = articulo;
	}
}
