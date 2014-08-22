/**
 *
 * @author Zackary Misso
 * Temporary view that allows the user to add an object to an entity state
 * 
 */
package views.temporaries;
import views.TemporaryView;
import views.major.GrandView;
import views.major.OptionView;
import views.minor.TextBox;
import views.minor.RadialButton;
import entities.SavedEntityState;
public class AddEntityStateObjectView implements TemporaryView{
    private OptionView reference;
    private TextBox askName;
    
    public AddEntityStateObjectView(){
        reference=null;
        askName=null;
    }
    
    @Override public void initializeView(){
        initializeRadialButtons();
        askName=new TextBox(16);
        askName.setSuperview(reference);
        askName.setXpos(xpos);
        askName.setYpos(ypos+270);
        reference.getSubviews().add(askName);
        if(reference.getReferenceObject()==null)
            System.out.println("Major Error :: No Reference :: OptionView");
        if(!(reference.getReferenceObject() instanceof SavedEntityState))
            System.out.println("Major Error :: Wrong Type :: OptionView");
    }
    
    private void initializeRadialButtons(){
        int num=0;
        reference.getScrollables().add(reference.makeRadial(num++,200,30,reference,"Bool"));
        reference.getScrollables().add(reference.makeRadial(num++,200,30,reference,"Byte"));
        reference.getScrollables().add(reference.makeRadial(num++,200,30,reference,"Color"));
        reference.getScrollables().add(reference.makeRadial(num++,200,30,reference,"Double"));
        reference.getScrollables().add(reference.makeRadial(num++,200,30,reference,"Image"));
        reference.getScrollables().add(reference.makeRadial(num++,200,30,reference,"Int"));
        reference.getScrollables().add(reference.makeRadial(num++,200,30,reference,"String"));
        reference.refactorViews();
    }
    
    @Override public void clearView(){
        reference.getSubviews().remove(askName);
        reference.setTemporary(null);
        askName=null;
        reference.clearBools();
        reference.clearCurrentView(); // delete this in the future
    }
    
    @Override public void acceptView(){
        RadialButton selected=null;
        for(int i=0;i<reference.getScrollables().size();i++)
            if(reference.getScrollables().get(i).getSelected())
                selected=(RadialButton)reference.getScrollables().get(i);
        if(!askName.getContents().equals("")&&selected!=null){
            String name=askName.getContents();
            SavedEntityState state=(SavedEntityState)reference.getReferenceObject();
            GrandView superview=reference.findGrandView();
            if(selected.getText().equals("Bool")){
                System.out.println("Adding To Entity :: Bool :: OptionView");
                state.getBooleans().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Byte")){
                System.out.println("Adding To Entity :: Byte :: OptionView");
                state.getBytes().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Color")){
                System.out.println("Adding To Entity :: Color :: OptionView");
                state.getColors().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Double")){
                System.out.println("Adding To Entity :: Double :: OptionView");
                state.getDoubles().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Image")){
                System.out.println("Adding To Entity :: Image :: OptionView");
                state.getImages().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Int")){
                System.out.println("Adding To Entity :: Int :: OptionView");
                state.getInts().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("String")){
                System.out.println("Adding To Entity :: String :: OptionView");
                state.getStrings().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            superview.getEntityState().redrawView();
            // implement more if needed
        }else{
            if(selected==null){
                System.out.println("Minor Error :: No Selected Type :: OptionView");
            }else{
                System.out.println("Minor Error :: No Name :: OptionView");
            }
        }
        reference.setAddEntityStateObj(false);
        clearView();
    }
    
    @Override public void rejectView(){
        clearView();
    }
    
    // setter methods
    @Override public void setReference(OptionView param){reference=param;}
}