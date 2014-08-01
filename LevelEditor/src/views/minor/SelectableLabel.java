/**
 *
 * @author Zackary Misso
 * This class contains the logic for a label that can be selected
 * 
 */
package views.minor;
import views.View;
import views.major.GrandView;
import views.major.EntityStateView;
import entities.SavedEntityState;
import entities.GameEntity;
import data.Area;
import java.awt.Color;
import java.awt.Graphics;
public class SelectableLabel extends View{
    private Object reference;
    private String text;
    private int index;
    private boolean repArea; // represents an area
    private boolean repEntity; // represents an entity
    private boolean repSavedEntity; // represents a saved entity
    private boolean repStrBool;
    private boolean repStrByte;
    private boolean repStrDou;
    private boolean repStrInt;
    private boolean repStrStr;
    private boolean repStrCol; // add this in later
    private boolean repStrImg; // add this in later
    
    // default constructor
    public SelectableLabel(){
        super();
        reference=null;
        text="";
        index=-10;
        repArea=false;
        repEntity=false;
        repSavedEntity=false;
        repStrBool=false;
        repStrByte=false;
        repStrDou=false;
        repStrInt=false;
        repStrStr=false;
        repStrCol=false;
        repStrImg=false;
    }
    
    // handles the clicks on this view
    public void clicked(){
        //subviewFalsify();
        setSelected(true);
        System.out.println("SELECTED==true");
        if(getSuperview()!=null){
            //InputController input=((PokemonEditorGrandView)getSuperview().getSuperview()).getInputs();
            if(repArea){
                // implement
            }
            if(repEntity){
                // implement
            }
            if(repSavedEntity){
                if(getSuperview()!=null){
                    View temp=getSuperview();
                    while(!(temp instanceof GrandView))
                        temp=temp.getSuperview();
                    EntityStateView esv=((GrandView)temp).getEntityState();
                    esv.setCurrent((SavedEntityState)reference);
                    esv.redrawView();
                    System.out.println(getSelected());
                    //if(!getSelected())
                    //    System.out.println("wat");
                }else{
                    System.out.println("Major Error :: Superview Null :: SelectableLabel");
                }
                System.out.println("Changed Test :: Selectable Label");
            }
            if(repStrBool){
                // will probably do nothing
            }
            if(repStrByte){
                // will probably do nothing
            }
            if(repStrDou){
                // will probably do nothing
            }
            if(repStrInt){
                // will probably do nothing
            }
            if(repStrStr){
                // will probably do nothing
            }
            if(repStrCol){
                // will probably do nothing
            }
            if(repStrImg){
                // will probably do nothing
            }
        }else{
            System.out.println("Major Error :: Superview null :: SelectableLabel");
        }
        //setSelected(true);
    }
    
    // handles the types on this view
    public void types(char c){
        // implement
    }
    
    // draws this views private variables to the screen
    public void paint(Graphics g){
        if(getXpos()>0&&getYpos()>0){
            g.setColor(Color.black);
            g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
            g.setColor(Color.white);
            g.drawString(text,getXpos()+8,getYpos()+20);
            if(getSelected())
                g.drawRect(getXpos(),getYpos(),getWidth(),getHeight());
        }
    }
    
    // returns the GameEntity cast of the object reference
    public GameEntity getEntity(){
        if(repEntity)
            return (GameEntity)reference;
        return null;
    }
    
    // returns the Area cast of the object reference
    public Area getArea(){
        if(repArea)
            return (Area)reference;
        return null;
    }
    
    // returs the saved entity case of the object reference
    public SavedEntityState getSavedEntityState(){
        if(repSavedEntity)
            return (SavedEntityState)reference;
        return null;
    }
    
    // returns the StrBool case of the object reference
    public String getStrBool(){
        if(repStrBool)
            return (String)reference;
        return null;
    }
    
    // returns the StrByte case of the object reference
    public String getStrByte(){
        if(repStrByte)
            return (String)reference;
        return null;
    }
    
    // returns the StrDouble case of the object reference
    public String getStrDou(){
        if(repStrDou)
            return (String)reference;
        return null;
    }
    
    // returns the StrInt case of the object reference
    public String getStrInt(){
        if(repStrInt)
            return (String)reference;
        return null;
    }
    
    // returns the StrStr case of the object reference
    public String getStrStr(){
        if(repStrStr)
            return (String)reference;
        return null;
    }
    
    // getter methods
    public Object getReference(){return reference;}
    public String getText(){return text;}
    public int getIndex(){return index;}
    public boolean getRepArea(){return repArea;}
    public boolean getRepEntity(){return repEntity;}
    public boolean getRepSavedEntity(){return repSavedEntity;}
    public boolean getRepStrBool(){return repStrBool;}
    public boolean getRepStrByte(){return repStrByte;}
    public boolean getRepStrDou(){return repStrDou;}
    public boolean getRepStrInt(){return repStrInt;}
    public boolean getRepStrStr(){return repStrStr;}
    public boolean getRepStrCol(){return repStrCol;}
    public boolean getRepStrImg(){return repStrImg;}
    
    // setter methods
    public void setReference(Object param){reference=param;}
    public void setText(String param){text=param;}
    public void setIndex(int param){index=param;}
    public void setRepArea(boolean param){repArea=param;}
    public void setRepEntity(boolean param){repEntity=param;}
    public void setRepSavedEntity(boolean param){repSavedEntity=param;}
    public void setRepStrBool(boolean param){repStrBool=param;}
    public void setRepStrByte(boolean param){repStrByte=param;}
    public void setRepStrDou(boolean param){repStrDou=param;}
    public void setRepStrInt(boolean param){repStrInt=param;}
    public void setRepStrStr(boolean param){repStrStr=param;}
    public void setRepStrCol(boolean param){repStrCol=param;}
    public void setRepStrImg(boolean param){repStrImg=param;}
}