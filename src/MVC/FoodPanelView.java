import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class FoodPanelView extends Panel
{
   Panel addFood = new Panel();
   
   Panel calPane = new Panel();
   Label calLabel = new Label("Calories: ");
   TextField calField = new TextField(20);
   
   Label addFoodLabel = new Label("Add Food");
   
   TextField foodBox = new TextField(50);
   Panel searchboxpane = new Panel();
   Button addFoodButton = new Button("Add Food");
   Panel addingFood = new Panel();
   Font addFont = new Font("addFont",Font.CENTER_BASELINE,24);

	public FoodPanelView(FoodListView fl)
   {
      this.setSize(320, 320);
      this.setBackground(new Color(100,100,100));
      this.setLayout(new GridLayout(1,2));
      calPane.add(calLabel);
      calPane.add(calField);
      addFood.setLayout(new GridLayout(4,1));
      addFood.add(addFoodLabel);
      addFoodLabel.setFont(addFont);
      searchboxpane.add(foodBox);
      addFood.add(searchboxpane);
      addFood.add(calPane);
      addingFood.setLayout(new FlowLayout());
      addingFood.add(addFoodButton);
      addFoodButton.addActionListener(new AddButtonListener(fl, this));
      addFood.add(addingFood);
      this.add(addFood);
	}
}
