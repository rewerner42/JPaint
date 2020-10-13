package model.shapes;

import model.interfaces.IShape;
import controller.Point;
import model.ColorConverter;
import model.ShapeType;
import model.ShapeColor;
import model.ShapeShadingType;

import java.awt.*;

public class Ellipses implements IShape{
    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType = ShapeType.ELLIPSE;
    private ShapeColor primaryShapeColor;
    private ShapeColor secondaryShapeColor;
    private ShapeShadingType shapeShadingType;

    public Ellipses(Point p1, Point p2, ShapeColor primaryShapeColor, ShapeColor secondaryShapeColor,ShapeShadingType shapeShadingType){
        this.startPoint = p1;
        this.endPoint = p2;
        this.primaryShapeColor = primaryShapeColor;
        this.secondaryShapeColor = secondaryShapeColor;
        this.shapeShadingType = shapeShadingType;
    }
    

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }
    
    @Override
    public ShapeType getShapeType(){
        return shapeType;
    }
    @Override
    public Color getPrimaryShapeColor(){
        return ColorConverter.convertColor(this.primaryShapeColor);
    }
    @Override
    public Color getSecondaryShapeColor(){
        return ColorConverter.convertColor(this.secondaryShapeColor);
    }
    @Override
    public ShapeShadingType getShapeShadingType(){
        return this.shapeShadingType;
    }
    @Override
    public void moveShape(Point vector){
        this.startPoint.add(vector);
        this.endPoint.add(vector);
    }

}
