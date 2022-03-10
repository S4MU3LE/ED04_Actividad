package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BolsaEmpleo {

	private List<Persona> listaVacantes;
	private String nombreBolsa;

	public BolsaEmpleo(List<Persona> listaVacantes, String nombreBolsa) {
		this.listaVacantes = new ArrayList<Persona>();
		this.nombreBolsa = nombreBolsa;
	}

	public List<Persona> getListaVacantes() {
		return listaVacantes;
	}

	public void setListaVacantes(List<Persona> listaVacantes) {
		this.listaVacantes = listaVacantes;
	}

	public String getNombreBolsa() {
		return nombreBolsa;
	}

	public void setNombreBolsa(String nombreBolsa) {
		this.nombreBolsa = nombreBolsa;
	}

// Método que añade una persona a la bolsa de trabajo si es mayor de edad y no se encuentra en ninguna otra bolsa de trabajo
	public void anyadirPersona(Persona persona, List<BolsaEmpleo> listaDeBolsas) {

		boolean estaEnBolsa = false;
		if (persona.obtenerEdad() >= 18) {
			estaEnBolsa = extracted(persona, listaDeBolsas, estaEnBolsa);
			if (!estaEnBolsa) {
				this.listaVacantes.add(persona);
			}
		}
	}

	private boolean extracted(Persona persona, List<BolsaEmpleo> listaDeBolsas, boolean estaEnBolsa) {
		for (BolsaEmpleo bolsa : listaDeBolsas) {
			if (bolsa.listaVacantes.contains(persona)) {
				estaEnBolsa = true;
			}
		}
		return estaEnBolsa;
	}

	@Override
	public String toString() {
		return "Bolsa de empleo: " + nombreBolsa + "\n" + Arrays.toString(this.listaVacantes.toArray());
	}

}

