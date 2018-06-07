package dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.FacturaEntity;
import excepciones.FacturaException;
import hibernate.HibernateUtil;

import negocio.Factura;

public class FacturaDao {


	private static FacturaDao instancia;
	private static SessionFactory sf = null;

	public static FacturaDao getInstancia() {
		if(instancia==null) {
			instancia = new FacturaDao();
			sf = HibernateUtil.getSessionFactory();
		}
		return instancia;
	}

	public int save(Factura factura) throws FacturaException{
		if (factura != null){
			FacturaEntity aux = new FacturaEntity();
			aux.setCliente(factura.getCliente().toEntity());
			aux.setEstado(factura.getEstado());
			aux.setFecha(factura.getFecha());
			aux.setPedido(factura.getPedido().toEntity());
			Session s = sf.openSession();
			s.beginTransaction();
			int nroFactura = (Integer) s.save(aux);
			s.getTransaction().commit();
			s.close();
			return nroFactura;
		}else{
			throw new FacturaException("Error al guardar la factura en la BD");
		}
	}

	public List<Factura> buscarFacturasByEstado(String estado) throws FacturaException{
		List<FacturaEntity> aux = new ArrayList<FacturaEntity>();
		List<Factura> devolver = new ArrayList<Factura>();
		Session s = sf.openSession();
		s.beginTransaction();
		aux = (List<FacturaEntity>) s.createQuery("Select f from FacturaEntity f where f.estado = ?").setString(0, estado).list();
		if (aux != null){
			for(FacturaEntity fac : aux)
				devolver.add(fac.toNegocio());
			return devolver;
		}else{
			throw new FacturaException("Error al obtener la lista de Facturas en la BD");
		}

	}

	public Factura buscarFacturaById(int idFactura) throws FacturaException{
		FacturaEntity aux = new FacturaEntity();
		Session s = sf.openSession();
		s.beginTransaction();
		aux = (FacturaEntity)s.createQuery("From Factura f where f.idFactura = ?").setInteger(0, idFactura).uniqueResult();
		if (aux == null)
			throw new FacturaException("Error al buscar la Factura en la BD");
		else
			return aux.toNegocio();
	}

	public void update(Factura factura) throws FacturaException {
		if (factura != null){
			FacturaEntity aux = factura.toEntity();
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(aux);
			s.getTransaction().commit();
			s.close();
		}else{
			throw new FacturaException("Error al actualizar la Factura en la BD");
		}
	}

	public void delete(Factura factura) throws FacturaException {
		if (factura != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(factura.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else {
			throw new FacturaException("Error en el borrado de factura en la BD");
		}	
	}

}
