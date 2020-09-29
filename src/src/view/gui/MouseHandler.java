package view.gui;

import controller.Point;
import model.persistence.*;
import view.gui.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import view.interfaces.PaintCanvasBase;
import java.lang.Math;

import java.awt.*;

public class MouseHandler extends MouseAdapter{

    PaintCanvasBase paintCanvas;
    ApplicationState applicationState;
    Point startPoint;
    Point endPoint;

    public MouseHandler(){
        super();
    }

    public MouseHandler(ApplicationState aState, PaintCanvasBase pCanvas){
        super();
        this.applicationState = aState;
        this.paintCanvas = pCanvas;
    }

    @Override
    public void mousePressed(MouseEvent e){
        startPoint = new Point(e.getX(),e.getY());
        System.out.println("click"+" "+e.getX()+" "+e.getY());
    }
    @Override
    public void mouseReleased(MouseEvent e){
        endPoint = new Point(e.getX(),e.getY());
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        draw(graphics2d);
        System.out.println("unclick"+" "+e.getX()+" "+e.getY());
    }

    public void draw(Graphics2D g2d){
        int x1 = startPoint.getX();
        int y1 = startPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();
        
        g2d.fillRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
    }
}
