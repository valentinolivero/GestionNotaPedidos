package negocio;
import datos.Curso;
import datos.Materia;
import datos.NotaPedido;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;

import dao.NotaPedidoDao;
public class NotaPedidoABM {

	NotaPedidoDao dao=new NotaPedidoDao();
	public NotaPedido traerNotaPedidoConMateria(int idNotaPedido) {
		return dao.traerNotaPedidoMateria(idNotaPedido);
	}
	
	public List<NotaPedido> traer(){
		return dao.traer();
	}
	public List<NotaPedido> traerConFecha(LocalDate fecha){
		return dao.traerConFecha(fecha);
	}
	public List<NotaPedido> traerPorFinal(LocalDate fechaFinal){
		return dao.traerPorFinal(fechaFinal);
	}
	public List<NotaPedido> traerFinales(LocalDate fechaDesde, LocalDate fechaHasta){
		return dao.traerFinales(fechaDesde, fechaHasta);
	}
	public List<NotaPedido> traerFinales(LocalDate fechaDesde, LocalDate fechaHasta, Materia materia){
		return dao.traerFinales(fechaDesde, fechaHasta, materia);
	}
	public int agregarNotaPedido(LocalDate fecha, int cantEstudiantes, Materia materia, String codCurso){
		Curso aux= new Curso(fecha, cantEstudiantes, materia, codCurso);
		return dao.agregarNotaPedido(aux);
		
	}
	


}
