/**
 *
 * @author Zackary Misso
 * This class contains the global options that are changeable by the user.
 * 
 */
package data;
public class GlobalSettings {
    private int tileSize;
    private boolean grid;
    private boolean tiled;
    
    public GlobalSettings(){
        tileSize=0;
        grid=false;
        tiled=false;
    }
    
    public void turnOnTiled(int size){
        tileSize=size;
        grid=true;
        tiled=true;
        if(size==0)
            turnOffTiled();
    }
    
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
