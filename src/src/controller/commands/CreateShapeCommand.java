package controller.commands;

import controller.*;
import model.interfaces.ICommand;
import model.shapes.*;
import model.interfaces.IShape;
import view.gui.*;
import model.shapes.ShapeList;

public class CreateShapeCommand implements ICommand, IUndoable{
    
    private ShapeList shapeList;
    private Point startPoint;
    private Point endPoint;
    private IShape commandShape;

    public CreateShapeCommand(ShapeList shapeList, Point startPoint, Point endPoint){
        this.shapeList = shapeList;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    public void run(){ //needs start point and end point
        IShape shape = new Rectangle(this.startPoint, this.endPoint);
        this.commandShape = shape;
        shapeList.addShape(commandShape);
        CommandHistory.add(this);
    }

    public void undo() {
        shapeList.removeShape(commandShape);
    }

    public void redo(){
        shapeList.addShape(commandShape);
        //CommandHistory.add(this);
    }

}
