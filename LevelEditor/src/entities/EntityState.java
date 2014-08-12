/**
 *
 * @author Zackary Misso
 * This class defines a generic state for game entities.
 * 
 */
package entities;
import datastructures.StringToBool;
import datastructures.StringToByte;
import datastructures.StringToInt;
import datastructures.StringToDouble;
import datastructures.StringToString;
import datastructures.StringToColor;
import datastructures.StringToImage;
import datastructures.StringToEntity;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Image;
public class EntityState {
    // all the different types the object can contain
    private ArrayList<StringToByte> bytes;
    private ArrayList<StringToInt> ints;
    private ArrayList<StringToDouble> doubles;
    private ArrayList<StringToBool> booleans;
    private ArrayList<StringToString> strings;
    private ArrayList<StringToColor> colors;
    private ArrayList<StringToImage> images;
    private ArrayList<StringToEntity> entities;
    private SavedEntityState reference;
    // TODO :: FIGURE OUT HOW TO STORE OBJECTS
    
    public EntityState(){ // default constructor
        bytes=new ArrayList<>();
        ints=new ArrayList<>();
        doubles=new ArrayList<>();
        booleans=new ArrayList<>();
        strings=new ArrayList<>();
        colors=new ArrayList<>();
        images=new ArrayList();
        entities=new ArrayList<>();
    }

    // initializes the state from the reference
    public void initializeFromReference(){
        // ints
        for(int i=0;i<reference.getInts().size();i++)
            addIntForKey(0,reference.getInts().get(i));
        // doubles
        for(int i=0;i<reference.getDoubles().size();i++)
            addDoubleForKey(0.0,reference.getDoubles().get(i));
        // booleans
        for(int i=0;i<reference.getBooleans().size();i++)
            addBooleanForKey(false,reference.getBooleans().get(i));
        // bytes
        for(int i=0;i<reference.getBytes().size();i++)
            addByteForKey((byte)0,reference.getBytes().get(i));
        // strings
        for(int i=0;i<reference.getStrings().size();i++)
            addStringForKey("",reference.getBytes().get(i));
        // colors
        for(int i=0;i<reference.getColors().size();i++)
            addColorForKey(Color.black,reference.getColors().get(i));
        // images idk how to implement this one
        // also idk how to implement entities yet
    }
    
    // writes the state to a string for to be saved as a level file
    public String writeState(){
        String data="";
        data+=reference.getName()+"\n";
        for(int i=0;i<bytes.size();i++)
            data+=bytes.get(i).getKey()+" "+bytes.get(i).getValue()+"\n";
        for(int i=0;i<ints.size();i++)
            data+=ints.get(i).getKey()+" "+ints.get(i).getValue()+"\n";
        for(int i=0;i<doubles.size();i++)
            data+=doubles.get(i).getKey()+" "+doubles.get(i).getValue()+"\n";
        for(int i=0;i<booleans.size();i++)
            data+=booleans.get(i).getKey()+" "+booleans.get(i).getValue()+"\n";
        for(int i=0;i<strings.size();i++)
            data+=strings.get(i).getKey()+" "+strings.get(i).getValue()+"\n";
        for(int i=0;i<colors.size();i++){
            // to do later
        }
        for(int i=0;i<images.size();i++){
            // to do later
        }
        for(int i=0;i<entities.size();i++){
            // to do later
        }
        data+="End\n";
        // implement more if needed
        return data;
    }

    // Adds a byte to the respective keymap
    public void addByteForKey(byte one,String two){
        bytes.add(new StringToByte(two,one));
    }

    // Adds an integer to the respective keymap
    public void addIntForKey(int one,String two){
        ints.add(new StringToInt(two,one));
    }
    
    // Adds a double to the respective keymap
    public void addDoubleForKey(double one,String two){
        doubles.add(new StringToDouble(two,one));
    }
    
    // Adds a boolean to the respective keymap
    public void addBooleanForKey(boolean one,String two){
        booleans.add(new StringToBool(two,one));
    }
    
    // Adds a String to the respective keymap
    public void addStringForKey(String one,String two){
        strings.add(new StringToString(two,one));
    }

    // Adds a color to the respective keymap
    public void addColorForKey(Color one,String two){
        colors.add(new StringToColor(two,one));
    }
    
    // Adds an Image to the respective keymap
    public void addImageForKey(Image one,String two){
        images.add(new StringToImage(two,one));
    }
    
    // Adds am entitiy to the respective keymap
    public void addEntityForKey(GameEntity one,String two){
        entities.add(new StringToEntity(two,one));
    }
    
    // getter methods
    public ArrayList<StringToByte> getBytes(){return bytes;}
    public ArrayList<StringToInt> getInts(){return ints;}
    public ArrayList<StringToDouble> getDoubles(){return doubles;}
    public ArrayList<StringToBool> getBooleans(){return booleans;}
    public ArrayList<StringToString> getStrings(){return strings;}
    public ArrayList<StringToColor> getColors(){return colors;}
    public ArrayList<StringToImage> getImages(){return images;}
    public ArrayList<StringToEntity> getEntities(){return entities;}
    public SavedEntityState getReference(){return reference;}
    
    // setter methods
    public void setBytes(ArrayList<StringToByte> param){bytes=param;}
    public void setInts(ArrayList<StringToInt> param){ints=param;}
    public void setDoubles(ArrayList<StringToDouble> param){doubles=param;}
    public void setBooleans(ArrayList<StringToBool> param){booleans=param;}
    public void setStrings(ArrayList<StringToString> param){strings=param;}
    public void setColors(ArrayList<StringToColor> param){colors=param;}
    public void setImages(ArrayList<StringToImage> param){images=param;}
    public void setEntities(ArrayList<StringToEntity> param){entities=param;}
    public void setReference(SavedEntityState param){reference=param;}
}