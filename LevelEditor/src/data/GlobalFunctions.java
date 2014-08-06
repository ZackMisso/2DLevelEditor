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
import java.util.ArrayList;
public class GlobalFunctions {
    // adds the specified bool object to all entities in current project
    public static void addBoolToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        // implement
    }
    
    // add the specified byte object to all entities in current project
    public static void addByteToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        // implement
    }
    
    // adds the specified color object to all entities in current project
    public static void addColorToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        // implement
    }
    
    // adds the specified double object to all entities in current project
    public static void addDoubleToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        // implement
    }
    
    // adds the specified entity object to all entities in current project
    public static void addEntityToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        // implement
    }
    
    // adds the specified image object to all entities in current project
    public static void addImageToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        // implement
    }
    
    // adds the specified int to all the entities in all current projects
    public static void addIntToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        // implement
    }
    
    // adds the specified string to all the entities in all current projects
    public static void addStringToAllEntities(String name,GrandView reference){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        ArrayList<SavedEntityState> saved=reference.getConfigs();
        // implement
    }
}