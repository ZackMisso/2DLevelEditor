/**
 *
 * @author Zackary Misso
 * A temporary view that allows the user to remove an entity state
 * 
 */
package views.temporaries;
import views.TemporaryView;
import views.major.GrandView;
import views.major.OptionView;
import views.major.SavedEntityStateView;
import views.major.EntityStateView;
import views.minor.SelectableLabel;
import views.minor.Label;
import entities.SavedEntityState;
import java.util.ArrayList;
public class RemoveEntityStateView implements TemporaryView{
    private OptionView reference;
    private Label title;
    
    public RemoveEntityStateView(){
        // implement
    }

    @Override // initializes the view
    public void initializeView(){
        title=new Label();
        title.setText("Would You Really Like To Delete This Saved State");
        title.setXpos(xpos+4);
        title.setYpos(ypos+100);
        title.setSuperview(reference);
        reference.getSubviews().add(title);
    }
    
    @Override // clears the view
    public void clearView(){
        reference.getSubviews().remove(title);
        reference.setRemoveEntityState(false);
        reference.clearCurrentView();
        title=null;
        reference=null;
    }
    
    @Override // accepts the changes
    public void acceptView(){
        SavedEntityState state=(SavedEntityState)reference.getReferenceObject();
        GrandView view=reference.findGrandView();
        SavedEntityStateView sesv=view.getSavedStates();
        EntityStateView esv=view.getEntityState();
        ArrayList<SelectableLabel> labels=sesv.getScrollablesAsLabels();
        if(state==null){
            System.out.println("Major Error :: State Null :: OptionView");
            return;
        }
        String name=state.getName();
        view.getConfigs().remove(state);
        for(int i=0;i<labels.size();i++)
            if(labels.get(i).getText().equals(name))
                sesv.getSubviews().remove(labels.remove(i--));
        sesv.refactorLabels();
        esv.setCurrent(null);
        esv.redrawView();
        clearView();
    }
    
    @Override // rejects the changes
    public void rejectView(){
        clearView();
    }
    
    @Override // setter methods
    public void setReference(OptionView param){reference=param;}
}