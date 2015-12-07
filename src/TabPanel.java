import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

//@author Roberto Ortiz
public class TabPanel extends View{
   
   private String iconPath;
   private Object[] colNames;
   private JButton logAdd, logDelete;
   private JTable logTable;
   private JComboBox searchExisting;
   
   //constructs
   public TabPanel(String whichType){
            
      //Simple switch for icon paths
      switch(whichType){
         
         case "Food": iconPath = "/assets/images/food.png";
                      colNames = new Object[]{"", "Name", "Unit Amount", "Calories", "Fat", "Protein", "Carbs"}; 
                      break;
                      
         case "Exercise": iconPath = "/assets/images/stopwatch.png";
                          colNames = new Object[]{"", "Name", "Time Spent (in minutes)", "Calories Burnt"};
                          break;
      }
      //render
      init(whichType, this, colNames);
   }
   
   //renders
   public void init(String type, JPanel base, Object[] tableColNames){
        
      //Config log tab panel
      base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
      
      //Create a Table and add to the panel
      logTable = new JTable(/*new DefaultTableModel(tableColNames)*/);
      base.add(logTable);
      
      //Config log tab panel's button panel
      JPanel logButtonPanel = new JPanel();
      logButtonPanel.setLayout(new BoxLayout(logButtonPanel, BoxLayout.X_AXIS));
      
      //Create SearchBox + Label
      JLabel comboBoxLabel = new JLabel("Search " + type + ": ", JLabel.RIGHT);
      searchExisting = new JComboBox();
      logButtonPanel.add(comboBoxLabel);
      logButtonPanel.add(searchExisting);
      
      //Create + Add buttons to the above
      logAdd = new JButton("Add " + type);
      logDelete = new JButton("Delete " + type);
      logButtonPanel.add(logAdd);
      logButtonPanel.add(logDelete);
      
      //Add buttons to panel
      base.add(logButtonPanel);
   }
   
   //Accessors
   public String getIconPath(){ return iconPath; }
   public JButton getLogAdd(){ return logAdd; }
   public JButton getLogDelete(){ return logDelete; }
   public JTable getLogTable(){ return logTable; }
   public JComboBox getBox(){ return searchExisting; }
}
