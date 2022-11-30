package datos;

import modelos.Jugador;
import modelos.Pais;

import java.io.*;
import java.util.ArrayList;

public class JugadoresDao {

    public static ArrayList<Jugador> leerArchivoJugadores(String direccionArchivo) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        String textoArchivo = "";

        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(";");
                jugadores.add(new Jugador(data[0], data[1], data[2], direccionArchivo));
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible");
        }
        return jugadores;
    }

    public static boolean registrarDatos(Object objeto, String direccionArchivo) {
        boolean lineaVacia=false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia=true;
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);

            if(!lineaVacia){
                bw.newLine();
            }
            bw.write(objeto.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar datos de estudiante");
            return false;
        }
    }
}