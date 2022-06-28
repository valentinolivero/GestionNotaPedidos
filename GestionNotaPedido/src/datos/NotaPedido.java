package datos;

import java.time.LocalDate;

public abstract class NotaPedido {
	protected int idNotaPedido;
	protected LocalDate fecha;
	protected int cantEstudiantes;
	protected Materia materia;
	public NotaPedido() {
		super();
	}
	public NotaPedido(LocalDate fecha, int cantEstudiantes, Materia materia) {
		super();
		this.fecha = fecha;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
	}
	public int getIdNotaPedido() {
		return idNotaPedido;
	}
	public void setIdNotaPedido(int idNotaPedido) {
		this.idNotaPedido = idNotaPedido;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getCantEstudiantes() {
		return cantEstudiantes;
	}
	public void setCantEstudiantes(int cantEstudiantes) {
		this.cantEstudiantes = cantEstudiantes;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}


}
