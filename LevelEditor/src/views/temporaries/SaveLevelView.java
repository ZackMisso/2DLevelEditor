/**
 *
 * @author Zackary Misso
 * This contains the logic for a temporary view that loads the desired level
 * 
 */
package views.temporaries;
import views.TemporaryView;
import views.major.OptionView;
public class SaveLevelView implements TemporaryView{
    private OptionView reference;
    
    public SaveLevelView(){
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
