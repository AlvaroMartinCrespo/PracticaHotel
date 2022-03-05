package Practica5;

import java.util.Scanner;

public class Hotel {

	private static final int MINIMO_ESTRELLAS = 1;
	private static final int MAXIMO_ESTRELLAS = 5;
	private String nombre;
	private int estrellas;
	private Habitacion[] arrayHabitaciones;

	public Scanner sc = new Scanner(System.in);

//	Construtor

	public Hotel(String nombre, int estrellas, Habitacion[] habitaciones) {
		this.nombre = nombre;
		setEstrellas(estrellas);
		this.arrayHabitaciones = habitaciones;
	}

//	Set Estrellas

	public void setEstrellas(int estrellas) {
		while (estrellas > MAXIMO_ESTRELLAS || estrellas < MINIMO_ESTRELLAS) {
			System.out.println("Error. Número de estrellas incorrecto: " + estrellas);
			System.out.println("Introduzca de nuevo el número de estrellas");
			estrellas = sc.nextInt();
		}
		this.estrellas = estrellas;
	}

//	ToString

	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ", estrellas=" + estrellas + "]";
	}

//	Métodos

	public int checkIn(String tHabitacion) {

//		Variables
		int posicionHabitacion = -1;

		for (int j = 0; j < arrayHabitaciones.length; j++) {

			if (arrayHabitaciones[j].gettHabitacion().equalsIgnoreCase(tHabitacion)
					&& arrayHabitaciones[j].isHabitacionOcupada() == false) {

				posicionHabitacion = arrayHabitaciones[j].getnHabitacion();

				arrayHabitaciones[j].setHabitacionOcupada(true);

				break;

			}
		}

		return posicionHabitacion;
	}
	
	public void checkOut(int numHabitacion) {
		
		
//		
		if(arrayHabitaciones[(numHabitacion-1)].isHabitacionOcupada()==true) {
			
			System.out.println("Check-out realizado correctamente");
			
			arrayHabitaciones[(numHabitacion-1)].setHabitacionOcupada(false);
			
		}else {
			System.out.println("Operación incorrecta, esa habitación no estaba actualmente ocupada");
		}
		
		
		
		
	}

}
