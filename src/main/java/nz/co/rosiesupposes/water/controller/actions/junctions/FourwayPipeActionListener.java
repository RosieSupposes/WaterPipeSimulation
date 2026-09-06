package nz.co.rosiesupposes.water.controller.actions.junctions;

import nz.co.rosiesupposes.water.controller.actions.PipeActionListener;
import nz.co.rosiesupposes.water.model.pipes.FourwayPipe;
import nz.co.rosiesupposes.water.model.pipes.Pipe;

import javax.swing.KeyStroke;

public class FourwayPipeActionListener extends PipeActionListener {

    private static FourwayPipe pipe;

    @Override
    public KeyStroke getKey() {
        return KeyStroke.getKeyStroke('x');
    }

    public Pipe getPipeTemplate() {
        if (pipe == null)
            pipe = new FourwayPipe();
        return pipe;
    }
}
