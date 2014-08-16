/**
 *
 * @author Zackary Misso
 * This class contains the logic for a Number Input.
 * 
 */
package views.minor;
import views.View;
import java.awt.Graphics;
import java.awt.Color;
public class NumberInput extends View{
    private String contents;
    private String title;
    private int digits;
    private boolean hasTitle;
    private boolean repInt;
    private boolean repByte;

    // TODO :: FIGURE OUT HOW TO INCORPORATE NEGATIVES
    
    // default constructor
    public NumberInput(){
        contents="";
        digits=4;
        title="";
        hasTitle=false;
        repInt=true;
        repByte=false;
        setXpos(-1000);
        setYpos(-1000);
        configureDimensions();
    }
    
    // constructor with length and position
    public NumberInput(int len,int x,int y){
        contents="";
        title="";
        hasTitle=false;
        digits=len;
        repInt=true;
        repByte=false;
        setXpos(x);
        setYpos(y);
        configureDimensions();
    }

    private void configureDimensions(){
        setWidth(digits*9);
        setHeight(24);
    }
    
    // handles user clicks
    public void clicked(){
        getSuperview().inputFalsify();
        setSelected(true);
    }
    
    // handles user types
    public void types(char c){
        if(Character.isDigit(c)){
            contents+=c;
            long max=0;
            long min=0;
            if(repByte){
                max=255;
                min=-256;
            }
            if(repInt){
                max=Integer.MAX_VALUE;
                min=Integer.MIN_VALUE;
            }
            long temp=Long.parseLong(contents);
            if(temp>max||temp<min){
                contents=contents.substring(0,contents.length()-1);
                System.out.println("Input was out of bounds :: NumberInput");
            }
        }
        else if(c==8&&contents.length()>0)
            contents=contents.substring(0,contents.length()-1);
        else if(c==10)getSuperview().types(c);
        else if(c==96)getSuperview().types(c);
        else{
            System.out.println("Minor Error :: Expecting digit :: NumberInput");
        }
    }

    // custom selection handling
    public void customFalsify(){
        // delete this
    }

    // gets the contents as an int
    public int getContentsAsInt(){
        return Integer.parseInt(contents);
    }

    // draws the view to the screen
    public void paint(Graphics g){
        int x=getXpos();
        g.setColor(Color.black);
        g.fillRect(x,getYpos(),getWidth(),getHeight());
        g.setColor(Color.white);
        if(hasTitle){
            // draw the title
        }
        if(!title.equals("")){
            g.drawString(title,getXpos()-31,getYpos()+14);
        }
        //g.fillRect(x,getYpos(),getWidth(),getHeight());
        //g.setColor(Color.white);
        g.drawString(contents,x+4,getYpos()+10);
        if(getSelected()){
            g.setColor(Color.yellow);
            g.drawRect(getXpos(),getYpos(),getWidth(),getHeight());
        }
    }
    
    // getter methods
    public String getContents(){return contents;}
    public String getTitle(){return title;}
    public int getDigits(){return digits;}
    public boolean getHasTitle(){return hasTitle;}
    public boolean getRepInt(){return repInt;}
    public boolean getRepByte(){return repByte;}
    
    // setter methods
    public void setContents(String param){contents=param;}
    public void setTitle(String param){title=param;}
    public void setDigits(int param){digits=param;}
    public void setHasTitle(boolean param){hasTitle=param;}
    public void setRepInt(boolean param){repInt=param;}
    public void setRepByte(boolean param){repByte=param;}
}
