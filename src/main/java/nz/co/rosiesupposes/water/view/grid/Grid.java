package nz.co.rosiesupposes.water.view.grid;

import nz.co.rosiesupposes.water.controller.mouse.CellMouseListener;
import nz.co.rosiesupposes.water.view.Size;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.*;

public class Grid extends JPanel {
    public static final int NUM_X_CELLS = 24;
    public static final int NUM_Y_CELLS = 24;

    public final Cell[][] cells = new Cell[NUM_X_CELLS][NUM_Y_CELLS];

    public Grid(int xPos, int yPos, CellMouseListener cellMouseListener) {
        setLayout(null);
        setBackground(Color.darkGray);
        setBounds(xPos, yPos, Size.GRID_WIDTH, Size.GRID_HEIGHT);

        createCells(cellMouseListener);
        addLinksBetweenNeighbours();
    }

    private void createCells(CellMouseListener cellMouseListener) {
        for (int x = 0; x < NUM_X_CELLS; x++) {
            for (int y = 0; y < NUM_Y_CELLS; y++) {
                Cell c = new Cell(cellMouseListener, x, y, this);
                cells[x][y] = c;
                add(c);
            }
        }
    }

    private void addLinksBetweenNeighbours() {
        for (int x = 0; x < NUM_X_CELLS; x++) {
            for (int y = 0; y < NUM_Y_CELLS; y++) {
                Cell c = cells[x][y];
                if (x > 0)
                    c.addLeftNeighbour(cells[x - 1][y]);

                if (x < NUM_X_CELLS - 1)
                    c.addRightNeighbour(cells[x + 1][y]);

                if (y > 0)
                    c.addTopNeighbour(cells[x][y - 1]);

                if (y < NUM_Y_CELLS - 1)
                    c.addBottomNeighbour(cells[x][y + 1]);
            }
        }
    }

    public void recalculate() {
        drainAllCells();

        for (Cell c : cells()) {
            if (checkForFlooding(c, new HashSet<>()))
                c.flood();
        }

        cells().forEach(Cell::updateCell);
    }

    private boolean checkForFlooding(Cell cell, Set<Cell> visited) {
        if (cell.isFlooded())
            return true;

        if (!visited.contains(cell)) {
            visited.add(cell);
            for (Cell neighbour : cell.neighbours()) {
                if (checkForFlooding(neighbour, visited)) {
                    cell.flood();
                    return true;
                }
            }
        }
        return false;
    }

    private void drainAllCells() {
        for (Cell c : cells()) {
            c.drain();
        }
    }

    private Iterable<? extends Cell> cells() {
        return Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .toList();
    }
}
