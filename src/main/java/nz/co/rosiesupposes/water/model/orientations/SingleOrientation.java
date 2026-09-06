package nz.co.rosiesupposes.water.model.orientations;

public enum SingleOrientation implements Orientation {

    Top(true, false, false, false),

    Bottom(false, true, false, false),

    Right(false, false, false, true),

    Left(false, false, true, false);
    private final boolean top;
    private final boolean bottom;
    private final boolean left;
    private final boolean right;

    SingleOrientation(boolean top, boolean bottom, boolean left, boolean right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public boolean hasTop() {
        return top;
    }

    public boolean hasBottom() {
        return bottom;
    }

    public boolean hasLeft() {
        return left;
    }

    public boolean hasRight() {
        return right;
    }

}
