package dao;
import datos.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class NotaPedidoDao {
	private static Session session;
	private Transaction tx;
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	public NotaPedido traerNotaPedidoMateria(int idNotaPedido) throws HibernateException{
		NotaPedido objeto= null;
		try {
			iniciaOperacion();
			objeto= (NotaPedido) session.createQuery("from NotaPedido n where n.idNotaPedido="+idNotaPedido).uniqueResult();
			Hibernate.initialize(objeto.getMateria());

		}finally {
			session.close();
		}
		return objeto;
	}
	public List<NotaPedido> traer()throws HibernateException{
		List<NotaPedido> lista= new ArrayList<>();
		try {
			iniciaOperacion();
			lista= session.createQuery("from NotaPedido n").list();
			for (int i=0; i<lista.size();i++) {
				Hibernate.initialize(lista.get(i).getMateria());
			}

		}finally {
			session.close();
		}
		return lista;

	}
	public List<NotaPedido> traerConFecha(LocalDate fecha)throws HibernateException{
		List<NotaPedido> lista= new ArrayList<>();
		try {
			iniciaOperacion();
			lista= session.createQuery("from NotaPedido n where n.fecha ='"+ fecha +"'").list();
			for (int i=0; i<lista.size();i++) {
				Hibernate.initialize(lista.get(i).getMateria());
			}

		}finally {
			session.close();
		}
		return lista;

	}
	public List<NotaPedido> traerPorFinal(LocalDate fechaFinal) throws HibernateException{
		List<NotaPedido> lista= new ArrayList<>();
		
		try {
			iniciaOperacion();
			lista= session.createQuery("from Final f where f.fechaExamen ='"+ fechaFinal+"'").list();
			for (int i=0; i<lista.size();i++) {
				Hibernate.initialize(lista.get(i).getMateria());
			}

		}finally {
			session.close();
		}
		return lista;
		
	}
	public List<NotaPedido> traerFinales(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException{
		List<NotaPedido> lista= new ArrayList<>();
		try {
			iniciaOperacion();
			lista= session.createQuery("from Final f where f.fechaExamen between '"+fechaDesde+"' and '"+fechaHasta+"'").list();
			for (int i=0; i<lista.size();i++) {
				Hibernate.initialize(lista.get(i).getMateria());
			}
		}finally {
			session.close();
		}
		return lista;
		
	}
	public List<NotaPedido> traerFinales(LocalDate fechaDesde, LocalDate fechaHasta, Materia materia) throws HibernateException{
		List<NotaPedido> lista= new ArrayList<>();
		try {
			iniciaOperacion();
			lista= session.createQuery("from Final f inner join fetch f.materia m where f.fechaExamen between '"+fechaDesde+"' and '"+fechaHasta+"'"+" and "+" m.idMateria ='"+materia.getIdMateria()+"'").list();

		}finally {
			session.close();
		}
		return lista;
		
	}
   public int agregarNotaPedido(Curso objeto) throws HibernateException{
	   int id=0;
	   try {
		   iniciaOperacion();
		   id= Integer.parseInt(session.save(objeto).toString());
		   tx.commit();
		   
	   }catch (HibernateException he) {
		   manejaExcepcion(he);
		   throw he;
	   }finally {
		   session.close();
	   }
	   return id;
   }
}
