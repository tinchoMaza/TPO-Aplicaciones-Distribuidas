package dao;

import hibernate.HibernateUtil;



import negocio.Articulo;
import negocio.Cliente;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import entities.ArticuloEntity;
import entities.ClienteEntity;
import excepciones.ArticuloException;
import excepciones.ClienteException;


public class ArticuloDao {

	private static ArticuloDao instancia;
	private static SessionFactory sf = null;

	public static ArticuloDao getInstancia(){
		if (instancia == null)
			sf = HibernateUtil.getSessionFactory();
		instancia = new ArticuloDao();
		return instancia;
	}

	public void save(Articulo articulo) throws ArticuloException{
		if (articulo != null){
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(articulo.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new ArticuloException("Error en el guardado del articulo en la BD");
		}
	}

	public void update(Articulo articulo) throws ArticuloException{
		if (articulo != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(articulo.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new ArticuloException("Error en el update del articulo en la BD");
		}
	}
	public void delete(Articulo articulo) throws ArticuloException {
		if (articulo != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(articulo.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else {
			throw new ArticuloException("Error en el borrado del articulo en la BD");
		}	
	}


	public Articulo buscarArticuloById(int idArticulo) throws ArticuloException{
		ArticuloEntity ar = null;
		Session s = sf.openSession();
		s.beginTransaction();
		Query query = s.createQuery("select c from ArticuloEntity c where c.idArticulo=?");
		query.setParameter(0, idArticulo);
		ar = (ArticuloEntity) query.uniqueResult();
		if (ar == null)
			throw new ArticuloException("Error en la busqueda del Articulo en la BD");
		else
			return ar.toNegocio();	
	}


	

}

