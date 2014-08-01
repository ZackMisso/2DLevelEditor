/**
 *
 * @author Zackary Misso
 * This class contains the data for a generic Game Entity in a level
 * 
 */
package entities;
import views.View;
import views.major.LevelView;
import datastructures.StringToInt;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
public class GameEntity extends View{
    private EntityState state;
    private Image image; // this may or may not be needed
    private Color color; // draws this until the image functionality is in place
    private int startX;
    private int startY;
    private int levelIndex; // the index of the entity in the level list of entities
    private int depth; // only applies to level editor
    private boolean isNew;
    
    public GameEntity(){
        super();
        state=new EntityState();
        color=null;
        //state=null; // STUPID!!!
        image=null;
        startX=-100;
        startY=-100;
        setWidth(12); // default for mario
        setHeight(16); // default for mario
        levelIndex=-100;
        depth=-100;
        isNew=true;
    }
    
    // handles when the game entity is clicked
    public void clicked(){
        getSuperview().subviewFalsify();
        setSelected(true);
        // implement more if needed
    }
    
    // handles typed input
    public void types(char c){
        // I do not know how we should implement this yet
    }

    // checks the EntityState for an image or color
    private void checkForGraphics(LevelView view){
        if(!state.getImages().isEmpty()){
            image=state.getImages().get(0).getValue();
        }else if(!state.getColors().isEmpty()){
            color=state.getColors().get(0).getValue();
        }else{
            image=view.getManGraphics().getMatch(state.getReference().getName());
            if(image!=null)
                System.out.println("Image Found :: GameEntity");
            //System.out.println("There is no graphics :: GameEntity");
        }
        //System.out.println("Change Test :: GameEntity");
    }

    // sets the pre set instance variaples
    public void updatePreSets(){
        ArrayList<StringToInt> ints=state.getInts();
        for(int i=0;i<ints.size();i++){
            if(ints.get(i).getKey().equals("startX")){
                startX=ints.get(i).getValue();
            }
            if(ints.get(i).getKey().equals("startY")){
                startY=ints.get(i).getValue();
            }
        }
        // implement more if needed
    }
    
    // returns the data that should be written to the level file
    public String writeData(){
        //String data="THIS IS A TEST";
        String data=state.writeState();
        return data+"\n";
    }

    // calculates the object's x position for the actual screen
    private int calculateX(LevelView view){
        // this may not be needed
        return startX-view.getLevelX();
    }

    // calculates the object's y position for the actual screen
    private int calculateY(LevelView view){
        // this may not be needed
        return startY-view.getLevelY();
    }
    
    // This is depreciated
    public void levelPaint(Graphics g,LevelView view){
        //Rectangle one=view.getLevelRect();
        Rectangle one=view.getRect();
        Rectangle two=getRect();
        //System.out.println(getXpos());
        //System.out.println(one.x+" "+one.width);
        //System.out.println(one.y+" "+one.height);
        //System.out.println(two.x+" "+two.width);
        //System.out.println(two.y+" "+two.height);
        if(one.intersects(two)){
            //System.out.println("IN VIEW :: GameEntity");
            if(image==null&&color==null)
                checkForGraphics(view);
            setXpos(calculateX(view));
            setYpos(calculateY(view));
            if(image!=null){
                g.drawImage(image,getXpos(),getYpos(),null);
            }else if(color!=null){
                // draw box with color
            }else{
                g.setColor(Color.black);
                g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
            }
            if(getSelected()){
                g.setColor(Color.yellow);
                g.drawRect(getXpos(),getYpos(),getWidth(),getHeight());
            }
        }
    }

    // the regular pain method
    public void paint(Graphics g){
        LevelView view=(LevelView)getSuperview();
        if(image==null&&color==null)
                checkForGraphics(view);
        setXpos(calculateX(view));
        setYpos(calculateY(view));
        if(image!=null){
            g.drawImage(image,getXpos(),getYpos(),null);
        }else if(color!=null){
            // draw box with color
        }else{
            g.setColor(Color.black);
            g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
        }
        if(getSelected()){
            g.setColor(Color.yellow);
            g.drawRect(getXpos(),getYpos(),getWidth(),getHeight());
        }
    }
    
    // getter methods
    public EntityState getState(){return state;}
    public Image getImage(){return image;}
    public Color getColor(){return color;}
    public int getStartX(){return startX;}
    public int getStartY(){return startY;}
    public int getLevelIndex(){return levelIndex;}
    public int getDepth(){return depth;}
    public boolean getIsNew(){return isNew;}
    
    // setter methods
    public void setState(EntityState param){state=param;}
    public void setImage(Image param){image=param;}
    public void setColor(Color param){color=param;}
    public void setStartX(int param){startX=param;}
    public void setStartY(int param){startY=param;}
    public void setLevelIndex(int param){levelIndex=param;}
    public void setDepth(int param){depth=param;}
    public void setIsNew(boolean param){isNew=param;}
}