import java.awt.*;
import javax.swing.*;

public class DMFrame extends JFrame{

		FoodList list = new FoodList();
		DayLog dayPane = new DayLog();
		FoodPanel foodPane = new FoodPanel(list);
		MenuBar menu = new MenuBar(this);
		Panel content = new Panel();
		public DMFrame(){
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setSize(1020, 500);
			content.setBackground(new Color(100,100,100));
			this.setTitle("Diet Manager");
			this.setResizable(false);
			this.setLayout(new BorderLayout());
			content.setLayout(new BorderLayout());
			this.getContentPane().removeAll();
			content.add(this.menu,BorderLayout.PAGE_START);
			content.add(this.foodPane,BorderLayout.LINE_START);
			content.add(this.list,BorderLayout.LINE_END);
			this.getContentPane().add(content);
		}
		
}
