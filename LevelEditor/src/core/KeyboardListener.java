/**
 *
 * @author Zackary Misso
 * This class listens for user input from the keyboard
 * 
 */
package core;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyboardListener implements KeyListener{
    private ProgramThread thread; // a reference to the program thread
    
    public KeyboardListener(){ // default constructor
		thread=null;
	}
	
    // reacts to a key being pressed
	public void keyPressed(KeyEvent event){
        thread.handleType(event.getKeyChar());
   	}
	
    // reacts to a key being released
	public void keyReleased(KeyEvent event){
        // does nothing
	}
	
    // reacts if a key was typed
	public void keyTyped(KeyEvent event){
		// does nothing for now
	}
    
    // setter methods
    public void setThread(ProgramThread param){thread=param;}
}