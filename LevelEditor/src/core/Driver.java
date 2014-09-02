/**
 *
 * @author Zackary Misso
 * This class contains the main method and begins the editor.
 * 
 */
package core;
import tests.IOUnitTester;
public class Driver {
    public static void main(String[] args){
        System.out.println("Initializing LevelEditor");
        new LevelEditor(800,800,"Generic2DLevelEditor");
        // UNIT TESTS
        //new IOUnitTester();
    }
}
