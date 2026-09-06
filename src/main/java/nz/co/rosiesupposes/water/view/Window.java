package nz.co.rosiesupposes.water.view;

import nz.co.rosiesupposes.water.controller.mouse.CellMouseListener;
import nz.co.rosiesupposes.water.view.grid.Grid;
import nz.co.rosiesupposes.water.view.menu.bar.ToolMenuBar;
import nz.co.rosiesupposes.water.view.menu.buttons.ToolButtonPanel;
import nz.co.rosiesupposes.water.view.menu.tools.ActionCreationHelper;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class Window extends JFrame {

    public Window() {
        this.setLayout(null);
        this.setTitle("Water Simulator");
        this.getContentPane().setPreferredSize(new Dimension(Size.WINDOW_WIDTH, Size.WINDOW_HEIGHT));

        ToolMenuBar menubar = new ToolMenuBar();
        this.setJMenuBar(menubar);

        ToolButtonPanel buttonPanel = new ToolButtonPanel(Size.BUTTON_PANEl_LEFT, Size.WINDOW_MARGIN);
        Grid grid = new Grid(Size.WINDOW_MARGIN, Size.WINDOW_MARGIN, new CellMouseListener());

        JPanel gridPanel = new JPanel();
        gridPanel.add(grid);

        this.add(grid);
        this.add(buttonPanel);

        ActionCreationHelper.createActions(menubar, buttonPanel);

        this.toFront();
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}