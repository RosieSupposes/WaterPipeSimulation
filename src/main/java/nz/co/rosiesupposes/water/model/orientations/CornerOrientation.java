package nz.co.rosiesupposes.water.model.orientations;

public enum CornerOrientation implements Orientation {

    TopLeft(true, false, true, false),

    TopRight(true, false, false, true),

    BottomLeft(false, true, true, false),

    BottomRight(false, true, false, true);
    private final boolean top;
    private final boolean bottom;
    private final boolean left;
    private final boolean right;

    CornerOrientation(boolean top, boolean bottom, boolean left, boolean right) {
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
