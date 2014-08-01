/**
 *
 * @author Zackary Misso
 * This class reads the world and other assets from a file
 * 
 */
package io;
import views.major.GrandView;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Image;
public class WorldReader{
    private final GrandView reference;
    
    public WorldReader(GrandView param){ // default constructor
        reference=param;
    }
    
    // reads the entire game save data from storage
    public void readWorld(){
        // implement
    }
    
    // reads the names of the stored image files from storage
    public ArrayList<String> readImageNames(){
        ArrayList<String> names=new ArrayList<>();
        // implement
        return names;
    }
    
    // reads the images of the stored image files from storage
    public ArrayList<Image> readImages(){
        ArrayList<Image> images=new ArrayList<>();
        // implement
        return images;
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
}