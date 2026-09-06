package nz.co.rosiesupposes.water.controller.mouse;

import nz.co.rosiesupposes.water.view.grid.Cell;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellMouseListener implements MouseListener {

    /**
     * mouse listeners, that we aren't using.
     */
    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        Cell cell = (Cell) e.getSource();
        cell.performAction();
    }
}
