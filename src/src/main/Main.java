package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;
import view.gui.MouseHandler;

//import java.awt.*;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseAdapter;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        //MouseHandler mHandler = new MouseHandler();
        //paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));
        controller.setup();
        paintCanvas.addMouseListener(new MouseHandler(appState,paintCanvas));

        // For example purposes only; remove all lines below from your final project.

    }
}
