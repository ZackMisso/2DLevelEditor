/*
 *
 * @author Zackary Misso
 * This class is used to represent a key-value mapping where the
 * string is the key and the color is the mapping
 *
 */
package datastructures;
import java.awt.Color;
public class StringToColor {
    private String key;
    private Color value;

    public StringToColor(){
    	key="";
    	value=null;
    }

    public StringToColor(String str,Color val){
    	key=str;
    	value=val;
    }

    // getter methods
    public String getKey(){return key;}
    public Color getValue(){return value;}

    // setter methods
    public void setKey(String param){key=param;}
    public void setValue(Color param){value=param;}
}
