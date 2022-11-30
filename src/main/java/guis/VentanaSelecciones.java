package guis;

import datos.SeleccionesDao;
import modelos.Jugador;
import modelos.Seleccion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class VentanaSelecciones extends Ventana implements ActionListener {
    private JComboBox nombresSelecciones;
    private JLabel seleccionRanking;
    private JLabel iconoSeleccion;
    private JButton verInformacion;
    private JButton verJugadores;
    private JButton salir;

    public VentanaSelecciones() {
        this.setTitle("Selecciones");
        crearEtiquetas();
        crearBotones();
        crearComboBox();
        this.setVisible(true);
    }

    private void crearEtiquetas() {
        this.generarEtiqueta("Ranking FIFA: ", 20, 100, 80, 20);
        seleccionRanking = this.generarEtiqueta("", 100, 100, 80, 20);
        iconoSeleccion = this.generarEtiqueta("",20, 150, 80, 50);
    }

    private void crearBotones() {
        verInformacion = this.generarBoton("Ver Informacion", 20, 300, 150, 30);
        verInformacion.addActionListener(this);
        verJugadores = this.generarBoton("Ver Jugadores", 200, 300, 150, 30);
        verJugadores.addActionListener(this);
        salir = this.generarBoton("Salir", 380, 300, 150, 30);
        salir.addActionListener(this);
    }

    private void crearComboBox() {
        nombresSelecciones = this.generarComboBoxSeleccion(obtenerSelecciones(), 20, 70, 200, 20);
    }

    public void mostrarDatosSeleccion() {
        Seleccion seleccion = obtenerSeleccionActual();
        seleccionRanking.setText(seleccion.getRankingFIFA());
        iconoSeleccion.setIcon(seleccion.obtenerIcono());
    }

    public List<Seleccion> obtenerSelecciones(){
        return SeleccionesDao.leerArchivoSelecciones("src/selecciones/teams.txt");
    }

    public Seleccion obtenerSeleccionActual(){
        return obtenerSelecciones().get(nombresSelecciones.getSelectedIndex());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verInformacion){
            try {
                mostrarDatosSeleccion();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == verJugadores){
            new VentanaJugadores(obtenerSeleccionActual());
            this.dispose();
        }

        if (e.getSource() == salir){
            this.dispose();
        }
    }
}
