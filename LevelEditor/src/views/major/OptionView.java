/**
 *
 * @author Zackary Misso
 * This class creates the option view. I have yet to decide what it is going to do
 * 
 */
package views.major;
import views.View;
import views.minor.TextBox;
import views.minor.Button;
import views.minor.RadialButton;
import views.minor.SelectableLabel;
import views.minor.Label;
import entities.SavedEntityState;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
public class OptionView extends View{
    private View container; // what this view is containing
    private ArrayList<View> scrollables;
    private ArrayList<View> temporaries;
    private Object referenceObject; // will depend on the type of view
    private TextBox askName; // allows the user to input a name for something
    private int index;
    private int displayCnt;
    private int radialCols;
    private boolean addEntityStateObj;
    private boolean removeEntityStateObj;
    private boolean addEntityState;
    private boolean removeEntityState;
    
    // default constructor
    public OptionView(){
        container=null;
        scrollables=new ArrayList<>();
        temporaries=new ArrayList<>();
        referenceObject=null;
        askName=null;
        addEntityStateObj=false;
        removeEntityStateObj=false;
        addEntityState=false;
        removeEntityState=false;
        index=0;
        displayCnt=4;
        radialCols=1;
        setXpos(600);
        setYpos(300);
        setWidth(200);
        setHeight(300);
        setShowing(true);
        initializeButtons();
    }
    
    // initializes the required buttons for the view
    private void initializeButtons(){
        int temp=0;
        int x=getXpos()-50;
        int y=getYpos();
        // initialize scrollUp button
        Button tempButton=new Button(temp++);
        tempButton.setSuperview(this);
        tempButton.setXpos(x+=50);
        tempButton.setYpos(y);
        tempButton.setTitle("UP");
        // add image data
        getSubviews().add(tempButton);
        // initialize scrollDown button
        tempButton=new Button(temp++);
        tempButton.setSuperview(this);
        tempButton.setXpos(x+=50);
        tempButton.setYpos(y);
        tempButton.setTitle("DOWN");
        // add image data
        getSubviews().add(tempButton);
        // initialize the accept button
        tempButton=new Button(temp++);
        tempButton.setSuperview(this);
        tempButton.setXpos(x+=50);
        tempButton.setYpos(y);
        tempButton.setTitle("YES");
        // add image data
        getSubviews().add(tempButton);
        // initialize the reject button
        tempButton=new Button(temp++);
        tempButton.setSuperview(this);
        tempButton.setXpos(x+=50);
        tempButton.setYpos(y);
        tempButton.setTitle("NO");
        // add image data
        getSubviews().add(tempButton);
        // implement more as needed
    }
    
    // initializes the radial buttons
    private void initializeRadialButtons(){
        // TODO :: SHORTEN THIS
        RadialButton rbool=new RadialButton();
        RadialButton rbyte=new RadialButton();
        RadialButton rcolor=new RadialButton();
        RadialButton rdouble=new RadialButton();
        RadialButton rimage=new RadialButton();
        RadialButton rint=new RadialButton();
        RadialButton rstring=new RadialButton();
        
        rbool.setSuperview(this);
        rbyte.setSuperview(this);
        rcolor.setSuperview(this);
        rdouble.setSuperview(this);
        rimage.setSuperview(this);
        rint.setSuperview(this);
        rstring.setSuperview(this);
        
        int num=0;
        
        rbool.setIndex(num++);
        rbyte.setIndex(num++);
        rcolor.setIndex(num++);
        rdouble.setIndex(num++);
        rimage.setIndex(num++);
        rint.setIndex(num++);
        rstring.setIndex(num++);
        
        rbool.setText("Bool");
        rbyte.setText("Byte");
        rcolor.setText("Color");
        rdouble.setText("Double");
        rimage.setText("Image");
        rint.setText("Int");
        rstring.setText("String");

        rbool.setWidth(200);
        rbyte.setWidth(200);
        rcolor.setWidth(200);
        rdouble.setWidth(200);
        rimage.setWidth(200);
        rint.setWidth(200);
        rstring.setWidth(200);

        rbool.setHeight(30);
        rbyte.setHeight(30);
        rcolor.setHeight(30);
        rdouble.setHeight(30);
        rimage.setHeight(30);
        rint.setHeight(30);
        rstring.setHeight(30);
        
        scrollables.add(rbool);
        scrollables.add(rbyte);
        scrollables.add(rcolor);
        scrollables.add(rdouble);
        scrollables.add(rimage);
        scrollables.add(rint);
        scrollables.add(rstring);
        
        getSubviews().add(rbool);
        getSubviews().add(rbyte);
        getSubviews().add(rcolor);
        getSubviews().add(rdouble);
        getSubviews().add(rimage);
        getSubviews().add(rint);
        getSubviews().add(rstring);
        
        refactorViews();
    }
    
