package negocio;
import dao.MateriaDao;
import datos.Materia;
public class MateriaABM {
MateriaDao dao= new MateriaDao();
public Materia traer(int idMateria) {
	return dao.traer(idMateria);
}
}
