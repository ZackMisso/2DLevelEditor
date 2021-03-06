/**
 *
 * @author Zackary Misso
 * This class contains the data for a generic Game Entity in a level
 * 
 */
package entities;
import data.GlobalSettings;
import views.View;
import views.major.LevelView;
import views.major.GameEntityView;
import views.major.LevelEntitiesView;
import views.minor.SelectableLabel;
import datastructures.StringToInt;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class GameEntity extends View{
    private EntityState state;
    private Image image; // this may or may not be needed
    private Color color; // draws this until the image functionality is in place
    private int startX;
    private int startY;
    private int depth; // only applies to level editor
    private boolean isNew;
    
    public GameEntity(){
        super();
        state=new EntityState();
        color=null;
        image=null;
        startX=-100;
        startY=-100;
        setWidth(12); // default for mario
        setHeight(16); // default for mario
        depth=-100;
        isNew=true;
    }
    
    // This constructor is being used for a unit test
    public GameEntity(int x,int y){
        startX=x;
        startY=y;
    }
    
    // handles when the game entity is clicked
    public void clicked(){
        getSuperview().subviewFalsify();
        setSelected(true);
        GameEntityView gev=findGrandView().getGameEntity();
        LevelEntitiesView lev=findGrandView().getLevelEntities();
        ArrayList<View> labels=lev.getScrollables();
        for(int i=0;i<labels.size();i++)
            if(((SelectableLabel)labels.get(i)).getReference()==this)
                labels.get(i).setSelected(true);
        gev.setCurrent(this);
        gev.redrawView();
    }
    
    // handles typed input
    public void types(char c){
        // implement shortcuts
    }

    // checks the EntityState for an image or color
    private void checkForGraphics(LevelView view){
        if(!state.getImages().isEmpty()){
            image=state.getImages().get(0).getValue();
            //System.out.println(getWidth()+" :: OLD WIDTH");
            setWidth(state.getImages().get(0).getValue().getWidth(null));
            //System.out.println(getWidth()+" :: NEW WIDTH");
            setHeight(state.getImages().get(0).getValue().getHeight(null));
        }else if(!state.getColors().isEmpty()){
            color=state.getColors().get(0).getValue();
        }else{
            image=view.getManGraphics().getMatch(state.getReference().getName());
            setWidth(image.getWidth(null));
            setHeight(image.getHeight(null));
            if(image!=null)
                System.out.println("Image Found :: GameEntity");
        }
    }

    // sets the pre set instance variaples
    public void updatePreSets(){
        ArrayList<StringToInt> ints=state.getInts();
        for(int i=0;i<ints.size();i++){
            if(ints.get(i).getKey().equals("startX")){
                startX=ints.get(i).getValue();
            }
            if(ints.get(i).getKey().equals("tileX")){
                startX=ints.get(i).getValue()*GlobalSettings.tileSize;
            }
            if(ints.get(i).getKey().equals("startY")){
                startY=ints.get(i).getValue();
            }
            if(ints.get(i).getKey().equals("tileY")){
                startY=ints.get(i).getValue()*GlobalSettings.tileSize;
            }
        }
        // implement more if needed
    }
    
    // returns the data that should be written to the level file
    public String writeData(){
        String data;
        if(!GlobalSettings.tiled)
            data=state.writeState();
        else{
            StringToInt startx=new StringToInt("startX",startX);
            StringToInt starty=new StringToInt("startY",startY);
            data=state.writeState(startx,starty);
        }
        return data+"\n";
    }

    // calculates the object's x position for the actual screen
    private int calculateX(LevelView view){
        return startX-view.getLevelX();
    }

    // calculates the object's y position for the actual screen
    private int calculateY(LevelView view){
        return startY-view.getLevelY();
    }
    
    // sets the location of the object to a multiple of the tileSize
    public void roundPosition(int tileSize,LevelView view){
        startX=(startX/tileSize)*tileSize;
        startY=(startY/tileSize)*tileSize;
    }
    
    // this is used by the tile system to tell if this object is a block
    public boolean isBlock(){
        ArrayList<StringToInt> ints=state.getInts();
        for(int i=0;i<ints.size();i++)
            if(ints.get(i).getKey().equals("block"))
                return ints.get(i).getValue()!=0;
        return false;
    }
    
    // this is causing an error
    public void changeLocationFromTile(int tileSize,LevelView view){
        System.out.println("TileSize :: "+tileSize);
        startX*=tileSize;
        startY*=tileSize;
        calculateX(view);
        calculateY(view);
    }

    // the regular paint method
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
    public int getDepth(){return depth;}
    public boolean getIsNew(){return isNew;}
    
    // setter methods
    public void setState(EntityState param){state=param;}
    public void setImage(Image param){image=param;}
    public void setStartX(int param){startX=param;}
    public void setStartY(int param){startY=param;}
    public void setDepth(int param){depth=param;}
    public void setIsNew(boolean param){isNew=param;}
}