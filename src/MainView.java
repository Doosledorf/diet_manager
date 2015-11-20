import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.PropertyChangeEvent;

public class MainView extends View
{
   public JPanel mainPanel = this;
   public FoodListView list;
   public FoodPanelView foodPane;
   public DayPanelView dayPane;
   public MenuBarView menu;

   public MainView(MainController controller)
   {
      this.controller = controller;

      mainFrame.setTitle("Diet Manager");
      mainFrame.setResizable(false);
      mainFrame.setLayout(new BorderLayout());
      mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      mainFrame.pack();

      mainFrame.setVisible(true);   

      initialize();
   }

   public void initialize()
   {
      list = new FoodListView(this.controller);
      foodPane = new FoodPanelView(this.controller, list);
      dayPane = new DayPanelView(this.controller);
      menu = new MenuBarView(this.controller, this, mainFrame);

      mainPanel.setLayout(new BorderLayout());

      mainPanel.setBackground(new Color(100, 100, 100));
      mainPanel.setBorder(BorderFactory.createEtchedBorder());

      mainFrame.getContentPane().removeAll();
		mainPanel.add(this.menu, BorderLayout.PAGE_START);
		mainPanel.add(this.foodPane, BorderLayout.LINE_START);
		mainPanel.add(this.list, BorderLayout.LINE_END);

      mainFrame.getContentPane().add(this);
   }

   public void modelPropertyChange(final PropertyChangeEvent pce)
   {
      if (pce.getPropertyName().equals(controller.FRAME_WIDTH))
      {
         Dimension size = new Dimension((Integer) pce.getNewValue(), mainFrame.getHeight());
         mainFrame.setPreferredSize(size);
         mainFrame.setSize(size);
      }
      else if (pce.getPropertyName().equals(controller.FRAME_HEIGHT))
      {
         Dimension size = new Dimension(mainFrame.getWidth(), (Integer) pce.getNewValue()); 
         mainFrame.setPreferredSize(size);
         mainFrame.setSize(size);
      }
   }
}