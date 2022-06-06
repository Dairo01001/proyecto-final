package main;

import javax.swing.JFrame;

public class Ventana extends JFrame {

    private final int ALTO = 600;
    private final int ANCHO = 800;
    
    public Ventana() {
        init();
        initComponents();
    }

    private void init() {
        setTitle("JigSaw");
        setSize(ANCHO, ALTO);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        
        add(new Inicio());
    }
}
