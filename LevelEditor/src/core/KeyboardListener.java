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
    private final boolean[] keys; // the list of possible keys
    private boolean accepting; // if we are accepting key presses
    
    // TODO :: PASS IN TYPE INFO TO THE PROGRAM THREAD
    
    public KeyboardListener(){
		keys=new boolean[256];
        accepting=true;
	}
	
    // reacts to a key being pressed
	public void keyPressed(KeyEvent event){
        //if(accepting)
        //    keys[event.getKeyCode()]=true;
        thread.handleType(event.getKeyChar());
   	}
	
    // reacts to a key being released
	public void keyReleased(KeyEvent event){
        //if(accepting)
        //    keys[event.getKeyCode()]=false;
	}
	
    // reacts if a key was typed
	public void keyTyped(KeyEvent event){
		// does nothing for now
	}

	// returns if a specified key is being pressed
	public boolean isKeyPressed(int key){return keys[key];}
    
	// returns if a specified key is not being pressed
	public boolean isKeyReleased(int key){return !keys[key];}
    
    // getter methods
    public ProgramThread getThread(){return thread;}
    public boolean getAccepting(){return accepting;}
    
    // setter methods
    public void setThread(ProgramThread param){thread=param;}
    public void setAccepting(boolean param){accepting=param;}
}