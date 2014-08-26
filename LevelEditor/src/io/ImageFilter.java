/**
 *
 * @author Zackary Misso
 * An extension of Java's FilenameFilter to filter the images out of the resource folder
 * 
 */
package io;
import java.io.File;
import java.io.FilenameFilter;
public class ImageFilter implements FilenameFilter{
    private final String[] extensions={".png",".jpeg",".bmp"};
    // the method to decide if the file should be filtered
    @Override public boolean accept(File dir,String name){
        for(String ext : extensions)
            if(name.endsWith(ext))
                return true;
        return false;
    }
}