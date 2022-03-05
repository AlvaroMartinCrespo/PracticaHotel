package Practica5;

import java.util.*;

public class Test {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Variables

		String nombre;
		String tHabitacion;
		int habitacionesSimples, habitacionesDobles, habitacionesTriples, sumaHabitaciones, accion, tHabitacionNum,
				numHabitacion;
		int estrellas = 1;
		Habitacion[] habitaciones;

//		Introducimos datos para crear el hotel

		System.out.println("Introduzca el nombre del hotel: ");
		nombre = entrada.nextLine();

//		Introducimos el tipo de habitacion y comprobamos que lo datos son correctos

		do {

			System.out.println("¿Cuantas habitaciones quieres crear simples?");
			habitacionesSimples = entrada.nextInt();

			if (habitacionesSimples < 0) {
				System.out.println("Error, el número debe ser mayor o igual a 0. Introduzcalo de nuevo");
			}

		} while (habitacionesSimples < 0);

		do {

			System.out.println("¿Cuantas habitaciones quieres crear dobles?");
			habitacionesDobles = entrada.nextInt();

			if (habitacionesDobles < 0) {
				System.out.println("Error, el número debe ser mayor o igual a 0. Introduzcalo de nuevo");
			}

		} while (habitacionesDobles < 0);

		do {

			System.out.println("¿Cuantas habitaciones quieres crear triples?");
			habitacionesTriples = entrada.nextInt();

			if (habitacionesTriples < 0) {
				System.out.println("Error, el número debe ser mayor o igual a 0. Introduzcalo de nuevo");
			}

		} while (habitacionesTriples < 0);

//		Total de habitaciones

		sumaHabitaciones = habitacionesSimples + habitacionesDobles + habitacionesTriples;

//		Creamos la array de habitaciones

		habitaciones = new Habitacion[sumaHabitaciones];

//		Introducimos los datos a la array

		for (int i = 0; i < habitaciones.length; i++) {

			if (i < habitacionesSimples) {

				habitaciones[i] = new Habitacion((i + 1), "Simple", false);

			} else if (i >= habitacionesSimples && i < (habitacionesSimples + habitacionesDobles)) {

				habitaciones[i] = new Habitacion((i + 1), "Doble", false);

			} else {

				habitaciones[i] = new Habitacion((i + 1), "Triple", false);

			}

		}

//		Comprobacion de los datos de la array

//		for(int g=0;g<habitaciones.length;g++) {
//			
//			System.out.println(habitaciones[g].getnHabitacion());
//			System.out.println(habitaciones[g].gettHabitacion());
//			System.out.println(habitaciones[g].isHabitacionOcupada());
//			
//		}

//		Instanciamos la clase hotel

		Hotel hotel = new Hotel(nombre, estrellas, habitaciones);

//		Introducimos el número de estrellas del hotel

		System.out.println("Introduzca el número de estrellas del hotel:");

		estrellas = entrada.nextInt();

		hotel.setEstrellas(estrellas);

//		Una vez hecho esto ya hemos terminado de crear el hotel

		System.out.println(
				"Enhorabuena, hotel creado correctamente con un total de " + sumaHabitaciones + " habitaciones");

//		Introducimos le menú

		do {

			System.out.println(" ");
			System.out.println(".:MENU:." + "\n" + "1. Realizar check-in." + "\n" + "2. Realizar check-out." + "\n"
					+ "3. Consultar información de habitación y hotel." + "\n" + "4. Salir.");
			accion = entrada.nextInt();

//			Introducimos un switch para le menu

			switch (accion) {

			case 1:

//				Introduce el numero de habitacion que desea y comprobamos que introduce una opción válida

				do {

					System.out.println(
							"Introduzca el tipo de habitación deseada: 1 - Simple, 2 - Doble, 3 - Triple");

					tHabitacionNum = entrada.nextInt();

					if (tHabitacionNum != 1 && tHabitacionNum != 2 && tHabitacionNum != 3) {
						System.out.println("No existe opción");
						System.out.println(" ");
					}

				} while (tHabitacionNum != 1 && tHabitacionNum != 2 && tHabitacionNum != 3);

//				Lo pasamos a String para que lo podamos comparar

				if (tHabitacionNum == 1) {

					tHabitacion = "Simple";

				} else if (tHabitacionNum == 2) {

					tHabitacion = "Doble";

				} else {

					tHabitacion = "Triple";
				}

//				Llamamos al método del hotel

				numHabitacion = hotel.checkIn(tHabitacion);

//				Por último comprobamos si la habitación esta libre o no.

				if (numHabitacion == -1) {

					System.out.println("Esas habitaciones no estan disponibles");

				} else {

					System.out.println("Check-in realizado correctamente. Se le ha asignado la habitación número "
							+ numHabitacion);

				}

				break;

			case 2:

//				Introduce el numero de la habitacion que quiere hacer el check out.

				System.out.println("Introduzca el número de habitación");
				numHabitacion = entrada.nextInt();

//				Comprobamos que exista esa habitacion, en caso de que existe llama al metodo de la clase hotel.

				if (numHabitacion > sumaHabitaciones || numHabitacion < 0) {
					System.out.println("Error, esa habitación no existe");
				} else {
					hotel.checkOut(numHabitacion);
				}

				break;

			case 3:

//				Introduce el numero de habitacion que quiere comprobar el estado

				System.out.println("Introduzca el número de habitación de la cual desea consultar el estado:");
				numHabitacion = entrada.nextInt();

//				Se imprime el método ToString de la clase Habitacion y de la clase Hotel.

				System.out.println(habitaciones[(numHabitacion - 1)].toString());
				System.out.println(hotel.toString());

				break;

			case 4:

				System.out.println("Gracias por utilizar nuestro hotel. Hasta pronto!");

				break;

			}

			if (accion > 4) {
				System.out.println("No existe opción.");
			}

		} while (accion != 4);

	}

}
