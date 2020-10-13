package controller;

public class Point {

    private int x;
    private int y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(Point p){
        this.x = p.getX();
        this.y = p.getY();
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
    public void add (Point p){
        this.x = this.x + p.getX();
        this.y = this.y + p.getY();
    }
    public void subtract(Point p){
        this.x = this.x - p.getX();
        this.y = this.y - p.getY();
    }
}
