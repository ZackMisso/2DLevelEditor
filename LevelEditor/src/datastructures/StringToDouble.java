/**
 *
 * @author Zackary Misso
 * This class is used to represent a key-value mapping where the string is the
 * key and the double is the value.
 * 
 */
package datastructures;
public class StringToDouble {
    private String key;
    private double value;
    
    public StringToDouble(){
        key="";
        value=0.0;
    }
    
    public StringToDouble(String str,double val){
        key=str;
        value=val;
    }
    
    // getter methods
    public String getKey(){return key;}
    public double getValue(){return value;}
    
    // setter methods
    public void setKey(String param){key=param;}
    public void setValue(double param){value=param;}
}