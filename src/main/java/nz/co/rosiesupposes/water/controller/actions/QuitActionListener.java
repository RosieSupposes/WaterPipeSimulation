package nz.co.rosiesupposes.water.controller.actions;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class QuitActionListener extends ToolActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(1);
    }

    public KeyStroke getKey() {
        return KeyStroke.getKeyStroke('q');
    }

    @Override
    public String getKeyAlias() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImageIcon getImage() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Color getSelectedColour() {
        throw new UnsupportedOperationException();
    }
}
