import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddButtonListener implements ActionListener {
	FoodListView list;
	FoodPanelView food;
	public AddButtonListener(FoodListView fl, FoodPanelView fp){
		list = fl;
		food = fp;
	}
	public void actionPerformed(ActionEvent arg0) {
		String current = list.list.getText();
		list.list.setText(current+food.foodBox.getText()+" "+"Cal"+food.calField.getText()+"\n");
		System.out.println("Output\n"+current);
		
	}

}
