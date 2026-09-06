package nz.co.rosiesupposes.water.controller.actions;

import nz.co.rosiesupposes.water.controller.SimulationState;
import nz.co.rosiesupposes.water.view.menu.buttons.ToolButton;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ToolActionListener implements ActionListener {
    public ToolButton button;

    public abstract KeyStroke getKey();

    public abstract String getKeyAlias();

    public abstract ImageIcon getImage();

    public abstract Color getSelectedColour();

    public void addButton(ToolButton toolButton) {
        this.button = toolButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);

        ToolButton.deselectAll();
        SimulationState.doDelete = false;
        SimulationState.currentPipe = null;
        button.select();
    }
}
