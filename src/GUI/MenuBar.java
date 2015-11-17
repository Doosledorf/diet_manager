import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MenuBar extends Panel{
	
	Label food = new Label("FoodLog");
	Label day = new Label("Day Log");
	MouseListener tabSwitch;

	public MenuBar(DMFrame dmf){
		tabSwitch = new TabSwitcher(this,dmf);
		this.setSize(WIDTH, 200);
		this.setBackground(new Color(180,180,180));
		food.setFont(new Font("addFont",Font.CENTER_BASELINE,24));
		food.setBounds(0, 0, 50, 50);
		food.setBackground(new Color(230,230,230));
		food.addMouseListener(tabSwitch);
		day.setFont(new Font("addFont",Font.CENTER_BASELINE,24));
		day.setBounds(0, 0, 50, 50);
		day.setBackground(new Color(200,200,200));
		day.addMouseListener(tabSwitch);
		this.add(food);
		this.add(day);
	}
}
