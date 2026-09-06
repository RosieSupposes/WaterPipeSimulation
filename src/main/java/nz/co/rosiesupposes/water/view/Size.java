package nz.co.rosiesupposes.water.view;

import nz.co.rosiesupposes.water.view.grid.Grid;

public class Size {
    public static final int WINDOW_PADDING = 10;
    public static final int WINDOW_MARGIN = 15;

    public static final int BUTTON_MARGIN = 20;
    public static final int BUTTON_PADDING = 15;

    public static final int SMALL_BUTTON_DIM = 75;
    public static final int LARGE_BUTTON_DIM = BUTTON_MARGIN + (SMALL_BUTTON_DIM * 2);
    public static final int BUTTON_GROUP_DIM = LARGE_BUTTON_DIM + (BUTTON_PADDING * 2);

    public static final int CELL_DIMENSION = 25;
    public static final int GRID_WIDTH = Grid.NUM_X_CELLS * CELL_DIMENSION;
    public static final int GRID_HEIGHT = Grid.NUM_Y_CELLS * CELL_DIMENSION;
    public static final int GRID_PANEL_WIDTH = GRID_WIDTH + (WINDOW_PADDING * 2);

    public static final int BUTTON_PANEL_HEIGHT = BUTTON_GROUP_DIM * 3;
    public static final int BUTTON_PANEL_WIDTH = BUTTON_GROUP_DIM * 3;
    public static final int BUTTON_PANEl_LEFT = GRID_WIDTH + (WINDOW_PADDING * 2) + WINDOW_MARGIN;

    public static final int WINDOW_HEIGHT = BUTTON_PANEL_HEIGHT + (2 * WINDOW_MARGIN);
    public static final int WINDOW_WIDTH = (2 * WINDOW_PADDING) + WINDOW_MARGIN + BUTTON_PANEL_WIDTH + GRID_PANEL_WIDTH;

}
