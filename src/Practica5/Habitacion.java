package Practica5;

public class Habitacion {

//	Atributos 
	private int nHabitacion;
	private String tHabitacion;
	private boolean habitacionOcupada;

//	Constructores

	public Habitacion(int nHabitacion, String tHabitacion, boolean habitacionOcupada) {
		this.nHabitacion = nHabitacion;
		this.tHabitacion = tHabitacion;
		this.habitacionOcupada = habitacionOcupada;

	}

	public Habitacion(String tHabitacion) {
		this.tHabitacion = tHabitacion;
	}

//	Getters y Setters

	public int getnHabitacion() {
		return nHabitacion;
	}

	public void setnHabitacion(int nHabitacion) {
		this.nHabitacion = nHabitacion;
	}

	public String gettHabitacion() {
		return tHabitacion;
	}

	public void settHabitacion(String tHabitacion) {
		this.tHabitacion = tHabitacion;
	}

	public boolean isHabitacionOcupada() {
		return habitacionOcupada;
	}

	public void setHabitacionOcupada(boolean habitacionOcupada) {
		this.habitacionOcupada = habitacionOcupada;
	}


//	Métodos

	
//	ToString
	
	@Override
	public String toString() {
		return "Habitacion [numero=" + nHabitacion + ", tipo=" + tHabitacion + ", Ocupada="
				+ habitacionOcupada + "]";
	}

	
	
	
	
	
}
