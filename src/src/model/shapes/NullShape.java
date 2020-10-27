package model.shapes;

import java.awt.Color;

import controller.Point;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;

public class NullShape implements IShape {

    @Override
    public Point getEndPoint() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Point getStartPoint() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ShapeType getShapeType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Color getPrimaryShapeColor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Color getSecondaryShapeColor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ShapeShadingType getShapeShadingType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void moveShape(Point vector) {
        // TODO Auto-generated method stub

    }
    
}
