package dao;

import java.util.*;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ArticuloDepositoEntity;
import entities.ArticuloEntity;
import excepciones.ArticuloException;
import hibernate.HibernateUtil;
import negocio.ArticuloDeposito;

public class ArticuloDepositoDao {
	

	private static ArticuloDepositoDao instancia;
	private static SessionFactory sf = null;

	public static ArticuloDepositoDao getInstancia(){
		if (instancia == null)
			sf = HibernateUtil.getSessionFactory();
		instancia = new ArticuloDepositoDao();
		return instancia;
	}
	
	

	public void save(ArticuloDeposito articulo) throws ArticuloException{
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

	public void update(ArticuloDeposito articulo) throws ArticuloException{
		if (articulo != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(articulo.toEntity());
			s.flush();
			s.getTransaction().commit();
			s.close();
		}else{
			throw new ArticuloException("Error en el update del articulo en la BD");
		}
	}
	public void delete(ArticuloDeposito articulo) throws ArticuloException {
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


	public ArticuloDeposito buscarArticuloById(int idArticulo) throws ArticuloException{
		ArticuloDepositoEntity ar = null;
		Session s = sf.openSession();
		s.beginTransaction();
		Query query = s.createQuery("select c from ArticuloDepositoEntity c where c.idArticulo=?");
		query.setParameter(0, idArticulo);
		ar = (ArticuloDepositoEntity) query.uniqueResult();
		if (ar == null)
			throw new ArticuloException("Error en la busqueda del Articulo en la BD");
		else
			return ar.toNegocio();	
	}



	public List<ArticuloDeposito> cargarArticulosDeposito() {
		Session session = sf.openSession();
		Query query = session.createQuery("select c from ArticuloDepositoEntity c");
		List<ArticuloDepositoEntity> artDepoEnt = query.list();
		List<ArticuloDeposito> artsdep = new ArrayList<ArticuloDeposito>();
		for(ArticuloDepositoEntity ae : artDepoEnt)
			artsdep.add(ae.toNegocio());
		return artsdep;
	}
}
