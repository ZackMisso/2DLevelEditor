/**
 *
 * @author ZackMisso
 * This class contains what objects in the view are currently selected
 * 
 */
package core;
import views.View;
import entities.GameEntity;
import entities.EntityState;
import data.Area;
public class InputController {
    private GameEntity selectedEntity;
    // change these to selectable labels
    private Area selectedArea;
    private EntityState selectedState;
    ////////////////////////////////////
    private View selectedView;
    private char typed; // may contain the characted that was typed
    
    public InputController(){ // default constructor
        selectedEntity=null;
        selectedView=null;
        selectedArea=null;
        selectedState=null;
        typed=0;
    }
    
    // deselects the selected entity
    public void deselectSelectedEntity(){
        selectedEntity.setSelected(false);
        selectedEntity=null;
    }
    
    // deselects the selected area
    public void deselectSelectedArea(){
        selectedArea.setSelected(false);
        selectedArea=null;
    }
    
    // deselects the selected view
    public void deselectSelectedView(){
        selectedView.setSelected(false);
        selectedView=null;
    }
    
    // handles the types
    public void handleType(char c){
        if(selectedView!=null)
            selectedView.types(c);
        else
            System.out.println("Minor Error :: No Selected View :: InputController");
        // maybe implement more later
    }
    
    // getter methods
    //public GameEntity getSelectedEntity(){return selectedEntity;}
    //public Area getSelectedArea(){return selectedArea;}
    //public EntityState getSelectedState(){return selectedState;}
    public View getSelectedView(){return selectedView;}
    //public char getTyped(){return typed;}
    
    // setter methods
    //public void setSelectedEntity(GameEntity param){selectedEntity=param;}
    //public void setSelectedArea(Area param){selectedArea=param;}
    //public void setSelectedState(EntityState param){selectedState=param;}
    public void setSelectedView(View param){selectedView=param;}
    //public void setTyped(char param){typed=param;}
}