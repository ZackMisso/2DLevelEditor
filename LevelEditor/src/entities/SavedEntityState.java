/**
 *
 * @author Zackary Misso
 * This class contains the data for saved entity states
 * 
 */
package entities;
import data.LevelContainer;
import entities.GameEntity;
import datastructures.StringToDouble;
import datastructures.StringToInt;
import java.util.ArrayList;
public class SavedEntityState{
    private LevelContainer reference;
    private ArrayList<String> ints;
    private ArrayList<String> doubles;
    private ArrayList<String> booleans;
    private ArrayList<String> bytes;
    private ArrayList<String> strings;
    private ArrayList<String> colors; // to be implemented
    private ArrayList<String> images; // to be implemented
    private ArrayList<String> entities;
    private String name;
    private boolean selected; // this is not needed
    
    // WILL NEED TO FIGURE OUT HOW TO ADD OBJECTS TO THIS LIST
    
    public SavedEntityState(){
        this(null);
    }
    
    public SavedEntityState(LevelContainer param){
        reference=param;
        ints=new ArrayList<>();
        doubles=new ArrayList<>();
        booleans=new ArrayList<>();
        strings=new ArrayList<>();
        colors=new ArrayList<>();
        images=new ArrayList<>();
        bytes=new ArrayList<>();
        entities=new ArrayList<>();
        name="";
        selected=false; //?????
    }

    // creates the initial setup for the Saved Entity State
    public void createDefaultState(){
        if(ints.isEmpty()&&doubles.isEmpty()&&booleans.isEmpty()&&strings.isEmpty()){
            ints.add("startX");
            ints.add("startY");
            //booleans.add("facingRight"); This is not needed for MARIO
        }else{
            System.out.println("Minor Error :: Already Initialized :: SavedEntityState");
        }
        System.out.println("Change Was Made Test :: SavedEntityState");
    }
    
    // adds an addable integer object
    public void addIntForKey(String key){
        ints.add(key);
        if(reference!=null){
        	// implement the change in every current entity
        	ArrayList<GameEntity> entities=reference.getEntities();
        	for(int i=0;i<entities.size();i++){
        		EntityState state=entities.get(i).getState();
        		if(this==state.getReference()){
        			StringToInt temp=new StringToInt();
         			temp.setKey(key);
        			state.getInts().add(temp);
        		}
        	}
        	// implement changing the entities in the other levels
        }else{
        	System.out.println("Major Error :: LevelContainer null :: SavedEntityState");
        }
    }
    
    // adds an addable double object
    public void addDoubleForKey(String key){
        doubles.add(key);
        if(reference!=null){
        	// implement the change in every current entity
        	ArrayList<GameEntity> entities=reference.getEntities();
        	for(int i=0;i<entities.size();i++){
        		EntityState state=entities.get(i).getState();
        		if(state.getReference()==this){
        			StringToDouble temp=new StringToDouble();
        			temp.setKey(key);
        			state.getDoubles().add(temp);
        		}
        	}
        	// implement changing the entities in the other levels.
        }else{
        	System.out.println("Major Error :: LevelContainer null :: SavedEntityState");
        }
    }
    
    // adds an addable boolean object
    public void addBooleanForKey(String key){
        booleans.add(key);
        if(reference!=null){
        	// implement the change in every current entity
        }else{
        	System.out.println("Major Error :: LevelContainer null :: SavedEntityState");
        }
    }
    
    // adds an addable string object
    public void addStringForKey(String key){
        strings.add(key);
        if(reference!=null){
        	// implement the change in every current entity
        }else{
        	System.out.println("Major Error :: LevelContainer null :: SavedEntityState");
        }
    }

    // adds an addable byte object
    public void addByteForKey(String key){
        // implement
    }

    // adds an addable color object
    public void addColorForKey(String key){
        // implement
    }

    // adds an addable image object
    public void addImageForKey(String key){
        // implement
    }
    
    // returns the description of this type of entity as a string
    public String writeDescription(){
        // implement
        return "";
    }
    
    // getter methods
    public LevelContainer getReference(){return reference;}
    public ArrayList<String> getInts(){return ints;}
    public ArrayList<String> getBytes(){return bytes;}
    public ArrayList<String> getDoubles(){return doubles;}
    public ArrayList<String> getBooleans(){return booleans;}
    public ArrayList<String> getStrings(){return strings;}
    public ArrayList<String> getColors(){return colors;}
    public ArrayList<String> getImages(){return images;}
    public ArrayList<String> getEntities(){return entities;}
    public String getName(){return name;}
    
    // setter methods
    public void setReference(LevelContainer param){reference=param;}
    public void setInts(ArrayList<String> param){ints=param;}
    public void setBytes(ArrayList<String> param){bytes=param;}
    public void setDoubles(ArrayList<String> param){doubles=param;}
    public void setBooleans(ArrayList<String> param){booleans=param;}
    public void setStrings(ArrayList<String> param){strings=param;}
    public void setColors(ArrayList<String> param){colors=param;}
    public void setImages(ArrayList<String> param){images=param;}
    public void setEntities(ArrayList<String> param){entities=param;}
    public void setName(String param){name=param;}
}