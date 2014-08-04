/**
 *
 * @author Zackary Misso
 * A temporary view allowing the user to add an entity state
 * 
 */
package views.temporaries;
import views.TemporaryView;
import views.major.GrandView;
import views.major.OptionView;
import views.minor.TextBox;
import entities.SavedEntityState;
public class AddEntityStateView implements TemporaryView{
    private OptionView reference;
    private TextBox askName;
    
    public AddEntityStateView(){
        super();
        reference=null;
    }
    
    // xpos = 600
    // ypos=300
    
    @Override // initializes the view
    public void initializeView(){
        System.out.println("Initializing Add Entity State");
        askName=new TextBox(20);
        askName.setXpos(xpos);
        askName.setYpos(ypos+270);
        askName.setSuperview(reference);
        reference.getSubviews().add(askName);
        //getSubviews().add(askName);
    }
    
    @Override // clears the view
    public void clearView(){
        reference.getSubviews().remove(askName);
        reference.setTemporary(null);
        askName=null;
        reference.setAddEntityState(false);
        reference.refactorViews();
    }
    
    @Override // accepts the changes
    public void acceptView(){
        if(!askName.getContents().equals("")){
            SavedEntityState add=new SavedEntityState();
            add.setName(askName.getContents());
            add.createDefaultState();
            GrandView view=reference.findGrandView();
            view.getConfigs().add(add);
            view.getSavedStates().refactorLabels();
        }else
            System.out.println("Minor Error :: text field blank :: OptionView");
        clearView();
    }
    
    @Override // rejects the changes
    public void rejectView(){
        clearView();
    }
    
    // getter methods
    public OptionView getReference(){return reference;}
    public TextBox getAskName(){return askName;}
    
    // setter methods
    @Override public void setReference(OptionView param){reference=param;}
    public void setAskName(TextBox param){askName=param;}
}