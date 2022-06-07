package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import util.Open;

public class Button extends JButton implements ActionListener{
    
    public Button(String text) {
        super(text);
        init();
    }
    
    private void init() {
        setFont(Ventana.FONT);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Open.openDocument(getText() + ".pdf");
    }
}
