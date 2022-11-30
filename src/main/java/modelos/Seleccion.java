package modelos;

import java.util.ArrayList;
import java.util.List;

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

	public String getRutaEquipo() {
		return "src/equipos/" + rutaBandera.substring(0,3) + ".txt";
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public Jugador buscarJugadorPorNombre(String nombre) {
		for (Jugador jugador: jugadores) {
			if(jugador.getNombre().equals(nombre)) {
				return jugador;
			}
		}
		throw new RuntimeException();
	}
	public void reemplazarJugador(Jugador jugador1, Jugador jugador2){
		ArrayList<Jugador> nuevosJugadores = new ArrayList<>();
		for (Jugador jugador: jugadores) {
			if(jugador == jugador1){
				nuevosJugadores.add(jugador2);
			}else{
				nuevosJugadores.add(jugador);
			}
		}
		jugadores = nuevosJugadores;
	}
}