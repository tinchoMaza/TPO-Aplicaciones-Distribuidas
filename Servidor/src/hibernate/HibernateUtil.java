package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ArticuloDepositoEntity;
import entities.ArticuloEntity;
import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.FacturaEntity;
import entities.ItemFacturaEntity;
import entities.ItemOrdenDeCompraEntity;
import entities.ItemOrdenDePedidoEntity;
import entities.ItemPedidoEntity;
import entities.ItemRemitoEntity;
import entities.LoteEntity;
import entities.MovimientoAjusteEntity;
import entities.MovimientoCtaCteEntity;
import entities.MovimientoDañoEntity;
import entities.MovimientoEntity;
import entities.MovimientoSimpleEntity;
import entities.OrdenDeCompraEntity;
import entities.OrdenDePedidoEntity;
import entities.PedidoEntity;
import entities.ProveedorEntity;
import entities.RemitoEntity;
import entities.UbicacionEntity;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static
    {
        try
        {
             AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(ClienteEntity.class);
             config.addAnnotatedClass(CuentaCorrienteEntity.class);
             config.addAnnotatedClass(MovimientoCtaCteEntity.class);
             config.addAnnotatedClass(ArticuloDepositoEntity.class);
             config.addAnnotatedClass(ArticuloEntity.class);
             config.addAnnotatedClass(LoteEntity.class);
             config.addAnnotatedClass(FacturaEntity.class);
             config.addAnnotatedClass(ItemFacturaEntity.class);
             config.addAnnotatedClass(ItemPedidoEntity.class);
             config.addAnnotatedClass(PedidoEntity.class);
             config.addAnnotatedClass(ProveedorEntity.class);
             config.addAnnotatedClass(UbicacionEntity.class);
             config.addAnnotatedClass(OrdenDeCompraEntity.class);
             config.addAnnotatedClass(OrdenDePedidoEntity.class);
             config.addAnnotatedClass(ItemOrdenDeCompraEntity.class);
             config.addAnnotatedClass(ItemOrdenDePedidoEntity.class);
             config.addAnnotatedClass(ItemRemitoEntity.class);
             config.addAnnotatedClass(MovimientoAjusteEntity.class);
             config.addAnnotatedClass(MovimientoDañoEntity.class);
             config.addAnnotatedClass(MovimientoEntity.class);
             config.addAnnotatedClass(MovimientoSimpleEntity.class);
             config.addAnnotatedClass(RemitoEntity.class);
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
