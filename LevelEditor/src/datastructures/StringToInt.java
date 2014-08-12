/**
 *
 * @author Zackary Misso
 * This class is used to represent a key-value mapping where the string is the
 * key and the int is the value.
 * 
 */
package datastructures;
public class StringToInt{
    private String key;
    private int value;
    
    public StringToInt(){
        key="";
        value=0;
    }
    
    public StringToInt(String str,int val){
        key=str;
        value=val;
    }
    
    // getter methods
    public String getKey(){return key;}
    public int getValue(){return value;}
    
    // setter methods
    public void setKey(String param){key=param;}
    public void setValue(int param){value=param;}
}
