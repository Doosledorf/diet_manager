import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;

public class TabSwitcherView implements MouseListener{

	MenuBarView menu;
	MainView frame;
	Panel content = new Panel();
	public TabSwitcherView(MenuBarView mb, MainView dmf){
		menu=mb;
		frame = dmf;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getComponent()==menu.day){
			frame.getContentPane().removeAll();
			frame.mainPanel.removeAll();
			frame.menu.food.setBackground(new Color(200,200,200));
			frame.menu.day.setBackground(new Color(230,230,230));
			
			frame.mainPanel.add(frame.menu,BorderLayout.PAGE_START);
			frame.mainPanel.add(frame.dayPane,BorderLayout.LINE_START);
			frame.mainPanel.add(frame.list,BorderLayout.LINE_END);
			frame.getContentPane().add(frame.mainPanel);
			frame.revalidate();
			System.out.println("Day Log");
		}
		if(arg0.getComponent()==menu.food){
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
