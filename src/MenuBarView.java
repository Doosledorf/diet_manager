import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class MenuBarView extends View
{
   private MainController controller;

   public JPanel mb = new JPanel();
   public MenuBarView menu = this;
	public Label food = new Label("FoodLog");
	public Label day = new Label("Day Log");
	private MouseListener tabSwitch;

	public MenuBarView(MainController controller, MainView dmf, JFrame mainFrame)
   {
      this.controller = controller;

		mb.setSize(200, 200);
		mb.setBackground(new Color(180,180,180));
		food.setFont(new Font("addFont",Font.CENTER_BASELINE,24));
		food.setBounds(0, 0, 50, 50);
		food.setBackground(new Color(230,230,230));
		food.addMouseListener(tabSwitch);
		day.setFont(new Font("addFont",Font.CENTER_BASELINE,24));
		day.setBounds(0, 0, 50, 50);
		day.setBackground(new Color(200,200,200));

      day.addMouseListener(new MouseAdapter()
      {
      	public void mouseClicked(MouseEvent e)
      	{
         	mainFrame.getContentPane().removeAll();
         	dmf.mainPanel.removeAll();

         	food.setBackground(new Color(200,200,200));
         	day.setBackground(new Color(230,230,230));
         
            dmf.mainPanel.add(menu, BorderLayout.PAGE_START);
         	dmf.mainPanel.add(dmf.dayPane, BorderLayout.LINE_START);
         	dmf.mainPanel.add(dmf.list, BorderLayout.LINE_END);
         	mainFrame.getContentPane().add(dmf.mainPanel);
         	dmf.revalidate();

         	System.out.println("Day Log");
      	}
      });

      food.addMouseListener(new MouseAdapter()
      {
      	public void mouseClicked(MouseEvent e)
      	{
         	mainFrame.getContentPane().removeAll();
         	dmf.mainPanel.removeAll();

         	day.setBackground(new Color(200,200,200));
         	food.setBackground(new Color(230,230,230));

            dmf.mainPanel.add(menu, BorderLayout.PAGE_START);
         	dmf.mainPanel.add(dmf.foodPane, BorderLayout.LINE_START);
         	dmf.mainPanel.add(dmf.list, BorderLayout.LINE_END);
         	mainFrame.getContentPane().add(dmf.mainPanel);
         	dmf.revalidate();

         	System.out.println("Food Log");
      	}
      });

		mb.add(food);
		mb.add(day);

      this.add(mb);
	}
}
