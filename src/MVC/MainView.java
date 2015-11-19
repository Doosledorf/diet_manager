import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.PropertyChangeEvent;

public class MainView extends View
{
   private JPanel mainPanel = new JPanel();
   private FoodListView list = new FoodListView();
   private FoodPanelView foodPane = new FoodPanelView(list);
   private DayLog dayPane = new DayLog();
   private MenuBarView menu = new MenuBarView(this);

   public MainView(MainController controller)
   {
      this.controller = controller;
   }

   public void initialize()
   {
      mainPanel.setLayout(new BorderLayout());

      mainPanel.setBackground(new Color(255, 255, 255));
      mainPanel.setBorder(BorderFactory.createEtchedBorder());
      mainPanel.setPreferredSize(new Dimension(200, 200));
      mainPanel.setSize(new Dimension(200, 200));

      this.getContentPane().removeAll();
		mainPanel.add(this.menu, BorderLayout.PAGE_START);
		mainPanel.add(this.foodPane, BorderLayout.LINE_START);
		mainPanel.add(this.list, BorderLayout.LINE_END);

      this.add(mainPanel);
   }

   public void listeners()
   {}

   public void modelPropertyChange(final PropertyChangeEvent pce)
   {
      if (pce.getPropertyName().equals(controller.FRAME_WIDTH_PROPERTY))
      {
         Dimension size = new Dimension((Integer) pce.getNewValue(), mainPanel.getHeight());
         mainPanel.setPreferredSize(size);
         mainPanel.setSize(size);
      }
      else if (pce.getPropertyName().equals(controller.FRAME_HEIGHT_PROPERTY))
      {
         Dimension size = new Dimension(mainPanel.getWidth(), (Integer) pce.getNewValue()); 
         mainPanel.setPreferredSize(size);
         mainPanel.setSize(size);
      }
   }
}