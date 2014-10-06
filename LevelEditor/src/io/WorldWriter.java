/**
 *
 * @author Zackary Misso
 * This class converts all of the data created in the program into level files
 * NOT FULLY IMPLEMENTED
 * 
 */
package io;
import data.GlobalSettings;
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
    private int startX;
    private int startY;
    
    public WorldWriter(){ // constructor used for unit tests
        reference=null;
    }
    
    public WorldWriter(GrandView param){ // default constructor
        reference=param;
    }
    
    // writes the entire game save data from storage
    public void writeWorld(){
        //System.out.println("Saving Level :: WorldWriter");
        String data="";
        ArrayList<GameEntity> objects=reference.getLevel().getEntities();
        if(GlobalSettings.tiled)
            data+=writeTileMap();
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
    
    // writes the TileMap to a file
    // Tile Map Settings ::
    // Tile
    // startX
    // startY
    // width
    // height
    // data array
    private String writeTileMap(){
        ArrayList<GameEntity> entities=reference.getLevel().getEntities();
        int[][] tileMap=makeTileMap(entities);
        String data="Tile\n"+startX+"\n"+startY+"\n"+tileMap[0].length+"\n"+tileMap.length+"\n";
        for(int i=0;i<tileMap.length;i++){
            for(int f=0;f<tileMap[0].length;f++)
                data+=tileMap[i][f]+" ";
            data+="\n";
        }
        return data;
    }
    
    // creates the tile map based on the entities on the screen
    // ERROR :: Currently assumes blocks are only one block size
    public int[][] makeTileMap(ArrayList<GameEntity> entities){
        int width=1;
        int height=1;
        startX=entities.get(0).getStartX();
        startY=entities.get(0).getStartY();
        int tileSize=GlobalSettings.tileSize;
        // get the dimensions of the tileMap
        for(int i=1;i<entities.size();i++){
            int entX=entities.get(i).getStartX();
            int entY=entities.get(i).getStartY();
            //boolean block=entities.get(i).isBlock();
            if(entX<startX){
                if((startX-entX)/tileSize==0)
                    System.out.println("Zero added");
                width+=((startX-entX)/tileSize);
                startX=entX;
            }
            if(entY<startY){
                height+=((startY-entY)/tileSize);
                startY=entY;
            }
            if(entX>startX+width*tileSize){
                //int temp=width;
                width+=((entX-(startX+width*tileSize))/tileSize);
                //if(temp>width)
                //    System.out.println("BUG HAS BEEN FOUND");
            }
            if(entY>startY+height*tileSize){
                //int temp=height;
                height+=((entY-(startY+height*tileSize))/tileSize);
                //if(temp>height)
                //    System.out.println("BUG HAS BEEN FOUND");
            }
        }
        // height=6
        // width=7
        // both == 8
        height++;
        width++;
        // Create the tileMap
        int[][] tileMap=new int[height][width];
        System.out.println("Width :: "+width+" Height :: "+height);
        for(int i=0;i<entities.size();i++){
            boolean block=entities.get(i).isBlock();
            if(block){
                int xpos=(entities.get(i).getStartX()-startX)/tileSize;
                //System.out.println(xpos);
                int ypos=(entities.get(i).getStartY()-startY)/tileSize;
                tileMap[ypos][xpos]=1;
            }
        }
        return tileMap;
    }
}