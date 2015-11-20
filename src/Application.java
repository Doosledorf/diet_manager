import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Application
{
   public JFrame mainFrame;

   public Application()
   {
      MainModel mainModel = new MainModel();
      LogModel logModel = new LogModel();

      MainController controller = new MainController();
      MainView mainView = new MainView(controller);
      FoodListView foodListView = new FoodListView(controller);

      controller.addModel(mainModel);
      controller.addModel(logModel);

      controller.addView(mainView);

      mainModel.defaultSettings();
      logModel.defaultSettings();
   }

   public static void main(String [] args)
   {
      new Application();
   }
}