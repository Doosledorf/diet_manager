import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Method;

public abstract class Controller implements PropertyChangeListener
{
   // Storage of all Models and Views that will be used by PCL
   private ArrayList<Model> listModels;
   private ArrayList<View> listViews;

   // Controller Constructor
   public Controller()
   {
      listModels = new ArrayList<Model>();
      listViews = new ArrayList<View>();
   }

   // Adds a model to the listModels array and to the PCL
   public void addModel(Model model)
   {
      listModels.add(model);
      model.addPropertyChangeListener(this);
   }

   // Removes a model from the listModels array and the PCL
   public void removeModel(Model model)
   {
      listModels.remove(model);
      model.removePropertyChangeListener(this);
   }

   // Adds a view to the listViews array and to the PCL
   public void addView(View view)
   {
      listViews.add(view);
      view.addPropertyChangeListener(this);
   }

   // Removes a view from the listViews array and the PCL
   public void removeView(View view)
   {
      listViews.remove(view);
      view.removePropertyChangeListener(this);
   }

   // Pushes all property changes to all views, in accordance to the MVC
   public void propertyChange(PropertyChangeEvent evt)
   {
      for (View view : listViews)
      {
         view.modelPropertyChange(evt);
      }
   }

   // Gets a stored property within the model PCL
   protected Object getModelProperty(String propertyName)
   {
   	for (Model model: listModels)
   	{
   		try
   		{
   			Method method = model.getClass().getMethod("get" + propertyName);

   			return method.invoke(model);
   		}
   		catch (Exception e)
   		{
   			e.getMessage();
   		}
   	}

   	return null;
   }

   // Sets a stored property within the model PCL
   protected void setModelProperty(String propertyName, Object newValue)
   {
   	for (Model model : listModels)
   	{
   		try
   		{
   			Method method = model.getClass().getMethod("set" + propertyName, new Class[]{newValue.getClass()});
   
   			method.invoke(model, newValue);
   		}
   		catch (Exception e)
   		{
   			e.getMessage();
   		}
   	}
   }
}