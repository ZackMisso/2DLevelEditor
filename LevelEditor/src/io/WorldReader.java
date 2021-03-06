/**
 *
 * @author Zackary Misso
 * This class reads the world and other assets from a file
 * TO BE IMPLEMENTED
 * 
 */
package io;
import views.major.GrandView;
import data.GlobalSettings;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Image;
import java.io.File;
public class WorldReader{
    private final GrandView reference;
    private final File resources;
    
    public WorldReader(){ // constructor used for unit tests
        this(null);
    }
    
    public WorldReader(GrandView param){ // default constructor
        reference=param;
        resources=new File("src/resources");
    }
    
    // reads the entire game save data from storage
    public void readWorld(){
        // implement
    }
    
    // reads the names of the stored image files from storage
    public ArrayList<String> readImageNames(){
        ArrayList<String> names=new ArrayList<>();
        if(resources.isDirectory()){
            File[] images=resources.listFiles(new ImageFilter());
            for(File file : images)
                names.add(file.getName());
        }else
            System.out.println("Major Error :: WorldReader :: Cant Find Resources");
        return names;
    }
    
    // reads the images of the stored image files from storage
    public ArrayList<Image> readImages(){
        ArrayList<Image> images=new ArrayList<>();
        // implement
        return images;
    }
    
    // just reads the names of the saved levels
    public ArrayList<String> readSavedLevelNames(){
        ArrayList<String> names=new ArrayList<>();
        // implement
        return null;
    }
    
    // reads the Saved Entity States from a file
    /*public void readSavedStates(){
        ArrayList<SavedEntityState> states=new ArrayList<>();
        try{
            Scanner scanner=new Scanner(new File("savedStates.txt"));
            String str=scanner.nextLine();
            while(!str.equals("End"))
                states.add(readState(scanner));
            return states;
        }catch(IOException e){
            System.out.println("Major Error :: IO Error :: WorldWriter");
            return null;
        }
    }

    // reads a single state
    private SavedEntityState readState(Scanner scanner){
        SavedEntityState state=new SavedEntityState();
        state.setName(str);
        String ints=scanner.nextLine();
        ArrayList<String> objects=readList(scanner);
        state.setInts(objects);
        String doubles=scanner.nextLine();
        objects=readList(scanner);
        state.setDoubles(objects);
        String booleans=scanner.nextLine();
        objects=readList(scanner);
        state.setBooleans(objects);
        String bytes=scanner.nextLine();
        objects=readList(scanner);
        state.setBytes(objects);
        String strings=scanner.nextLine();
        objects.readList(scanner);
        state.setStrings(objects);
        Strings colors=scanner.nextLine();
        colors.readList(scanner);
        state.setColors(objects);
        String images=scanner.nextLine();
        images.readList(scanner);
        state.setImages(objects);
        return state;
    }

    // abstract method to read the list of object names
    private ArrayList<String> readList(Scanner scanner){
        ArrayList<String> names;
        String str=scanner.nextLine();
        while(!str.equals("End"))
            names.add(str);
        return names;
    }*/
    
    // reads the past global settings from a file
    public GlobalSettings readSettings(){
        // implement
        return new GlobalSettings();
    }
}