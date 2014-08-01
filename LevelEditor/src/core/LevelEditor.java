/**
 *
 * @author Zackary Misso
 * This class is the top class in the class hierarchy. It contains everything
 * 
 */
package core;
import javax.swing.JFrame;
public class LevelEditor {
    private final JFrame window; // the window the user interacts with
	private final ProgramThread thread; // the thread that runs the program
	private final KeyboardListener keyListener; // listens for keyboard input
	private final MousepadListener mouseListener; // listens for mouse input
    
    public LevelEditor(int x,int y,String title){
        // creates the window for the level editor
        window=new JFrame();
		window.setSize(x,y);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setLocationRelativeTo(null);
		window.setTitle(title);
		window.setVisible(true);
        // set the variables for the level editor
		thread=new ProgramThread(this);
		keyListener=new KeyboardListener();
		mouseListener=new MousepadListener();
        keyListener.setThread(thread);
        mouseListener.setThread(thread);
        // adds components to the window
		window.add(thread);
		window.addKeyListener(keyListener);
		window.addMouseListener(mouseListener);
        // start the thread
		new Thread(thread).start();
    }
    
    // getter methods
	public JFrame getWindow(){return window;}
	public KeyboardListener getKeyListener(){return keyListener;}
	public MousepadListener getMouseListener(){return mouseListener;}
	public ProgramThread getThread(){return thread;}
}