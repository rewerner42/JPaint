package controller.commands;

import java.io.IOException;

import controller.CommandHistory;
import controller.IUndoable;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.shapes.ShapeGroup;

public class GroupCommand implements ICommand, IUndoable {

    private IShapeList selectedShapeList;
    private IShapeList shapeList;
    private ShapeGroup shapeGroup;

    public GroupCommand(IApplicationState appState) {
        this.selectedShapeList = appState.getSelected();
        this.shapeList = appState.getShapes();
    }

    @Override
    public void undo() {
        this.splitGroup();
    }

    @Override
    public void redo() {
        this.addGroup();
    }

    @Override
    public void run() throws IOException {
        shapeGroup = new ShapeGroup();
        //create ShapeGroup
        for(IShape shape:this.selectedShapeList){
            this.shapeGroup.addShape(shape);
        }
        this.addGroup();
        CommandHistory.add(this);
    }

    private void addGroup(){
        for(IShape shape:this.shapeGroup){
            this.shapeList.removeShape(shape);
        }
        this.shapeList.addShape(shapeGroup);
    }

    private void splitGroup(){
        for(IShape shape:this.shapeGroup){
            this.shapeList.addShape(shape);
        }
        this.shapeList.removeShape(shapeGroup);
    }

}