    // checks and initializes the view based on what the option view should display
    public void checkInitialization(){
        if(addEntityStateObj)
            initializeAddEntityStateObj();
        if(removeEntityStateObj)
            initializeRemoveEntityStateObj();
        if(addEntityState)
            initializeAddEntityState();
        if(removeEntityState)
            initializeRemoveEntityState();
        
        // implement the rest as they are needed
    }
    
    // checks and does the accepting functionality for the current view
    private void acceptCurrentView(int btnval){
        // implement button modifier logic
        if(addEntityStateObj)
            acceptAddEntityStateObj();
        if(removeEntityStateObj)
            acceptRemoveEntityStateObj();
        if(addEntityState)
            acceptAddEntityState();
        if(removeEntityState)
            acceptRemoveEntityState();
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval){
                    temp.setSelected(false);
                }
            }
        // implement the rest as they are needed
    }
    
    // checks and does the rejecting functionality for the current view
    private void rejectCurrentView(int btnval){
        // implement -- this should be the same for every view
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval){
                    temp.setSelected(false);
                }
            }
        referenceObject=false;
        clearBools();
        // implement more maybe
    }
    
    // initializes the add entity state obj view
    private void initializeAddEntityStateObj(){
        clearCurrentView();
        System.out.println("THIS CODE IS WORKING :: OpionView");
        initializeRadialButtons();
        askName=new TextBox(16);
        askName.setSuperview(this);
        askName.setXpos(getXpos()); // edit
        askName.setYpos(getYpos()+getHeight()-30); // edit
        // implement more for askName
        // TODO :: ADD A METHOD THAT ADDS THE BUTTONS FOR YOU
        getSubviews().add(askName);
        temporaries.add(askName);
        if(referenceObject==null){
            System.out.println("Major Error :: No Reference :: OptionView");
        }
        if(!(referenceObject instanceof SavedEntityState)){
            System.out.println("Major Error :: Wrong Type :: OptionView");
        }
    }
    
    // handles accepting the add entity state obj
    private void acceptAddEntityStateObj(){
        RadialButton selected=null;
        for(int i=0;i<scrollables.size();i++)
            if(scrollables.get(i).getSelected())
                selected=(RadialButton)scrollables.get(i);
        if(!askName.getContents().equals("")&&selected!=null){
            String name=askName.getContents();
            SavedEntityState state=(SavedEntityState)referenceObject;
            GrandView superview=(GrandView)getSuperview();
            if(selected.getText().equals("Bool")){
                System.out.println("Adding To Entity :: Bool :: OptionView");
                //SavedEntityState state=(SavedEntityState)referenceObject;
                state.getBooleans().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Byte")){
                System.out.println("Adding To Entity :: Byte :: OptionView");
                //SavedEntityState state=(SavedEntityState)referenceObject;
                state.getBytes().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Color")){
                System.out.println("Adding To Entity :: Color :: OptionView");
                //SavedEntityState state=(SavedEntityState)referenceObject;
                state.getColors().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Double")){
                System.out.println("Adding To Entity :: Double :: OptionView");
                //SavedEntityState state=(SavedEntityState)referenceObject;
                state.getDoubles().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Image")){
                System.out.println("Adding To Entity :: Image :: OptionView");
                //SavedEntityState state=(SavedEntityState)referenceObject;
                state.getImages().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("Int")){
                System.out.println("Adding To Entity :: Int :: OptionView");
                //SavedEntityState state=(SavedEntityState)referenceObject;
                state.getInts().add(name);
                // implement more if needed
                // Will need to add to all game entities
            }
            if(selected.getText().equals("String")){
                System.out.println("Adding To Entity :: String :: OptionView");
                //SavedEntityState state=(SavedEntityState)referenceObject;
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
        addEntityStateObj=false;
        clearCurrentView();
    }
    
    // initializes the remove entity state obj view
    private void initializeRemoveEntityStateObj(){
        clearCurrentView();
        // implement
    }
    
    // handles accepting the remove entity state obj
    private void acceptRemoveEntityStateObj(){
        // implement
    }
    
    // initializes the remove entity state view
    private void initializeRemoveEntityState(){
        clearCurrentView();
        System.out.println("Initializing Remove Entity State");
        Label temp=new Label();
        temp.setText("Would You Really Like To Delete This Saved State");
        temp.setXpos(getXpos()+4);
        temp.setYpos(getYpos()+100);
        temp.setSuperview(this);
        temporaries.add(temp);
        getSubviews().add(temp);
        System.out.println("Change Was Made Test :: OptionView");
    }
    
    // handles accepting the remove entity state
    private void acceptRemoveEntityState(){
        SavedEntityState state=(SavedEntityState)referenceObject;
        GrandView view=(GrandView)getSuperview();
        SavedEntityStateView sesv=view.getSavedStates();
        EntityStateView esv=view.getEntityState();
        //ArrayList<SelectableLabel> labels=sesv.getLabels();
        ArrayList<SelectableLabel> labels=sesv.getScrollablesAsLabels();
        // DEBUG INFO :: THIS IS FOR THIS VIEW
        for(int i=0;i<temporaries.size();i++){
            getSubviews().remove(temporaries.get(i));
            temporaries.remove(i--);
        }
        if(state==null){
            System.out.println("Major Error :: State Null :: OptionView");
            return;
        }
        // DEBUG INFO :: THIS IS THIS VIEW
        //System.out.println("THIS SHOULD WORK :: "+state.getName());
        String name=state.getName();
        view.getConfigs().remove(state);
        //sesv.refactorLabels();
        System.out.println("LABELS :: "+labels.size());
        for(int i=0;i<labels.size();i++)
            if(labels.get(i).getText().equals(name))
                sesv.getSubviews().remove(labels.remove(i--));
        sesv.refactorLabels();
        esv.setCurrent(null);
        esv.redrawView();
        removeEntityState=false;
        clearCurrentView();
        //System.out.println("LABELS :: "+labels.size());
        //System.out.println("Change Was Made Test :: OptionView");
    }
    
    // initializes the add entity state view
    private void initializeAddEntityState(){
        clearCurrentView();
        System.out.println("Initializing Add Entity State");
        askName=new TextBox(20);
        askName.setXpos(getXpos());
        askName.setYpos(getYpos()+getHeight()-30);
        askName.setSuperview(this);
        //askName.setYpos(0);
        getSubviews().add(askName);
        // implement more if needed
    }
    
    // handles accepting the add entity state
    private void acceptAddEntityState(){
        //if(referenceObject instanceof ArrayList){
        System.out.println("TEST :: 010110");
        if(!askName.getContents().equals("")){
            //ArrayList<SavedEntityState> states=(ArrayList<SavedEntityState>)referenceObject;
            SavedEntityState add=new SavedEntityState();
            add.setName(askName.getContents());
            add.createDefaultState();
            //states.add(add);
            GrandView view=(GrandView)getSuperview();
            //view.getSavedStates().getSavedStates().add(add);
            view.getConfigs().add(add);
            //view.getSavedStates().getSavedStates().add(new SavedEntityState());
            //System.out.println(view.getSavedStates().getSavedStates().size());
            view.getSavedStates().refactorLabels();
            //System.out.println(view.getSavedStates().getSavedStates().size());
        }else{
            System.out.println("Minor Error :: text field blank :: OptionView");
        }
        // implement the actual new entity and add it to the list of entities
        getSubviews().remove(askName);
        askName=null;
        addEntityState=false;
        clearCurrentView();
            
            
        //}else{
        //    System.out.println("Major Error :: reference object not ArrayList :: Option View");
        //}
    }
    
    // clears the current view to make the initialization for the new one smoother
    private void clearCurrentView(){
        //referenceObject=null; // This causes an error
        for(int i=0;i<temporaries.size();i++){
            getSubviews().remove(temporaries.get(i));
            temporaries.remove(i--);
        }
        for(int i=0;i<scrollables.size();i++){
            getSubviews().remove(scrollables.get(i));
            scrollables.remove(i--);
        }
        //scrollables.clear();
        for(int i=0;i<getSubviews().size();i++){
            if(getSubviews().get(i)instanceof TextBox)
                getSubviews().remove(i--);
            // implement more if needed
        }
        askName=null;
    }
    
    // handles the button clicks
    public void update(){
        super.update();
        switch(buttonSelected()){
            case -1:
                break;
            case 0:
                scrollUp(0);
                break;
            case 1:
                scrollDown(1);
                break;
            case 2:
                acceptCurrentView(2);
                break;
            case 3:
                rejectCurrentView(3);
                break;
            default:
                System.out.println("More Buttons included than initialized -- OptionView");
                break;
        }
    }
    
    // sets all of the view based booleans to false
    public void clearBools(){
        addEntityStateObj=false;
        removeEntityState=false;
        addEntityState=false;
        removeEntityState=false;
        // implement more as they are added
    }
    
    // handles the scroll up logic
    private void scrollUp(int btnval){
        if(index>0){
            index-=radialCols; // this is for only one case
            refactorViews();
        }
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval){
                    temp.setSelected(false);
                }
            }
    }
    
    // handles the scroll down logic
    private void scrollDown(int btnval){
        if(index+displayCnt<scrollables.size()){
            index+=radialCols; // this is for only one case
            refactorViews();
        }
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval){
                    temp.setSelected(false);
                }
            }
    }
    
    // updates the locations of the scrollables
    private void refactorViews(){
        int x=getXpos();
        int y=getYpos()+20;
        int c=radialCols;
        for(int i=0;i<scrollables.size();i++){
            RadialButton temp=(RadialButton)scrollables.get(i);
            boolean one=temp.getIndex()>index;
            boolean two=temp.getIndex()<index+displayCnt*radialCols;
            if(one&&two){
                System.out.println("FOUR MICE OF MEN");
                //temp.setXpos(x);
                //temp.setYpos(y);
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
    
    // TODO :: Add a method in the View class to turn off the specified button
    
    // handles the clicks on this view
    public void clicked(){
        System.out.println("Option View was clicked");
        subviewFalsify();
        // implement more if needed
    }
    
    // handles the types on this view
    public void types(char c){
        // implement
    }
    
    // draws this views private variables to the screen
    public void paint(Graphics g){
        g.setColor(Color.pink);
        g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
        if(addEntityStateObj){
            // implement
        }
        if(removeEntityStateObj){
            // implement
        }
        if(addEntityState){
            // implement
        }
        if(removeEntityState){
            // implement
        }
        super.paint(g); // maybe not need
    }
    
    // getter methods
    public View getContainer(){return container;}
    public ArrayList<View> getScrollables(){return scrollables;}
    public ArrayList<View> getTemporaries(){return temporaries;}
    public Object getReferenceObject(){return referenceObject;}
    public TextBox getAskName(){return askName;}
    //public Button getScrollUp(){return scrollUp;}
    //public Button getScrollDown(){return scrollDown;}
    //public Button getAccept(){return accept;}
    //public Button getReject(){return reject;}
    public int getIndex(){return index;}
    public int getDisplayCnt(){return displayCnt;}
    public int getRadialCols(){return radialCols;}
    public boolean getAddEntityStateObj(){return addEntityStateObj;}
    public boolean getRemoveEntityStateObj(){return removeEntityStateObj;}
    public boolean getAddEntityState(){return addEntityState;}
    public boolean getRemoveEntityState(){return removeEntityState;}
    
    // setter methods
    public void setContainer(View param){container=param;}
    public void setScrollables(ArrayList<View> param){scrollables=param;}
    public void setTemporaries(ArrayList<View> param){temporaries=param;}
    public void setReferenceObject(Object param){referenceObject=param;}
    public void setAskName(TextBox param){askName=param;}
    //public void setScrollUp(Button param){scrollUp=param;}
    //public void setScrollDown(Button param){scrollDown=param;}
    //public void setAccept(Button param){accept=param;}
    //public void setReject(Button param){reject=param;}
    public void setIndex(int param){index=param;}
    public void setDisplayCnt(int param){displayCnt=param;}
    public void setRadialCols(int param){radialCols=param;}
    public void setAddEntityStateObj(boolean param){addEntityStateObj=param;}
    public void setRemoveEntityStateObj(boolean param){removeEntityStateObj=param;}
    public void setAddEntityState(boolean param){addEntityState=param;}
    public void setRemoveEntityState(boolean param){removeEntityState=param;}
}