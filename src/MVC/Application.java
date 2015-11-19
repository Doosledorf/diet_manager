import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Application
{
   public JFrame mainFrame;

   public Application()
   {
      FrameModel frameModel = new FrameModel();

      MainController controller = new MainController();
      MainView mainView = new MainView(controller);

      controller.addModel(frameModel);
      controller.addView(mainView);

      frameModel.defaultSettings();
   }

   public static void main(String [] args)
   {
      new Application();
   }
}