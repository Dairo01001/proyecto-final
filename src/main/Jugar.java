package main;

import game.Pregunta;
import util.Read;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Jugar extends JPanel implements ActionListener {

    private int correctas;
    private int incorrectas;
    private Pregunta[] infoPreguntas;
    private int index = 0;

    private JButton siguiente;
    private JTextArea pregunta;
    private JLabel showInfo;
    private JRadioButton[] opciones;

    public Jugar() {
        init();
        initComponents();
    }

    private void init() {
        setLayout(new BorderLayout());
        infoPreguntas = Read.getPreguntas(3);
        opciones = new JRadioButton[4];
        correctas = 0;
        incorrectas = 0;
    }

    private void initComponents() {
        siguiente = new JButton("SIGUIENTE");
        siguiente.setFont(Ventana.FONT);
        siguiente.addActionListener(this);

        pregunta = new JTextArea();
        pregunta.setEditable(false);
        pregunta.setFont(Ventana.FONT);
        JPanel containerOpciones = new JPanel();
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < opciones.length; i++) {
            opciones[i] = new JRadioButton();
            opciones[i].setFont(Ventana.FONT);
            group.add(opciones[i]);
            containerOpciones.add(opciones[i]);
        }

        JPanel containerShowInfo = new JPanel();
        containerShowInfo.setLayout(new BoxLayout(containerShowInfo, BoxLayout.PAGE_AXIS));
        showInfo = new JLabel("Correctas: " + correctas + " || Incorrectas: " + incorrectas);
        showInfo.setFont(Ventana.FONT);
        containerShowInfo.add(showInfo);

        add(containerOpciones, BorderLayout.SOUTH);
        add(pregunta, BorderLayout.CENTER);
        add(siguiente, BorderLayout.EAST);
        add(containerShowInfo, BorderLayout.NORTH);

        showPregunta();
    }

    private void showPregunta() {
        pregunta.setText(infoPreguntas[index].getPregunta());
        int i = 0;
        for (; i < infoPreguntas[index].getOpciones().length; i++) {
            opciones[i].setText(infoPreguntas[index].getOpciones()[i]);
            opciones[i].setVisible(true);
        }
        for (; i < opciones.length; i++) {
            opciones[i].setVisible(false);
        }
        index++;
    }

    private String selectOpcion() {
        for (JRadioButton opcione : opciones) {
            if (opcione.isSelected()) {
                return opcione.getText();
            }
        }
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (index < infoPreguntas.length) {
            String selected = selectOpcion();
            if (!"".equals(selected)) {
                if (infoPreguntas[index - 1].respuestaCorrecta(selected)) {
                    correctas++;
                } else {
                    incorrectas++;
                }
                showInfo.setText("Correctas: " + correctas + " || Incorrectas: " + incorrectas);
                showPregunta();
            } else {
                JOptionPane.showMessageDialog(null, "Escoje una opcion!");
            }
        } else {
            String nombre = JOptionPane.showInputDialog(null, "Escribe tu nombre");
            String grupo = JOptionPane.showInputDialog(null, "Ingresa tu grupo");
            JOptionPane.showMessageDialog(null, nombre + " tu puntaje es de " + correctas);
            if (Read.setPuntaje(nombre, grupo, correctas)) {
                JOptionPane.showMessageDialog(null, "Puntaje Guardado!");
            }
        }
    }
}
