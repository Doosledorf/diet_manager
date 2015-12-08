import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.PropertyChangeEvent;
import javax.swing.border.*;

public class MainView extends View{
   private MainController controller;

   public MainView(MainController controller){
      this.controller = controller;

      //Config
      mainFrame.setTitle("Diet Manager");
      mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

      //Sizing
      mainFrame.setResizable(true);

      //Render
      init();
      mainFrame.setVisible(true);
   }
   
   public void init()
   {
      //Layout
      mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));

      //Instantiate the menubar.
      MainMenuBar mainMenu = new MainMenuBar(this.controller);
      mainFrame.setJMenuBar(mainMenu);

      //Top Wrap Panel
      JPanel topWrap = new JPanel();

      //Instantiate the date picker
      DateAndWeightPanel datePick = new DateAndWeightPanel(this.controller);

      //Instantiate the stats
      DailyGoalsPanel dayGoals = new DailyGoalsPanel(this.controller);

      //Instantiate the log.
      ListLogPanel listLog = new ListLogPanel(this.controller, mainFrame);

      //Top Wrap Attributes
      topWrap.setBorder(new EmptyBorder(0, 25, 50, 25));

      //Pull em together.
      topWrap.add(datePick);
      topWrap.add(dayGoals);
      mainFrame.add(topWrap);
      mainFrame.add(listLog);  
   }

   public void modelPropertyChange(final PropertyChangeEvent pce)
   {
   	if (pce.getPropertyName().equals(controller.FRAME_WIDTH))
   	{
   		Dimension size = new Dimension((Integer) pce.getNewValue(), mainFrame.getHeight());
   		mainFrame.setSize(size);
   	}
   	else if (pce.getPropertyName().equals(controller.FRAME_HEIGHT))
   	{
   		Dimension size = new Dimension(mainFrame.getWidth(), (Integer) pce.getNewValue());
   		mainFrame.setSize(size);
   	}
   }
}