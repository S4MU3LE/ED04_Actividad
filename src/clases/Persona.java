package clases;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

public class Persona {

	private String nombre;
	private String apellidos;
	private String dni;
	private Date fecha_nacimiento;
	private String calle;

	private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
	private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public static Pattern getRegexp() {
		return REGEXP;
	}

	public static String[] getInvalidos() {
		return INVALIDOS;
	}

	private static final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };

//	(1) Lo primero que hacemos es asegurarnos de que el
// 	string no es ninguno de los DNI no v�lidos que fija
// 	el Ministerio de Interior.
//	  
// 	(2)Despu�s, mediante una expresi�n regular, validamos
// 	que el string tenga 8 n�meros y una letra al final
//	(en este punto, solo estamos validando que la cadena
//	de texto est� bien formada).
//	  
//   (3)Para terminar, no basta con que el �ltimo d�gito
//   sea una letra, tiene que cumplir que el �ltimo
//   car�cter se corresponda con el d�gito de control de
//   la tabla despu�s de aplicar la operaci�n m�dulo 23.

	public Persona(String nombre, String apellidos, String dni, Date fecha_nacimiento, String calle) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;

		if (extracted(dni)
		) {
			this.dni = dni;

		} else {
			throw new IllegalArgumentException("El DNI es incorrecto");
		}

		this.fecha_nacimiento = fecha_nacimiento;
		this.calle = calle;

	}

	private boolean extracted(String dni) {
		return Arrays.binarySearch(INVALIDOS, dni) < 0 // (1)
				&& REGEXP.matcher(dni).matches() // (2)
				&& dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23) // (3)
;
	}

//M�todo que realiza la diferencia entre la fecha actual y la fecha de	nacimiento de la persona para obtener su edad

	public Integer obtenerEdad() {
		int FechaNacimientoAnyo = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
		return FechaNacimientoAnyo
				- fecha_nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	// Dos personas son iguales si tienen el mismo DNI
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	// M�todo que muestra la informaci�n de una persona
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", fecha_nacimiento="
				+ fecha_nacimiento + ", calle=" + calle + "]";
	}

	public static String getDigitoControl() {
		return DIGITO_CONTROL;
	}

}

