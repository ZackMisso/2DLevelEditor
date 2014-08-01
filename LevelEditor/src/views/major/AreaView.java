/**
 *
 * @author Zackary Misso
 * This class displays the list of areas created by the user. Areas are like
 * levels, for example Palet Town is an area, and each Route is a separate
 * area.
 * 
 */
package views.major;
import views.MajorView;
import views.minor.SelectableLabel;
import views.minor.Button;
import data.Area;
import data.AreaController;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class AreaView extends MajorView{
    private AreaController areaController;
    private Area area;
    //private ArrayList<SelectableLabel> labels;
    //private Button scrollUp;
    //private Button scrollDown;
    private int labelCnt; // probably dont need this
    //private int topLabel;
    //private int displayCnt;
    
    // the default constructor
    public AreaView(){
        super();
        areaController=new AreaController();
        area=null;
        labelCnt=0;
        setIndex(0);
        setDisplayCnt(4);
        //initializeSubviews();
        setXpos(600);
        setYpos(0);
        setWidth(200);
        setHeight(300);
        setShowing(true);
        setAllowsScrollables(true);
        setAllowsAccepting(true);
        initializeDefaults();
    }
    
    /*private void initializeSubviews(){
        int temp=0;
        // initialize scroll up button
        scrollUp=new Button(temp++);
        scrollUp.setSuperview(this);
        getSubviews().add(scrollUp);
        // initialize scroll Down button
        scrollDown=new Button(temp++);
        scrollDown.setSuperview(this);
        getSubviews().add(scrollDown);
        // initialize Labels
        labels=new ArrayList<>();
        // you should not be able to initialize any labels now
    }*/
    
    // handles user clicks
    public void clicked(){
        // implement
    }
    
    // handles user types
    public void types(char c){
        // implement
    }
    
    // draws the view to the screen
    public void paint(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(getXpos(),getYpos(),getWidth(),getHeight());
        super.paint(g);
        //for(int i=0;i<getSubviews().size();i++){
        //    if(!(getSubviews().get(i) instanceof SelectableLabel))
        //        getSubviews().get(i).paint(g);
        //    else{
        //        int index=((SelectableLabel)getSubviews().get(i)).getIndex();
        //        if(index>=topLabel&&index<topLabel+displayCnt)
        //            getSubviews().get(i).paint(g);
        ///    }
        //}//
    }
    
    // tries to tell which button and selectable label is selected if any
    /*public void update(){
        super.update();
        switch(buttonSelected()){
            case -1:
                break;
            case 0:
                scrollUp();
                break;
            case 1:
                scrollDown();
                break;
            default:
                System.out.println("More Buttons included than initialized -- AreaView "+buttonSelected());
                break;
        }
    }*/
    
    // adds an area to the current list of areas
    public void addArea(Area toAdd){
        SelectableLabel addLabel=new SelectableLabel();
        addLabel.setReference(toAdd);
        addLabel.setRepArea(true);
        areaController.getAreas().add(toAdd);
        addLabel.setSuperview(this);
        addLabel.setIndex(labelCnt++);
        getSubviews().add(addLabel);
        //View.sort(labels);
    }
    
    // removes an area from the current lists of areas
    public void removeAreaForIndex(int index){
        //for(int i=index;i<getScrollables().size();i++)
        //    getScrollables().get(i).setIndex(getScrollables().get(i).getIndex()-1);
        //getScrollables().remove(index);
    }
    
    // THIS WILL MOST LIKELY NOT BE USED AT ALL
    // changes the area to the parameter index
    //public void changeArea(int index){
    //    writeArea(); // maybe
    //    // This will be call
    //}
    
    // scrolls the viewable labels up
    public void scrollUp(int btnval){
        if(labelCnt>getIndex()+getDisplayCnt())
            setIndex(getIndex()+1);
        getScrollUp().setSelected(false);
    }
    
    // scrolls the viewable labels down
    public void scrollDown(int btnval){
        if(getIndex()>0)
            setIndex(getIndex()-1);
        getScrollDown().setSelected(false);
    }
    
    public void add(int btnval){
        // implement
        getAccept().setSelected(false);
    }
    
    public void remove(int btnval){
        // implement
        getReject().setSelected(false);
    }
    
    // writes the current changes to the current area
    public String writeArea(){
        // implement
        return "";
    }
    
    // getter methods
    public AreaController getAreaController(){return areaController;}
    public Area getArea(){return area;}
    //public ArrayList<SelectableLabel> getLabels(){return labels;}
    //public Button getScrollUp(){return scrollUp;}
    //public Button getScrollDown(){return scrollDown;}
    public int getLabelCnt(){return labelCnt;}
    //public int getTopLabel(){return topLabel;}
    //public int getDisplayCnt(){return displayCnt;}
    
    // setter methods
    public void setReference(AreaController param){areaController=param;}
    public void setArea(Area param){area=param;}
    //public void setLabels(ArrayList<SelectableLabel> param){labels=param;}
    //public void setScrollUp(Button param){scrollUp=param;}
    //public void setScrollDown(Button param){scrollDown=param;}
    public void setLabelCnt(int param){labelCnt=param;}
    //public void setTopLabel(int param){topLabel=param;}
    //public void setDisplayCnt(int param){displayCnt=param;}
}