package main;

import util.Read;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
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
        String[] colums = {"NOMBRE", "GRUPO", "PUNTAJE"};

        JTable puntajes = new JTable(parseArray(Read.getPuntajes()), colums);
        puntajes.setFont(Ventana.FONT);

        JScrollPane containerTable = new JScrollPane(puntajes);
        containerTable.setFont(new Font("Courier New", Font.BOLD, 18));

        add(containerTable);
    }

    private String[][] parseArray(ArrayList<String[]> arr) {
        String[][] ar = new String[arr.size()][3];
        for (int i = 0; i < arr.size(); i++) {
            ar[i] = arr.get(i);
        }
        return ar;
    }
}
