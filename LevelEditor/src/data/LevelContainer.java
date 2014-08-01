/**
 *
 * @author Zackary Misso
 * This class will store all of the level's data while editing it
 * The difference between this class and the Area class is that this class will
 * contain the temporary changes before they are saved.
 * 
 */
package data;
import entities.GameEntity;
import java.util.ArrayList;
public class LevelContainer{
    private ArrayList<GameEntity> entities;
    
    public LevelContainer(){
        entities=new ArrayList<>();
        // implement
    }
    
    // getter methods
    public ArrayList<GameEntity> getEntities(){return entities;}
    
    // setter methods
    public void setEntities(ArrayList<GameEntity> param){entities=param;}
}