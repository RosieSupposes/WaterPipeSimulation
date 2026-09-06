package nz.co.rosiesupposes.water.controller.actions.junctions;

import nz.co.rosiesupposes.water.controller.actions.PipeActionListener;
import nz.co.rosiesupposes.water.model.orientations.JunctionOrientation;
import nz.co.rosiesupposes.water.model.pipes.Pipe;
import nz.co.rosiesupposes.water.model.pipes.ThreewayPipe;

import javax.swing.KeyStroke;

public class LeftThreewayPipeActionListener extends PipeActionListener {

    private static ThreewayPipe pipe;

    @Override
    public KeyStroke getKey() {
        return KeyStroke.getKeyStroke('8');
    }

    public Pipe getPipeTemplate() {
        if (pipe == null)
            pipe = new ThreewayPipe(JunctionOrientation.WestJunction);
        return pipe;
    }
}
