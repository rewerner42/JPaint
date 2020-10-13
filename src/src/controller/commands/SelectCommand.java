package controller.commands;

import controller.*;
import model.interfaces.*;

public class SelectCommand implements ICommand,IUndoable{
    
    private IShapeList selectedShapeList;
    private IShapeList shapeList;
    private Point selectionBeginning;
    private Point selectionEnding;

    public SelectCommand (Point startPoint, Point endPoint, IShapeList shapeList, IShapeList selectedShapeList){
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.selectionBeginning = startPoint;
        this.selectionEnding = endPoint;
    }
    @Override
    public void run(){
        System.out.println("Now Selecting.");
        addToList();
        CommandHistory.add(this);
    }
    @Override
    public void redo(){
        addToList();
    }
    @Override 
    public void undo(){
        removeFromList();
    }

    private void addToList(){
        selectedShapeList.clearList();
        for (IShape shape:this.shapeList){
            if (contains(shape)){
                System.out.println(shape);
                this.selectedShapeList.addShape(shape);
            }
        }
    }
    private void removeFromList(){
        for (IShape shape:selectedShapeList){
            this.selectedShapeList.removeShape(shape);
        }
    }
    private boolean contains(IShape shape){
        Point sPoint = shape.getStartPoint();
        Point ePoint = shape.getEndPoint();

        int x1 = sPoint.getX();
        int x2 = ePoint.getX();
        int x3 = sPoint.getX();
        int x4 = ePoint.getX();
        int y1 = sPoint.getY();
        int y2 = ePoint.getY();
        int y3 = ePoint.getY();
        int y4 = sPoint.getY();

        int [] x = {x1,x2,x3,x4};
        int [] y = {y1,y2,y3,y4};

        int maxX = Math.max(selectionBeginning.getX(),selectionEnding.getX());
        int minX = Math.min(selectionBeginning.getX(),selectionEnding.getX());
        int minY = Math.min(selectionBeginning.getY(),selectionEnding.getY());
        int maxY = Math.max(selectionBeginning.getY(),selectionEnding.getY());

        for (int i = 0; i<4; i++){
            System.out.println(x[i]+";"+y[i]+";"+maxX+";"+minX+";"+minY+";"+maxY);
            if (isIn(x[i],y[i],maxX, minX, minY, maxY)) {
                return true;
            }
        }
        for(int i = 0; i<4; i++){
            for(int j = i+1; j<4; j++ ){
                if(crosses(x[i],y[i],x[j],y[j],maxX, minX, minY, maxY)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isIn(int x, int y, int maxX , int minX, int minY, int maxY){
        if (x <= maxX && x >= minX && y <= maxY && y >= minY) {
            return true;
        }
        return false;
    }

    private boolean crosses(int x1, int y1, int x2, int y2, int maxX , int minX, int minY, int maxY){
        if((x1 <= maxX && x2 >= minX && y1 >= maxY && y2 <= minY )|| (x1 >= maxX && x2 <= minX && y1 <= maxY && y2 >= minY) 
                || (x2 <= maxX && x1 >= minX && y2 >= maxY && y1 <= minY )|| (x2 >= maxX && x1 <= minX && y2 <= maxY && y1 >= minY ) ){
            return true;
        }
        return false;
    }

}
