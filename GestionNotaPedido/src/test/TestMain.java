package test;
import datos.*;
import negocio.*;
import java.time.*;
import java.util.*;
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n 1");
		MateriaABM materiaABM= new MateriaABM();
		Materia materiaAux= materiaABM.traer(1);
		System.out.println(materiaAux.toString());

		System.out.println("\n 2");
		NotaPedidoABM notaPedidoABM= new NotaPedidoABM();
		NotaPedido notaPedidoAux= notaPedidoABM.traerNotaPedidoConMateria(1);
		System.out.println(notaPedidoAux.toString());

		System.out.println("\n 3");
		System.out.println(notaPedidoABM.traerConFecha(LocalDate.of(2022, 03, 01)));

		System.out.println("\n 4");
		//System.out.println(notaPedidoABM.traerPorFinal(LocalDate.of(2022, 5, 9)));
		System.out.println(notaPedidoABM.traerFinales(LocalDate.of(2022, 5, 9), LocalDate.of(2022, 5, 11)).toString());

		System.out.println("\n 5");
		System.out.println(notaPedidoABM.traerFinales(LocalDate.of(2022, 5, 9), LocalDate.of(2022, 5, 11), materiaABM.traer(3)));

		System.out.println("\n 6");
		System.out.println(notaPedidoABM.agregarNotaPedido(LocalDate.of(2022, 6, 15), 100, materiaABM.traer(3), "codCurso"));


	}

}
