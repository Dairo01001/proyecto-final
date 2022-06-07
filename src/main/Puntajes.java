package main;

import util.Read;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Puntajes extends JPanel {

    public Puntajes() {
        init();
        initComponents();
    }

    private void init() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        String[] colums = {"Nombre", "Grupo", "Puntaje"};
        add(new JScrollPane(new JTable(Read.getPuntajes(), colums)));
    }
}
