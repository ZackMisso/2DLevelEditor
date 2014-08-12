/**
 *
 * @author Zackary Misso
 * A "major view" is any view that can contain other views
 * 
 */
package views;
import views.minor.Button;
import views.minor.SelectableLabel;
import java.util.ArrayList;
public abstract class MajorView extends View{
    private ArrayList<View> scrollables;
    private Button scrollUp;
    private Button scrollDown;
    private Button accept;
    private Button reject;
    private boolean allowsScrollables; // probably dont need this
    private boolean allowsAccepting; // probably dont need this
    private int index;
    private int displayCnt;
    private int xOffset;
    private int yOffset;

    public MajorView(){
        super();
        scrollables=new ArrayList<>();
        scrollUp=null;
        scrollDown=null;
        accept=null;
        reject=null;
        allowsScrollables=false;
        allowsAccepting=false;
        index=0;
        displayCnt=3;
        xOffset=0;
        yOffset=0;
    }
    
    // initializes the buttons for the view
    public void initializeDefaults(){
        int temp=0;
        int x=getXpos()-50;
        int y=getYpos();
        if(allowsScrollables){
            scrollUp=makeButton(temp++,x+=50,y,(View)this,"UP");
            scrollDown=makeButton(temp++,x+=50,y,(View)this,"DOWN");
        }
        if(allowsAccepting){
            accept=makeButton(temp++,x+=50,y,this,"YES");
            reject=makeButton(temp++,x+=50,y,this,"NO");
        }
    }
    
    public void refactorLocationsDefault(){
        int tempX=getXpos()+10+xOffset;
        int tempY=getYpos()+20+yOffset;
        for(int i=0;i<scrollables.size();i++){
            if(i>=index&&i<=index+displayCnt){
                scrollables.get(i).setXpos(tempX);
                scrollables.get(i).setYpos(tempY);
                tempY+=30;
            }else{
                scrollables.get(i).setXpos(-1000);
                scrollables.get(i).setYpos(-1000);
            }
        }
    }
    
    public void clearScrollables(){
        for(int i=0;i<scrollables.size();i++)
            getSubviews().remove(scrollables.remove(i--));
    }
    
    public void update(){
        int num=buttonSelected();
        if(scrollUp!=null&&scrollUp.getIndex()==num)
            scrollUp();
        if(scrollDown!=null&&scrollDown.getIndex()==num)
            scrollDown();
        if(accept!=null&&accept.getIndex()==num)
            add();
        if(reject!=null&&reject.getIndex()==num)
            remove();
    }
    
    public abstract void scrollUp();
    public abstract void scrollDown();
    public abstract void add();
    public abstract void remove();
    
    // Type conversion methods
    public ArrayList<SelectableLabel> getScrollablesAsLabels(){
        ArrayList<SelectableLabel> list=new ArrayList<>();
        for(int i=0;i<scrollables.size();i++)
            list.add((SelectableLabel)scrollables.get(i));
        return list;
    }

    // key shortcuts for this view
    public void types(char c){
        if(c==10)add();
    }
    
    // getter methods
    public ArrayList<View> getScrollables(){return scrollables;}
    public Button getScrollUp(){return scrollUp;}
    public Button getScrollDown(){return scrollDown;}
    public Button getAccept(){return accept;}
    public Button getReject(){return reject;}
    public int getIndex(){return index;}
    public int getDisplayCnt(){return displayCnt;}
    public int getXOffset(){return xOffset;}
    public int getYOffset(){return yOffset;}
    public boolean getAllowsScrollables(){return allowsScrollables;}
    public boolean getAllowsAccepting(){return allowsAccepting;}
    
    // setter methods
    public void setScrollables(ArrayList<View> param){scrollables=param;}
    public void setScrollUp(Button param){scrollUp=param;}
    public void setScrollDown(Button param){scrollDown=param;}
    public void setAccept(Button param){accept=param;}
    public void setReject(Button param){reject=param;}
    public void setIndex(int param){index=param;}
    public void setDisplayCnt(int param){displayCnt=param;}
    public void setXOffset(int param){xOffset=param;}
    public void setYOffset(int param){yOffset=param;}
    public void setAllowsScrollables(boolean param){allowsScrollables=param;}
    public void setAllowsAccepting(boolean param){allowsAccepting=param;}
}