package util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Open {
    
    public static void openDocument(String name) {
        try {
            File path = new File(Read.URI + name);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo");
        }
    }
}
