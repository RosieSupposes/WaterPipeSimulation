package nz.co.rosiesupposes.water.controller.actions;

import nz.co.rosiesupposes.water.controller.SimulationState;
import nz.co.rosiesupposes.water.model.pipes.Pipe;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;

public abstract class PipeActionListener extends ToolActionListener {

    @Override
    public Color getSelectedColour() {
        return new Color(125, 225, 100);
    }

    public abstract Pipe getPipeTemplate();

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        SimulationState.currentPipe = this.getPipeTemplate();
    }

    @Override
    public String getKeyAlias() {
        return ("" + getKey().getKeyChar()).toUpperCase();
    }

    @Override
    public ImageIcon getImage() {
        return getPipeTemplate().getImage();
    }
}
