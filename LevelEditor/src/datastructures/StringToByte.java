/**
 *
 * @author Zackary Misso
 * This class is used to represent a key-value mapping where the string is the
 * key and the byte is the value.
 * 
 */
package datastructures;
public class StringToByte{
    private String key;
    private byte value;
    
    public StringToByte(){
        key="";
        value=0;
    }
    
    public StringToByte(String str,byte val){
        key=str;
        value=val;
    }
    
    // getter methods
    public String getKey(){return key;}
    public byte getValue(){return value;}
    
    // setter methods
    public void setKey(String param){key=param;}
    public void setValue(byte param){value=param;}
}