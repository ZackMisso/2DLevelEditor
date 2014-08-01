/**
 *
 * @author Zackary Misso
 * This class implements the logic for an area (level in a game)
 * 
 */
package data;
import entities.GameEntity;
import java.util.ArrayList;
public class Area{
    private ArrayList<GameEntity> entities;
    private String name;
    private boolean selected;
    
    // default constructor
    public Area(){
        entities=new ArrayList<>();
        name="";
        selected=false;
    }
    
    // returns the data in the area as a string
    public String writeArea(){
        // implement
        return "";
    }
    
    // getter methods
    public ArrayList<GameEntity> getEntities(){return entities;}
    public String getName(){return name;}
    public boolean getSelected(){return selected;}
    
    // setter methods
    public void setEntities(ArrayList<GameEntity> param){entities=param;}
    public void setName(String param){name=param;}
    public void setSelected(boolean param){selected=param;}
}