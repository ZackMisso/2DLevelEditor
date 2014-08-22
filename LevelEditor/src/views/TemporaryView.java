/**
 *
 * @author Zackary Misso
 * This interface contains the required logic for a temporary view
 * 
 */
package views;
import views.major.OptionView;
public interface TemporaryView{
    public static final int xpos=600;
    public static final int ypos=300;
    public void initializeView();
    public void acceptView();
    public void rejectView();
    public void clearView();
    public void setReference(OptionView param);
}