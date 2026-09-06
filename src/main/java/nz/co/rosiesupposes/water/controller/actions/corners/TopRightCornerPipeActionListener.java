package nz.co.rosiesupposes.water.controller.actions.corners;

import nz.co.rosiesupposes.water.controller.actions.PipeActionListener;
import nz.co.rosiesupposes.water.model.orientations.CornerOrientation;
import nz.co.rosiesupposes.water.model.pipes.CornerPipe;
import nz.co.rosiesupposes.water.model.pipes.Pipe;

import javax.swing.KeyStroke;

public class TopRightCornerPipeActionListener extends PipeActionListener {

    private static CornerPipe pipe;

    @Override
    public KeyStroke getKey() {
        return KeyStroke.getKeyStroke('2');
    }

    public Pipe getPipeTemplate() {
        if (pipe == null)
            pipe = new CornerPipe(CornerOrientation.TopRight);
        return pipe;
    }
}
