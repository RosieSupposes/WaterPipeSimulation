package nz.co.rosiesupposes.water.view.menu.tools;

import nz.co.rosiesupposes.water.controller.actions.DeleteActionListener;
import nz.co.rosiesupposes.water.controller.actions.QuitActionListener;
import nz.co.rosiesupposes.water.controller.actions.corners.*;
import nz.co.rosiesupposes.water.controller.actions.junctions.*;
import nz.co.rosiesupposes.water.controller.actions.sinks.*;
import nz.co.rosiesupposes.water.controller.actions.sources.*;
import nz.co.rosiesupposes.water.controller.actions.straight.HorizontalPipeActionListener;
import nz.co.rosiesupposes.water.controller.actions.straight.VerticalPipeActionListener;
import nz.co.rosiesupposes.water.view.Size;
import nz.co.rosiesupposes.water.view.menu.bar.*;
import nz.co.rosiesupposes.water.view.menu.buttons.ToolButton;
import nz.co.rosiesupposes.water.view.menu.buttons.ToolButtonPanel;
import nz.co.rosiesupposes.water.view.menu.buttons.groups.*;

import java.awt.Dimension;

public class ActionCreationHelper {
    public static final Dimension SMALL_BUTTON = new Dimension(Size.SMALL_BUTTON_DIM, Size.SMALL_BUTTON_DIM);
    public static final Dimension HALF_BUTTON = new Dimension(Size.LARGE_BUTTON_DIM, Size.SMALL_BUTTON_DIM);
    public static final Dimension LARGE_BUTTON = new Dimension(Size.LARGE_BUTTON_DIM, Size.LARGE_BUTTON_DIM);

    public static void createActions(ToolMenuBar menubar, ToolButtonPanel buttonPanel) {
        createOptions(menubar, buttonPanel);
        createStraight(menubar, buttonPanel);
        createCorner(menubar, buttonPanel);
        createJunctions(menubar, buttonPanel);
        createSinkSources(menubar, buttonPanel);
    }

    private static void createOptions(ToolMenuBar menubar, ToolButtonPanel panel) {
        DeleteActionListener actionListener = new DeleteActionListener();

        ToolMenu menu = new ToolMenu("Options");
        menubar.add(menu);

        menu.add(new ToolMenuItem("Quit", new QuitActionListener()));
        menu.add(new ToolMenuItem("Delete", actionListener));

        SingleButtonGroup group = new SingleButtonGroup(2, 0, "Delete");
        panel.add(group);

        group.addButton(new ToolButton(actionListener, group));
    }

    private static void createStraight(ToolMenuBar menubar, ToolButtonPanel panel) {
        VerticalPipeActionListener vertical = new VerticalPipeActionListener();
        HorizontalPipeActionListener horizontal = new HorizontalPipeActionListener();

        ToolMenu menu = new ToolMenu("Straight Pipes");
        menubar.add(menu);

        menu.add(new ToolMenuItem("Vertical Pipe", vertical));
        menu.add(new ToolMenuItem("Horizontal Pipe", horizontal));

        DualButtonGroup group = new DualButtonGroup(0, 1, "Straight Pipes");
        panel.add(group);

        group.addButtons(new ToolButton(horizontal, group), new ToolButton(vertical, group));
    }

    private static void createCorner(ToolMenuBar menubar, ToolButtonPanel panel) {
        TopLeftCornerPipeActionListener topLeft = new TopLeftCornerPipeActionListener();
        TopRightCornerPipeActionListener topRight = new TopRightCornerPipeActionListener();
        BottomLeftCornerPipeActionListener bottomLeft = new BottomLeftCornerPipeActionListener();
        BottomRightCornerPipeActionListener bottomRight = new BottomRightCornerPipeActionListener();

        ToolMenu menu = new ToolMenu("Corner Pipes");
        menubar.add(menu);

        menu.add(new ToolMenuItem("Top Left Corner", topLeft));
        menu.add(new ToolMenuItem("Top Right Corner", topRight));
        menu.add(new ToolMenuItem("Bottom Left Corner", bottomLeft));
        menu.add(new ToolMenuItem("Bottom Right Corner", bottomRight));

        QuadButtonGroup group = new QuadButtonGroup(1, 1, "Corner Pipes");
        panel.add(group);

        group.addButtons(
                new ToolButton(topLeft, group),
                new ToolButton(topRight, group),
                new ToolButton(bottomLeft, group),
                new ToolButton(bottomRight, group)
        );
    }


