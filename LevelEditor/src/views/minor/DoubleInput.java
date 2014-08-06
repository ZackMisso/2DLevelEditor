/**
 *
 * @author Zackary Misso
 * This class holds the logic for an Input Box for doubles
 * NOTE :: MAYBE CHANGE THE NUMBER INPUT CLASS TO DO THIS TOO
 * 
 */
package views.minor;
import views.View;
import java.awt.Graphics;
public class DoubleInput extends View{
    private NumberInput wholeNumber;
    private NumberInput decimalNumber;
    private String title;
    private boolean hasTitle;
    
    public DoubleInput(){
        // implement
    }
    
    public void clicked(){
        // implement
    }
    
    public void types(char c){
        // implement
    }
    
    public double getContentsAsDouble(){
        // implement
        return 0.0;
    }
    
    public void paint(Graphics g){
        // implement
        super.paint(g);
    }
    
    // getter methods
    
    public NumberInput getWholeNumber(){return wholeNumber;}
    public NumberInput getDecimalNumber(){return decimalNumber;}
    public String getTitle(){return title;}
    public boolean getHasTitle(){return hasTitle;}
    
    // setter methods
    public void setWholeNumber(NumberInput param){wholeNumber=param;}
    public void setDecimalNumber(NumberInput param){decimalNumber=param;}
    public void setTitle(String param){title=param;}
    public void setHasTitle(boolean param){hasTitle=param;}
}
