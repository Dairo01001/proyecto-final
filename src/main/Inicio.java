package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends JPanel {

    private JLabel titulo;
    private JButton repasar, jugar, puntajes;
    
    private JPanel contenedorBotones; 
    
    public Inicio() {
        init();
        initComponents();
    }
    
    private void init() {
        setLayout(new BorderLayout());
    }
    
    private void initComponents() {
        titulo = new JLabel("JigSaw");
        
        jugar = new JButton("JUGAR");
        repasar = new JButton("REPASAR");
        puntajes = new JButton("PUNTAJES");
        
        contenedorBotones = new JPanel();
        contenedorBotones.setLayout(new FlowLayout());
        
        contenedorBotones.add(jugar);
        contenedorBotones.add(repasar);
        contenedorBotones.add(puntajes);
        
        
        add(titulo, BorderLayout.NORTH);
        add(contenedorBotones, BorderLayout.CENTER);
    }
}
