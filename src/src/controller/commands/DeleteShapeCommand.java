package controller.commands;

import controller.CommandHistory;
import controller.IUndoable;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.shapes.ShapeList;

public class DeleteShapeCommand implements ICommand,IUndoable{
    
    private ShapeList shapeList;
    private ShapeList deletedShapeList;

    public DeleteShapeCommand(){
    }

    @Override
    public void run(){
        delete();
        CommandHistory.add(this);
    }
    @Override
    public void undo() {
        for(IShape shape:this.deletedShapeList){
            this.shapeList.addShape(shape);
        }
    }
    @Override
    public void redo(){
        delete();
    }
    private void delete(){
        for(IShape shape:this.deletedShapeList){
            this.shapeList.removeShape(shape);
        }
    }
}
