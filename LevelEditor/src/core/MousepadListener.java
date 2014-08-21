/**
 *
 * @author Zackary Misso
 * This class listens for mouse input from the user
 * 
 */
package core;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MousepadListener implements MouseListener{
    private ProgramThread thread; // reference to the thread
	private int mouseX,mouseY; // the coordinates of the mouse
	//private boolean clicked; // if the mouse is being clicked
    private boolean accepting;
    
    // TODO :: PASS IN MOUSE INFO TO THE PROGRAM THREAD
	
	public MousepadListener(){
        thread=null;
		mouseX=mouseY=0;
		//clicked=false;
        accepting=true;
	}
    
    // reaction if the user clicks
	public void mouseClicked(MouseEvent event){
		if(accepting){
            mouseX=event.getX();
            mouseY=event.getY();
            //clicked=true;
            thread.handleClick(mouseX,mouseY);
        }
	}

    // reaction if the mouse enters the window
	public void mouseEntered(MouseEvent event){
		// does nothing
	}

    // reaction if the mouse exits the window
	public void mouseExited(MouseEvent event){
		// does nothing
	}

    // reaction if the mouse is pressed
	public void mousePressed(MouseEvent event){
		//if(accepting)
        //    mouseClicked(event);
        // should do nothing
	}

    // reaction if the mouse is released
	public void mouseReleased(MouseEvent event){
        //if(accepting)
            //clicked=false;
	}
	
	// getter methods
    //public ProgramThread getThread(){return thread;}
	//public boolean isMousePressed(){return clicked;}
	//public int getX(){return mouseX;}
	//public int getY(){return mouseY;}
    
    // setter methods
    public void setThread(ProgramThread param){thread=param;}
    public void setAccepting(boolean param){accepting=param;}
}