/**
 *
 * @author Zackary Misso
 * This class contains the logic for a view that allows the user to select an image for the game
 * 
 */
package views.temporaries;
import views.TemporaryView;
import views.major.OptionView;
import java.util.ArrayList;
public class SelectImageView implements TemporaryView{
    private OptionView reference;
    
    public SelectImageView(){ // default constructor
        reference=null;
    }
    
    // initializes the view
    @Override public void initializeView(){
        initializeScrollables();
        // implement
    }
    
    private void initializeScrollables(){
        ArrayList<String> imgs=reference.findGrandView().getReader().readImageNames();
        
        // implement
    }

    @Override public void acceptView(){
        // implement
    }
    
    @Override public void rejectView(){
        // implement
    }
    
    @Override public void clearView(){
        reference=null;
        // implement
    }
    
    // setter methods
    @Override public void setReference(OptionView param){reference=param;}
}
