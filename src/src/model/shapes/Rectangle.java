package model.shapes;

import model.interfaces.IShape;

import controller.Point;

public class Rectangle implements IShape {
    private Point startPoint;
    private Point endPoint;
    

    public Rectangle(Point p1, Point p2){
        this.startPoint = p1;
        this.endPoint = p2;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

}
