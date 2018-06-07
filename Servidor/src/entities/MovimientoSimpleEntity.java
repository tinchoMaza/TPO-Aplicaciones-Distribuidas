package entities;

import java.util.*;
import javax.persistence.*;

import negocio.MovimientoSimple;

@Entity
@DiscriminatorValue("SIMPLE")

public class MovimientoSimpleEntity extends MovimientoEntity{

	public MovimientoSimpleEntity() {
		super();
	}

	public MovimientoSimpleEntity(Integer idMov, Date fecha, String tipoMovimiento, ArticuloEntity articulo) {
		super(idMov, fecha, tipoMovimiento, articulo);
	}

	
	public MovimientoSimple toNegocio() {
		return new MovimientoSimple(this.idMov, this.fecha, this.articulo.toNegocio(), this.tipoMovimiento);
	}
	
	
}
