package view.gui;

import controller.Point;
import controller.commands.CreateShapeCommand;
import controller.commands.MoveCommand;
import controller.commands.SelectCommand;
import model.ShapeDrawer;
import model.persistence.*;
import model.shapes.NonArtisticShapeList;
import model.shapes.ShapeList;
import model.interfaces.*;
import model.observers.EventPublisher;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import view.interfaces.PaintCanvasBase;

public class MouseHandler extends MouseAdapter{

    private PaintCanvasBase paintCanvas;
    private ApplicationState applicationState;
    private ShapeDrawer shapeDrawer;
    private IShapeList shapeList;
    private IShapeList selectedShapeList;
    private Point startPoint;
    private Point endPoint;
    private EventPublisher events;

    public MouseHandler(){
        super();
    }

    public MouseHandler(ApplicationState aState, PaintCanvasBase pCanvas){
        super();
        this.applicationState = aState;
        this.paintCanvas = pCanvas;
        this.shapeDrawer = new ShapeDrawer(paintCanvas,applicationState);
        this.shapeList = new ShapeList(shapeDrawer);
        this.selectedShapeList = new NonArtisticShapeList();
        this.applicationState.updateSelectedShapeList(this.selectedShapeList,this.shapeList);
    }

    @Override
    public void mousePressed(MouseEvent e){
        startPoint = new Point(e.getX(),e.getY());
        //System.out.println("click"+" "+e.getX()+" "+e.getY());
    }
    @Override
    public void mouseReleased(MouseEvent e){
        endPoint = new Point(e.getX(),e.getY());
        //Graphics2D graphics2d = paintCanvas.getGraphics2D();
        //graphics2d.setColor(Color.GREEN);
        switch(applicationState.getActiveMouseMode()){
            case MOVE:
                System.out.println("MOVE");
                new MoveCommand(this.startPoint, this.endPoint, this.shapeList, this.selectedShapeList).run();
                break;
            case SELECT:
                new SelectCommand(this.startPoint, this.endPoint, this.shapeList, this.selectedShapeList).run();
                break;
            case DRAW:
                new CreateShapeCommand(this.shapeList,this.startPoint,this.endPoint,this.applicationState).run();
                break;
        }
    }
}
