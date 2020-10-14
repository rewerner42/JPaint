package model.shapes;

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
}
