package controller;

import controller.Point;

public class Travel {
    private final Point startPoint = new Point();
    private final Point endPoint = new Point();

    public int getStart(){
        int x = startPoint.getX();
        int y = startPoint.getY();
    }

    public int getEnd(){
        int x = endPoint.getX();
        int y = endPoint.getY();
    }
}
