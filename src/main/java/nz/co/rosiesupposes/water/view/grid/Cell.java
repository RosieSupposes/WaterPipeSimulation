package nz.co.rosiesupposes.water.view.grid;

import nz.co.rosiesupposes.water.controller.SimulationState;
import nz.co.rosiesupposes.water.controller.mouse.CellMouseListener;
import nz.co.rosiesupposes.water.model.CellState;
import nz.co.rosiesupposes.water.model.pipes.Pipe;
import nz.co.rosiesupposes.water.view.Size;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.util.function.Function;

public class Cell extends JPanel {
    private final Grid grid;
    private final int cellY;
    private final int cellX;
    private CellState currentState = new CellState(false, false);
    private Pipe pipe;

    private final EnumMap<Direction, Cell> neighbours = new EnumMap<>(Direction.class);

    public Cell(CellMouseListener cellMouseListener, int x, int y, Grid grid) {
        this.cellX = x;
        this.cellY = y;
        this.addMouseListener(cellMouseListener);
        setBounds(x * Size.CELL_DIMENSION, y * Size.CELL_DIMENSION, Size.CELL_DIMENSION, Size.CELL_DIMENSION);

        setBackground(Color.getHSBColor((float) Math.random(), 0.1f, 1f));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.grid = grid;
    }

    private int getCellX() {
        return cellX;
    }

    private int getCellY() {
        return cellY;
    }

    public void performAction() {
        System.out.println("Cell: " + this.getCellX() + "," + this.getCellY());

        if (pipe == null) {
            if (SimulationState.currentPipe != null) {
                this.pipe = SimulationState.currentPipe.create();
            }
        } else if (SimulationState.doDelete) {
            this.pipe = null;
        }

        grid.recalculate();
        updateCell();
    }

    void updateCell() {
        CellState newState = checkCurrentState();
        if (currentState.hasStateChanged(newState)) {
            currentState = newState;
            this.repaint();
        }
    }

    private CellState checkCurrentState() {
        boolean hasPipe = pipe != null;
        boolean hasWater = false;
        if (hasPipe) {
            hasWater = pipe.isFlooded();
        }
        return new CellState(hasWater, hasPipe);
    }

    public void addLeftNeighbour(Cell cell) {
        neighbours.put(Direction.Left, cell);
    }

    public void addRightNeighbour(Cell cell) {
        neighbours.put(Direction.Right, cell);
    }

    public void addTopNeighbour(Cell cell) {
        neighbours.put(Direction.Top, cell);
    }

    public void addBottomNeighbour(Cell cell) {
        neighbours.put(Direction.Bottom, cell);
    }

    public List<Cell> neighbours() {
        List<Cell> cells = new ArrayList<>();
        checkConnectionToNeighbour(cells, connectsDown(), Cell::connectsUp, neighbours.get(Direction.Bottom));
        checkConnectionToNeighbour(cells, connectsUp(), Cell::connectsDown, neighbours.get(Direction.Top));
        checkConnectionToNeighbour(cells, connectsLeft(), Cell::connectsRight, neighbours.get(Direction.Left));
        checkConnectionToNeighbour(cells, connectsRight(), Cell::connectsLeft, neighbours.get(Direction.Right));
        return cells;
    }

    private void checkConnectionToNeighbour(
            List<Cell> cells,
            boolean connects,
            Function<Cell, Boolean> checkReverseConnection,
            Cell cell
    ) {
        if (connects && cell != null && checkReverseConnection.apply(cell))
            cells.add(cell);
    }

    private boolean connectsUp() {
        if (pipe == null)
            return false;
        return pipe.connectsUp();
    }

    private boolean connectsDown() {
        if (pipe == null)
            return false;
        return pipe.connectsDown();
    }

    private boolean connectsRight() {
        if (pipe == null)
            return false;
        return pipe.connectsRight();
    }

    private boolean connectsLeft() {
        if (pipe == null)
            return false;
        return pipe.connectsLeft();
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (pipe != null) {
            ImageIcon icon = pipe.getImage();
            g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
        }
    }

    public void drain() {
        if (pipe != null)
            pipe.drain();
    }

    public void flood() {
        if (pipe != null)
            pipe.flood();
        updateCell();
    }

    public boolean isFlooded() {
        return pipe != null && pipe.isFlooded();
    }
}
