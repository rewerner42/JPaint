package view.gui;

import view.gui.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MouseHandler extends MouseAdapter{
    public MouseHandler(){
        super();
    }

    @Override
    public void mousePressed(MouseEvent e){
        System.out.println("click");
    }
    @Override
    public void mouseReleased(MouseEvent e){
        System.out.println("unclick");
    }
}
