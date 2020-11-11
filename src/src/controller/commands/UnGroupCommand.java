package controller.commands;

import java.io.IOException;

import controller.CommandHistory;
import controller.IUndoable;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.shapes.NonArtisticShapeList;

public class UnGroupCommand implements ICommand, IUndoable {

    private IShapeList selectedShapeList;
    private IShapeList shapeList;
    private IShapeList groupList = new NonArtisticShapeList();

    public UnGroupCommand(IApplicationState appState){
        this.selectedShapeList = appState.getSelected();
        this.shapeList = appState.getShapes();
    }

    @Override
    public void run() throws IOException {
        for(IShape shape:this.selectedShapeList){
            if(shape.getShapeType() == ShapeType.GROUP){
                groupList.addShape(shape);
                for(IShape shape2:(IShapeList)shape){
                    this.shapeList.addShape(shape2);
                }
                this.shapeList.removeShape(shape);
            }
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        this.fuseGroup();
    }

    @Override
    public void redo() {
        this.splitGroup();
    }

    private void splitGroup(){
        for(IShape group:this.groupList){
            for(IShape shape2:(IShapeList)group){
                this.shapeList.addShape(shape2);
            }
            this.shapeList.removeShape(group);
        }
    }

    private void fuseGroup(){
        for(IShape group:this.groupList){
            for(IShape shape2:(IShapeList)group){
                this.shapeList.removeShape(shape2);
            }
            this.shapeList.addShape(group);
        }
    }   
}
