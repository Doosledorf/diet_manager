import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.PropertyChangeEvent;

public abstract class View extends JPanel
{
   public MainController controller;
   public JFrame mainFrame = new JFrame();

   public void modelPropertyChange(PropertyChangeEvent evt) {};
}