package controller.commands;

import controller.*;
import model.interfaces.ICommand;
import model.shapes.*;
import model.interfaces.*;
import model.persistence.ApplicationState;

public class CreateShapeCommand implements ICommand, IUndoable{
    
    private IShapeList shapeList;
    private Point startPoint;
    private Point endPoint;
    private IShape commandShape;
    private ApplicationState appState;

    public CreateShapeCommand(IShapeList shapeList, Point startPoint, Point endPoint, ApplicationState appState){
        this.shapeList = shapeList;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.appState = appState;
    }
    public void run(){ //needs start point and end point
        this.shapeList.addShape(ShapeFactory.getShape(this.startPoint, this.endPoint, this.appState));
        CommandHistory.add(this);
    }

    public void undo() {
        this.shapeList.removeShape(commandShape);
    }

    public void redo(){
        this.shapeList.addShape(commandShape);
    }

}
