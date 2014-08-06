/**
 *
 * @author Zackary Misso
 * This class creates the option view. I have yet to decide what it is going to do
 * 
 */
package views.major;
import views.View;
import views.MajorView;
import views.TemporaryView;
import views.minor.TextBox;
import views.minor.RadialButton;
//import views.minor.SelectableLabel;
//import views.minor.Label;
import views.temporaries.AddEntityStateView;
import views.temporaries.AddEntityStateObjectView;
import views.temporaries.GlobalSettingsView;
import views.temporaries.RemoveEntityStateView;
import views.temporaries.RemoveEntityStateObjectView;
//import entities.SavedEntityState;
//import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
public class OptionView extends MajorView{
    //private View container; // what this view is containing
    private TemporaryView temporary;
    //private ArrayList<View> temporaries;
    private Object referenceObject; // will depend on the type of view
    //private TextBox askName; // allows the user to input a name for something
    private int radialCols;
    private boolean addEntityStateObj;
    private boolean removeEntityStateObj;
    private boolean addEntityState;
    private boolean removeEntityState;
    private boolean globalSettings;
    
    // default constructor
    public OptionView(){
        super();
        //container=null;
        temporary=null;
        //temporaries=new ArrayList<>();
        referenceObject=null;
        //askName=null;
        addEntityStateObj=false;
        removeEntityStateObj=false;
        addEntityState=false;
        removeEntityState=false;
        globalSettings=false;
        setIndex(0);
        setDisplayCnt(4);
        radialCols=1;
        setXpos(600);
        setYpos(300);
        setWidth(200);
        setHeight(300);
        setShowing(true);
        setAllowsScrollables(true);
        setAllowsAccepting(true);
        initializeDefaults();
    }
    
    // checks and initializes the view based on what the option view should display
    public void checkInitialization(){
        if(addEntityStateObj)
            temporary=new AddEntityStateObjectView();
        if(removeEntityStateObj)
            temporary=new RemoveEntityStateObjectView();
        if(addEntityState)
            temporary=new AddEntityStateView();
        if(removeEntityState)
            temporary=new RemoveEntityStateView();
        if(globalSettings)
            temporary=new GlobalSettingsView();
        if(temporary!=null){
            temporary.setReference(this);
            temporary.initializeView();
        }
    }
    
    @Override
    public void add(int btnval){acceptCurrentView(btnval);}
    @Override
    public void remove(int btnval){rejectCurrentView(btnval);}
    
    // checks and does the accepting functionality for the current view
    private void acceptCurrentView(int btnval){
        // implement button modifier logic
        if(addEntityStateObj)
            temporary.acceptView();//acceptAddEntityStateObj();
        if(removeEntityStateObj)
            temporary.acceptView();
        if(addEntityState)
            temporary.acceptView();//acceptAddEntityState();
        if(removeEntityState)
            temporary.acceptView();//acceptRemoveEntityState();
        if(globalSettings)
            temporary.acceptView();
        getAccept().setSelected(false);
        // implement the rest as they are needed
    }
    
    // checks and does the rejecting functionality for the current view
    private void rejectCurrentView(int btnval){
        temporary.clearView();
        getReject().setSelected(false);
        referenceObject=false;
        clearBools();
        // implement more maybe
    }
    
    // clears the current view to make the initialization for the new one smoother
    public void clearCurrentView(){
        for(int i=0;i<getScrollables().size();i++){
            getSubviews().remove(getScrollables().get(i));
            getScrollables().remove(i--);
        }
        for(int i=0;i<getSubviews().size();i++){
            if(getSubviews().get(i)instanceof TextBox)
                getSubviews().remove(i--);
            // implement more if needed
        }
    }
    
    // sets all of the view based booleans to false
    public void clearBools(){
        addEntityStateObj=false;
        removeEntityState=false;
        addEntityState=false;
        removeEntityState=false;
        globalSettings=false;
        // implement more as they are added
    }
    
    @Override // handles the scroll up logic
    public void scrollUp(int btnval){
        if(getIndex()>0){
            setIndex(getIndex()-radialCols); // this is for only one case
            refactorViews();
        }
        getScrollUp().setSelected(false);
    }
    
    @Override // handles the scroll down logic
    public void scrollDown(int btnval){
        if(getIndex()+getDisplayCnt()<getScrollables().size()){
            setIndex(getIndex()+radialCols); // this is for only one case
            refactorViews();
        }
        getScrollDown().setSelected(false);
    }
    
    // updates the locations of the scrollables
    public void refactorViews(){
        int x=getXpos();
        int y=getYpos()+20;
        int c=radialCols;
        for(int i=0;i<getScrollables().size();i++){
            RadialButton temp=(RadialButton)getScrollables().get(i);
            boolean one=temp.getIndex()>getIndex();
            boolean two=temp.getIndex()<getIndex()+getDisplayCnt()*radialCols;
            if(one&&two){
                System.out.println("FOUR MICE OF MEN");
                if(--c==0){
                    x=getXpos();
                    y+=40;
                    c=radialCols;
                }else{
                    x+=60;
                }
                temp.setXpos(x);
                temp.setYpos(y);
            }else{
                temp.setXpos(-1000);
                temp.setYpos(-1000);
            }
            if(temp.getWidth()<=0)
                System.out.println("Major Error :: Width Not Set :: OptionView");
            if(temp.getHeight()<=0)
                System.out.println("Major Error :: Height Not Set :: OptionView");
        }
        System.out.println("Test Change :: OptionView");
    }
    
    // handles the clicks on this view
    @Override public void clicked(){
        System.out.println("Option View was clicked");
        subviewFalsify();
        // implement more if needed
    }
    
    // handles the types on this view
    @Override public void types(char c){
        // implement
    }
    
    // draws this views private variables to the screen
    @Override public void paint(Graphics g){
        g.setColor(Color.pink);
        g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
        super.paint(g); // maybe not need
    }
    
    // getter methods
    public TemporaryView getTemporary(){return temporary;}
    public Object getReferenceObject(){return referenceObject;}
    public int getRadialCols(){return radialCols;}
    public boolean getAddEntityStateObj(){return addEntityStateObj;}
    public boolean getRemoveEntityStateObj(){return removeEntityStateObj;}
    public boolean getAddEntityState(){return addEntityState;}
    public boolean getRemoveEntityState(){return removeEntityState;}
    public boolean getGlobalSettings(){return globalSettings;}
    
    // setter methods
    public void setTemporary(TemporaryView param){temporary=param;}
    public void setReferenceObject(Object param){referenceObject=param;}
    public void setRadialCols(int param){radialCols=param;}
    public void setAddEntityStateObj(boolean param){addEntityStateObj=param;}
    public void setRemoveEntityStateObj(boolean param){removeEntityStateObj=param;}
    public void setAddEntityState(boolean param){addEntityState=param;}
    public void setRemoveEntityState(boolean param){removeEntityState=param;}
    public void setGlobalSettings(boolean param){globalSettings=param;}
}