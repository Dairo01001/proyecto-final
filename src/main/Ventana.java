package main;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Ventana extends JFrame {
    
    public static final Font FONT = new Font("Courier New", Font.BOLD, 14);

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
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        JTabbedPane container = new JTabbedPane();
        
        container.add("Jugar", new Jugar());
        container.add("Puntajes", new Puntajes());
        container.add("Repasar", new Repasar());
        
        add(container, BorderLayout.CENTER);
    }
}
