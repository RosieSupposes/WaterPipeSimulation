package nz.co.rosiesupposes.water.view.menu.buttons;

import nz.co.rosiesupposes.water.controller.actions.ToolActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ToolButton extends JButton {
    public static final List<ToolButton> allButtons = new ArrayList<>();

    private final String key;
    private final ImageIcon icon;
    private final ToolActionListener listener;
    private final ToolButtonGroup group;
    private boolean isSelected = false;

    public ToolButton(ToolActionListener actionListener, ToolButtonGroup group) {
        this.key = actionListener.getKeyAlias();
        this.icon = actionListener.getImage();
        this.listener = actionListener;
        this.group = group;

        this.addActionListener(actionListener);
        actionListener.addButton(this);

        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        allButtons.add(this);
    }

    public static void deselectAll() {
        for (ToolButton button : allButtons)
            button.deselect();
    }

    public void select() {
        isSelected = true;
    }

    public void deselect() {
        isSelected = false;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (icon != null) {
            int x = 0;
            int buttonWidth = getWidth();
            int buttonHeight = getHeight();

            int imgHeight = buttonHeight;
            int imgWidth = imgHeight; //img is presumed to be square with width and height equal to button height

            if (buttonWidth != buttonHeight) {
                int diff = buttonWidth - imgWidth;
                x = diff / 2;
            }
            g.drawImage(icon.getImage(), x, 0, imgWidth, imgHeight, icon.getImageObserver());

            int fontSize = 15;
            Font font = new Font(Font.MONOSPACED, Font.BOLD, fontSize);
            g.setFont(font);
            g.drawString(key, 5, fontSize);
        }
    }

    @Override
    public Color getBackground() {
        if (isSelected)
            return listener.getSelectedColour();
        else
            return Color.lightGray;
    }

    public void setVariables(int rowIndex, int columnIndex, Dimension size) {
        this.setBounds(
                group.calculateWidth(rowIndex),
                group.calculateHeight(columnIndex),
                size.width,
                size.height
        );
    }
}
