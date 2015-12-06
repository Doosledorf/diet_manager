import java.util.List;
import java.util.Map;

public class LogModel extends Model
{
   private Map<String, Day> dayLogData;
   private Map<String, Food> foodLogData;
   private Map<String, Exercise> exerciseLogData;
   
   private Director theDirector;
   private static final String[] CSV_LIST = {"log.csv", "foods.csv", "exercise.csv"};

   public void defaultSettings()
   {
   
      for(String csv : CSV_LIST){
         
         theDirector.direct(csv);
      } 
//       ParseFile dayCsv = new ParseFile("log.csv");
//       DayStore dayStore = new DayStore(dayCsv.splitLists);
//       dayStore.createMap();
//       setDayLogData(dayStore.getLog());
// 
//       ParseFile foodsCsv = new ParseFile("foods.csv");
//       FoodStore foodStore = new FoodStore(foodsCsv.splitLists);
//       foodStore.createMap();
//       setFoodLogData(foodStore.getLog());
   }

   // Accessors
   public Map<String, Day> getDayLogData()
   {
      return dayLogData;
   }

   public Map<String, Food> getFoodLogData()
   {
      return foodLogData;
   }

   // Mutators
   public void setDayLogData(Map<String, Day> dayLogData)
   {
      Map<String, Day> oldDayLogdata = this.dayLogData;
      this.dayLogData = dayLogData;

      firePropertyChange(MainController.DAY_LOG_DATA, oldDayLogdata, dayLogData);
   }

   public void setFoodLogData(Map<String, Food> foodLogData)
   {
      Map<String, Food> oldFoodLogData = this.foodLogData;
      this.foodLogData = foodLogData;

      firePropertyChange(MainController.FOOD_LOG_DATA, oldFoodLogData, foodLogData);
   }
}