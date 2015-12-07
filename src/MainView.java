import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.PropertyChangeEvent;

public class MainView extends View{
 
   public MainView(){
   
      //Config
      mainFrame.setTitle("Diet Manager");
      mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      
      //Sizing
      mainFrame.setSize(800,600);
      mainFrame.setResizable(false);
      
      //Layout
      //getContentPane is crucial for some reason...
      
      //Render
      init();
      mainFrame.setVisible(true);
      //mainFrame.pack();
   }
   
   public void init(){
      
      mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));//BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
      
      //Instantiate the menubar.
      MainMenuBar mainMenu = new MainMenuBar();
      mainFrame.setJMenuBar(mainMenu);
      
      //Instantiate the date picker
      DateAndWeightPanel datePick = new DateAndWeightPanel();
      
      //Instantiate the stats
      DailyGoalsPanel dayGoals = new DailyGoalsPanel();
      
      //Instantiate the log.
      ListLogPanel listLog = new ListLogPanel();
        
      //Pull em together.
      mainFrame.add(datePick);
      mainFrame.add(dayGoals);
      mainFrame.add(listLog);  
   }
      
   public static void main (String[]args){
   
      MainView mv = new MainView();
   }
}