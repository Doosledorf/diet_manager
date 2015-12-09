import java.util.List;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class MainController extends Controller
{
   // List of all properties that will be sent to the PCL
   public static final String FRAME_WIDTH = "Width";
   public static final String FRAME_HEIGHT = "Height";
   public static final String DAY_LOG_DATA = "DayLogData";
   public static final String FOOD_LOG_DATA = "FoodLogData";
   public static final String EXPORT = "Export";

   // Called when the export button is hit
   public void export()
   {
      // Calls the method getExport
      String tmp = (String) getModelProperty(EXPORT);
   }

   // Called upon load, populates the logTable search box
   public void populateSearchBox(String type, JComboBox comboBox)
   {
      switch(type)
      {
         case "Food":
      		Map<String, Food> data = (Map<String, Food>) getModelProperty(FOOD_LOG_DATA);

      		for (String food : data.keySet())
      		{
      			Food foodObj = data.get(food);
   
               comboBox.addItem(foodObj.getName());
      		}
            break;
         case "Exercise":
            comboBox.addItem("exercise");
            break;
      }
   }

   // Adds a row to the logTable based on user-input
   public void addLogRow(String type, String name, DefaultTableModel model)
   {
      switch(type)
      {
         case "Food":
      		Map<String, Food> data = (Map<String, Food>) getModelProperty(FOOD_LOG_DATA);

      		for (String food : data.keySet())
      		{
      			Food foodObj = data.get(food);

               if (foodObj.getName() == name)
               {
                  model.addRow(new Object[] {foodObj.getName(), "0", foodObj.getCal(), foodObj.getFat(), foodObj.getProtein(), foodObj.getCarbs()});
               }
      		}
            break;
         case "Exercise":
            model.addRow(new Object[] {"none", "none", "none"});
            break;
      }
   }

   // Mutators
   public void changeFrameWidth(int newFrameWidth)
   {
      setModelProperty(FRAME_WIDTH, newFrameWidth);
   }

   public void changeFrameHeight(int newFrameHeight)
   {
      setModelProperty(FRAME_HEIGHT, newFrameHeight);
   }

   public void changeDayLogData(List<List<String>> newDayLogData)
   {
      setModelProperty(DAY_LOG_DATA, newDayLogData);
   }

   public void changeFoodLogData(List<List<String>> newFoodLogData)
   {
      setModelProperty(FOOD_LOG_DATA, newFoodLogData);
   }
}