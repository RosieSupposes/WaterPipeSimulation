package nz.co.rosiesupposes.water.model.orientations;

public enum JunctionOrientation implements Orientation {
    /**
     * AKA Top Junction
     */
    NorthJunction(true, false, true, true),

    /**
     * AKA Bottom Junction
     */
    SouthJunction(false, true, true, true),

    /**
     * AKA Right Junction
     */
    EastJunction(true, true, false, true),

    /**
     * AKA Left Junction
     */
    WestJunction(true, true, true, false),

    All(true, true, true, true);

    private final boolean top;
    private final boolean bottom;
    private final boolean left;
    private final boolean right;

    JunctionOrientation(boolean top, boolean bottom, boolean left, boolean right) {
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
