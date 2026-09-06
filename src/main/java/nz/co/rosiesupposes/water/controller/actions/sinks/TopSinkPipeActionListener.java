package nz.co.rosiesupposes.water.controller.actions.sinks;

import nz.co.rosiesupposes.water.controller.actions.PipeActionListener;
import nz.co.rosiesupposes.water.model.orientations.SingleOrientation;
import nz.co.rosiesupposes.water.model.pipes.Pipe;
import nz.co.rosiesupposes.water.model.pipes.SinkPipe;

import javax.swing.KeyStroke;

public class TopSinkPipeActionListener extends PipeActionListener {

    private static SinkPipe pipe;

    @Override
    public KeyStroke getKey() {
        return KeyStroke.getKeyStroke('w');
    }

    public Pipe getPipeTemplate() {
        if (pipe == null)
            pipe = new SinkPipe(SingleOrientation.Top);
        return pipe;
    }
}
