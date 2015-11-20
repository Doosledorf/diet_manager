import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;

public class TabSwitcherView extends View implements MouseListener
{
   private Controller controller;

	private MenuBarView menu;
	private MainView frame;
	private Panel content = new Panel();

	public TabSwitcherView(MainController controller, MenuBarView mb)
   {
      this.controller = controller;

		menu=mb;
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
   {
		// TODO Auto-generated method stub
		if (arg0.getComponent()== menu.day)
      {
			mainFrame.getContentPane().removeAll();
			menu.mainFrame.removeAll();
			mainFrame.menu.food.setBackground(new Color(200,200,200));
			frame.menu.day.setBackground(new Color(230,230,230));
			
			frame.mainPanel.add(frame.menu,BorderLayout.PAGE_START);
			frame.mainPanel.add(frame.dayPane,BorderLayout.LINE_START);
			frame.mainPanel.add(frame.list,BorderLayout.LINE_END);
			frame.getContentPane().add(frame.mainPanel);
			frame.revalidate();
			System.out.println("Day Log");
		}

		if (arg0.getComponent() == menu.food)
      {
			frame.getContentPane().removeAll();
			frame.mainPanel.removeAll();
			frame.menu.day.setBackground(new Color(200,200,200));
			frame.menu.food.setBackground(new Color(230,230,230));
			frame.mainPanel.add(frame.menu,BorderLayout.PAGE_START);
			frame.mainPanel.add(frame.foodPane,BorderLayout.LINE_START);
			frame.mainPanel.add(frame.list,BorderLayout.LINE_END);
			frame.getContentPane().add(frame.mainPanel);
			frame.revalidate();
			System.out.println("Food Log");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
