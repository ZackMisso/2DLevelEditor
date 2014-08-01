/**
 *
 * @author Zackary Misso
 * This class converts all of the data created in the program into level files
 * 
 */
package io;
import views.major.GrandView;
import entities.GameEntity;
import entities.SavedEntityState;
import java.util.ArrayList;
//import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
//import java.io.File;
public class WorldWriter{
    private GrandView reference;
    
    public WorldWriter(GrandView param){ // default constructor
        reference=param;
    }
    
    // writes the entire game save data from storage
    public void writeWorld(){
        //System.out.println("Saving Level :: WorldWriter");
        String data="";
        ArrayList<GameEntity> objects=reference.getLevel().getEntities();
        for(int i=0;i<objects.size();i++)
            data+=objects.get(i).writeData();
        //System.out.println(data+" :: WorldWriter");
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("firstLevel.txt"));
            writer.write(data);
            //System.out.println("TEST 1 :: WorldWriter");
            writer.close();
        }catch(IOException e){
            System.out.println("Major Error :: IO Error :: WorldWriter");
        }
        //try{
        //    Scanner scanner=new Scanner(new File("firstLevel.txt"));
        //    System.out.println("Check :: "+scanner.nextLine()+" :: WorldWriter");
        //}catch(IOException e){
        //    System.out.println("Check Cant Read File :: WorldWriter");
        //}
    }

    // writes the Saved Entity States from a file
    public void writeSavedStates(){
        String data;
        ArrayList<SavedEntityState> states=reference.getConfigs();
        //for(int i=0;i<states.size();i++)
        //    data+=states.get(i).writeData();
        //try{
        //    BufferedWriter writer=new BufferedWriter(new FileWriter("savedStates.txt"));
        //    writer.write(data);
        //    writer.close();
        //}catch(IOException e){
        //    System.out.println("Major Error :: IO Error :: WorldWriter");
        //}
    }
}