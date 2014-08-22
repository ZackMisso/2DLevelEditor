/**
 *
 * @author Zackary Misso
 * This class represents a view that allows the user to change the global settings
 */
package views.temporaries;
import views.TemporaryView;
import views.major.OptionView;
import views.minor.NumberInput;
import views.minor.Label;
import data.GlobalSettings;
public class GlobalSettingsView implements TemporaryView{
    private OptionView reference;
    private GlobalSettings settings;
    private Label title;
    private NumberInput askTileSize;
    
    public GlobalSettingsView(){
        reference=null;
        settings=null;
        askTileSize=null;
    }
    
    @Override // initializes the view
    public void initializeView(){
        settings=reference.findGrandView().getSettings();
        title=new Label();
        title.setText("What do you want the tile size to be?");
        title.setXpos(xpos);
        title.setYpos(ypos+50);
        title.setSuperview(reference);
        reference.getSubviews().add(title);
        askTileSize=new NumberInput();
        askTileSize.setXpos(xpos);
        askTileSize.setYpos(ypos+270);
        askTileSize.setContents(settings.getTileSize()+"");
        askTileSize.setSuperview(reference);
        reference.getSubviews().add(askTileSize);
    }
    
    @Override // clears the view
    public void clearView(){
        reference.getSubviews().remove(title);
        reference.getSubviews().remove(askTileSize);
        reference=null;
        settings=null;
        title=null;
        askTileSize=null;
    }
    
    @Override // accepts the changes
    public void acceptView(){
        settings.turnOnTiled(askTileSize.getContentsAsInt());
        clearView();
    }
    
    @Override // rejects the changes
    public void rejectView(){
        clearView();
    }

    // setter methods
    @Override public void setReference(OptionView param){reference=param;}
}