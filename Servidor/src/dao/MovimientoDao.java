package dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.MovimientoAjusteEntity;
import entities.MovimientoDa�oEntity;
import entities.MovimientoSimpleEntity;
import excepciones.MovimientoException;
import hibernate.HibernateUtil;
import negocio.MovimientoAjuste;
import negocio.MovimientoDa�o;
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

	public void save(MovimientoDa�o movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoDa�oEntity aux = new MovimientoDa�oEntity();
			aux.setTipoMovimiento("DA�O");
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
			throw new MovimientoException("Error en el guardado de un movimiento por da�o en la BD");
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

	public void update(MovimientoDa�o movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoDa�oEntity aux = new MovimientoDa�oEntity();
			aux.setTipoMovimiento("DA�O");
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
			throw new MovimientoException("Error al actualizar un movimiento por da�o en la BD");
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

	public void delete(MovimientoDa�o movimiento) throws MovimientoException{
		if (movimiento != null){
			MovimientoDa�oEntity aux = new MovimientoDa�oEntity();
			aux.setTipoMovimiento("DA�O");
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
			throw new MovimientoException("Error al borrar un movimiento por da�o en la BD");
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

