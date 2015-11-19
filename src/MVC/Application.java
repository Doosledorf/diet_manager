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

      mainFrame = new JFrame("Diet Manager");
      mainFrame.setSize(1020, 500);
      mainFrame.setResizable(false);
      mainFrame.setLayout(new BorderLayout());
      mainFrame.getContentPane().add(mainView, BorderLayout.CENTER);
      mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      mainFrame.pack();

      mainFrame.setVisible(true);
   }

   public static void main(String [] args)
   {
      new Application();
   }
}