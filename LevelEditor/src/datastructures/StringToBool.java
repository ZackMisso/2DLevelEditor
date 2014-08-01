/**
 *
 * @author Zackary Misso
 * This class is used to represent a key-value mapping where the string is the
 * key and the byte is the value.
 * 
 */
package datastructures;
public class StringToBool {
    private String key;
    private boolean value;
    
    public StringToBool(){
        key="";
        value=false;
    }
    
    public StringToBool(String str,boolean val){
        key=str;
        value=val;
    }
    
    // getter methods
    public String getKey(){return key;}
    public boolean getValue(){return value;}
    
    // setter methods
    public void setKey(String param){key=param;}
    public void setValue(boolean param){value=param;}
}
