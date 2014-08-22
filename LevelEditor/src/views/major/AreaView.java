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
import data.Area;
import data.AreaController;
import java.awt.Color;
import java.awt.Graphics;
public class AreaView extends MajorView{
    private AreaController areaController;
    private Area area;
    private int labelCnt; // probably dont need this
    
    // the default constructor
    public AreaView(){
        super();
        areaController=new AreaController();
        area=null;
        labelCnt=0;
        setDisplayCnt(4);
        setXpos(600);
        setYpos(0);
        setWidth(200);
        setHeight(300);
        setAllowsScrollables(true);
        setAllowsAccepting(true);
        initializeDefaults();
    }
    
    // handles user clicks
    @Override public void clicked(){
        System.out.println("Area View was clicked");
        subviewFalsify();
    }
    
    // handles user types
    @Override public void types(char c){
        super.types(c);
        // implement shortcuts
    }
    
    // draws the view to the screen
    @Override public void paint(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
        super.paint(g);
    }
    
    // adds an area to the current list of areas
    public void addArea(Area toAdd){
        SelectableLabel addLabel=new SelectableLabel();
        addLabel.setReference(toAdd);
        addLabel.setRepArea(true);
        areaController.getAreas().add(toAdd);
        addLabel.setSuperview(this);
        addLabel.setIndex(labelCnt++);
        getSubviews().add(addLabel);
    }
    
    // removes an area from the current lists of areas
    public void removeAreaForIndex(int index){
        //for(int i=index;i<getScrollables().size();i++)
        //    getScrollables().get(i).setIndex(getScrollables().get(i).getIndex()-1);
        //getScrollables().remove(index);
    }
    
    // scrolls the viewable labels up
    @Override public void scrollUp(){
        if(labelCnt>getIndex()+getDisplayCnt())
            setIndex(getIndex()+1);
        getScrollUp().setSelected(false);
    }
    
    // scrolls the viewable labels down
    @Override public void scrollDown(){
        if(getIndex()>0)
            setIndex(getIndex()-1);
        getScrollDown().setSelected(false);
    }
    
    @Override public void add(){
        // implement
        getAccept().setSelected(false);
    }
    
    @Override public void remove(){
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
    
    // setter methods
    public void setReference(AreaController param){areaController=param;}
    public void setArea(Area param){area=param;}
}