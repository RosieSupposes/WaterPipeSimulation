package nz.co.rosiesupposes.water.controller.actions;

import nz.co.rosiesupposes.water.controller.SimulationState;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.net.URL;

public class DeleteActionListener extends ToolActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        SimulationState.doDelete = true;
    }

    public KeyStroke getKey() {
        return KeyStroke.getKeyStroke(getKeyAlias());
    }

    @Override
    public String getKeyAlias() {
        return "DELETE";
    }

    @Override
    public ImageIcon getImage() {
        URL resource = getClass().getResource("/ui/delete-pipe-button.png");
        assert resource != null;
        return new ImageIcon(resource);
    }

    @Override
    public Color getSelectedColour() {
        return new Color(225, 150, 150);
    }
}
