/**
 *
 * @author Zackary Misso
 * This class contains the logic for a temporary view that loads in a level
 * 
 */
package views.temporaries;
import views.TemporaryView;
import views.major.OptionView;
public class LoadLevelView implements TemporaryView{
    private OptionView reference;
    
    public LoadLevelView(){
        // implement
    }
    
    public void initializeView(){
        // implement
    }
    
    public void clearView(){
        reference=null;
        // implement
    }
    
    public void rejectView(){
        clearView();
        // implement
    }
    
    public void acceptView(){
        // implement
        clearView();
    }
    
    // setter methods
    public void setReference(OptionView param){reference=param;}
}