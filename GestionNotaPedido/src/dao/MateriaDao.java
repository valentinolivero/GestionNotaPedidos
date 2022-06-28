package dao;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Materia;
public class MateriaDao {
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
	public Materia traer(int idMateria) throws HibernateException{
				Materia objeto= new Materia();

				try {
					iniciaOperacion();
					objeto= (Materia) session.createQuery("from Materia m where m.idMateria="+idMateria).uniqueResult();
					
				}finally {
					session.close();
				}
				return objeto;
				
				
	}

}
