/**
 *
 * @author Zackary Misso
 * This class will contain the level modifiers (buttons that do stuff)
 * 
 */
package views.major;
import views.View;
import views.minor.Button;
import entities.GameEntity;
import entities.SavedEntityState;
import io.WorldWriter;
import java.awt.Graphics;
import java.awt.Color;
public class ModifiersView extends View{
    // TODO :: LEARN HOW TO OPEN OTHER PROJECTS
    // default constructor
    public ModifiersView(){
        setXpos(0);
        setYpos(568);
        setWidth(600);
        setHeight(32);
        setShowing(true);
        initializeSubviews();
    }
    
    // initializes all of the subviews for this view
    private void initializeSubviews(){
        int temp=0;
        int x=-55;
        int y=getYpos()+6;
        makeButton(temp++,x+=60,y,this,"S LEV");
        makeButton(temp++,x+=60,y,this,"SETT");
        makeButton(temp++,x+=60,y,this,"->");
        makeButton(temp++,x+=60,y,this,"<-");
        makeButton(temp++,x+=60,y,this,"CGO");
        makeButton(temp++,x+=60,y,this,"CE");
        makeButton(temp++,x+=60,y,this,"DGO");
        makeButton(temp++,x+=60,y,this,"DE");
        makeButton(temp++,x+=60,y,this," ^");
        makeButton(temp++,x+=60,y,this," v");
    }
    
    // handles user clicks
    public void clicked(){
        System.out.println("Modifiers View was clicked");
        subviewFalsify();
    }
    
    // checks if an action should be performed
    public void update(){
        super.update();
        switch(this.buttonSelected()){
            case -1:
                break;
            case 0:
                saveLevel(0);
                break;
            case 1:
                changeSettings(1);
                break;
            case 2:
                shiftRight(2);
                break;
            case 3:
                shiftLeft(3);
                break;
            case 4:
                createGameObject(4);
                break;
            case 5:
                createEntity(5);
                break;
            case 6:
                deleteGameObject(6);
                break;
            case 7:
                deleteEntity(7);
                break;
            case 8:
                shiftUp(8);
                break;
            case 9:
                shiftDown(9);
                break;
        }
    }        
    
    // handles user types
    public void types(char c){
        // implement
    }
    
    // what happens when the save level button is pressed
    public void saveLevel(int btnval){
        System.out.println("Save Level Button pressed");
        GrandView grand=(GrandView)getSuperview();
        WorldWriter writer=grand.getWriter();
        writer.writeWorld();
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // what happens when the open level button is pressed
    public void changeSettings(int btnval){
        System.out.println("Change Settings Button pressed");
        GrandView grand=findGrandView();
        grand.getOptions().clearBools();
        grand.getOptions().setGlobalSettings(true);
        grand.getOptions().checkInitialization();
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // what happens when the shift right button is pressed
    public void shiftRight(int btnval){
        System.out.println("Shift Right Button pressed");
        GrandView grand=(GrandView)getSuperview();
        LevelView level=grand.getLevel();
        level.setLevelX(level.getLevelX()-40);
        level.refactorLocations(-40,0);
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // what happens when the shift left button is pressed
    public void shiftLeft(int btnval){
        System.out.println("Shift Left Button pressed");
        GrandView grand=(GrandView)getSuperview();
        LevelView level=grand.getLevel();
        level.setLevelX(level.getLevelX()+40);
        level.refactorLocations(40,0);
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // what happens when the create game object button is pressed
    public void createGameObject(int btnval){
        System.out.println("Create Game Object Button pressed");
        GrandView grand=findGrandView();
        SavedEntityState state=grand.getSavedStates().getSelectedState();
        if(state!=null){
            GameEntity entity=new GameEntity();
            if(entity.getState()==null)
                System.out.println("Major Error :: EntityState null :: ModifiersView");
            entity.getState().setReference(state);
            entity.getState().initializeFromReference();
            GameEntityView gev=grand.getGameEntity();
            gev.setCurrent(entity);
            System.out.println("GameEntityView redraw :: ModifiersView");
            gev.redrawView();
            // implement more possibly
        }else{
            System.out.println("Minor Error :: No Saved State Selected :: ModifiersView");
        }
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // what happens when the create entity button is pressed
    public void createEntity(int btnval){
        System.out.println("Create Entity Button pressed");
        // implement
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // what happens when the delete game object button is pressed
    public void deleteGameObject(int btnval){
        System.out.println("Delete Game Object Button pressed");
        GrandView grand=findGrandView();
        LevelView level=grand.getLevel();
        GameEntity selected=level.getSelectedEntity();
        if(selected!=null){
            level.getEntities().remove(selected);
            level.getSubviews().remove(selected);
        }
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // what happens when the delete entity button is pressed
    public void deleteEntity(int btnval){
        System.out.println("Delete Entity Button pressed");
        // implement
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // what happens when the shift up button is pressed
    public void shiftUp(int btnval){
        System.out.println("Shift Up Button pressed");
        GrandView grand=findGrandView();
        LevelView level=grand.getLevel();
        level.setLevelY(level.getLevelY()+40);
        level.refactorLocations(0,40);
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // what happens when the shift down button is pressed
    public void shiftDown(int btnval){
        System.out.println("Shift Down Button pressed");
        GrandView grand=(GrandView)getSuperview();
        LevelView level=grand.getLevel();
        level.setLevelY(level.getLevelY()-40);
        level.refactorLocations(0,-40);
        for(int i=0;i<getSubviews().size();i++)
            if(getSubviews().get(i)instanceof Button){
                Button temp=(Button)getSubviews().get(i);
                if(temp.getIndex()==btnval)
                    temp.setSelected(false);
            }
    }
    
    // paints the background for this view
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(getXpos(),getYpos(),getWidth(),getHeight());
        super.paint(g);
    }
}