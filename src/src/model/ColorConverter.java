package model;
import java.awt.*;

public class ColorConverter {

    public static Color convertColor(ShapeColor shapeColor){
        ShapeColor currentColor = shapeColor;
        Color color;
        switch (currentColor){
                case BLUE:
                    color = Color.blue;
                    break;
                case BLACK:
                    color = Color.black;
                    break;
                case DARK_GRAY:
                    color = Color.darkGray;
                    break;
                case CYAN:
                    color = Color.cyan;
                    break;
                case GRAY:
                    color = Color.gray;
                    break;
                case GREEN:
                    color = Color.green;
                    break;
                case LIGHT_GRAY:
                    color = Color.lightGray;
                    break;
                case MAGENTA:
                    color = Color.magenta;
                    break;
                case ORANGE:
                    color = Color.orange;
                    break;
                case PINK:
                    color = Color.pink;
                case RED:
                    color = Color.red;
                    break;
                case WHITE:
                    color = Color.white;
                    break;
                case YELLOW:
                    color = Color.yellow;
                    break;
                default:
                    color = Color.green;
                    break;
        }
        return color;
    }
}
