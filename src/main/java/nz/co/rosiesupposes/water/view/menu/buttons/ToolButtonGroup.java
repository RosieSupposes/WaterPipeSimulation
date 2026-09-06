package nz.co.rosiesupposes.water.view.menu.buttons;

import nz.co.rosiesupposes.water.view.Size;

import javax.swing.JPanel;
import java.awt.*;

public abstract class ToolButtonGroup extends JPanel {
    private final String title;

    protected Dimension internalButtonSize;

    public ToolButtonGroup(int xColumn, int yColumn, String title) {
        this.title = title;

        setLayout(null);
        setBounds(
                xColumn * Size.BUTTON_GROUP_DIM,
                yColumn * Size.BUTTON_GROUP_DIM,
                Size.BUTTON_GROUP_DIM,
                Size.BUTTON_GROUP_DIM
        );
    }

    public int calculateWidth(int row) {
        return Size.BUTTON_PADDING + (row * (this.internalButtonSize.width + Size.BUTTON_MARGIN));
    }

    public int calculateHeight(int column) {
        return Size.BUTTON_PADDING + (column * (this.internalButtonSize.height + Size.BUTTON_MARGIN));
    }

    public void paint(Graphics g){
        super.paint(g);

        int fontSize = 20;
        Font font = new Font(Font.MONOSPACED, Font.BOLD, fontSize);
        g.setFont(font);
//        AttributedCharacterIterator iterator = ;
//        g.drawString(title, 5, fontSize);
    }
}
