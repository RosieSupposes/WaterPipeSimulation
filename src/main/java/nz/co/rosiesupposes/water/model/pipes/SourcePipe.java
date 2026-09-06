package nz.co.rosiesupposes.water.model.pipes;

import nz.co.rosiesupposes.water.model.orientations.SingleOrientation;

public class SourcePipe extends Pipe {
    public SourcePipe(SingleOrientation orientation) {
        super(orientation, "");
    }

    @Override
    public boolean isFlooded() {
        return true;
    }
}
