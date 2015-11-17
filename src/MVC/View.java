import java.beans.PropertyChangeEvent;
import javax.swing.JFrame;

public abstract class View extends JFrame
{
   public MainController controller;

   public View()
   {
      initialize();
      listeners();
   }

   public abstract void initialize();
   public abstract void listeners();
   public abstract void modelPropertyChange(PropertyChangeEvent evt);
}