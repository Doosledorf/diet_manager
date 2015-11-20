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
         food.calField.setText("0");
         food.fatField.setText("0");
         food.carbField.setText("0");
         food.proField.setText("0");
      }
      //This needs to stay the same or display something new, etc.
      else if(false){
         food.foodBox.setText("Not Defined");
      }
	}
}
