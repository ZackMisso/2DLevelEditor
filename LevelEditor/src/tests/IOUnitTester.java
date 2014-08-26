/**
 *
 * @author ZackMisso
 * This classes main functionality is to test the WorldReader and WorldWriter implementations
 * 
 */
package tests;
import io.WorldReader;
import io.WorldWriter;
import java.util.ArrayList;
public class IOUnitTester{
    private WorldReader reader;
    private WorldWriter writer;
    
    public IOUnitTester(){
        reader=new WorldReader();
        writer=new WorldWriter();
        testReadImages();
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