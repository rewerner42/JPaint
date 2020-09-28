package controller;

public class Point {

    private int x;
    private int y;

    public Point(){
        
    }

    public Point(int xPoint, int yPoint){
        this.x = xPoint;
        this.y = yPoint;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int newX){
        this.x = newX;
    }
    public void setY(int newY){
        this.y = newY;
    }
}
