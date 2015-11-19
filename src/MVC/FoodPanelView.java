import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class FoodPanelView extends Panel
{
   Panel addFood = new Panel();
   
   Panel statPane = new Panel();
   Label calLabel = new Label("Calories: ");
   TextField calField = new TextField(20);
   Label fatLabel = new Label("Fat: ");
   TextField fatField = new TextField(20);
   Label proLabel = new Label("Protien: ");
   TextField proField = new TextField(20);
   Label carbLabel = new Label("Carbs: ");
   TextField carbField = new TextField(20);
   
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
      calLabel.setFont(addFont);
      fatLabel.setFont(addFont);
      proLabel.setFont(addFont);
      carbLabel.setFont(addFont);
      statPane.setLayout(new GridLayout(0,2));
      statPane.add(calLabel);
      statPane.add(calField);
      statPane.add(fatLabel);
      statPane.add(fatField);
      statPane.add(proLabel);
      statPane.add(proField);
      statPane.add(carbLabel);
      statPane.add(carbField);
      addFood.setLayout(new GridLayout(4,1));
      addFood.add(addFoodLabel);
      addFoodLabel.setFont(addFont);
      searchboxpane.add(foodBox);
      addFood.add(searchboxpane);
      addFood.add(statPane);
      addingFood.setLayout(new FlowLayout());
      addingFood.add(addFoodButton);
      addFoodButton.addActionListener(new AddButtonListener(fl, this));
      addFood.add(addingFood);
      this.add(addFood);
	}
}
