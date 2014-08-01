/**
 *
 * @author Zackary Misso
 * This class will contain the entire view for the editor and all of its
 * subviews. Note : I named this with a very distinct name because I will be
 * using this project for other projects in the future, and this class will be
 * used only for this project.
 * 
 */
package views.major;
import views.View;
import core.InputController;
import core.ProgramThread;
import io.WorldReader;
import io.WorldWriter;
import entities.SavedEntityState;
import java.awt.Graphics;
import java.util.ArrayList;
public class GrandView extends View{
    private ProgramThread thread;
    private InputController inputs;
    private ArrayList<SavedEntityState> configs;
    // Actual Classes
    private LevelView level;
    private AreaView areas;
    private EntityStateView entityState;
    private GameEntityView gameEntity;
    private LevelEntitiesView levelEntities;
    private SavedEntityStateView savedStates;
    private ModifiersView modifiers;
    private OptionView options;
    private WorldReader reader;
    private WorldWriter writer;
    
    // the default constructor
    public GrandView(){
        super();
        //levels=new LevelContainer(); // maybe a thing
        configs=new ArrayList<>();
        setXpos(0);
        setYpos(0);
        setWidth(800);
        setHeight(800);
        inputs=new InputController();
        reader=new WorldReader(this);
        writer=new WorldWriter(this);
        initializeViews(); // initializes subviews
        readDataFromFile(); // reads past data from the saved file
        setShowing(true);
    }
    
    // initializes all of the subviews for this view
    private void initializeViews(){
        // initialize LevelView
        System.out.println("Initializing the Level View");
        level=new LevelView();
        level.setSuperview(this);
        getSubviews().add(level);
        // initialize AreaView
        System.out.println("Initializing the Area View");
        areas=new AreaView();
        areas.setSuperview(this);
        getSubviews().add(areas);
        // initialize EntityStateView
        System.out.println("Initializing the Entity State View");
        entityState=new EntityStateView();
        entityState.setSuperview(this);
        getSubviews().add(entityState);
        // initialize GameEntityView
        System.out.println("Initializing the Game Entity View");
        gameEntity=new GameEntityView();
        gameEntity.setSuperview(this);
        getSubviews().add(gameEntity);
        // initialize LevelEntitiesView
        System.out.println("Initializing the Level Entities View");
        levelEntities=new LevelEntitiesView();
        levelEntities.setSuperview(this);
        getSubviews().add(levelEntities);
        // initialize SavedEntityStateView
        System.out.println("Initializing the Saved Entity State View");
        savedStates=new SavedEntityStateView();
        savedStates.setSuperview(this);
        savedStates.setSavedStates(configs);
        getSubviews().add(savedStates);
        // initialize ModifiersView
        System.out.println("Initializing the Modifiers View");
        modifiers=new ModifiersView();
        modifiers.setSuperview(this);
        getSubviews().add(modifiers);
        // initialize OptionView
        System.out.println("Initializing the Options View");
        options=new OptionView();
        options.setSuperview(this);
        getSubviews().add(options);
    }
    
    // reads the previous saved data from a file
    private void readDataFromFile(){
        // implement
    }
    
    // handles the clicks from the user
    public void clicked(){
        System.out.println("Grand View was clicked");
        // impleemnt
    }
    
    // handles the types from the user
    public void types(char c){
        // implement
    }

    // custom selection handling
    public void customFalsify(){
        // implement
    }
    
    public void paint(Graphics g){
        super.paint(g);
        // implement
    }
    
    // getter methods
    public ProgramThread getThread(){return thread;}
    public InputController getInputs(){return inputs;}
    public ArrayList<SavedEntityState> getConfigs(){return configs;}
    public LevelView getLevel(){return level;}
    public AreaView getAreas(){return areas;}
    public EntityStateView getEntityState(){return entityState;}
    public GameEntityView getGameEntity(){return gameEntity;}
    public LevelEntitiesView getLevelEntities(){return levelEntities;}
    public SavedEntityStateView getSavedStates(){return savedStates;}
    public ModifiersView getModifiers(){return modifiers;}
    public OptionView getOptions(){return options;}
    public WorldReader getReader(){return reader;}
    public WorldWriter getWriter(){return writer;}
    
    // setter methods
    public void setThread(ProgramThread param){thread=param;}
    public void setInputs(InputController param){inputs=param;}
    public void setConfigs(ArrayList<SavedEntityState> param){configs=param;}
    public void setLevel(LevelView param){level=param;}
    public void setAreas(AreaView param){areas=param;}
    public void setEntityState(EntityStateView param){entityState=param;}
    public void setGameEntity(GameEntityView param){gameEntity=param;}
    public void setLevelEntities(LevelEntitiesView param){levelEntities=param;}
    public void setSavedStates(SavedEntityStateView param){savedStates=param;}
    public void setModifiers(ModifiersView param){modifiers=param;}
    public void setOptions(OptionView param){options=param;}
    public void setWorldReader(WorldReader param){reader=param;}
    public void setWorldWriter(WorldWriter param){writer=param;}
}