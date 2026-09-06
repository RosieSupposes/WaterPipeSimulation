package nz.co.rosiesupposes.water.controller.actions.sources;

import nz.co.rosiesupposes.water.controller.actions.PipeActionListener;
import nz.co.rosiesupposes.water.model.orientations.SingleOrientation;
import nz.co.rosiesupposes.water.model.pipes.Pipe;
import nz.co.rosiesupposes.water.model.pipes.SourcePipe;

import javax.swing.KeyStroke;

public class RightSourcePipeActionListener extends PipeActionListener {

    private static SourcePipe pipe;

    @Override
    public KeyStroke getKey() {
        return KeyStroke.getKeyStroke('l');
    }

    public Pipe getPipeTemplate() {
        if (pipe == null)
            pipe = new SourcePipe(SingleOrientation.Right);
        return pipe;
    }
}
