package modelos;

import java.util.ArrayList;

import excepciones.AccesoADatosInterrumpidoException;

import javax.swing.*;

public class Seleccion {
	private String nombre;
	private String rankingFIFA;
	private String rutaBandera;
	private ArrayList<Jugador> jugadores;

	public Seleccion(){
		this.jugadores = new ArrayList<>();
	}

	public Seleccion(String nombre, String rankingFIFA, String rutaBandera) {
		this.nombre = nombre;
		this.rankingFIFA = rankingFIFA;
		this.rutaBandera = rutaBandera;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRankingFIFA() {
		return rankingFIFA;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public ImageIcon obtenerIcono(){
		String ruta = "src/img/" + rutaBandera;
		return new ImageIcon(String.valueOf(new ImageIcon(ruta)));
	}

	public void setRutaBandera(String rutaBandera) {
		this.rutaBandera = rutaBandera;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

}