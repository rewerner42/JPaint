package model.interfaces;

import controller.Point;
import model.ShapeShadingType;
import model.ShapeType;
import java.awt.*;

public interface IShape{
    Point getEndPoint();
    Point getStartPoint();
    ShapeType getShapeType();
    Color getPrimaryShapeColor();
    Color getSecondaryShapeColor();
    ShapeShadingType getShapeShadingType();
    void moveShape(Point vector);
}
