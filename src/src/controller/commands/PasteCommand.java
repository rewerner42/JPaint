package controller.commands;

import controller.CommandHistory;
import controller.IUndoable;
import model.interfaces.ICommand;

public class PasteCommand implements ICommand, IUndoable{
    
    public PasteCommand(){

    }

    @Override
    public void run(){
        CommandHistory.add(this);
    }

    @Override
    public void undo(){

    }

    @Override
    public void redo(){

    }
}
