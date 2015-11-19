import javax.swing.*;
import java.awt.*;
import java.util.*;

public class FoodListView extends Panel
{
	public TextArea list = new TextArea("Food Eaten\n");
	private Font font = new Font("FoodFont", Font.BOLD, 16);

	public FoodListView()
   {
		this.setBackground(new Color(100,100,100));
		this.add(list);
		list.setEditable(false);
		list.setFont(font);
		this.setSize(320,320);
	}
}
