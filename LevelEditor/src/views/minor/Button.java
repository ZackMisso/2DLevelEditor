/**
 *
 * @author Zackary Misso
 * This class represents a button. The button will have no functionality
 */
package views.minor;
import views.View;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
public class Button extends View{
    private Image image;
    private String title; // maybe implement this
    private int index;
    
    // default constructor
    public Button(){
        super();
        title="";
        image=null;
        //index=-100;
        setWidth(50);
        setHeight(20);
    }
    
    // initializes button with index as parameter
    public Button(int val){
        this();
        index=val;
    }
    
    // what happens when the button is clicked
    public void clicked(){
        setSelected(true);
        // implement the rest if there is more
    }
    
    // what happens when the button is typed
    public void types(char c){
        // implement
    }

    // custom selection handling
    public void customFalsify(){
        // implement
    }
    
    // draws the button on the screen
    public void paint(Graphics g){
        if(image==null){
            switch(index){
                case 0:
                    g.setColor(Color.cyan);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
                case 1:
                    g.setColor(Color.black);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
                case 2:
                    g.setColor(Color.gray);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
                case 3:
                    g.setColor(Color.green);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
                case 4:
                    g.setColor(Color.lightGray);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
                case 5:
                    g.setColor(Color.magenta);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
                case 6:
                    g.setColor(Color.orange);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
                case 7:
                    g.setColor(Color.pink);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
                case 8:
                    g.setColor(Color.red);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
                case 9:
                    g.setColor(Color.yellow);
                    g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
                    break;
            }
        }
        g.setColor(Color.white);
        g.drawString(title,getXpos()+4,getYpos()+16);
        if(getSelected()){
            g.setColor(Color.white);
            g.drawRect(getXpos(),getYpos(),getWidth(),getHeight());
        }
    }
    
    // getter methods
    public Image getImage(){return image;}
    public String getTitle(){return title;}
    public int getIndex(){return index;}
    
    // setter methods
    public void setImage(Image param){image=param;}
    public void setTitle(String param){title=param;}
    public void setIndex(int param){index=param;}
}