    private static void createJunctions(ToolMenuBar menubar, ToolButtonPanel panel) {
        TopThreewayPipeActionListener top = new TopThreewayPipeActionListener();
        RightThreewayPipeActionListener right = new RightThreewayPipeActionListener();
        LeftThreewayPipeActionListener left = new LeftThreewayPipeActionListener();
        BottomThreewayPipeActionListener bottom = new BottomThreewayPipeActionListener();
        FourwayPipeActionListener four = new FourwayPipeActionListener();

        ToolMenu menu = new ToolMenu("Junctions");
        menubar.add(menu);

        menu.add(new ToolMenuItem("Top Junction", top));
        menu.add(new ToolMenuItem("Right Junction", right));
        menu.add(new ToolMenuItem("Left Junction", left));
        menu.add(new ToolMenuItem("Bottom Junction", bottom));
        menu.add(new ToolMenuItem("Fourway Junction", four));

        QuadButtonGroup threewayJunctions = new QuadButtonGroup(0, 2, "Threeway Junctions");
        panel.add(threewayJunctions);

        threewayJunctions.addButtons(
                new ToolButton(top, threewayJunctions),
                new ToolButton(right, threewayJunctions),
                new ToolButton(left, threewayJunctions),
                new ToolButton(bottom, threewayJunctions)
        );

        SingleButtonGroup fourwayJunctions = new SingleButtonGroup(1, 2, "Fourway Junctions");
        panel.add(fourwayJunctions);

        fourwayJunctions.addButton(new ToolButton(four, fourwayJunctions));
    }


    private static void createSinkSources(ToolMenuBar menubar, ToolButtonPanel panel) {
        TopSinkPipeActionListener topSink = new TopSinkPipeActionListener();
        RightSinkPipeActionListener rightSink = new RightSinkPipeActionListener();
        LeftSinkPipeActionListener leftSink = new LeftSinkPipeActionListener();
        BottomSinkPipeActionListener bottomSink = new BottomSinkPipeActionListener();

        TopSourcePipeActionListener topSource = new TopSourcePipeActionListener();
        RightSourcePipeActionListener rightSource = new RightSourcePipeActionListener();
        LeftSourcePipeActionListener leftSource = new LeftSourcePipeActionListener();
        BottomSourcePipeActionListener bottomSource = new BottomSourcePipeActionListener();

        ToolMenu menu = new ToolMenu("Sinks and Sources");
        menubar.add(menu);

        menu.add(new ToolMenuItem("Top Sink", topSink));
        menu.add(new ToolMenuItem("Right Sink", rightSink));
        menu.add(new ToolMenuItem("Left Sink", leftSink));
        menu.add(new ToolMenuItem("Bottom Sink", bottomSink));

        menu.add(new ToolMenuItem("Top Source", topSource));
        menu.add(new ToolMenuItem("Right Source", rightSource));
        menu.add(new ToolMenuItem("Left Source", leftSource));
        menu.add(new ToolMenuItem("Bottom Source", bottomSource));

        QuadButtonGroup sinks = new QuadButtonGroup(2, 1, "Sinks");
        panel.add(sinks);

        sinks.addButtons(
                new ToolButton(topSink, sinks),
                new ToolButton(rightSink, sinks),
                new ToolButton(leftSink, sinks),
                new ToolButton(bottomSink, sinks)
        );

        QuadButtonGroup sources = new QuadButtonGroup(2, 2, "Sources");
        panel.add(sources);

        sources.addButtons(
                new ToolButton(topSource, sources),
                new ToolButton(rightSource, sources),
                new ToolButton(leftSource, sources),
                new ToolButton(bottomSource, sources)
        );
    }
}
