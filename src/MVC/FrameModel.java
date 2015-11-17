public class FrameModel extends Model
{
   private Integer frameWidth;
   private Integer frameHeight;

   public void defaultSettings()
   {
      setFrameWidth(300);
      setFrameHeight(200);
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

      firePropertyChange(MainController.FRAME_WIDTH_PROPERTY, oldFrameWidth, frameWidth);
   }

   public void setFrameHeight(Integer frameHeight)
   {
      Integer oldFrameHeight = this.frameHeight;
      this.frameHeight = frameHeight;

      firePropertyChange(MainController.FRAME_HEIGHT_PROPERTY, oldFrameHeight, frameHeight);
   }
}