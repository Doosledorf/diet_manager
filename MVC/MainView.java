import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.PropertyChangeEvent;

public class MainView extends View
{
   private JPanel mainPanel;
   private JTextField mainTextField;
   private JButton mainButton;

   public MainView(MainController controller)
   {
      this.controller = controller;
   }

   public void initialize()
   {
      mainPanel = new JPanel();
      mainTextField = new JTextField();
      mainButton = new JButton("test");

      mainTextField.setText("The model will overwrite this.");

      mainPanel.setLayout(new BorderLayout());

      mainPanel.setBackground(new Color(255, 255, 255));
      mainPanel.setBorder(BorderFactory.createEtchedBorder());
      mainPanel.setPreferredSize(new Dimension(200, 200));
      mainPanel.setSize(new Dimension(200, 200));

      mainPanel.add(mainTextField);
      mainPanel.add(mainButton);
      this.add(mainPanel);
   }

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