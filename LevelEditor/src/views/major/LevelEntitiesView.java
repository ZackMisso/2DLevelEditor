/**
 *
 * @author Zackary Misso
 * This view displays all of the Game Entities currently in the game
 * 
 */
package views.major;
import views.MajorView;
import views.minor.SelectableLabel;
import entities.GameEntity;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
public class LevelEntitiesView extends MajorView{
    private ArrayList<GameEntity> entities;
    //private ArrayList<SelectableLabel> labels;
    private int prevSize;
    
    // default constructor
    public LevelEntitiesView(){
        super();
        entities=new ArrayList<>();
        //labels=new ArrayList<>();
        setAllowsScrollables(true);
        setAllowsAccepting(true);
        setIndex(0);
        setDisplayCnt(3);
        setShowing(true);
        setXpos(0);
        setYpos(600);
        setWidth(200);
        setHeight(200);
        prevSize=0;
        initializeDefaults();
    }
    
    // checks if the list of objects needs to be updated
    public void update(){
        super.update();
        if(prevSize!=entities.size())
            refactorLabels();
    }
    
    // handles the scroll up functionality
    public void scrollUp(){
        if(getIndex()>0){
            setIndex(getIndex()-1);
        }
        System.out.println(entities.size());
        getScrollUp().setSelected(false);
    }
    
    // handles the scroll down functionality
    public void scrollDown(){
        if(getIndex()+getDisplayCnt()<entities.size()){
            setIndex(getIndex()+1);
        }
        getScrollDown().setSelected(false);
    }
    
    // allows the user to add an instance of the selected entity
    public void add(){
        // implement
        getAccept().setSelected(false);
    }
    
    // allows the user to remove the selected game object
    public void remove(){
        // implement
        getReject().setSelected(false);
    }

    // resets the labels to be drawn
    public void refactorLabels(){
        clearScrollables();
        prevSize=entities.size();
        for(int i=0;i<entities.size();i++){
            System.out.println("Refactoring Labels :: LevelEntitiesView");
            SelectableLabel temp=new SelectableLabel();
            temp.setText(entities.get(i).getState().getReference().getName()+"     x:"+entities.get(i).getStartX()+"  y:"+entities.get(i).getStartY());
            temp.setIndex(i);
            temp.setRepEntity(true);
            temp.setReference(entities.get(i));
            temp.setWidth(150);
            temp.setHeight(30);
            // implement more if needed
            temp.setSuperview(this);
            getScrollables().add(temp);
            getSubviews().add(temp);
        }
        refactorLocationsDefault();
        //System.out.println("Change Test :: LevelEntitiesView");
    }
    
    // handles the clicks on this view
    public void clicked(){
        System.out.println("Level Entities View was Clicked");
        subviewFalsify();
        // implement more if needed
    }
    
    // handles the types on this view
    public void types(char c){
        super.types(c);
        // implement
    }
    
    // draws this views private variables to the screen
    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
        // implement more if needed
        super.paint(g);
    }
    
    // getter methods
    public ArrayList<GameEntity> getEntities(){return entities;}
    //public ArrayList<SelectableLabel> getLabels(){return labels;}
    public int getPrevSize(){return prevSize;}
    
    // setter methods
    public void setEntities(ArrayList<GameEntity> param){entities=param;}
    //public void setLabels(ArrayList<SelectableLabel> param){labels=param;}
    public void setPrevSize(int param){prevSize=param;}
}