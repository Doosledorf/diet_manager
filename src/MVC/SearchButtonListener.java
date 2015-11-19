import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButtonListener implements ActionListener
{
	private FoodPanelView food;

	public SearchButtonListener(FoodPanelView fp)
   {
		food = fp;
	}

	public void actionPerformed(ActionEvent arg0)
   {
		System.out.println("This needs to be finished!");
      String foodSearch = food.foodBox.getText();
      System.out.println("Searching for: "+foodSearch);
      //This needs to search for foodSearch in the CSV
      if(true){
         food.calField.setText("This is fake");
         food.fatField.setText("Still fake");
         food.carbField.setText("Still no");
         food.proField.setText("This is nope");
      }
      //This needs to stay the same or display something new, etc.
      else if(false){
         food.foodBox.setText("Not in database");
      }
	}
}
