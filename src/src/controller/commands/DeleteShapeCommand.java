package controller.commands;

import controller.CommandHistory;
import controller.IUndoable;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

public class DeleteShapeCommand implements ICommand,IUndoable{

    private IShapeList deletedShapeList;
    private IShapeList shapeList;

    public DeleteShapeCommand(IShapeList deletedShapeList, IShapeList shapeList){
        this.deletedShapeList = deletedShapeList;
        this.shapeList = shapeList;
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
