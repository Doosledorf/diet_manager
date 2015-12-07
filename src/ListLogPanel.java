import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class ListLogPanel extends View{

   private MainController controller;
   
   public ListLogPanel (/*MainController con*/){
      
      // this.controller = con;
      
      //Set layout
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      //Construct tab-holder
      JTabbedPane tabbedPane = new JTabbedPane();
      
      //Create TabPanels and get those icons
      TabPanel foodLogPanel = new TabPanel("Food");
      ImageIcon foodIcon = new ImageIcon(foodLogPanel.getIconPath());
      TabPanel exerciseLogPanel = new TabPanel("Exercise");
      ImageIcon exerciseIcon = new ImageIcon(exerciseLogPanel.getIconPath());
               
      //Constuct + Add the tabs.
      tabbedPane.addTab("Food Log", foodIcon, foodLogPanel, "A list of foods eaten today.");
      tabbedPane.addTab("Exercise Log", exerciseIcon, exerciseLogPanel, "A list of the workouts done today.");
      
      //Add
      add(tabbedPane);
   }
}