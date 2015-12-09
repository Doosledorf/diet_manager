import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Model
{
   // PropertyChangeSupport decl
   protected PropertyChangeSupport propertyChangeSupport;

   // Model Constructor
   public Model()
   {
      propertyChangeSupport = new PropertyChangeSupport(this);
   }

   // Adds a property to the PCS
   public void addPropertyChangeListener(PropertyChangeListener listener)
   {
      propertyChangeSupport.addPropertyChangeListener(listener);
   }

   // Removes a property from the PCS
   public void removePropertyChangeListener(PropertyChangeListener listener)
   {
      propertyChangeSupport.removePropertyChangeListener(listener);
   }

   // Fires the change of a property's data
   protected void firePropertyChange(String propertyName, Object oldVal, Object newVal)
   {
      propertyChangeSupport.firePropertyChange(propertyName, oldVal, newVal);
   }
}