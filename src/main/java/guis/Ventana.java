package guis;

import modelos.Jugador;
import modelos.Seleccion;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class Ventana extends JFrame {

    public Ventana() {
        this.setLayout(null);
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    protected JTextField generarCampoDeTexto(int x, int y, int ancho, int largo) {
        JTextField campoDeTexto = new JTextField();
        this.add(campoDeTexto);
        campoDeTexto.setBounds(x, y, ancho, largo);
        return campoDeTexto;
    }
    protected JPasswordField generarCampoDeTextoContraseña(int x, int y, int ancho, int largo) {
        JPasswordField campoDeTexto = new JPasswordField();
        campoDeTexto.setBounds(x, y, ancho, largo);
        campoDeTexto.setVisible(true);
        this.add(campoDeTexto);
        return campoDeTexto;
    }

    protected JButton generarBoton(String texto, int x, int y, int ancho, int largo) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, largo);
        this.add(boton);

        return boton;
    }

    protected JButton generarBoton(int x, int y, int ancho, int largo) {
        JButton boton = new JButton();
        boton.setBounds(x, y, ancho, largo);
        this.add(boton);

        return boton;
    }

    protected JLabel generarEtiqueta (String texto, int x, int y, int ancho, int largo, String fuente, int tamaño) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        Font myFont1 = new Font(fuente, Font.BOLD, tamaño);
        etiqueta.setFont(myFont1);
        this.add(etiqueta);
        return etiqueta;
    }

    protected JLabel generarEtiqueta (String texto, int x, int y, int ancho, int largo) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        this.add(etiqueta);
        return etiqueta;
    }

    protected JComboBox generarComboBoxJugadores(List <Jugador> jugadores, int x, int y, int ancho, int largo) {
        JComboBox <String> comboBox = new JComboBox<String>();
        this.add(comboBox);
        comboBox.setBounds(x,y,ancho,largo);

        for (Jugador jugador: jugadores) {
            comboBox.addItem(jugador.getNombre());
        }

        return comboBox;
    }

    protected JComboBox generarComboBoxSeleccion(List <Seleccion> selecciones, int x, int y, int ancho, int largo) {
        JComboBox <String> comboBox = new JComboBox<String>();
        this.add(comboBox);
        comboBox.setBounds(x,y,ancho,largo);

        for (Seleccion seleccion: selecciones) {
            comboBox.addItem(seleccion.getNombre());
        }

        return comboBox;
    }

    protected JCheckBox generarCheckBox(String texto, int x, int y, int ancho, int largo){
        JCheckBox jCheckBox = new JCheckBox(texto);
        jCheckBox.setBounds(x,y,ancho,largo);
        jCheckBox.setBackground(Color.WHITE);
        jCheckBox.setFocusable(false);
        this.add(jCheckBox);
        return jCheckBox;
    }
}

