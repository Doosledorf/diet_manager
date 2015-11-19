import java.util.List;

public class LogModel extends Model
{
   private List<List<String>> dayLogData;
   private List<List<String>> foodLogData;

   public void defaultSettings()
   {
      setDayLogData(null);
      setFoodLogData(null);
   }

   // Accessors
   public List<List<String>> getDayLogData()
   {
      return dayLogData;
   }

   public List<List<String>> getFoodLogData()
   {
      return foodLogData;
   }

   // Mutators
   public void setDayLogData(List<List<String>> dayLogData)
   {
      List<List<String>> oldDayLogdata = this.dayLogData;
      this.dayLogData = dayLogData;

      firePropertyChange(MainController.DAY_LOG_DATA, oldDayLogdata, dayLogData);
   }

   public void setFoodLogData(List<List<String>> foodLogData)
   {
      List<List<String>> oldFoodLogData = this.foodLogData;
      this.foodLogData = foodLogData;

      firePropertyChange(MainController.FOOD_LOG_DATA, oldFoodLogData, foodLogData);
   }
}