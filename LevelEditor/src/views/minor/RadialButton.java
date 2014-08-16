/**
 *
 * @author Zackary Misso
 * This class contains the logic for a Radial Button.
 * 
 */
package views.minor;
import views.View;
import java.awt.Graphics;
import java.awt.Color;
public class RadialButton extends View{
    private String text;
    private int index; // the index of this button in the controller
    
    // default constructor
    public RadialButton(){
        text="";
        index=-100;
    }
    
    // handles being clicked
    public void clicked(){
        getSuperview().subviewFalsify();
        setSelected(true);
    }
    
    // handles input from keyboard
    public void types(char c){
        if(c==10)getSuperview().types(c);
        if(c==96)getSuperview().types(c);
        // implement more as needed
    }
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.drawOval(getXpos(),getYpos(),10,10);
        g.setColor(Color.black); 
        if(getSelected())
            g.fillOval(getXpos()+1,getYpos()+1,8,8);
        g.drawString(text,getXpos()+10,getYpos());
    }
    
    // getter methods
    public String getText(){return text;}
    public int getIndex(){return index;}
    
    // setter methods
    public void setText(String param){text=param;}
    public void setIndex(int param){index=param;}
}