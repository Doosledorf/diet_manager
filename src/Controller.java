import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Method;

public abstract class Controller implements PropertyChangeListener
{
   private ArrayList<Model> listModels;
   private ArrayList<View> listViews;

   public Controller()
   {
      listModels = new ArrayList<Model>();
      listViews = new ArrayList<View>();
   }

   public void addModel(Model model)
   {
      listModels.add(model);
      model.addPropertyChangeListener(this);
   }

   public void removeModel(Model model)
   {
      listModels.remove(model);
      model.removePropertyChangeListener(this);
   }

   public void addView(View view)
   {
      listViews.add(view);
      view.addPropertyChangeListener(this);
   }

   public void removeView(View view)
   {
      listViews.remove(view);
      view.removePropertyChangeListener(this);
   }

   public void propertyChange(PropertyChangeEvent evt)
   {
      for (View view : listViews)
      {
         view.modelPropertyChange(evt);
      }
   }

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