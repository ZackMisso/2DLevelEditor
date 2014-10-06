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
import data.GlobalSettings;
import io.WorldReader;
import io.WorldWriter;
import entities.SavedEntityState;
import java.awt.Graphics;
import java.util.ArrayList;
public class GrandView extends View{
    private final ProgramThread thread;
    private final InputController inputs;
    private ArrayList<SavedEntityState> configs;
    private LevelView level=new LevelView();
    private AreaView areas;
    private EntityStateView entityState;
    private GameEntityView gameEntity;
    private LevelEntitiesView levelEntities;
    private SavedEntityStateView savedStates;
    private ModifiersView modifiers;
    private OptionView options;
    private final GlobalSettings settings;
    private final WorldReader reader;
    private final WorldWriter writer;
    
    // the default constructor
    public GrandView(ProgramThread param){
        super();
        thread=param;
        configs=new ArrayList<>();
        setXpos(0);
        setYpos(0);
        setWidth(800);
        setHeight(800);
        inputs=new InputController();
        settings=new GlobalSettings();
        reader=new WorldReader(this);
        writer=new WorldWriter(this);
        initializeViews(); // initializes subviews
        readDataFromFile(); // reads past data from the saved file
    }
    
    // initializes all of the subviews for this view
    private void initializeViews(){
        // initialize LevelView
        System.out.println("Initializing the Level View");
        level=new LevelView();
        level.setSuperview(this);
        level.setSettings(settings);
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
        //gameEntity.setSettings(settings);
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
        levelEntities.setEntities(level.getEntities());
    }
    
    // reads the previous saved data from a file
    private void readDataFromFile(){
        // implement
    }
    
    // handles the clicks from the user
    @Override public void clicked(){
        // impleemnt
    }
    
    // handles the types from the user
    @Override public void types(char c){
        // implement
    }

    @Override public void paint(Graphics g){
        super.paint(g);
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
    public GlobalSettings getSettings(){return settings;}
    public WorldReader getReader(){return reader;}
    public WorldWriter getWriter(){return writer;}
    
    // setter methods
    public void setConfigs(ArrayList<SavedEntityState> param){configs=param;}
}