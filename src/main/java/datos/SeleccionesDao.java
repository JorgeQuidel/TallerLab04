package datos;

import modelos.Jugador;
import modelos.Seleccion;

import java.io.*;
import java.util.ArrayList;

public class SeleccionesDao {

    public static ArrayList<Seleccion> leerArchivoSelecciones(String direccionArchivo) {
        ArrayList<Seleccion> selecciones = new ArrayList<>();
        String textoArchivo = "";

        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(";");
                selecciones.add(new Seleccion(data[1], data[2], data[3]));
            }
        } catch (IOException e) {
            System.out.println("Documento no disponible");
        }
        return selecciones;
    }

}
