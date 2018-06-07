package dto;
import java.util.*;


public class MovimientoSimpleDTO extends MovimientoStockDTO{

	public MovimientoSimpleDTO (int idMov, Date fecha, ArticuloDTO articulo, String tipoMovimiento) {
		super(idMov, fecha, articulo, tipoMovimiento);
	}
}
