package nz.co.rosiesupposes.water.view.menu.buttons;

import nz.co.rosiesupposes.water.view.Size;

import javax.swing.JPanel;
import java.awt.Color;

public class ToolButtonPanel extends JPanel {

    public ToolButtonPanel(int xPos, int yPos) {
        setLayout(null);
        setBounds(
                xPos,
                yPos,
                Size.BUTTON_GROUP_DIM * 3,
                Size.BUTTON_GROUP_DIM * 3
        );
    }

    public Color getBackground() {
        return Color.pink;
    }
}
