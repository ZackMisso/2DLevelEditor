/**
 *
 * @author Zackary Misso
 * This is an abstract class created to reduce the amount of code
 * 
 */
package views;
public abstract class Displayable {
    private int xpos;
    private int ypos;
    private int width;
    private int height;
    
    public Displayable(){ // default constructor
        this(0,0,0,0);
    }
    
    // constructor with all parameters
    public Displayable(int x,int y,int w,int h){
        xpos=x;
        ypos=y;
        width=w;
        height=h;
    }
    
    // getter methods
    public int getXpos(){return xpos;}
    public int getYpos(){return ypos;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
    
    // setter methods
    public void setXpos(int param){xpos=param;}
    public void setYpos(int param){ypos=param;}
    public void setWidth(int param){width=param;}
    public void setHeight(int param){height=param;}
}