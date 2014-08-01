/**
 *
 * @author Zackary Misso
 * This class represents a key-value mapping where the key is a string and the value is a user defined entity
 * 
 */
package datastructures;
import entities.GameEntity;
public class StringToEntity {
    private String key;
    private GameEntity value;
    
    public StringToEntity(){
        key="";
        value=null;
    }
    
    // getter methods
    public String getKey(){return key;}
    public GameEntity getValue(){return value;}
    
    // setter methods
    public void setKey(String param){key=param;}
    public void setValue(GameEntity param){value=param;}
}
