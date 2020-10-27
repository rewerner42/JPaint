package model.shapes;

import model.ColorConverter;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import controller.Point;

public class ShapeFactory {
    private ShapeFactory(){}
    public static IShape createEllipse(Point p1,Point p2, ApplicationState appState){
        return new Ellipses(p1,p2,appState.getActivePrimaryColor(),appState.getActiveSecondaryColor(),appState.getActiveShapeShadingType());
    }
    public static IShape createRectangle(Point p1,Point p2, ApplicationState appState){
        return new Rectangle(p1,p2,appState.getActivePrimaryColor(),appState.getActiveSecondaryColor(),appState.getActiveShapeShadingType());
    }
    public static IShape createTriangle(Point p1,Point p2, ApplicationState appState){
        return new Triangle(p1, p2,appState.getActivePrimaryColor(),appState.getActiveSecondaryColor(),appState.getActiveShapeShadingType());
    }
    public static IShape createShapeFromShape(IShape shape){
        switch(shape.getShapeType()){
            case TRIANGLE:
                return new Triangle(shape.getStartPoint(), shape.getEndPoint(), ColorConverter.convertColor(shape.getPrimaryShapeColor()), ColorConverter.convertColor(shape.getSecondaryShapeColor()), shape.getShapeShadingType());
            case ELLIPSE:
                return new Ellipses(shape.getStartPoint(), shape.getEndPoint(), ColorConverter.convertColor(shape.getPrimaryShapeColor()), ColorConverter.convertColor(shape.getSecondaryShapeColor()), shape.getShapeShadingType());
            case RECTANGLE:
                return new Rectangle(shape.getStartPoint(), shape.getEndPoint(), ColorConverter.convertColor(shape.getPrimaryShapeColor()), ColorConverter.convertColor(shape.getSecondaryShapeColor()), shape.getShapeShadingType());
            default:
                return new NullShape();
        }
    }
}
