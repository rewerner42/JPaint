package model.shapes;

import model.ShapeType;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import controller.Point;

public class ShapeFactory {
    private ShapeFactory(){}
    public static IShape getShape(Point p1,Point p2, ApplicationState appState){
        switch (appState.getActiveShapeType()){
            case ELLIPSE:
                return new Ellipses(p1,p2,appState.getActivePrimaryColor(),appState.getActiveSecondaryColor(),appState.getActiveShapeShadingType());
            case RECTANGLE:
                return new Rectangle(p1,p2,appState.getActivePrimaryColor(),appState.getActiveSecondaryColor(),appState.getActiveShapeShadingType());
            case TRIANGLE:
                return new Triangle(p1, p2,appState.getActivePrimaryColor(),appState.getActiveSecondaryColor(),appState.getActiveShapeShadingType());
            default:
                return null;
        }
    }
}
