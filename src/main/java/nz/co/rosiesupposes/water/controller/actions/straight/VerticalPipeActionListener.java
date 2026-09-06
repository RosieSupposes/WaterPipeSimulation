package nz.co.rosiesupposes.water.controller.actions.straight;

import nz.co.rosiesupposes.water.controller.actions.PipeActionListener;
import nz.co.rosiesupposes.water.model.orientations.StraightOrientation;
import nz.co.rosiesupposes.water.model.pipes.Pipe;
import nz.co.rosiesupposes.water.model.pipes.StraightPipe;

import javax.swing.KeyStroke;

public class VerticalPipeActionListener extends PipeActionListener {

    private static StraightPipe pipe;

    @Override
    public KeyStroke getKey() {
        return KeyStroke.getKeyStroke('v');
    }

    public Pipe getPipeTemplate() {
        if (pipe == null)
            pipe = new StraightPipe(StraightOrientation.Vertical);
        return pipe;
    }
}
