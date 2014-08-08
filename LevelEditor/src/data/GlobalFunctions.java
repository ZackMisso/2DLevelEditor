/**
 *
 * @author Zack Misso
 * This class contains some static functions that can be used to easily edit
 * datastructures throughout the entire project. NOTE :: Not all of these will
 * be used for every project
 * 
 */
package data;
import views.major.GrandView;
import entities.GameEntity;
import entities.EntityState;
import entities.SavedEntityState;
import datastructures.StringToBool;
import datastructures.StringToByte;
import datastructures.StringToColor;
import datastructures.StringToDouble;
import datastructures.StringToEntity;
import datastructures.StringToImage;
import datastructures.StringToInt;
import datastructures.StringToString;
import java.util.ArrayList;
public class GlobalFunctions {
    // adds the specified bool object to all entities in current project
    public static void addBoolToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getBooleans().add(name);
        for(int i=0;i<entities.size();i++){
            EntityState state=entities.get(i).getState();
            StringToBool data=new StringToBool(name,false);
            state.getBooleans().add(data);
        }
    }
    
    // add the specified byte object to all entities in current project
    public static void addByteToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getBytes().add(name);
        for(int i=0;i<entities.size();i++){
            EntityState state=entities.get(i).getState();
            StringToByte data=new StringToByte(name,(byte)0);
            state.getBytes().add(data);
        }
    }
    
    // adds the specified color object to all entities in current project
    public static void addColorToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getColors().add(name);
        for(int i=0;i<entities.size();i++){
            EntityState state=entities.get(i).getState();
            StringToColor data=new StringToColor(name,null);
            state.getColors().add(data);
        }
    }
    
    // adds the specified double object to all entities in current project
    public static void addDoubleToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getDoubles().add(name);
        for(int i=0;i<entities.size();i++){
            EntityState state=entities.get(i).getState();
            StringToDouble data=new StringToDouble(name,0.0);
            state.getDoubles().add(data);
        }
    }
    
    // adds the specified entity object to all entities in current project
    public static void addEntityToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getEntities().add(name);
        for(int i=0;i<entities.size();i++){
            EntityState state=entities.get(i).getState();
            StringToEntity data=new StringToEntity(name,null);
            state.getEntities().add(data);
        }
    }
    
    // adds the specified image object to all entities in current project
    public static void addImageToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getImages().add(name);
        for(int i=0;i<entities.size();i++){
            EntityState state=entities.get(i).getState();
            StringToImage data=new StringToImage(name,null);
            state.getImages().add(data);
        }
    }
    
    // adds the specified int to all the entities in all current projects
    public static void addIntToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getInts().add(name);
        for(int i=0;i<entities.size();i++){
            EntityState state=entities.get(i).getState();
            StringToInt data=new StringToInt(name,0);
            state.getInts().add(data);
        }
    }
    
    // adds the specified string to all the entities in all current projects
    public static void addStringToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getStrings().add(name);
        for(int i=0;i<entities.size();i++){
            EntityState state=entities.get(i).getState();
            StringToString data=new StringToString(name,"");
            state.getStrings().add(data);
        }
    }
    
    public static void removeBoolToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getBooleans().remove(name);
        // implement
    }
    
    public static void removeByteToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getBytes().remove(name);
        // implement
    }
    
    public static void removeColorToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getColors().remove(name);
        // implement
    }
    
    public static void removeDoubleToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getDoubles().remove(name);
        // implement
    }
    
    public static void removeEntityToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getEntities().remove(name);
        // implement
    }
    
    public static void removeImageToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getImages().remove(name);
        // implement
    }
    
    public static void removeIntToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getInts().remove(name);
        // implement
    }
    
    public static void removeStringToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        for(int i=0;i<saved.size();i++)
            saved.get(i).getStrings().remove(name);
        // implement
    }
    
    // TODO :: Possibly add some function at the end of the previous methods
    // to update some views that use the entity states.
}