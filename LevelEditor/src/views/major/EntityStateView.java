/**
 *
 * @author Zackary Misso
 * This view will display a selected entity state's data
 * 
 */
package views.major;
import views.MajorView;
import views.minor.SelectableLabel;
import views.minor.Label;
import entities.SavedEntityState;
import entities.GameEntity;
import entities.EntityState;
import datastructures.StringToBool;
import datastructures.StringToByte;
import datastructures.StringToInt;
import datastructures.StringToDouble;
import datastructures.StringToString;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
public class EntityStateView extends MajorView{
    private ArrayList<SelectableLabel> viewNames; // the names of the inputs for the entity
    private ArrayList<Label> inputs; // the input boxes for the entity
    private SavedEntityState current; // the currently selected entity's state
    private String stateName;
    
    // default constructor
    public EntityStateView(){
        //reference=null;
        viewNames=new ArrayList<>();
        inputs=new ArrayList<>();
        current=null;
        stateName="";
        setXpos(400);
        setYpos(600);
        setWidth(200);
        setHeight(200);
        setAllowsScrollables(true);
        setAllowsAccepting(true);
        setShowing(true);
        setIndex(0);
        setDisplayCnt(4);
        initializeDefaults();
    }
        
    // redraws the view of the entity based on the currently set EntityState
    public void redrawView(){
        if(current==null){
            clearLists();
            setIndex(0);
            System.out.println("Current was null :: EntityStateView");
            // possibly add more
        }else{
            clearLists();
            setIndex(0);
            System.out.println(current.getInts().size()+" :: Size of Ints :: EntityStateView");
            int slxpos=getXpos()+30; // EDIT maybe
            int lxpos=getXpos()+10; // EDIT maybe
            int ypos=getYpos()+20;
            ypos=createByteLabels(current.getBytes(),ypos,lxpos,slxpos);
            ypos=createIntLabels(current.getInts(),ypos,lxpos,slxpos);
            ypos=createDoubleLabels(current.getDoubles(),ypos,lxpos,slxpos);
            ypos=createBoolLabels(current.getBooleans(),ypos,lxpos,slxpos);
            ypos=createStringLabels(current.getStrings(),ypos,lxpos,slxpos);
            ypos=createColorLabels(current.getColors(),ypos,lxpos,slxpos);
            ypos=createImageLabels(current.getImages(),ypos,lxpos,slxpos);
            //selectNext();
            // implement more if necessary
        }
        System.out.println("redrawView called");
    }

    // clears the arraylists from the subviews and this scope
    private void clearLists(){
        for(int i=0;i<viewNames.size();i++)
            getSubviews().remove(viewNames.remove(i--));
        for(int i=0;i<inputs.size();i++)
            getSubviews().remove(inputs.remove(i--));
        // implement more if needed
    }

    // TODO :: REDUCE THE SIZE OF THIS CODE!!!

    // creates the selectable label and label for all of the bytes
    private int createByteLabels(ArrayList<String> list,int y,int lx,int slx){
        for(int i=0;i<list.size();i++){
            Label label=new Label();
            label.setSuperview(this);
            label.setXpos(lx);
            label.setYpos(y);
            label.setText("BYTE");
            SelectableLabel slabel=new SelectableLabel();
            slabel.setText(list.get(i));
            slabel.setXpos(slx);
            slabel.setYpos(y);
            slabel.setWidth(150);
            slabel.setHeight(30);
            slabel.setRepStrByte(true);
            slabel.setReference(list.get(i));
            slabel.setSuperview(this);
            inputs.add(label);
            viewNames.add(slabel);
            getSubviews().add(label);
            getSubviews().add(slabel);
            y+=40;
        }
        return y;
    }

    // creates the selectable label and label for all of the ints
    private int createIntLabels(ArrayList<String> list,int y,int lx,int slx){
        for(int i=0;i<list.size();i++){
            Label label=new Label();
            label.setSuperview(this);
            label.setXpos(lx);
            label.setYpos(y+20);
            label.setText("INT");
            SelectableLabel slabel=new SelectableLabel();
            slabel.setText(list.get(i));
            slabel.setXpos(slx);
            slabel.setYpos(y);
            slabel.setWidth(150);
            slabel.setHeight(30);
            slabel.setRepStrInt(true);
            slabel.setReference(list.get(i));
            slabel.setSuperview(this);
            inputs.add(label);
            viewNames.add(slabel);
            getSubviews().add(label);
            getSubviews().add(slabel);
            y+=40;
        }
        return y;
    }

