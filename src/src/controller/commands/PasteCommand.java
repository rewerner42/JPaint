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
    IShapeList shapeList;
    IApplicationState appState;
    IShapeList clipBoard;

    public PasteCommand(IApplicationState appState){
        this.shapeList = appState.getShapes();
        this.clipBoard = appState.getClipboard();
        }

    @Override
    public void run(){
        
        IShape s;
        for(IShape shape:clipBoard){
            System.out.println(shape);
            
            s = ShapeFactory.createShapeFromShape(shape);
            System.out.println(s);
            this.shapeList.addShape(s);
            this.objectsToPaste.addShape(s);
            s.moveShape(new Point(20,20));
            System.out.println("pasting Shape");
        }
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
        for(IShape shape:this.objectsToPaste){
            this.shapeList.addShape(shape);
            System.out.println("pasting Shape");
        }
    }
    private void removePasted(){
        for(IShape shape:this.objectsToPaste){
            this.shapeList.removeShape(shape);
            System.out.println("removing Shape");
        }
    }
}
