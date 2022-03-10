package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {

	public static void main(String[] args) throws ParseException {

		// Fecha nacimiento de la persona1
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaPersona1 = "17/02/2000";
		Date fechaNacimientoPersona1 = formatoFecha.parse(fechaPersona1);

		// Fecha nacimiento de la persona2
		String fechaPersona2 = "24/12/2013";
		Date fechaNacimientoPersona2 = formatoFecha.parse(fechaPersona2);

		// Fecha nacimiento de la persona2
		String fechaPersona3 = "04/03/1980";
		Date fechaNacimientoPersona3 = formatoFecha.parse(fechaPersona3);

		// Crear personas
		Persona persona1 = new Persona("Jose", "P�rez T�rres", "73937219Q", fechaNacimientoPersona1, "C/Calle, n�2");
		Persona persona2 = new Persona("Pepe", "Mart�n Carrasco", "06714005Y", fechaNacimientoPersona2,
				"C/Calle2, n�13");
		Persona persona3 = new Persona("Manuel", "L�pez Garc�a", "45055360Q", fechaNacimientoPersona3, "C/Calle3, n�4");

		// Mostrar datos de la persona1
		System.out.println("Los datos de la persona son: " + persona1.toString());
		System.out.println();

		// Obtener edad de la persona1
		System.out.println("La persona1 tiene " + persona1.obtenerEdad() + " a�os");
		System.out.println();

		// Creaci�n de bolsas de empleo vac�as
		BolsaEmpleo b1 = new BolsaEmpleo(new ArrayList<>(), "Bolsa trabajo 01");
		BolsaEmpleo bolsa02 = new BolsaEmpleo(new ArrayList<>(), "Bolsa trabajo 02");
		BolsaEmpleo bolsa03 = new BolsaEmpleo(new ArrayList<>(), "Bolsa trabajo 03");

		List<BolsaEmpleo> listaDeBolsas = new ArrayList<>();
		listaDeBolsas.add(b1);
		listaDeBolsas.add(bolsa02);
		listaDeBolsas.add(bolsa03);

		// A�ade la persona1 a la bolsa01
		b1.anyadirPersona(persona1, listaDeBolsas);
		System.out.println(b1.toString());
		System.out.println(
				"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println();

		// Intenta a�adir la persona1 a la bolsa02 (pero no puede porque ya est� en la
		// bolsa01
		bolsa02.anyadirPersona(persona1, listaDeBolsas);
		System.out.println(bolsa02.toString());
		System.out.println(
				"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println();

		// Intenta a�adir la persona2 a la bolsa02 pero no puede porque es menor de edad
		bolsa02.anyadirPersona(persona2, listaDeBolsas);
		System.out.println(bolsa02.toString());
		System.out.println(
				"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println();

		// A�ade la persona3 a la bolsa02
		bolsa02.anyadirPersona(persona3, listaDeBolsas);
		System.out.println(bolsa02.toString());
		System.out.println(
				"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println();

		// Intenta a�adir la persona1 a la bolsa03 (pero no puede porque ya est� en la
		// bolsa01
		bolsa02.anyadirPersona(persona1, listaDeBolsas);
		System.out.println(bolsa03.toString());
		System.out.println(
				"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println();
	}

}

