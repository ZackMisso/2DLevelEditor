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

    @Override // initializes the view
    public void initializeView(){
        clearView();
    }
    
    @Override // clears the view
    public void clearView(){
        reference.setRemoveEntityStateObj(false);
        // implement
    }
    
    @Override // accepts the changes
    public void acceptView(){
        // impmlement
    }
    
    @Override // rejects the changes
    public void rejectView(){
        // implement
    }
    
    // getter methods
    public OptionView getReference(){return reference;}
    
    @Override // setter methods
    public void setReference(OptionView param){reference=param;}
}
