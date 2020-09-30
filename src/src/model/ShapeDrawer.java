package model;

import model.persistence.ApplicationState;
import model.interfaces.*;
import model.shapes.ShapeList;
import view.interfaces.PaintCanvasBase;
import java.awt.Graphics2D;
import controller.*;

import java.awt.Color;


public class ShapeDrawer {

    private final PaintCanvasBase paintCanvas;
    private final ApplicationState appState;
    private final Graphics2D graphics2d;

    public ShapeDrawer(PaintCanvasBase paintCanvas, ApplicationState appState){
        this.paintCanvas = paintCanvas;
        this.appState = appState;
        this.graphics2d = this.paintCanvas.getGraphics2D();
    }

    public void worker(ShapeList shapeList){
        clearEntireCanvas();
        paintShapesToCanvas(shapeList);
    }

    private void paintShapesToCanvas(ShapeList shapeList){
        for(IShape shape : shapeList){
            paintShape(shape);
        }
    }
    private void clearEntireCanvas(){
        this.graphics2d.setColor(paintCanvas.getBackground());
        this.graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
    }
    private void paintShape(IShape shape){
        Point startPoint = shape.getStartPoint();
        Point endPoint = shape.getEndPoint();

        int x1 = startPoint.getX();
        int y1 = startPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
    }
}
