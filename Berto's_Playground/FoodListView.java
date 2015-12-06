import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.reflect.*;
import java.beans.PropertyChangeEvent;

public class FoodListView extends View 
{
   private MainController controller;
 
	public TextArea list = new TextArea("Food Eaten\n-----------------------------\n");
	private Font font = new Font("FoodFont", Font.BOLD, 16);

	public FoodListView(MainController controller)
   {
      this.controller = controller;
      this.controller.addView(this);

		this.setBackground(new Color(100,100,100));
		this.add(list);
		list.setEditable(true);
		list.setFont(font);
		this.setSize(320,320);
	}

   public void modelPropertyChange(final PropertyChangeEvent pce)
   {
      if (pce.getPropertyName().equals(controller.FOOD_LOG_DATA))
      {
         Map<String, Food> data = (Map<String, Food>) pce.getNewValue();

         for (String food : data.keySet())
         {
            Food foodObj = data.get(food);

            list.append("Name: " + foodObj.getName() + "\n");
            list.append("Calories: " + foodObj.getCal() + "\n");
            list.append("Fat: " + foodObj.getFat() + "\n");
            list.append("Carbs: " + foodObj.getCarbs() + "\n");
            list.append("Protein: " + foodObj.getProtein() + "\n-----------------------------\n");
         }
      }
   }
}
