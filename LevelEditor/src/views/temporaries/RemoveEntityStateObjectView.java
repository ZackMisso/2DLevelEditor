/**
 *
 * @author Zackary Misso
 * A temporary view that allows the user to remove an object from an entity
 * 
 */
package views.temporaries;
import views.TemporaryView;
import views.major.OptionView;
public class RemoveEntityStateObjectView implements TemporaryView{
    private OptionView reference;
    
    public RemoveEntityStateObjectView(){
        // implement
    }

    // initializes the view
    @Override public void initializeView(){
        clearView();
    }
    
    // clears the view
    @Override public void clearView(){
        reference.setRemoveEntityStateObj(false);
        // implement
    }
    
    // accepts the changes
    @Override public void acceptView(){
        // impmlement
    }
    
    // rejects the changes
    @Override public void rejectView(){
        // implement
    }
    
    @Override // setter methods
    public void setReference(OptionView param){reference=param;}
}
