package model;

import model.persistence.ApplicationState;
import model.interfaces.*;
import model.shapes.ShapeList;
import view.interfaces.PaintCanvasBase;
import java.awt.Graphics2D;
import java.awt.*;
import controller.Point;



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
        switch(shape.getShapeType()){
            case ELLIPSE:
                paintEll(shape);
                break;
            case RECTANGLE:
                paintRect(shape);
                break;
            case TRIANGLE:
                paintTri(shape);
                break;
        }
    }

    private void paintRect(IShape shape){
        Point startPoint = shape.getStartPoint();
        Point endPoint = shape.getEndPoint();
        int x1 = startPoint.getX();
        int y1 = startPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();
        
        switch (shape.getShapeShadingType()){
            case FILLED_IN:
                graphics2d.setColor(shape.getPrimaryShapeColor());
                graphics2d.fillRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
                break;
            case OUTLINE:
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.getSecondaryShapeColor());
                graphics2d.drawRect(Math.min(x1,x2),Math.min(y1,y2), Math.abs(x1-x2),Math.abs(y1-y2));
                break;
            case OUTLINE_AND_FILLED_IN:
                graphics2d.setColor(shape.getPrimaryShapeColor());
                graphics2d.fillRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.getSecondaryShapeColor());
                graphics2d.drawRect(Math.min(x1,x2),Math.min(y1,y2), Math.abs(x1-x2),Math.abs(y1-y2));
                
                break;
        }
    }

    private void paintTri(IShape shape){
        Point startPoint = shape.getStartPoint();
        Point endPoint = shape.getEndPoint();
        int x1 = startPoint.getX();
        int y1 = startPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();
        int x3,y3;
        if (y1 > y2){ // if upwards movement
            x3 = x2;
            y3 = y1;
        }
        else{ // if downwards movement
            x3 = x1;
            y3 = y2;
        }
        int [] xPoints = {x1,x2,x3};
        int [] yPoints = {y1,y2,y3};
        switch (shape.getShapeShadingType()){
            case FILLED_IN:
                graphics2d.setColor(shape.getPrimaryShapeColor());
                graphics2d.fillPolygon(xPoints, yPoints, 3);
                break;
            case OUTLINE:
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.getSecondaryShapeColor());
                graphics2d.drawPolygon(xPoints, yPoints, 3);
                break;
            case OUTLINE_AND_FILLED_IN:
                graphics2d.setColor(shape.getPrimaryShapeColor());
                graphics2d.fillPolygon(xPoints, yPoints, 3);
                
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.getSecondaryShapeColor());
                graphics2d.drawPolygon(xPoints, yPoints, 3);
                break;
        }
    }
    private void paintEll(IShape shape){
        Point startPoint = shape.getStartPoint();
        Point endPoint = shape.getEndPoint();
        int x1 = startPoint.getX();
        int y1 = startPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();
        switch (shape.getShapeShadingType()){
            case FILLED_IN:
                graphics2d.setColor(shape.getPrimaryShapeColor());
                graphics2d.fillOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
                break;
            case OUTLINE:
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.getSecondaryShapeColor());
                graphics2d.drawOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
                break;
            case OUTLINE_AND_FILLED_IN:
                graphics2d.setColor(shape.getPrimaryShapeColor());
                graphics2d.fillOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.getSecondaryShapeColor());
                graphics2d.drawOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
                break;
        }
    }
}
