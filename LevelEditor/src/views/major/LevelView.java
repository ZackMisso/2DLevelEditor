/**
 *
 * @author Zackary Misso
 * This view displays the level that is currently being edited
 * 
 */
package views.major;
import views.View;
import entities.GameEntity;
import data.ManualGraphics;
import data.GlobalSettings;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
public class LevelView extends View{
    // this class will contain all of the entities
    private ArrayList<GameEntity> entities;
    private ManualGraphics mans;
    private GlobalSettings settings;
    private int levelX; // the xposition of the view with respect to the level
    private int levelY; // the yposition of the view with respect to the level
    private int levelWidth;
    private int levelHeight;
    private boolean sorted;
    
    // default constructor
    public LevelView(){
        entities=new ArrayList<>();
        mans=new ManualGraphics(); // Hack
        levelX=0;
        levelY=0;
        sorted=true;
        setXpos(0);
        setYpos(0);
        setWidth(600);
        setHeight(568);
        levelWidth=getWidth();
        levelHeight=getHeight();
        setShowing(true);
    }
    
    // handles the clicks
    public void clicked(){
        subviewFalsify();
        // implement more possibly
        System.out.println("Level View was clicked");
    }
    
    // handles the types
    public void types(char c){
        // implement
    }
    
    // refactors the locations of the objects when the view is shifted
    public void refactorLocations(int x,int y){
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof GameEntity||true){
                View temp=getSubviews().get(i);
                temp.setXpos(temp.getXpos()+x);
                temp.setYpos(temp.getYpos()+y);
            }
    }

    // returns the currently selected game object
    public GameEntity getSelectedEntity(){
        GameEntity temp=null;
        for(int i=0;i<entities.size();i++)
            if(entities.get(i).getSelected())
                temp=entities.get(i);
        return temp;
    }
    
    // draws the view and the subviews to the screen
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(getXpos(), getYpos(), getWidth(), getHeight());
        g.setColor(Color.black);
        if(settings.getTiled()){
            for(int i=levelX;i<getWidth()+levelX;i++)
                if(i%settings.getTileSize()==0)
                    g.drawLine(i-levelX,0,i-levelX,getHeight());
            for(int i=levelY;i<getHeight()+levelY;i++)
                if(i%settings.getTileSize()==0)
                    g.drawLine(0,i-levelY,getWidth(),i-levelY);
        }
        if(!sorted)
            sortByDepth();
        super.paint(g);
    }
    
    // sorts the game entity list based on user defined depth
    private void sortByDepth(){
        // TODO :: TEST THIS!!!!
        // THIS WILL NOT BE NEEDED FOR SOME APPLICATIONS (MAINLY MY CURRENT ONE)
        for(int i=1;i<entities.size();i++){
            int j=i;
            int k=j-1;
            while(entities.get(j).getDepth()<entities.get(k).getDepth()){
                GameEntity temp=entities.get(j);
                entities.set(j,entities.get(k));
                entities.set(k,temp);
                j--;
                k--;
            }
        }
    }
    
    // writes all of the entities to a string to write to the file
    public String writeLevel(){
        // this may not be needed
        return "";
    }
    
    // getter methods
    public ArrayList<GameEntity> getEntities(){return entities;}
    public ManualGraphics getManGraphics(){return mans;}
    public GlobalSettings getSettings(){return settings;}
    public int getLevelX(){return levelX;}
    public int getLevelY(){return levelY;}
    public int getLevelWidth(){return levelWidth;}
    public int getLevelHeight(){return levelHeight;}
    public boolean getSorted(){return sorted;}
    
    // setter methods
    public void setEntities(ArrayList<GameEntity> param){entities=param;}
    public void setManGraphics(ManualGraphics param){mans=param;}
    public void setSettings(GlobalSettings param){settings=param;}
    public void setLevelX(int param){levelX=param;}
    public void setLevelY(int param){levelY=param;}
    public void setLevelWidth(int param){levelWidth=param;}
    public void setLevelHeight(int param){levelHeight=param;}
    public void setSorted(boolean param){sorted=param;}
}