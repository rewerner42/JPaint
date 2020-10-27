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

    public static ShapeColor convertColor(Color shapeColor){
        Color currentColor = shapeColor;
        if(currentColor.equals(Color.BLUE)){
            return ShapeColor.BLUE;
        }else if(currentColor.equals(Color.BLACK)){
            return ShapeColor.BLACK;
        }else if(currentColor.equals(Color.DARK_GRAY)){
            return ShapeColor.DARK_GRAY;
        }else if(currentColor.equals(Color.CYAN)){
            return ShapeColor.CYAN;
        }else if(currentColor.equals(Color.GRAY)){
            return ShapeColor.GRAY;
        }else if(currentColor.equals(Color.GREEN)){
            return ShapeColor.GREEN;
        }else if(currentColor.equals(Color.LIGHT_GRAY)){
            return ShapeColor.LIGHT_GRAY;
        }else if(currentColor.equals(Color.MAGENTA)){
            return ShapeColor.MAGENTA;
        }else if(currentColor.equals(Color.ORANGE)){
            return ShapeColor.ORANGE;
        }else if(currentColor.equals(Color.PINK)){
            return ShapeColor.PINK;
        }else if(currentColor.equals(Color.RED)){
            return ShapeColor.RED;
        }else if(currentColor.equals(Color.WHITE)){
            return ShapeColor.WHITE;
        }else{
            return ShapeColor.YELLOW;
        }
    }
}
