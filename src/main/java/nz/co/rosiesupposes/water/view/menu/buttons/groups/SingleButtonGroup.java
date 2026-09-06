package nz.co.rosiesupposes.water.view.menu.buttons.groups;

import nz.co.rosiesupposes.water.view.menu.buttons.ToolButton;
import nz.co.rosiesupposes.water.view.menu.buttons.ToolButtonGroup;
import nz.co.rosiesupposes.water.view.menu.tools.ActionCreationHelper;

public class SingleButtonGroup extends ToolButtonGroup {

    public SingleButtonGroup(int xColumn, int yColumn, String title) {
        super(xColumn, yColumn, title);
        this.internalButtonSize = ActionCreationHelper.LARGE_BUTTON;
    }

    public void addButton(ToolButton button) {
        this.add(button);
        button.setVariables(0, 0, internalButtonSize);
    }

}
