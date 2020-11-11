package model.shapes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import controller.Point;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

public class ShapeGroup implements IShape, IShapeList {

    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType = ShapeType.GROUP;
    private Color primaryShapeColor = null;
    private Color secondaryShapeColor = null;
    private ShapeShadingType shapeShadingType = null;

    private ArrayList<IShape> canvasShapes = new ArrayList<>();

    public ShapeGroup() {
        
    }

    @Override
    public Point getEndPoint() {
        return this.endPoint;
    }

    @Override
    public Point getStartPoint() {
        return this.startPoint;
    }

    @Override
    public ShapeType getShapeType() {
        return this.shapeType;
    }

    @Override
    public Color getPrimaryShapeColor() {
        return this.primaryShapeColor;
    }

    @Override
    public Color getSecondaryShapeColor() {
        return this.secondaryShapeColor;
    }

    @Override
    public ShapeShadingType getShapeShadingType() {
        return this.shapeShadingType;
    }

    @Override
    public void moveShape(Point vector) {
        for(IShape shape:canvasShapes){
            shape.moveShape(vector);
        }
        this.startPoint.add(vector);
        this.endPoint.add(vector);
    }

    private void generatePoints(){
        
    }

    private void generatePoints(Point p1, Point p2){
        if(this.startPoint == null || this.endPoint == null){
            this.startPoint = new Point(p1);
            this.endPoint = new Point(p2);
        }
        else
        {
            int xp1 = p1.getX();
            int yp1 = p1.getY();
            int xp2 = p2.getX();
            int yp2 = p2.getY();

            int x1 = this.startPoint.getX();
            int y1 = this.startPoint.getY();

            int x2 = this.endPoint.getX();
            int y2 = this.endPoint.getY();
            this.startPoint.setX(Math.min(Math.min(xp1,xp2),Math.min(x1,x2)));
            this.startPoint.setY(Math.min(Math.min(yp1,yp2),Math.min(y1,y2)));
            this.endPoint.setX(Math.max(Math.max(xp1,xp2),Math.max(x1,x2)));
            this.endPoint.setY(Math.max(Math.max(yp1,yp2),Math.max(y1,y2)));
        }
    }

    @Override
    public Iterator<IShape> iterator() {
        return canvasShapes.iterator();
    }

    @Override
    public void addShape(IShape shape) {
        canvasShapes.add(shape);
        generatePoints(shape.getStartPoint(),shape.getEndPoint());
    }

    @Override
    public void removeShape(IShape shape) {
        canvasShapes.remove(shape);
        //generatePoints(shape.getStartPoint(),shape.getEndPoint());
    }

    @Override
    public boolean containsShape(IShape shape) {
        for(IShape tShape:this.canvasShapes){
            if(shape == tShape){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clearList() {
        canvasShapes = new ArrayList<>();
        generatePoints();
    }
    
}
