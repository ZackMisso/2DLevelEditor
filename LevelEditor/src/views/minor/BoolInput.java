/**
 *
 * @author Zackary Misso
 * Basically a glorified Radial Button
 * 
 */
package views.minor;
import views.View;
import java.awt.Graphics;
import java.awt.Color;
public class BoolInput extends View{
    private String title;
    private boolean contents;
    private boolean hasTitle;

    // the default constructor
    public BoolInput(){
    	title="";
    	contents=false;
    	hasTitle=false;
    	configureDimensions();
    }

    // sets the length and the width of the view
    private void configureDimensions(){
    	setWidth(36);
    	setHeight(24);
    }

    // what happens when the user clicks
    public void clicked(){
    	getSuperview().inputFalsify();
    	contents=true;
    }

    // what happens when the user types
    public void types(char c){
    	if(c==10)getSuperview().types(c);
        if(c==96)getSuperview().types(c);
        // implement more as needed
    }

    // DELETE THIS
    public void customFalsify(){
    	// delete this
    }

    public void paint(Graphics g){
    	int x=getXpos();
    	g.setColor(Color.black);
    	if(hasTitle){
    		// implement
    	}
    	g.fillRect(x,getYpos(),getWidth(),getHeight());
    	if(contents){
    		g.setColor(Color.yellow);
    		g.fillRect(x+3,getYpos()+3,getWidth()-3,getHeight()-3);
    	}
    	// implement more if needed
    }

    // getter methods
    public String getTitle(){return title;}
    public boolean getContents(){return contents;}
    public boolean getHasTitle(){return hasTitle;}

    // setter methods
    public void setTitle(String param){title=param;}
    public void setContents(boolean param){contents=param;}
    public void setHasTitle(boolean param){hasTitle=param;}
}
