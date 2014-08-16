/**
 *
 * @author Zackary Misso
 * This class holds the logic to input colors
 * 
 */
package views.minor;
import views.View;
import java.awt.Color;
import java.awt.Graphics;
public class ColorInput extends View{
    private NumberInput red;
    private NumberInput blue;
    private NumberInput green;
    private Color color;
    private String title;

    public ColorInput(){
    	red=null;
    	blue=null;
    	green=null;
    	color=null;
    	title="";
    }

    // initializes the inputs for the colors
    public void initializeInputs(){
    	// implement
    }

    // handles clicks
    public void clicked(){
    	// implement
    }

    // handles types
    public void types(char c){
    	if(c==10)getSuperview().types(c);
        if(c==96)getSuperview().types(c);
        // implement more as needed
    }

    public void paint(Graphics g){
    	// implement
    	super.paint(g);
    }

    // getter methods
    public NumberInput getRed(){return red;}
    public NumberInput getBlue(){return blue;}
    public NumberInput getGreen(){return green;}
    public Color getColor(){return color;}
    public String getTitle(){return title;}

    // setter methods
    public void setRed(NumberInput param){red=param;}
    public void setBlue(NumberInput param){blue=param;}
    public void setGreen(NumberInput param){green=param;}
    public void setColor(Color param){color=param;}
    public void setTitle(String param){title=param;}
}