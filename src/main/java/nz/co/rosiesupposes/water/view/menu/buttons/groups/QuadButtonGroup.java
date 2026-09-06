package nz.co.rosiesupposes.water.view.menu.buttons.groups;

import nz.co.rosiesupposes.water.view.menu.buttons.ToolButton;
import nz.co.rosiesupposes.water.view.menu.buttons.ToolButtonGroup;
import nz.co.rosiesupposes.water.view.menu.tools.ActionCreationHelper;

public class QuadButtonGroup extends ToolButtonGroup {

    public QuadButtonGroup(int xColumn, int yColumn, String title) {
        super(xColumn, yColumn, title);
        this.internalButtonSize = ActionCreationHelper.SMALL_BUTTON;
    }

    public void addButtons(ToolButton button1, ToolButton button2, ToolButton button3, ToolButton button4) {
        addButton(button1, 0, 0);
        addButton(button2, 1, 0);
        addButton(button3, 0, 1);
        addButton(button4, 1, 1);
    }

    private void addButton(ToolButton button, int row, int column) {
        this.add(button);
        button.setVariables(row, column, internalButtonSize);
    }

}
