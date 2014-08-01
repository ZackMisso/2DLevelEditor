/**
 *
 * @author Zackary Misso
 * This class contains the logic for a text block to be implemented
 * 
 */
package views.minor;
import views.View;
import java.awt.Graphics;
import java.awt.Color;
public class TextBox extends View{
    private String contents;
    private String title;
    private int spacesPerRow;
    private int depth;
    private boolean hasTitle;
    
    // default constructor
    public TextBox(){
        // implement default constructor
        configDimentions();
    }
    
    // constructor with the number of spaces as the param
    public TextBox(int param){
        title="";
        contents="";
        spacesPerRow=param;
        depth=1;
        hasTitle=false;
        configDimentions();
    }
    
    // constructor with the number of spaces and the depth
    public TextBox(int param,int param2){
        title="";
        contents="";
        spacesPerRow=param;
        depth=param2;
        hasTitle=false;
        configDimentions();
    }
    
    // calculates the dimention of the box
    private void configDimentions(){
        setWidth(spacesPerRow*8);
        setHeight(depth*24);
    }
    
    // hwndles when the user clicks
    public void clicked(){
        getSuperview().inputFalsify();
        setSelected(true);
    }
    
    // handles when the user types
    public void types(char c){
        if(Character.isLetter(c))
            contents=contents+c;
        if(c==8&&contents.length()>0)
            contents=contents.substring(0,contents.length()-1);
    }

    // custom selection handling
    public void customFalsify(){
        // delete this
    }
    
    // draws the TextBox to the screen
    public void paint(Graphics g){
        //System.out.println("TOTAL");
        //System.out.println("X :: "+getXpos()+" Y :: "+getYpos());
        //System.out.println("W :: "+spacesPerRow*8+" H :: "+depth*8);
        int x=getXpos();
        g.setColor(Color.black);
        if(hasTitle){
            // implement
        }
        g.fillRect(x,getYpos(),getWidth(),getHeight());
        g.setColor(Color.yellow);
        g.drawString(contents,x+4,getYpos()+10);
        // possibly implement more
        if(getSelected()){
            //g.setColor(Color.yellow);
            g.drawRect(getXpos(),getYpos(),getWidth(),getHeight());
        }
    }
    
    // getter method
    public String getContents(){return contents;}
    public String getTitle(){return title;}
    public int getSpacesPerRow(){return spacesPerRow;}
    public int getDepth(){return depth;}
    public boolean getHasTitle(){return hasTitle;}
    
    // setter method
    public void setTitle(String param){title=param;}
    public void setContents(String param){contents=param;}
    public void setSpacesPerRow(int param){spacesPerRow=param;}
    public void setDepth(int param){depth=param;}
    public void setHasTitle(boolean param){hasTitle=param;}
}