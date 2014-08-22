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
    
    // TODO :: PASS IN MOUSE INFO TO THE PROGRAM THREAD
	
	public MousepadListener(){
        thread=null;
		mouseX=mouseY=0;
	}
    
    // reaction if the user clicks
	public void mouseClicked(MouseEvent event){
        mouseX=event.getX();
        mouseY=event.getY();
        thread.handleClick(mouseX,mouseY);
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
		// does nothing
	}

    // reaction if the mouse is released
	public void mouseReleased(MouseEvent event){
        // does nothing
	}
    
    // setter methods
    public void setThread(ProgramThread param){thread=param;}
}