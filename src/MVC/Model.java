import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Model
{
   protected PropertyChangeSupport propertyChangeSupport;
   
   public Model()
   {
      propertyChangeSupport = new PropertyChangeSupport(this);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener)
   {
      propertyChangeSupport.addPropertyChangeListener(listener);
   }
   
   public void removePropertyChangeListener(PropertyChangeListener listener)
   {
      propertyChangeSupport.removePropertyChangeListener(listener);
   }
   
   protected void firePropertyChange(String propertyName, Object oldVal, Object newVal)
   {
      propertyChangeSupport.firePropertyChange(propertyName, oldVal, newVal);
   }
}