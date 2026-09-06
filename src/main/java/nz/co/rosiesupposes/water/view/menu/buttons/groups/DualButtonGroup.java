package nz.co.rosiesupposes.water.view.menu.buttons.groups;

import nz.co.rosiesupposes.water.view.menu.buttons.ToolButton;
import nz.co.rosiesupposes.water.view.menu.buttons.ToolButtonGroup;
import nz.co.rosiesupposes.water.view.menu.tools.ActionCreationHelper;

public class DualButtonGroup extends ToolButtonGroup {


    public DualButtonGroup(int xColumn, int yColumn, String title) {
        super(xColumn, yColumn, title);
        this.internalButtonSize = ActionCreationHelper.HALF_BUTTON;
    }

    public void addButtons(ToolButton button1, ToolButton button2) {
        addButton(button1, 0);
        addButton(button2, 1);
    }

    private void addButton(ToolButton button, int column) {
        this.add(button);
        button.setVariables(0, column, internalButtonSize);
    }
}
