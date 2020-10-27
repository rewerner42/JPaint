package controller.commands;

import controller.CommandHistory;
import controller.IUndoable;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.shapes.NonArtisticShapeList;
import model.shapes.ShapeFactory;
import controller.Point;

public class PasteCommand implements ICommand, IUndoable{
    
    IShapeList objectsToPaste = new NonArtisticShapeList();
    IShapeList clonedObjects = new NonArtisticShapeList();
    IShapeList shapeList;
    IApplicationState appState;
    

    public PasteCommand(IApplicationState appState){
        this.shapeList = appState.getShapes();
        IShapeList clipBoard = appState.getClipboard();
        for(IShape shape:clipBoard){
            this.objectsToPaste.addShape(shape);
        }
        IShape clonedShape;
        for(IShape shape:this.objectsToPaste){
            clonedShape = ShapeFactory.createShapeFromShape(shape);
            clonedShape.moveShape(new Point(50,50));
            clonedObjects.addShape(clonedShape);
            System.out.println("pasting Shape");
        }
    }

    @Override
    public void run(){
        paste();
        CommandHistory.add(this);
    }
    @Override
    public void undo(){
        System.out.println("undo");
        removePasted();
    }

    @Override
    public void redo(){
        System.out.println("redo");
        paste();    
    }
    private void paste(){
        for(IShape shape:this.clonedObjects){
            this.shapeList.addShape(shape);
        }
    }
    private void removePasted(){
        for(IShape shape:this.clonedObjects){
            this.shapeList.removeShape(shape);
        }
    }
}
