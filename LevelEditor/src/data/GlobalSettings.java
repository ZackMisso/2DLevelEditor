/**
 *
 * @author Zackary Misso
 * This class contains the global options that are changeable by the user.
 * 
 */
package data;
public class GlobalSettings {
    public static int tileSize; // the length of a side of a cell in px.
    private boolean grid; // if the level editor is displaying the grid
    public static boolean tiled; // if the game runs on tile physics (to be implemented)
    
    public GlobalSettings(){ // default constructor
        tileSize=0;
        grid=false;
        tiled=false;
    }
    
    // turn on tile physics implementation (to be finished)
    public void turnOnTiled(int size){
        tileSize=size;
        grid=true;
        tiled=true;
        System.out.println("SIZE :: "+size);
        if(size==0)
            turnOffTiled();
    }
    
    // turn off tile physics implementation
    public void turnOffTiled(){
        tileSize=0;
        grid=false;
        tiled=false;
    }
    
    // getter methods
    public int getTileSize(){return tileSize;}
    public boolean getGrid(){return grid;}
    public boolean getTiled(){return tiled;}
    
    // setter methods
    public void setTileSize(int param){tileSize=param;}
    public void setGrid(boolean param){grid=param;}
    public void setTiled(boolean param){tiled=param;}
}
