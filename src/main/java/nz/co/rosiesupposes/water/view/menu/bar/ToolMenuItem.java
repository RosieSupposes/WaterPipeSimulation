package nz.co.rosiesupposes.water.view.menu.bar;

import nz.co.rosiesupposes.water.controller.actions.ToolActionListener;

import javax.swing.JMenuItem;

public class ToolMenuItem extends JMenuItem {

    public ToolMenuItem(String title, ToolActionListener actionListener) {
        super(title);
        this.setAccelerator(actionListener.getKey());
        this.addActionListener(actionListener);
    }
}
