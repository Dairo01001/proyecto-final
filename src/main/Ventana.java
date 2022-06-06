package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {

    private final int ALTO = 600;
    private final int ANCHO = 800;
    
     private JButton repasar, jugar, puntajes;
    
    public Ventana() {
        init();
        initComponents();
    }

    private void init() {
        setTitle("JigSaw");
        setSize(ANCHO, ALTO);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        JPanel butons = new JPanel();
        butons.setLayout(new BoxLayout(butons, BoxLayout.Y_AXIS));
        
        // init Buttons
        jugar = new JButton("JUGAR");
        repasar = new JButton("REPASAR");
        puntajes = new JButton("PUNTAJES");
        
        butons.add(jugar);
        butons.add(repasar);
        butons.add(puntajes);
        
        add(butons, BorderLayout.WEST);
        add(new Jugar(), BorderLayout.CENTER);
    }
}
