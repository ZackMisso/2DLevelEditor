/**
 *
 * @author Zackary Misso
 * This class contains all of the areas
 * TO BE IMPLEMENTED
 * 
 */
package data;
import views.major.AreaView;
import java.util.ArrayList;
public class AreaController{
    // Convert this to string storage later to save space
    //private ArrayList<String> areas;
    //private Area currentArea;
    private AreaView reference;
    private ArrayList<Area> areas;
    private int currentIndex;
    
    // default constructor
    public AreaController(){
        // implement
    }
    
    // loads the area at the given index in the array
    public void loadAreaForIndex(int index){
        // implement
    }
    
    // returns all of the data in the areas as a string
    public String writeAreas(){
        String temp="";
        for(int i=0;i<areas.size();i++)
            temp+=areas.get(i).writeArea();
        return temp;
    }
    
    // getter methods
    //public ArrayList<String> getAreas(){return areas;}
    //public Area getCurrentArea(){return currentArea;}
    public AreaView getReference(){return reference;}
    public ArrayList<Area> getAreas(){return areas;}
    public int getCurrentIndex(){return currentIndex;}
    
    // setter methods
    //public void setAreas(ArrayList<String>param){areas=param;}
    //public void setCurrentArea(Area param){currentArea=param;}
    public void setReference(AreaView param){reference=param;}
    public void setAreas(ArrayList<Area> param){areas=param;}
    public void setCurrentIndex(int param){currentIndex=param;}
}