    // creates the selectable label and label for all of the doubls
    private int createDoubleLabels(ArrayList<String> list,int y,int lx,int slx){
        for(int i=0;i<list.size();i++){
            Label label=new Label();
            label.setSuperview(this);
            label.setXpos(lx);
            label.setYpos(y);
            label.setText("DOUBLE");
            SelectableLabel slabel=new SelectableLabel();
            slabel.setText(list.get(i));
            slabel.setXpos(slx);
            slabel.setYpos(y);
            slabel.setWidth(150);
            slabel.setHeight(30);
            slabel.setRepStrDou(true);
            slabel.setReference(list.get(i));
            slabel.setSuperview(this);
            inputs.add(label);
            viewNames.add(slabel);
            getSubviews().add(label);
            getSubviews().add(slabel);
            y+=40;
        }
        return y;
    }

    // creates the selectable label and label for all of the bools
    private int createBoolLabels(ArrayList<String> list,int y,int lx,int slx){
        for(int i=0;i<list.size();i++){
            Label label=new Label();
            label.setSuperview(this);
            label.setXpos(lx);
            label.setYpos(y);
            label.setText("BOOLEAN");
            SelectableLabel slabel=new SelectableLabel();
            slabel.setText(list.get(i));
            slabel.setXpos(slx);
            slabel.setYpos(y);
            slabel.setWidth(150);
            slabel.setHeight(30);
            slabel.setRepStrBool(true);
            slabel.setReference(list.get(i));
            slabel.setSuperview(this);
            inputs.add(label);
            viewNames.add(slabel);
            getSubviews().add(label);
            getSubviews().add(slabel);
            y+=40;
        }
        return y;
    }

    // creates the selectable label and label for all of the strings
    private int createStringLabels(ArrayList<String> list,int y,int lx,int slx){
        for(int i=0;i<list.size();i++){
            Label label=new Label();
            label.setSuperview(this);
            label.setXpos(lx);
            label.setYpos(y);
            label.setText("STRING");
            SelectableLabel slabel=new SelectableLabel();
            slabel.setText(list.get(i));
            slabel.setXpos(slx);
            slabel.setYpos(y);
            slabel.setWidth(150);
            slabel.setHeight(30);
            slabel.setRepStrStr(true);
            slabel.setReference(list.get(i));
            slabel.setSuperview(this);
            inputs.add(label);
            viewNames.add(slabel);
            getSubviews().add(label);
            getSubviews().add(slabel);
            y+=40;
        }
        return y;
    }

    // creates the selectable label and label for all of the colors
    private int createColorLabels(ArrayList<String> list,int y,int lx,int slx){
        for(int i=0;i<list.size();i++){
            Label label=new Label();
            label.setSuperview(this);
            label.setXpos(lx);
            label.setYpos(y);
            label.setText("COLOR");
            SelectableLabel slabel=new SelectableLabel();
            slabel.setText(list.get(i));
            slabel.setXpos(slx);
            slabel.setYpos(y);
            slabel.setWidth(150);
            slabel.setHeight(30);
            slabel.setRepStrCol(true);
            slabel.setReference(list.get(i));
            slabel.setSuperview(this);
            inputs.add(label);
            viewNames.add(slabel);
            getSubviews().add(label);
            getSubviews().add(slabel);
            y+=40;
        }
        return y;
    }

