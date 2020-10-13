package controller.commands;

import controller.CommandHistory;
import controller.IUndoable;
import model.interfaces.ICommand;

public class CopyCommand implements ICommand, IUndoable{
    
    public CopyCommand(){

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
