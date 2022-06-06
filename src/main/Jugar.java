package main;

import game.Pregunta;
import util.Read;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Jugar extends JPanel implements ActionListener {

    private JButton siguiente;
    private Pregunta[] preguntas;
    private Preguntar uiPregunta;
    private int index = 0;

    public Jugar() {
        init();
        initComponents();
    }

    private void init() {
        setLayout(new BorderLayout());
        preguntas = Read.getPreguntas(3);
    }

    private void initComponents() {
        siguiente = new JButton("SIGUIENTE");
        siguiente.addActionListener(this);
        add(siguiente, BorderLayout.SOUTH);
        
        uiPregunta = new Preguntar(preguntas[index].getPregunta(), preguntas[index].getOpciones()); 

        add(uiPregunta, BorderLayout.CENTER);
        index++;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (index < preguntas.length) {
            uiPregunta.setPregunta(preguntas[index].getPregunta());
            uiPregunta.setOpciones(preguntas[index].getOpciones());
            uiPregunta.updateUI();
            index++;
        }
    }
}