    // creates the selectable label and label for all of the images
    private int createImageLabels(ArrayList<String> list,int y,int lx,int slx){
        for(int i=0;i<list.size();i++){
            Label label=new Label();
            label.setSuperview(this);
            label.setXpos(lx);
            label.setYpos(y);
            label.setText("IMAGE");
            SelectableLabel slabel=new SelectableLabel();
            slabel.setText(list.get(i));
            slabel.setXpos(slx);
            slabel.setYpos(y);
            slabel.setWidth(150);
            slabel.setHeight(30);
            slabel.setRepStrImg(true);
            slabel.setReference(list.get(i));
            slabel.setSuperview(this);
            inputs.add(label);
            viewNames.add(slabel);
            getSubviews().add(label);
            getSubviews().add(slabel);
            y+=40;
        }
        System.out.println("Change test :: EntityStateView");
        return y;
    }
    
    // handles clicks
    public void clicked(){
        System.out.println("Entity State View was clicked");
        subviewFalsify();
        // implement more if needed
    }
    
    // handles types
    public void types(char c){
        super.types(c);
        // implement
    }
    
    // handles up scrolls
    public void scrollUp(){
        if(getIndex()>0)
            setIndex(getIndex()-1);
        getScrollUp().setSelected(false);
    }
    
    // handles down scrolls
    public void scrollDown(){
        if(getIndex()+getDisplayCnt()<viewNames.size())
            setIndex(getIndex()+1);
        getScrollDown().setSelected(false);
    }
    
    // tells the level editor to pull up the add entity state obj screen in the
    // options view
    public void add(){
        OptionView temp=null;
        temp=((GrandView)getSuperview()).getOptions();
        if(temp!=null&&current!=null&&!temp.getAddEntityStateObj()){
                System.out.println("Adding Saved Entity State");
                temp.clearBools();
                temp.setAddEntityStateObj(true);
                temp.setReferenceObject(current);
                temp.checkInitialization();
                //implement more possibly
        }else{
            if(temp==null)
                System.out.println("Mayor Error :: OptionView null :: EntityStateView");
            if(current==null)
                System.out.println("Minor Error :: No SavedEntity :: EntityStateView");
        }
        getAccept().setSelected(false);
    }
    
