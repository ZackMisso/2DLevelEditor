/**
 * 
 * @author Zackary Misso
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 **/
package datastructures;
import java.awt.Image;
public class StringToImage{
	private String key;
	private Image value;
    //private int width;
    //private int height;

    public StringToImage(){
    	// implement
    }

    public StringToImage(String str,Image img){
    	// implement
    }
    
    public int getWidth(){
        return value.getWidth(null);
    }
    
    public int getHeight(){
        return value.getHeight(null);
    }

    // getter methods
    public String getKey(){return key;}
    public Image getValue(){return value;}

    // setter methods
    public void setKey(String param){key=param;}
    public void setValue(Image param){value=param;}
}
