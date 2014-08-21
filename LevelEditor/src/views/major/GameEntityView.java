/**
 *
 * @author Zackary Misso
 * This view allows the user to edit the values given to a game entity.
 * 
 */
package views.major;
import views.MajorView;
import views.minor.NumberInput;
import views.minor.TextBox;
import datastructures.StringToInt;
import datastructures.StringToString;
import entities.GameEntity;
import entities.EntityState;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class GameEntityView extends MajorView{
    private GameEntity current;
    
    // default constructor
    public GameEntityView(){
        super();
        current=null;
        //setIndex(0);
        setDisplayCnt(4);
        this.setAllowsAccepting(true);
        this.setAllowsScrollables(true);
        setXpos(600);
        setYpos(600);
        setWidth(200);
        setHeight(200);
        setXOffset(20);
        setShowing(true);
        initializeDefaults();
    }
    
    // updates the view to view the current game entity being viewed
    public void redrawView(){
        clearScrollables();
        if(current==null){
            System.out.println("Current Null :: GameEntityView");
            // don't do anything
        }else{
            initializeBoolInputs();
            initializeByteInputs();
            initializeColorInputs();
            initializeDoubleInputs();
            initializeImageInputs();
            initializeImageInputs();
            initializeIntInputs();
            initializeStringInputs();
            refactorLocationsDefault();
            selectNext();
            // implement more if needed
        }
    }

    // draws the inputs for the bools
    private void initializeBoolInputs(){
        // implement LATER
    }

    // draws the inputs for the bytes
    private void initializeByteInputs(){
        // implement LATER
    }

    // draws the inputs for the colors
    private void initializeColorInputs(){
        // I honestly don't even know what to do
    }

    // draws the inputs for the doubles
    private void initializeDoubleInputs(){
        // implement LATER
    }

    // draws the inputs for the images
    private void initializeImageInputs(){
        // implement LATER
    }

    // draws the inputs for the ints
    private void initializeIntInputs(){
        ArrayList<StringToInt> ints=current.getState().getInts();
        for(int i=0;i<ints.size();i++){
            NumberInput newinput=new NumberInput();
            newinput.setSuperview(this);
            newinput.setHasTitle(true);
            newinput.setTitle(ints.get(i).getKey());
            newinput.setContents(ints.get(i).getValue()+"");
            newinput.setWidth(150);
            newinput.setHeight(20);
            getScrollables().add(newinput);
            getSubviews().add(newinput);
            // add more if needed
        }
    }

    // draws the inputs for the strings
    private void initializeStringInputs(){
        ArrayList<StringToString> strings=current.getState().getStrings();
        for(int i=0;i<strings.size();i++){
            TextBox newinput=new TextBox();
            newinput.setSuperview(this);
            newinput.setHasTitle(true);
            newinput.setTitle(strings.get(i).getKey());
            newinput.setContents(strings.get(i).getValue());
            newinput.setWidth(200);
            newinput.setHeight(20);
            getScrollables().add(newinput);
            getSubviews().add(newinput);
            // add more if needed
        }
    }
    
    // handles when this view is clicked
    public void clicked(){
        subviewFalsify();
        System.out.println("Game Entity View Was Clicked");
    }
    
    // handles when there are types on this view
    public void types(char c){
        super.types(c);
        // implement
    }
    
    // scrolls the view up if possible
    public void scrollUp(){
        if(getIndex()>0){
            setIndex(getIndex()-1);
            refactorLocationsDefault();
        }
        getScrollUp().setSelected(false);
    }
    
    // scrolls the view down if possible
    public void scrollDown(){
        if(getIndex()+getDisplayCnt()<getScrollables().size()){
            setIndex(getIndex()+1);
            refactorLocationsDefault();
        }
        getScrollDown().setSelected(false);
    }

    // accepts the changes
    public void add(){
        System.out.println("Accept Button Pressed :: GameEntityView");
        if(current.getIsNew()){
            GrandView grand=(GrandView)getSuperview();
            current.setIsNew(false);
            grand.getLevel().getEntities().add(current);
            current.setSuperview(grand.getLevel());
            grand.getLevel().getSubviews().add(current);
        }
        EntityState state=current.getState();
        acceptBytes(state);
        acceptBools(state);
        acceptDoubles(state);
        acceptInts(state);
        acceptStrings(state);
        acceptImages(state);
        acceptColors(state);
        // implement more if needed
        current.updatePreSets();
        current=null;
        redrawView();
        getAccept().setSelected(false);
    }

    // alters the entity state for each byte
    private void acceptBytes(EntityState state){
        // implement
    }

    // alters the entity state for each boolean
    private void acceptBools(EntityState state){
        // implement
    }

    // alters the entity state for each double
    private void acceptDoubles(EntityState state){
        // implement
    }

    // alters the entity state for each int
    private void acceptInts(EntityState state){
        ArrayList<StringToInt> ints=state.getInts();
        for(int i=0;i<ints.size();i++){
            StringToInt data=ints.get(i);
            for(int f=0;f<getScrollables().size();f++){
                if(getScrollables().get(f)instanceof NumberInput){
                    NumberInput input=(NumberInput)getScrollables().get(f);
                    if(input.getTitle().equals(data.getKey())){
                        data.setValue(Integer.parseInt(input.getContents()));
                    }
                }
            }
        }
    }

    // alters the entity state for each string
    private void acceptStrings(EntityState state){
        // implement
    }

    // alters the entity state for each image
    private void acceptImages(EntityState state){
        // implement
    }

    // alters the entity state for each color
    private void acceptColors(EntityState state){
        // implement
    }

    // rejects the changes
    public void remove(){
        current=null;
        redrawView();
        getReject().setSelected(false);
    }
    
    // draws this view to the screen
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
        super.paint(g);
    }
    
    // getter methods
    //public GameEntity getCurrent(){return current;}
    
    // setter methods
    public void setCurrent(GameEntity param){current=param;}
}