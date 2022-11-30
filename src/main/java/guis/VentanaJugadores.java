package guis;

import datos.JugadoresDao;
import modelos.Jugador;
import modelos.Seleccion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJugadores extends Ventana implements ActionListener {
    private Seleccion seleccion;
    private String rutaJugadores;
    private JButton volver;
    private JButton verInfo;
    private JButton guardarCambios;
    private JComboBox nombresJugadores;
    private JTextField nombre;
    private JTextField posicion;
    private JLabel numero;
    private JLabel pais;

    public VentanaJugadores(Seleccion seleccion) {
        this.seleccion = seleccion;
        this.rutaJugadores = seleccion.getRutaEquipo();
        this.setTitle("Buscador Jugadores");
        cargarJugadores();
        crearEtiquetas();
        crearBotones();
        crearComboBox();
        mostrarDatosEstudiante();
        this.setVisible(true);
    }

    private void cargarJugadores(){
        seleccion.setJugadores(JugadoresDao.leerArchivoJugadores(rutaJugadores));
    }

    private void crearComboBox() {
        nombresJugadores = this.generarComboBoxJugadores(seleccion.getJugadores(), 20, 70, 200, 20);
    }

    private void rellenarComboBox(){
        nombresJugadores.removeAllItems();
        for (Jugador jugador: seleccion.getJugadores()) {
            nombresJugadores.addItem(jugador.getNombre());
        }
    }

    private void crearBotones() {
        verInfo = this.generarBoton("Ver información", 20, 300, 150, 30);
        verInfo.addActionListener(this);
        volver = this.generarBoton("Volver", 200, 300, 150, 30);
        volver.addActionListener(this);
        guardarCambios = this.generarBoton("Guardar Cambios", 380, 300, 150, 30);
        guardarCambios.addActionListener(this);
    }

    private void crearEtiquetas() {
        this.generarEtiqueta("Nombre: ", 20, 100, 80, 20);
        this.generarEtiqueta("Posición: ", 20, 200, 80, 20);
        this.generarEtiqueta("N°: ", 20, 150, 80, 20);
        this.generarEtiqueta("Selección: ", 20, 250, 80, 20);
        nombre = this.generarCampoDeTexto(100, 100, 300, 20);
        posicion = this.generarCampoDeTexto(100, 150, 300, 20);
        numero = this.generarEtiqueta("", 100, 200, 300, 20);
        pais = this.generarEtiqueta("", 100, 250, 300, 20);
    }

    public void mostrarDatosEstudiante() {
        Jugador jugador = seleccion.buscarJugadorPorNombre(nombresJugadores.getSelectedItem().toString());
        nombre.setText(jugador.getNombre());
        numero.setText(jugador.getNumero());
        posicion.setText(jugador.getPosicion());
        pais.setText(seleccion.getNombre());
    }

    private void editarJugador(){
        String campoNombre = nombre.getText();
        String campoPosicion = posicion.getText();
        if(camposVacios() || !poscionFormatoCorrecto(campoPosicion) || !agregarGK(campoPosicion)){
            return;
        }
        Jugador jugador1 = seleccion.buscarJugadorPorNombre(nombresJugadores.getSelectedItem().toString());
        Jugador jugador2 = new Jugador(jugador1.getNumero(), campoNombre, campoPosicion, jugador1.getRutaBandera());
        seleccion.reemplazarJugador(jugador1, jugador2);
        JugadoresDao.registrarDatos(seleccion.getJugadores(), seleccion.getRutaEquipo());
    }

    public boolean agregarGK(String campoPosicion){
        return !seleccion.hayTresGK() || !campoPosicion.equals("GK");
    }

    public boolean camposVacios() {
        return nombre.getText().equals("") || posicion.getText().equals("");
    }

    public boolean poscionFormatoCorrecto(String posicion){
        return posicion.equals("GK") || posicion.equals("MF") || posicion.equals("FW") || posicion.equals("DF");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volver) {
            new VentanaSelecciones();
            this.dispose();
        }

        if (e.getSource() == verInfo) {
            try {
                mostrarDatosEstudiante();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == guardarCambios) {
            editarJugador();
            rellenarComboBox();
            mostrarDatosEstudiante();
        }
    }
}