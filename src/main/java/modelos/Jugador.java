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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public ImageIcon obtenerIcono(){
		String ruta = "src/img/" + rutaBandera;
		return new ImageIcon(String.valueOf(new ImageIcon(ruta)));
	}
}