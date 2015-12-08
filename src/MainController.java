import java.util.List;

public class MainController extends Controller
{
   public static final String FRAME_WIDTH = "Width";
   public static final String FRAME_HEIGHT = "Height";
   public static final String DAY_LOG_DATA = "DayLogData";
   public static final String FOOD_LOG_DATA = "FoodLogData";
   public static final String EXPORT = "Export";

   public void export()
   {
      // Calls the method getExport
      String tmp = (String) getModelProperty(EXPORT);
   }

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