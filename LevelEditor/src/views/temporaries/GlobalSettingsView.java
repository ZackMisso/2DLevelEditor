/**
 *
 * @author Zackary Misso
 * This class represents a view that allows the user to change the global settings
 */
package views.temporaries;
import views.TemporaryView;
import views.major.OptionView;
import views.major.LevelView;
import views.minor.NumberInput;
import views.minor.Label;
import data.GlobalSettings;
import entities.GameEntity;
import entities.EntityState;
import entities.SavedEntityState;
import java.util.ArrayList;
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
        int size=settings.getTileSize();
        settings.turnOnTiled(askTileSize.getContentsAsInt());
        LevelView lv=reference.findGrandView().getLevel();
        boolean tile=settings.getTiled();
        if(tile){
            // Tile Cordinates
            size=settings.getTileSize();
            ArrayList<GameEntity> entities=reference.findGrandView().getLevel().getEntities();
            for(int i=0;i<entities.size();i++){
                entities.get(i).roundPosition(size,lv);
                EntityState state=entities.get(i).getState();
                for(int f=0;f<state.getInts().size();f++){
                    if(state.getInts().get(f).getKey().equals("startX"))
                        state.getInts().get(f).setKey("tileX");
                    if(state.getInts().get(f).getKey().equals("startY"))
                        state.getInts().get(f).setKey("tileY");
                }
                SavedEntityState ses=state.getReference();
                for(int f=0;f<ses.getInts().size();f++){
                    if(ses.getInts().get(f).equals("startX"))
                        ses.getInts().set(f,"tileX");
                    if(ses.getInts().get(f).equals("startY"))
                        ses.getInts().set(f,"tileY");
                }
            }
        }else{
            // Normal Coordinates
            ArrayList<GameEntity> entities=reference.findGrandView().getLevel().getEntities();
            for(int i=0;i<entities.size();i++){
                entities.get(i).changeLocationFromTile(size,lv);
                EntityState state=entities.get(i).getState();
                for(int f=0;f<state.getInts().size();f++){
                    if(state.getInts().get(f).getKey().equals("tileX"))
                        state.getInts().get(f).setKey("startX");
                    if(state.getInts().get(f).getKey().equals("tileY"))
                        state.getInts().get(f).setKey("startY");
                }
                SavedEntityState ses=state.getReference();
                for(int f=0;f<ses.getInts().size();f++){
                    if(ses.getInts().get(f).equals("tileX"))
                        ses.getInts().set(f,"startX");
                    if(ses.getInts().get(f).equals("tileY"))
                        ses.getInts().set(f,"startY");
                }
            }
        }
        clearView();
    }
    
    @Override // rejects the changes
    public void rejectView(){
        clearView();
    }

    // setter methods
    @Override public void setReference(OptionView param){reference=param;}
}