    // tells the level editor to pull up the add entity state obj screen in the
    // options view
    public void remove(){
        LevelView level=null;
        OptionView temp=null;
        temp=((GrandView)getSuperview()).getOptions();
        level=((GrandView)getSuperview()).getLevel();
        if(current!=null&&temp!=null&&level!=null){
            SelectableLabel selected=null;
            for(int i=0;i<viewNames.size();i++)
                if(viewNames.get(i).getSelected())
                    selected=null;
            if(selected!=null){
                // LOGIC FOR BOOLEANS
                if(selected.getStrBool()!=null){
                    String str=selected.getStrBool();
                    int ind=0;
                    for(int i=0;i<current.getBooleans().size();i++)
                        if(current.getBooleans().get(i).equals(str))
                            ind=i;
                    current.getBooleans().remove(ind);
                    ArrayList<GameEntity> ref=level.getEntities();
                    for(int i=0;i<ref.size();i++){
                        EntityState entstate=ref.get(i).getState();
                        if(entstate.getReference()==current){
                            ArrayList<StringToBool> bools=entstate.getBooleans();
                            for(int j=0;j<bools.size();j++)
                                if(bools.get(j).getKey().equals(str)){
                                    System.out.println("Boolean Deleted from Entity :: "+i);
                                    bools.remove(j--);
                                }
                        }
                    }
                    System.out.println("Change To Test :: EntityState View");
                    System.out.println("Removed Bool object");
                // LOGIC FOR BYTES
                }else if(selected.getStrByte()!=null){
                    String str=selected.getStrByte();
                    int ind=0;
                    for(int i=0;i<current.getBytes().size();i++)
                        if(current.getBytes().get(i).equals(str))
                            ind=i;
                    current.getBytes().remove(ind);
                    ArrayList<GameEntity> ref=level.getEntities();
                    for(int i=0;i<ref.size();i++){
                        EntityState entstate=ref.get(i).getState();
                        if(entstate.getReference()==current){
                            ArrayList<StringToByte> byts=entstate.getBytes();
                            for(int j=0;j<byts.size();j++)
                                if(byts.get(j).getKey().equals(str)){
                                    System.out.println("Byte Deleted from Entity :: "+i);
                                    byts.remove(j--);
                                }
                        }
                    }
                    System.out.println("Change To Test :: EntityState View");
                    System.out.println("Removed Byte object");
                // LOGIC FOR DOUBLES
                }else if(selected.getStrDou()!=null){
                    String str=selected.getStrDou();
                    int ind=0;
                    for(int i=0;i<current.getInts().size();i++)
                        if(current.getDoubles().get(i).equals(str))
                            ind=i;
                    current.getDoubles().remove(ind);
                    ArrayList<GameEntity> ref=level.getEntities();
                    for(int i=0;i<ref.size();i++){
                        EntityState entstate=ref.get(i).getState();
                        if(entstate.getReference()==current){
                            ArrayList<StringToDouble> dobs=entstate.getDoubles();
                            for(int j=0;j<dobs.size();j++)
                                if(dobs.get(j).getKey().equals(str)){
                                    System.out.println("Double Deleted from Entity :: "+i);
                                    dobs.remove(j--);
                                }
                        }
                    }
                    System.out.println("Change To Test :: EntityState View");
                    System.out.println("Removed Double object");
                // LOGIC FOR INTS
                }else if(selected.getStrInt()!=null){
                    String str=selected.getStrInt();
                    int ind=0;
                    for(int i=0;i<current.getInts().size();i++)
                        if(current.getInts().get(i).equals(str))
                            ind=i;
                    current.getInts().remove(ind);
                    ArrayList<GameEntity> ref=level.getEntities();
                    for(int i=0;i<ref.size();i++){
                        EntityState entstate=ref.get(i).getState();
                        if(entstate.getReference()==current){
                            ArrayList<StringToInt> nums=entstate.getInts();
                            for(int j=0;j<nums.size();j++)
                                if(nums.get(j).getKey().equals(str)){
                                    System.out.println("Int Deleted from Entity :: "+i);
                                    nums.remove(j--);
                                }
                        }
                    }
                    System.out.println("Change To Test :: EntityState View");
                    System.out.println("Removed Int object");
                // LOGIC FOR STRINGS
                }else if(selected.getStrStr()!=null){
                    // implement
                    // edit all of the objects within the types
                    String str=selected.getStrStr();
                    int ind=0;
                    for(int i=0;i<current.getStrings().size();i++)
                        if(current.getStrings().get(i).equals(str))
                            ind=i;
                    current.getStrings().remove(ind);
                    ArrayList<GameEntity> ref=level.getEntities();
                    for(int i=0;i<ref.size();i++){
                        EntityState entstate=ref.get(i).getState();
                        if(entstate.getReference()==current){
                            ArrayList<StringToString> strs=entstate.getStrings();
                            for(int j=0;j<strs.size();i++)
                                if(strs.get(j).getKey().equals(str)){
                                    System.out.println("String Deleted from Entity :: "+i);
                                    strs.remove(j--);
                                }
                        }
                    }
                    System.out.println("Change To Test :: EntityState View");
                    System.out.println("Removed Str object");
                    // IMPLEMENT FOR IMAGE AND COLOR
                }else{
                    System.out.println("Major Error :: No Setting :: EntityStateView");
                }
            }else{
                System.out.println("Minor Error :: No Selected Item :: EntityStateView");
            }
        }
        else{
            if(temp==null)
                System.out.println("Major Error :: OptionView Null :: EntityStateView");
            if(current==null)
                System.out.println("Minor Error :: None Selected :: EntityStateView");
            if(level==null)
                System.out.println("Major Error :: Level null :: EntityStateView");
        }
        getReject().setSelected(false);
    }
    
    // draws the view and the subviews
    public void paint(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
        super.paint(g);
    }
    
    // getter methods
    public SavedEntityState getCurrent(){return current;}
    public ArrayList<SelectableLabel> getViewNames(){return viewNames;}
    public ArrayList<Label> getInputs(){return inputs;}
    public String getStateName(){return stateName;}
    
    // setter methods
    public void setCurrent(SavedEntityState param){current=param;}
    public void setViewNames(ArrayList<SelectableLabel> param){viewNames=param;}
    public void setInputs(ArrayList<Label> param){inputs=param;}
    public void setStateName(String param){stateName=param;}
}