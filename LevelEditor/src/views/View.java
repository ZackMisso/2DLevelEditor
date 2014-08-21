/**
 *
 * @author Zackary Misso
 * This class contains the data for a generic view object
 * 
 */
package views;
//import java.awt.Color;
import views.major.GrandView;
import views.minor.Button;
import views.minor.SelectableLabel;
import views.minor.TextBox;
import views.minor.NumberInput;
import views.minor.ColorInput;
import views.minor.RadialButton;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Rectangle;
public abstract class View extends Displayable{
    private ArrayList<View> subviews;
    private View superview;
    private boolean showing;
    private boolean selected;
    
    public View(){ // default constructor
        this(0,0,0,0);
    }
    
    public View(int x,int y,int w,int h){
        super(x,y,w,h);
        subviews=new ArrayList<>();
        superview=null;
        showing=false;
        selected=false;
    }
    
    // updates the view
    public void update(){
        for(int i=0;i<subviews.size();i++)
            subviews.get(i).update();
    }
    
    // if the view is being displayed, draw it and its subviews on the screen
    public void paint(Graphics g){
        if(showing){
            //g.setColor(Color.black);
            //g.drawRect(getXpos(),getYpos(),getWidth(),getHeight());
            for(int i=0;i<subviews.size();i++)
                subviews.get(i).paint(g);
        }
    }
    
    // adds a view as a subview of this view
    public void addView(View view){
        view.setSuperview(this);
        subviews.add(view);
    }
    
    // removes a certain subview of this view
    public void removeView(View view){
        view.setSuperview(null);
        subviews.remove(view);
    }
    
    // checks if this view was clicked
    public boolean wasClicked(int x,int y){
        boolean temp;
        Rectangle one=new Rectangle(getXpos(),getYpos(),getWidth(),getHeight());
        Rectangle two=new Rectangle(x,y,1,1);
        temp=one.intersects(two);
        if(temp){
            boolean temp2=false;
            for(int i=0;i<subviews.size();i++)
                if(subviews.get(i).wasClicked(x,y)){
                    i=subviews.size();
                    temp2=true;
                }
            if(!temp2){
                clicked();
                View sup=this;
                if(sup.getSuperview()==null)
                    System.out.println("Major Error :: Did not set up the Superview :: View");
                while(!(sup instanceof GrandView)){
                    sup=sup.getSuperview();
                }
                ((GrandView)sup).getInputs().setSelectedView(this);
            }
            return true;
        }
        return false;
    }
    
    // returns the index of the selected button within the view
    public int buttonSelected(){
        for(int i=0;i<subviews.size();i++)
            if(subviews.get(i) instanceof Button)
                if(subviews.get(i).selected)
                    return ((Button)subviews.get(i)).getIndex();
        return -1;
    }
    
    // returns the index of the selected label within the view
    public int labelSelected(){
        for(int i=0;i<subviews.size();i++)
            if(subviews.get(i) instanceof SelectableLabel)
                return ((SelectableLabel)subviews.get(i)).getIndex();
        return -1;
    }
    
    // returns the list of all selected labels within this subview
    public ArrayList<SelectableLabel> getSelectableLabels(){
        ArrayList<SelectableLabel> list=new ArrayList<>();
        for(int i=0;i<subviews.size();i++)
            if(subviews.get(i) instanceof SelectableLabel)
                list.add((SelectableLabel)subviews.get(i));
        return list;
    }
    
    // sets all subviews selected value to false
    public void subviewFalsify(){
        for(int i=0;i<subviews.size();i++)
            subviews.get(i).setSelected(false);
    }

    // sets all inputs selected values to false
    public void inputFalsify(){
        textBoxFalsify();
        numberInputFalsify();
        colorInputFalsify();
    }
    
    // sets all selectable labels selected valuesto false
    public void labelFalsify(){
        for(int i=0;i<subviews.size();i++)
            if(subviews.get(i)instanceof SelectableLabel)
                subviews.get(i).setSelected(false);
    }
    
    // sets all subviews that are textboxes selected values to false
    public void textBoxFalsify(){
        for(int i=0;i<subviews.size();i++)
            if(subviews.get(i) instanceof TextBox)
                subviews.get(i).setSelected(false);
    }

    // sets all subviews that are number inputs selected values to false
    public void numberInputFalsify(){
        for(int i=0;i<subviews.size();i++)
            if(subviews.get(i)instanceof NumberInput)
                subviews.get(i).setSelected(false);
    }

    public void colorInputFalsify(){
        for(int i=0;i<subviews.size();i++)
            if(subviews.get(i)instanceof ColorInput)
                subviews.get(i).setSelected(false);
    }
    
    // finds the grand view by searching up the view hierarchy
    public GrandView findGrandView(){
        View view=superview;
        while(!(view instanceof GrandView))
            view=view.getSuperview();
        return (GrandView)view;
    }

    // adds a single button to this view with the parameters
    public Button makeButton(int cnt,int x,int y,View sup,String title){
        Button button=new Button(cnt);
        button.setXpos(x);
        button.setYpos(y);
        button.setSuperview(sup);
        button.setTitle(title);
        subviews.add(button);
        return button;
    }
    
    public RadialButton makeRadial(int ind,int w,int h,View sup,String text){
        RadialButton button=new RadialButton();
        button.setWidth(w);
        button.setHeight(h);
        button.setIndex(ind);
        button.setSuperview(sup);
        button.setText(text);
        subviews.add(button);
        return button;
    }
    
    // TODO :: POSSIBLY ADD MORE METHODS LIKE THE ONES ABOVE
    
    // what happens when the view is clicked
    public abstract void clicked();
    
    // what happens when the user types
    public abstract void types(char c);
    
    // MAYBE MAKE A TYPE METHOD FOR NUMBERS AND ONE FOR TEXT
    
    // getter methods
    public ArrayList<View> getSubviews(){return subviews;}
    public View getSuperview(){return superview;}
    public boolean getShowing(){return showing;}
    public boolean getSelected(){return selected;}
    
    // setter methods
    public void setSubviews(ArrayList<View> param){subviews=param;}
    public void setSuperview(View param){superview=param;}
    public void setShowing(boolean param){showing=param;}
    public void setSelected(boolean param){selected=param;}
}