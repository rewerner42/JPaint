package view.gui;

import controller.Travel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MouseHandler extends MouseAdapter{


    public MouseHandler(){
        super();
    }

    @Override
    public void mousePressed(MouseEvent e){
        System.out.println("click"+" "+e.getX()+" "+e.getY());
    }
    @Override
    public void mouseReleased(MouseEvent e){
        System.out.println("unclick"+" "+e.getX()+" "+e.getY());
    }
}
