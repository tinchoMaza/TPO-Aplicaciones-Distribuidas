package dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.PedidoEntity;
import entities.UbicacionEntity;
import excepciones.PedidoException;
import hibernate.HibernateUtil;
import negocio.Pedido;
import negocio.Ubicacion;

public class PedidoDao {

	private static PedidoDao instancia = null;
	private static SessionFactory sf = null;
	//t

	public static PedidoDao getInstancia() {
		if(instancia==null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new PedidoDao();
		}
		return instancia;
	}

	public int save(Pedido p) throws PedidoException {
		if (p != null) {
			Session session = sf.openSession();
			session.beginTransaction();
			Integer id =  (Integer) session.save(p.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
			return id;
		}
		else {
			throw new PedidoException("Error en el guardado del Pedido");
		}	
	}

	public void update(Pedido p) throws PedidoException {
		if (p != null) {
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(p.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else {
			throw new PedidoException("Error al actualizar el Pedido");
		}	
	}

	public void delete(Pedido p) throws PedidoException {
		if (p != null) {
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(p.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else{
			throw new PedidoException("Error al borrar el Pedido");
		}	
	}

	public Pedido buscarPedidoById(Integer idPedido) throws PedidoException{
		PedidoEntity aux;
		Session s = sf.openSession();
		s.beginTransaction();
		aux = (PedidoEntity)s.createQuery("Select p From PedidoEntity p where p.nroPedido = ?").setInteger(0, idPedido).uniqueResult();
		if (aux != null) 
			return aux.toNegocio();
		else
			throw new PedidoException("Error al buscar pedido en la BD");
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> buscarPedidosByEstado(String estado) throws PedidoException{
		List<Pedido> devolver = new ArrayList<Pedido>();
		Session s = sf.openSession();
		s.beginTransaction();
		Query query = s.createQuery("Select p From PedidoEntity p where p.estado = ?");
		query.setParameter(0, estado);
		List<PedidoEntity> aux = query.list();
		if (aux != null) {
			for(PedidoEntity ped : aux)
				devolver.add(ped.toNegocio());
			s.flush();
			s.getTransaction().commit();
			s.close();
			return devolver;
		}else{
			throw new PedidoException("Error al buscar lista de pedidos en la BD");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> buscarPedidosByCliente(int cuitCliente) throws PedidoException{
		List<Pedido> devolver = new ArrayList<Pedido>();
		List<PedidoEntity> aux = new ArrayList<PedidoEntity>();
		Session s = sf.openSession();
		s.beginTransaction();
		aux = (List<PedidoEntity>)s.createQuery("From Pedido p where p.idCliente = ?").setInteger(0, cuitCliente).list();
		if (aux != null) {
			for(PedidoEntity ped : aux)
				devolver.add(ped.toNegocio());
			return devolver;

		}else{
			throw new PedidoException("Error al buscar lista de pedidos en la BD");
		}

	}

	public List<Pedido> buscarPedidosByEstadoPorOrden(String estado, int nroPedido) throws PedidoException {
		List<Pedido> devolver = new ArrayList<Pedido>();
		Session s = sf.openSession();
		s.beginTransaction();
		Query query = s.createQuery("Select p From PedidoEntity p where p.estado = ? and p.nroPedido>?");
		query.setParameter(0, estado);
		query.setParameter(1, nroPedido);
		List<PedidoEntity> aux = query.list();
		if (aux != null) {
			for(PedidoEntity ped : aux)
				devolver.add(ped.toNegocio());
			s.flush();
			s.getTransaction().commit();
			s.close();
			return devolver;
		}else{
			throw new PedidoException("Error al buscar lista de pedidos en la BD");
		}
	}
}