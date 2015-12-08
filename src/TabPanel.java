import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.*;

//@author Roberto Ortiz
public class TabPanel extends View{
   
   private String iconPath;
   private String type;
   private String[] tableColNames;
   private Object[][] tableColVals = {};
   private JButton logAdd, logDelete;
   private JTable logTable;
   private JComboBox searchExisting;
   private JPanel dataPanelHolder;
   private MainController controller;

   //constructs
   public TabPanel(MainController controller, JTabbedPane tabbedPane, JFrame mainFrame, String type){
      this.controller = controller;
      this.controller.addView(this);
      this.type = type;

      // Table Model
      DefaultTableModel model = new DefaultTableModel();

      //Simple switch for icon paths
      switch(type)
      {
         case "Food":
            iconPath = "/assets/images/food.png";
            model.addColumn("Name");
            model.addColumn("Unit Amount");
            model.addColumn("Calories");
            model.addColumn("Fat");
            model.addColumn("Protein");
            model.addColumn("Carbs");
            break;
         case "Exercise":
            iconPath = "/assets/images/stopwatch.png";
            model.addColumn("Name");
            model.addColumn("Time Spent (in minutes)");
            model.addColumn("Calories Burnt");
            break;
      }

      //Table + ScrollPane
      logTable = new JTable(model);
      logTable.setPreferredScrollableViewportSize(logTable.getPreferredSize());
      logTable.setFillsViewportHeight(true);
      JTableHeader header = logTable.getTableHeader();
      add(header);
      add(logTable);

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
      logAdd.addActionListener(new ActionListener()
      {
      	public void actionPerformed(ActionEvent e)
      	{
            controller.addLogRow(type, String.valueOf(searchExisting.getSelectedItem()), model);
            mainFrame.pack();
      	}
      });
      logDelete = new JButton("Delete Selected Row");
      logDelete.addActionListener(new ActionListener()
      {
      	public void actionPerformed(ActionEvent e)
      	{
            int[] rows = logTable.getSelectedRows();

            for (int i = 0; i < rows.length; i++)
            {
               model.removeRow(rows[i] - i);
            }
      	}
      });
      logButtonPanel.add(logAdd);
      logButtonPanel.add(logDelete);

      //Add buttons to panel
      add(logButtonPanel);
   }

   public void modelPropertyChange(final PropertyChangeEvent pce)
   {
   	if (pce.getPropertyName().equals(controller.FOOD_LOG_DATA))
   	{
         controller.populateSearchBox(getType(), getBox());
   	}
   }

   //Accessors
   public String getIconPath(){ return iconPath; }
   public JButton getLogAdd(){ return logAdd; }
   public JButton getLogDelete(){ return logDelete; }
   public JTable getLogTable(){ return logTable; }
   public JComboBox getBox(){ return searchExisting; }
   public String getType(){ return type; }
   public JPanel getDataHolder(){ return dataPanelHolder; }
}
