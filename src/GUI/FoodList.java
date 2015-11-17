import javax.swing.*;
import java.awt.*;
import java.util.*;

public class FoodList extends Panel{

	public TextArea list = new TextArea("Food Eaten\n");
	Font font = new Font("FoodFont",Font.BOLD,16);
	public FoodList(){
		this.setBackground(new Color(100,100,100));
		this.add(list);
		list.setEditable(false);
		list.setFont(font);
		this.setSize(320,320);
	}
}
