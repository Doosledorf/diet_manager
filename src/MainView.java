import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.PropertyChangeEvent;

public class MainView extends View
{
   public JPanel mainPanel = new JPanel();
   public FoodListView list = new FoodListView();
   public FoodPanelView foodPane = new FoodPanelView(list);

   // Move to MVC approach
   public DayPanelView dayPane = new DayPanelView();

   public MenuBarView menu = new MenuBarView(this);

   public MainView(MainController controller)
   {
      this.controller = controller;

      this.setTitle("Diet Manager");
      this.setResizable(false);
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.pack();

      this.setVisible(true);

      initialize();
   }

   public void initialize()
   {
      mainPanel.setLayout(new BorderLayout());

      mainPanel.setBackground(new Color(100, 100, 100));
      mainPanel.setBorder(BorderFactory.createEtchedBorder());

      this.getContentPane().removeAll();
		mainPanel.add(this.menu, BorderLayout.PAGE_START);
		mainPanel.add(this.foodPane, BorderLayout.LINE_START);
		mainPanel.add(this.list, BorderLayout.LINE_END);

      this.getContentPane().add(mainPanel);
   }

   public void modelPropertyChange(final PropertyChangeEvent pce)
   {
      if (pce.getPropertyName().equals(controller.FRAME_WIDTH))
      {
         Dimension size = new Dimension((Integer) pce.getNewValue(), this.getHeight());
         this.setPreferredSize(size);
         this.setSize(size);
      }
      else if (pce.getPropertyName().equals(controller.FRAME_HEIGHT))
      {
         Dimension size = new Dimension(this.getWidth(), (Integer) pce.getNewValue()); 
         this.setPreferredSize(size);
         this.setSize(size);
      }
   }
}