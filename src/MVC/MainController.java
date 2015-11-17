public class MainController extends Controller
{
   public static final String FRAME_WIDTH_PROPERTY = "Width";
   public static final String FRAME_HEIGHT_PROPERTY = "Height";

   public void changeFrameWidth(int newFrameWidth)
   {
      setModelProperty(FRAME_WIDTH_PROPERTY, newFrameWidth);
   }

   public void changeFrameHeight(int newFrameHeight)
   {
      setModelProperty(FRAME_HEIGHT_PROPERTY, newFrameHeight);
   }
}