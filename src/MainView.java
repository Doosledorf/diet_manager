import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.PropertyChangeEvent;

public class MainView extends View{
   private MainController controller;

   public MainView(MainController controller){
      this.controller = controller;

      //Config
      mainFrame.setTitle("Diet Manager");
      mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      
      //Sizing
      mainFrame.setResizable(false);
      
      //Layout
      //getContentPane is crucial for some reason...
      
      //Render
      init();
      mainFrame.setVisible(true);
      mainFrame.pack();
   }
   
   public void init(){
      
      mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));//BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
      
      //Instantiate the menubar.
      MainMenuBar mainMenu = new MainMenuBar(this.controller);
      mainFrame.setJMenuBar(mainMenu);
      
      //Instantiate the date picker
      DateAndWeightPanel datePick = new DateAndWeightPanel(this.controller);
      
      //Instantiate the stats
      DailyGoalsPanel dayGoals = new DailyGoalsPanel(this.controller);
      
      //Instantiate the log.
      ListLogPanel listLog = new ListLogPanel(this.controller);
        
      //Pull em together.
      mainFrame.add(datePick);
      mainFrame.add(dayGoals);
      mainFrame.add(listLog);  
   }

   public void modelPropertyChange(final PropertyChangeEvent pce)
   {
      System.out.println(pce.getPropertyName());
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