/**
 *
 * @author Zackary Misso
 * This view lists all of the saved entity states that the user has made
 * 
 */
package views.major;
import views.MajorView;
import views.View;
import views.minor.SelectableLabel;
import entities.SavedEntityState;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class SavedEntityStateView extends MajorView{
    private ArrayList<SavedEntityState> savedStates;
    
    // default constructor
    public SavedEntityStateView(){
        super();
        savedStates=new ArrayList<>();
        setAllowsScrollables(true);
        setAllowsAccepting(true);
        setXpos(200);
        setYpos(600);
        setWidth(200);
        setHeight(200);
        setShowing(true);
        setIndex(0);
        setDisplayCnt(3);
        initializeDefaults();
    }
    
    // handles when the scroll up button is selected
    public void scrollUp(){
        if(getIndex()>0){
            setIndex(getIndex()-1);
            refactorLocationsDefault();
        }
        getScrollUp().setSelected(false);
    }
    
    // handles when the scroll down button is selected
    public void scrollDown(){
        if(getIndex()+getDisplayCnt()<savedStates.size()){
            setIndex(getIndex()+1);
            refactorLocationsDefault();
        }
        getScrollDown().setSelected(false);
    }
    
    // handles when the add button is selected
    public void add(){
        OptionView temp=null;
        SavedEntityState selected=null;
        temp=((GrandView)getSuperview()).getOptions();
        for(int i=0;i<getScrollables().size();i++)
            if(getScrollables().get(i).getSelected())
                selected=((SelectableLabel)getScrollables().get(i)).getSavedEntityState();
        if(selected==null){
            if(temp!=null&&!temp.getAddEntityState()){
                System.out.println("Adding Saved Entity State");
                temp.clearBools();
                temp.setAddEntityState(true);
                temp.setReferenceObject(savedStates);
                temp.checkInitialization();
            }else{
                if(temp==null)
                    System.out.println("Major Error :: OptionView null 1 :: SavedEntityStateView");
                else
                    System.out.println("Minor Error :: OptionView open :: SavedEntityStateView");
            }
        }else{ // DELETE THIS IT IS NOT NEEDED
            if(temp!=null&&!temp.getAddEntityStateObj()&&false){ // WORK ON THIS
                // this is temporarily not going to be available
                System.out.println("Adding Saved Entity State Obj");
                temp.clearBools();
                temp.setAddEntityStateObj(true);
                temp.setReferenceObject(selected);
                temp.checkInitialization();
                //implement more possibly
            }else{
                System.out.println("Major Error :: OptionView null 2 :: SavedEntityStateView");
                
            }
        }
        getAccept().setSelected(false);
    }
    
    // handles when the remove button is selected
    public void remove(){
        OptionView temp=null;
        SavedEntityState state=null;
        View grand=getSuperview();
        for(int i=0;i<grand.getSubviews().size();i++)
        	if(grand.getSubviews().get(i)instanceof OptionView)
        		temp=(OptionView)grand.getSubviews().get(i);
        for(int i=0;i<getScrollables().size();i++)
            if(getScrollables().get(i).getSelected())
                state=((SelectableLabel)getScrollables().get(i)).getSavedEntityState();
        if(temp!=null&&!temp.getRemoveEntityState()&&state!=null){
        	temp.clearBools();
        	temp.setRemoveEntityState(true);
            temp.setReferenceObject(state);
            temp.checkInitialization();
        }else{
            if(state==null)
                System.out.println("Major Error :: No State Selected :: SavedEntityStateView");
        	if(temp==null)
                System.out.println("Major Error :: OptionView null :: SavedEntityStateView");
        }
        getReject().setSelected(false);
    }

    // returns the selected SavedEntityState
    public SavedEntityState getSelectedState(){
        for(int i=0;i<getScrollables().size();i++)
            if(getScrollables().get(i).getSelected())
                return ((SelectableLabel)getScrollables().get(i)).getSavedEntityState();
        return null;
        // TODO :: ACTUALLY USE THIS IN THIS CLASS
    }
    
    // this method recreates the list of labels (very inefficient)
    public void refactorLabels(){
        clearScrollables();
        for(int i=0;i<savedStates.size();i++){
            SelectableLabel temp=new SelectableLabel();
            temp.setText(savedStates.get(i).getName());
            temp.setIndex(i);
            temp.setRepSavedEntity(true);
            temp.setReference(savedStates.get(i));
            temp.setWidth(150);
            temp.setHeight(30);
            temp.setSuperview(this);
            getScrollables().add(temp);
            getSubviews().add(temp);
        }
        refactorLocationsDefault();
    }
    
    // handles the clicks on this view
    public void clicked(){
        subviewFalsify();
        View tempView=this;
        while(!(tempView instanceof GrandView))
            tempView=tempView.getSuperview();
        EntityStateView esv=((GrandView)tempView).getEntityState();
        esv.setCurrent(null);
        esv.redrawView();
        System.out.println("Saved Entity State View was clicked");
    }
    
    // handles the types on this view
    public void types(char c){
    	super.types(c);
        // implement
    }
    
    // draws this views private variables to the screen
    public void paint(Graphics g){
        g.setColor(Color.magenta);
        g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
        super.paint(g);
    }
    
    // getter methods
    public ArrayList<SavedEntityState> getSavedStates(){return savedStates;}
    
    // setter methods
    public void setSavedStates(ArrayList<SavedEntityState> param){savedStates=param;}
}