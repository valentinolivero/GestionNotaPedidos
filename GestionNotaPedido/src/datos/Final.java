package datos;

import java.time.LocalDate;

public class Final extends NotaPedido{
private LocalDate fechaExamen;

public Final() {
	super();
}

public Final(LocalDate fecha, int cantEstudiantes, Materia materia, LocalDate fechaExamen) {
	super(fecha, cantEstudiantes, materia);
	this.fechaExamen = fechaExamen;
}

public LocalDate getFechaExamen() {
	return fechaExamen;
}

public void setFechaExamen(LocalDate fechaExamen) {
	this.fechaExamen = fechaExamen;
}

@Override
public String toString() {
	return "NotaPedido [fechaExamen=" + fechaExamen +"IdNotaPedido="+idNotaPedido+" Fecha="+fecha+" Materia="+materia.toString()+ "]";
}

}
