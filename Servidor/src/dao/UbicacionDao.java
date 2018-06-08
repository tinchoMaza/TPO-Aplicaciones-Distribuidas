package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.Query;

import entities.RemitoEntity;
import entities.UbicacionEntity;
import excepciones.RemitoException;
import excepciones.UbicacionException;
import hibernate.HibernateUtil;
import negocio.Remito;
import negocio.Ubicacion;

public class UbicacionDao {

	private static UbicacionDao instancia;
	private static SessionFactory sf = null;

	public static UbicacionDao getInstancia(){
		if (instancia == null)
			instancia = new UbicacionDao();
		sf = HibernateUtil.getSessionFactory();
		return instancia;
	}


	public void save(Ubicacion ubicacion) throws UbicacionException{
		if (ubicacion != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(ubicacion.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new UbicacionException("Error al buscar ubicacion en la BD");
		}
	}

	public void update(Ubicacion ubicacion) throws UbicacionException{
		if (ubicacion != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(ubicacion.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new UbicacionException("Error al buscar ubicacion en la BD");
		}
	}

	public void delete(Ubicacion ubicacion) throws UbicacionException{
		if (ubicacion != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.delete(ubicacion.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new UbicacionException("Error al buscar ubicacion en la BD");
		}
	}


	public List<Ubicacion> cargarUbicaciones() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select u from UbicacionEntity u");
		List<UbicacionEntity> ubsent = query.list();
		List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
		for(UbicacionEntity ue : ubsent)
			ubicaciones.add(ue.toNegocio());
		session.flush();
		session.getTransaction().commit();
		session.close();
		return ubicaciones;
	}

}