package main;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Preguntar extends JPanel {
    
    private  String pregunta;
    private  String[] opciones;

    public Preguntar(String pregunta, String[] opciones) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        init();
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }
    
    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(new JLabel(pregunta));
        
        ButtonGroup group = new ButtonGroup();
        for (String opcione : opciones) {
            JRadioButton op = new JRadioButton(opcione);
            group.add(op);
            add(op);
        }
    }
}
