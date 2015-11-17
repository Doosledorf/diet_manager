import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Food extends Label{
	
	String Name;
	String CalorieCount;
	public Food(String foodName, int calCount){
		Name = foodName;
		CalorieCount = calCount+"";
		this.setName(Name+" Cal. "+CalorieCount);
		
	}
	
}
