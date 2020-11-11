package model;

import model.persistence.ApplicationState;
import model.interfaces.*;
import model.shapes.ShapeGroup;
import model.shapes.ShapeList;
import view.interfaces.PaintCanvasBase;
import java.awt.Graphics2D;

import calcs.Actual;
import calcs.Outline;
import calcs.TriangleVertices;

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
        int i = 0;
        for(IShape shape : shapeList){
            System.out.println(i);
            i++;
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
                paintEll(shape, false);
                break;
            case RECTANGLE:
                paintRect(shape, false);
                break;
            case TRIANGLE:
                paintTri(shape, false);
                break;
            case GROUP:
                groupOutline(shape);
                paintGroup((ShapeGroup)shape);
                break;
        }
    }

    private void paintGroup(IShapeList l){
        for(IShape shape:l){
            switch(shape.getShapeType()){
                case ELLIPSE:
                    paintEll(shape, true);
                    break;
                case RECTANGLE:
                    paintRect(shape, true);
                    break;
                case TRIANGLE:
                    paintTri(shape, true);
                    break;
                case GROUP:
                    paintGroup((ShapeGroup)shape);
                    break;
            }
        }
    }

    private void groupOutline(IShape shape){
        if(appState.getSelected().containsShape(shape)){
            Point startPoint = shape.getStartPoint();
            Point endPoint = shape.getEndPoint();
            int x1 = startPoint.getX();
            int y1 = startPoint.getY();
            int x2 = endPoint.getX();
            int y2 = endPoint.getY();
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2d.setStroke(stroke);
            graphics2d.setColor(Color.BLACK);
            graphics2d.drawRect(Math.min(x1,x2)-5,Math.min(y1,y2)-5, Math.abs(x1-x2)+10,Math.abs(y1-y2)+10);
        }
    }

    private void paintRect(IShape shape, boolean group){
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
        if(appState.getSelected().containsShape(shape) && !group){
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2d.setStroke(stroke);
            graphics2d.setColor(Color.BLACK);
            graphics2d.drawRect(Math.min(x1,x2)-5,Math.min(y1,y2)-5, Math.abs(x1-x2)+10,Math.abs(y1-y2)+10);
        }
    }

    private void paintTri(IShape shape, boolean group){
        TriangleVertices triVerCal = new TriangleVertices();
        Point startPoint = shape.getStartPoint();
        Point endPoint = shape.getEndPoint();
        triVerCal.setStrategy(new Actual());
        int [] xPoints = triVerCal.getXVertices(startPoint, endPoint);
        int [] yPoints = triVerCal.getYVertices(startPoint, endPoint);
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
        triVerCal.setStrategy(new Outline());
        int [] nxPoints = triVerCal.getXVertices(startPoint, endPoint);
        int [] nyPoints = triVerCal.getYVertices(startPoint, endPoint);
        if(appState.getSelected().containsShape(shape) && !group){
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2d.setStroke(stroke);
            graphics2d.setColor(Color.BLACK);
            graphics2d.drawPolygon(nxPoints, nyPoints, 3);
        }
    }
    private void paintEll(IShape shape, boolean group){
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
        if(appState.getSelected().containsShape(shape) && !group){
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2d.setStroke(stroke);
            graphics2d.setColor(Color.BLACK);
            graphics2d.drawOval(Math.min(x1,x2)-5,Math.min(y1,y2)-5,Math.abs(x1-x2)+10,Math.abs(y1-y2)+10);
        }
    }
}
