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
    //private RadialController reference; // reference to the controller
    private String text;
    private int index; // the index of this button in the controller
    private boolean hack;
    
    // default constructor
    public RadialButton(){
        // THIS IS A HACK FIX LATER
        //reference=null;
        text="";
        index=-100;
        hack=true;
    }
    
    // constructor with radial controller reference
    //public RadialButton(RadialController param){
    //    this(param,0,0);
    //}
    
    // the constructor with the location of the radial button
    //public RadialButton(RadialController param,int x,int y){
    //    //reference=param;
    //    text="";
    //    index=-100;
    //    setXpos(x);
    //    setYpos(y);
    //    hack=false;
    //}
    
    // handles being clicked
    public void clicked(){
        if(!hack)
            //reference.clearSelected();
        getSuperview().subviewFalsify();
        setSelected(true);
    }
    
    // handles input from keyboard
    public void types(char c){
        // will do nothing at first
    }
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        //if(getXpos()>0)
        //    System.out.println("PARTYYYYYYY");
        g.drawOval(getXpos(),getYpos(),10,10);
        g.setColor(Color.black);
        if(getSelected()){
            g.fillOval(getXpos()+1,getYpos()+1,8,8);
        }
        g.drawString(text,getXpos()+10,getYpos());
    }
    
    // getter methods
    //public RadialController getReference(){return reference;}
    public String getText(){return text;}
    public int getIndex(){return index;}
    public boolean getHack(){return hack;}
    
    // setter methods
    //public void setReference(RadialController param){reference=param;}
    public void setText(String param){text=param;}
    public void setIndex(int param){index=param;}
    public void setHack(boolean param){hack=param;}
}