public class MainModel extends Model
{
   // Data Storage
   private Integer frameWidth;
   private Integer frameHeight;

   // Default Settings
   public void defaultSettings()
   {
      setFrameWidth(600);
      setFrameHeight(350);
   }

   // Accessors
   public Integer getFrameWidth()
   {
      return frameWidth;
   }

   public Integer getFrameHeight()
   {
      return frameHeight;
   }

   // Mutators
   public void setFrameWidth(Integer frameWidth)
   {
      Integer oldFrameWidth = this.frameWidth;
      this.frameWidth = frameWidth;

      firePropertyChange(MainController.FRAME_WIDTH, oldFrameWidth, frameWidth);
   }

   public void setFrameHeight(Integer frameHeight)
   {
      Integer oldFrameHeight = this.frameHeight;
      this.frameHeight = frameHeight;

      firePropertyChange(MainController.FRAME_HEIGHT, oldFrameHeight, frameHeight);
   }
}