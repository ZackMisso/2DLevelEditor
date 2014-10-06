/**
 *
 * @author ZackMisso
 * This classes main functionality is to test the WorldReader and WorldWriter implementations
 * 
 */
package tests;
import data.GlobalSettings;
import io.WorldReader;
import io.WorldWriter;
import entities.GameEntity;
import java.util.ArrayList;
public class IOUnitTester{
    private WorldReader reader;
    private WorldWriter writer;
    
    public IOUnitTester(){
        reader=new WorldReader();
        writer=new WorldWriter();
        //testReadImages();
        testMakeTileMap();
    }
    
    // unit test to check the make tile map method in WorldWriter
    private void testMakeTileMap(){
        ArrayList<GameEntity> entities=new ArrayList<>();
        GlobalSettings.tileSize=16;
        for(int i=0;i<16*8;i+=32)
            for(int f=0;f<16*8;f+=16)
                entities.add(new GameEntity(f,i));
        int[][] map=writer.makeTileMap(entities);
        for(int i=0;i<map.length;i++){
            for(int f=0;f<map[0].length;f++)
                System.out.print(map[i][f]);
            System.out.println();
        }
        System.out.println();
        System.out.println("Should be 8 alternating rows of ones and zeros");
    }
    
    // unit test to check the world readers readImageNames function
    private boolean testReadImages(){
        // named after image files
        boolean floor=false;
        boolean mario=false;
        ArrayList<String> imgs=reader.readImageNames();
        if(imgs.contains("floor.png"))
            floor=true;
        if(imgs.contains("mario.png"))
            mario=true;
        if(mario&&floor)
            return true;
        else
            for(int i=0;i<imgs.size();i++)
                System.out.println(imgs.get(i));
        return false;
    }
}