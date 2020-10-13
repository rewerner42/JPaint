package controller.commands;

import controller.Point;
import controller.CommandHistory;
import controller.IUndoable;
import model.interfaces.ICommand;
import model.interfaces.*;
import model.shapes.ShapeList;

public class MoveCommand implements ICommand,IUndoable{
    
    private IShapeList selectedShapeList;
    private IShapeList sList;
    private Point movement = new Point();
    private Point backwardsMovement = new Point();

    public MoveCommand(Point startPoint, Point endPoint, IShapeList shapeList, IShapeList selectedShapeList){
        this.sList = shapeList;
        this.selectedShapeList = selectedShapeList;
        movement.add(endPoint);
        movement.subtract(startPoint);
        backwardsMovement.subtract(endPoint);
        backwardsMovement.add(startPoint);
    }

    @Override
    public void run(){
        move();
        CommandHistory.add(this);
    }
    @Override
    public void undo() {
        moveBack();
    }
    @Override
    public void redo(){
        move();
    }

    private void move(){
        for (IShape shape:this.selectedShapeList){
            this.sList.removeShape(shape);
            shape.moveShape(movement);
            this.sList.addShape(shape);
        }
    }
    private void moveBack(){
        for (IShape shape:this.selectedShapeList){
            this.sList.removeShape(shape);
            shape.moveShape(backwardsMovement);
            this.sList.addShape(shape);
        }
    }
}
