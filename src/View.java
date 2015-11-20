import java.beans.PropertyChangeEvent;
import javax.swing.JFrame;

public abstract class View extends JFrame
{
   public MainController controller;

   public void modelPropertyChange(PropertyChangeEvent evt) {};
}