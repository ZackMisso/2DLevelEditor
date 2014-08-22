/**
 *
 * @author Zackary Misso
 * This class runs the level editor. Very similar to a Game Loop
 * 
 */
package core;
import views.major.GrandView;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class ProgramThread extends JPanel implements Runnable {
    private LevelEditor reference; // a reference to the editor
    private GrandView grandView;
    
    public ProgramThread(LevelEditor param){
        reference=param;
        setIgnoreRepaint(true);
        grandView=new GrandView(this);
    }
    
    // updates everything every iteration of the run loop
    public void update(){
        grandView.update();
    }
    
    // paints every image after every iteration of the run loop
    public void paint(Graphics g){
        BufferedImage backBuffer = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        Graphics g2 = backBuffer.getGraphics();
        grandView.paint(g2);
        g.drawImage(backBuffer, 0, 0, reference.getWindow());
        g2.dispose();
    }
    
    // handles logic when there is a click
    public void handleClick(int x,int y){
        System.out.println("Mouse X: "+x+" Mouse Y: "+y);
        grandView.wasClicked(x,y);
    }
    
    // handles logic when there is a type
    public void handleType(char c){
        System.out.println("Key Typed :: "+c+" Int Value :: "+(int)c);
        grandView.getInputs().handleType(c);
    }
    
    public void run(){
        boolean running=true;
        long lastTime=System.nanoTime();
        double nsPerTick=1000000000D/60D;
        int ticks=0;
        int frames=0;
        long lastTimer=System.currentTimeMillis();
        double delta=0;
        while(running){
            long now=System.nanoTime();
            delta+=(now-lastTime)/nsPerTick;
            lastTime=now;
            boolean shouldRender=false;
            while(delta>=1){
                ticks++;
                update();
                delta-=1;
                shouldRender=true;
            }
            if(shouldRender){
                frames++;
                paint(reference.getWindow().getGraphics());
            }
            if(System.currentTimeMillis()-lastTimer>=1000){
                lastTimer+=1000;
                frames=0;
                ticks=0;
            }
        }
        repaint();
    }
}