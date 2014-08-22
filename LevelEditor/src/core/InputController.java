/**
 *
 * @author ZackMisso
 * This class contains what objects in the view are currently selected
 * 
 */
package core;
import views.View;
public class InputController {
    private View selectedView;
    private char typed; // may contain the characted that was typed
    
    public InputController(){ // default constructor
        selectedView=null;
        typed=0;
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
    public View getSelectedView(){return selectedView;}
    
    // setter methods
    public void setSelectedView(View param){selectedView=param;}
}