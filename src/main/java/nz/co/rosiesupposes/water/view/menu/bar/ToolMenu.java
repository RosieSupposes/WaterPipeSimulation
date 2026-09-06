package nz.co.rosiesupposes.water.view.menu.bar;

import javax.swing.JMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ToolMenu extends JMenu {
    public ToolMenu(String title) {
        super(title);
        this.addFocusListener(new ToolMenuFocusListener(this));
    }
}

class ToolMenuFocusListener implements FocusListener {
    private final Container parent;

    public ToolMenuFocusListener(Component component) {
        this.parent = component.getParent();
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        parent.repaint();
    }
}