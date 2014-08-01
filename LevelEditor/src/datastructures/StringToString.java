/**
 *
 * @author Zackary Misso
 * This class is used to represent a key-value mapping where the string is the
 * key and the string is the value.
 * 
 */
package datastructures;
public class StringToString {
    private String key;
    private String value;
    
    public StringToString(){
        key="";
        value="";
    }
    
    public StringToString(String str,String val){
        key=str;
        value=val;
    }
    
    // getter methods
    public String getKey(){return key;}
    public String getValue(){return value;}
    
    // setter methods
    public void setKey(String param){key=param;}
    public void setValue(String param){value=param;}
}
