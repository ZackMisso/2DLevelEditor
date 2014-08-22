/**
 *
 * @author Zackary Misso
 * This class contains the logic for a Label
 * 
 */
package views.minor;
import views.View;
import java.awt.Graphics;
import java.awt.Color;
public class Label extends View{
    private String text;
    
    public Label(){
        super();
        text="";
    }
    
    // handles clicks
    public void clicked(){
        // does nothing
    }
    
    // handles types
    public void types(char c){
        // does nothing
    }
    
    // draws the text to the screen
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.drawString(text,getXpos(),getYpos());
    }
    
    // getter methods
    public String getText(){return text;}
    
    // setter methods
    public void setText(String param){text=param;}
}
