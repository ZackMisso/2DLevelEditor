/**
 *
 * @author Zackary Misso
 * This class is a hack to skip over the search for an
 * image to represent units. This will need to be fixed
 * for implementation with future projects
 * THIS WILL NOT BE USED IN FINAL PROJECT
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
            mario.setValue(ImageIO.read(new File("src/resources/marioBig.png")));
            images.add(mario);
            // floor
            StringToImage floor=new StringToImage();
            floor.setKey("floor");
            floor.setValue(ImageIO.read(new File("src/resources/floor.png")));
            images.add(floor);
            // block
            StringToImage block=new StringToImage();
            block.setKey("block");
            block.setValue(ImageIO.read(new File("src/resources/block.png")));
            images.add(block);
            // breakableBlock
            StringToImage breakableblock=new StringToImage();
            breakableblock.setKey("breakableblock");
            breakableblock.setValue(ImageIO.read(new File("src/resources/breakableBlock.png")));
            images.add(breakableblock);
            // castle
            StringToImage castle=new StringToImage();
            castle.setKey("castle");
            castle.setValue(ImageIO.read(new File("src/resources/castle.png")));
            images.add(castle);
            // goomba
            StringToImage goomba=new StringToImage();
            goomba.setKey("goomba");
            goomba.setValue(ImageIO.read(new File("src/resources/goomba.png")));
            images.add(goomba);
            // itemblock
            StringToImage itemblock=new StringToImage();
            itemblock.setKey("itemblock");
            itemblock.setValue(ImageIO.read(new File("src/resources/itemblock.png")));
            images.add(itemblock);
            // koopa
            StringToImage koopa=new StringToImage();
            koopa.setKey("koopa");
            koopa.setValue(ImageIO.read(new File("src/resources/koopa.png")));
            images.add(koopa);
            // pipe2x2
            StringToImage pipe2x2=new StringToImage();
            pipe2x2.setKey("pipe2x2");
            pipe2x2.setValue(ImageIO.read(new File("src/resources/pipe2x2.png")));
            images.add(pipe2x2);
            // pipe2x3
            StringToImage pipe2x3=new StringToImage();
            pipe2x3.setKey("pipe2x3");
            pipe2x3.setValue(ImageIO.read(new File("src/resources/pipe2x3.png")));
            images.add(pipe2x3);
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
