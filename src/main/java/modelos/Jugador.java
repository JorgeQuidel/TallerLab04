package modelos;

import javax.swing.*;

public class Jugador {
	private String numero;
	private String nombre;
	private String posicion;
	private String rutaBandera;

	public Jugador(String numero, String nombre, String posicion, String rutaBandera) {
		this.numero = numero;
		this.nombre = nombre;
		this.posicion = posicion;
		this.rutaBandera = rutaBandera;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRutaBandera() {
		return rutaBandera;
	}

	public String getNumero() {
		return numero;
	}

	public String getPosicion() {
		return posicion;
	}
}