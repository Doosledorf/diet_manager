import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class MainMenuBar extends JMenuBar
{
   public MainMenuBar(MainController controller)
   {
      //Create out sole option for now
      JMenu options = new JMenu("Options");
      
      //Add the option to the bar
      add(options);
      
      //Create menu suboptions
      JMenuItem save = new JMenuItem("Save");
      JMenuItem addFoodToDB = new JMenuItem("Enter food information");
      JMenuItem addExerciseToDB = new JMenuItem("Enter exercise information");
      JMenuItem export = new JMenuItem(new AbstractAction("Export")
      {
          public void actionPerformed(ActionEvent ae)
      	{
      		controller.export();
          }
      });

      //Pull it together
      options.add(save);
      options.addSeparator();
      options.add(addFoodToDB);
      options.add(addExerciseToDB);
      options.addSeparator();
      options.add(export);
   }
   
   //MAYBE ACCESSORS?
}