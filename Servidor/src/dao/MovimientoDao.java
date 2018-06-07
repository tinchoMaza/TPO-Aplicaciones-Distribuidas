package dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.MovimientoAjusteEntity;
import entities.MovimientoDañoEntity;
import entities.MovimientoSimpleEntity;
import excepciones.MovimientoException;
import hibernate.HibernateUtil;
import negocio.MovimientoAjuste;
import negocio.MovimientoDaño;
import negocio.MovimientoSimple;

public class MovimientoDao {

	private static MovimientoDao instancia;
	private static SessionFactory sf;

	private MovimientoDao(){}

	public static MovimientoDao getInstancia(){
		if(instancia == null){
			instancia = new MovimientoDao();
			sf = HibernateUtil.getSessionFactory();
		}
		return instancia;
	}



	public void save(MovimientoSimple movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoSimpleEntity aux = new MovimientoSimpleEntity();
			aux.setIdMov(movimiento.getIdMov());
			aux.setArticulo(movimiento.getArticulo().toEntity());
			aux.setFecha(movimiento.getFecha());
			aux.setTipoMovimiento("SIMPLE");
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new MovimientoException("Error en el guardado de un movimiento simple en la BD");
		}
	}

	public void save(MovimientoDaño movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoDañoEntity aux = new MovimientoDañoEntity();
			aux.setTipoMovimiento("DAÑO");
			aux.setArticulo(movimiento.getArticulo().toEntity());
			aux.setEncargado(movimiento.getEncargado());
			aux.setFecha(movimiento.getFecha());
			aux.setAutorizante(movimiento.getAutorizante());
			aux.setDescripcion(movimiento.getDescripcion());
			aux.setDestino(movimiento.getDestino());
			aux.setIdMov(movimiento.getIdMov());
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new MovimientoException("Error en el guardado de un movimiento por daño en la BD");
		}
	}

	public void save(MovimientoAjuste movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoAjusteEntity aux = new MovimientoAjusteEntity();
			aux.setTipoMovimiento("AJUSTE");
			aux.setArticulo(movimiento.getArticulo().toEntity());
			aux.setEncargado(movimiento.getEncargado());
			aux.setFecha(movimiento.getFecha());
			aux.setDescripcion(movimiento.getDescripcion());
			aux.setIdMov(movimiento.getIdMov());		
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new MovimientoException("Error en el guardado de un movimiento por ajuste en la BD");
		}
	}


	public void update(MovimientoSimple movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoSimpleEntity aux = new MovimientoSimpleEntity();
			aux.setIdMov(movimiento.getIdMov());
			aux.setArticulo(movimiento.getArticulo().toEntity());
			aux.setFecha(movimiento.getFecha());
			aux.setTipoMovimiento("SIMPLE");
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new MovimientoException("Error al actualizar un movimiento simple en la BD");
		}
	}

	public void update(MovimientoDaño movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoDañoEntity aux = new MovimientoDañoEntity();
			aux.setTipoMovimiento("DAÑO");
			aux.setArticulo(movimiento.getArticulo().toEntity());
			aux.setEncargado(movimiento.getEncargado());
			aux.setFecha(movimiento.getFecha());
			aux.setAutorizante(movimiento.getAutorizante());
			aux.setDescripcion(movimiento.getDescripcion());
			aux.setDestino(movimiento.getDestino());
			aux.setIdMov(movimiento.getIdMov());
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new MovimientoException("Error al actualizar un movimiento por daño en la BD");
		}
	}

	public void update(MovimientoAjuste movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoAjusteEntity aux = new MovimientoAjusteEntity();
			aux.setTipoMovimiento("AJUSTE");
			aux.setArticulo(movimiento.getArticulo().toEntity());
			aux.setEncargado(movimiento.getEncargado());
			aux.setFecha(movimiento.getFecha());
			aux.setDescripcion(movimiento.getDescripcion());
			aux.setIdMov(movimiento.getIdMov());		
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new MovimientoException("Error al actualizar un movimiento por ajuste en la BD");
		}
	}

	public void delete(MovimientoSimple movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoSimpleEntity aux = new MovimientoSimpleEntity();
			aux.setIdMov(movimiento.getIdMov());
			aux.setArticulo(movimiento.getArticulo().toEntity());
			aux.setFecha(movimiento.getFecha());
			aux.setTipoMovimiento("SIMPLE");
			Session s = sf.openSession();
			s.beginTransaction();
			s.delete(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new MovimientoException("Error al borrar un movimiento simple en la BD");
		}
	}

	public void delete(MovimientoDaño movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoDañoEntity aux = new MovimientoDañoEntity();
			aux.setTipoMovimiento("DAÑO");
			aux.setArticulo(movimiento.getArticulo().toEntity());
			aux.setEncargado(movimiento.getEncargado());
			aux.setFecha(movimiento.getFecha());
			aux.setAutorizante(movimiento.getAutorizante());
			aux.setDescripcion(movimiento.getDescripcion());
			aux.setDestino(movimiento.getDestino());
			aux.setIdMov(movimiento.getIdMov());
			Session s = sf.openSession();
			s.beginTransaction();
			s.delete(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new MovimientoException("Error al borrar un movimiento por daño en la BD");
		}
	}

	public void delete(MovimientoAjuste movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoAjusteEntity aux = new MovimientoAjusteEntity();
			aux.setTipoMovimiento("AJUSTE");
			aux.setArticulo(movimiento.getArticulo().toEntity());
			aux.setEncargado(movimiento.getEncargado());
			aux.setFecha(movimiento.getFecha());
			aux.setDescripcion(movimiento.getDescripcion());
			aux.setIdMov(movimiento.getIdMov());		
			Session s = sf.openSession();
			s.beginTransaction();
			s.delete(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new MovimientoException("Error al borrar un movimiento por ajuste en la BD");
		}
	}


}

