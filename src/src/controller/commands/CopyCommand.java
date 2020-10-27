package controller.commands;

import controller.CommandHistory;
import controller.IUndoable;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShapeList;
import model.shapes.NonArtisticShapeList;
import model.interfaces.IShape;

public class CopyCommand implements ICommand, IUndoable{
    
    private IShapeList selectedShapeList;
    private IShapeList before = new NonArtisticShapeList();
    private IApplicationState appState;

    public CopyCommand(IApplicationState appState){
        this.selectedShapeList = appState.getSelected();
        this.appState = appState;
    }

    @Override
    public void run(){
        for(IShape shape:this.selectedShapeList){
            System.out.println(shape);
            before.addShape(shape);
        }
        clip();
        CommandHistory.add(this);
    }

    @Override
    public void undo(){
        unClip();
    }

    @Override
    public void redo(){
        clip();
    }

    private void clip(){
        this.appState.setClipboard(before);
    }

    private void unClip(){
        this.appState.emptyClipboard();
    }
}
