/**
 *
 * @author Zackary Misso
 * This class is a hack to skip over the search for an
 * image to represent units. This will need to be fixed
 * for implementation with future projects
 * 
 */
package data;
import datastructures.StringToImage;
import java.awt.Image;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ManualGraphics{
    private ArrayList<StringToImage> images;
    
    // default constructor
    public ManualGraphics(){
        images=new ArrayList<>();
        initializeImages();
    }
    
    // reads the images into the list
    private void initializeImages(){
        try{
            // mario
            StringToImage mario=new StringToImage();
            mario.setKey("mario");
            mario.setValue(ImageIO.read(new File("src/resources/mario.png")));
            images.add(mario);
            // floor
            StringToImage floor=new StringToImage();
            floor.setKey("floor");
            floor.setValue(ImageIO.read(new File("src/resources/floor.png")));
            images.add(floor);
        // implement
        }catch(IOException e){
            System.out.println("MajorError :: Cant Read Images :: ManualGraphics");
        }
    }
    
    // returns the image if there is a match
    public Image getMatch(String name){
        for(int i=0;i<images.size();i++)
            if(images.get(i).getKey().equals(name))
                return images.get(i).getValue();
        return null;
    }
}
