import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.beans.PropertyChangeEvent;

public class FoodListView extends View 
{
   private MainController controller;
 
	public TextArea list = new TextArea("Food Eaten\n");
	private Font font = new Font("FoodFont", Font.BOLD, 16);

	public FoodListView(MainController controller)
   {
      this.controller = controller;

		this.setBackground(new Color(100,100,100));
		this.add(list);
		list.setEditable(false);
		list.setFont(font);
		this.setSize(320,320);
	}

   public void modelPropertyChange(final PropertyChangeEvent pce)
   {
      if (pce.getPropertyName().equals(controller.FOOD_LOG_DATA))
      {
         for ((String) food : pce.getNewValue())
         {
         
         }

         System.out.println(pce.getNewValue());
      }
   }
}
