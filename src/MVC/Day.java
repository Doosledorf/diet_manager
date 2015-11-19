import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Day{
   
   //Attributes
   double weight, calorieGoal;
   Map<String, Double> foodEaten; //Food, Count 
   
   //Default Constructor. No previous date.
   public Day(){
      
      weight = 150.0;
      calorieGoal = 2000.0;
      foodEaten = new HashMap<>();
   }
   
   //Perhaps another constructor here, Needs testing.
   
   //Accessors. Might be a little too toolboxy...
   public double getWeight(){ return weight; }
   public double getGoal(){ return calorieGoal; }
   
   //Gets entire list of food eaten that day
   public List<String> getFoodList(){
   
      List<String> foodList = new ArrayList<>(); 
      for(String food : foodEaten.keySet()){
         foodList.add(food);
      }
      return foodList;
   }
   
   //Gets count of that food eaten for the day 
   public double getFoodCount(String food){ 
   
      if (foodEaten.containsKey(food)){ return foodEaten.get(food); }
      else return 0.0;
   } 
   
   //Creates a single tuple of food and count
   public String[] getFoodTuple(String food){
      if (foodEaten.containsKey(food)){ 
         return new String[]{food, Double.toString(getFoodCount(food))}; 
      }
      else return new String[]{};
   }
   
   //Mutators
   public void setWeight(double newWeight){ weight = newWeight; }
   public void setGoal(double newGoal){ calorieGoal = newGoal; }
   public void addFood(String newFood, double foodCount){ foodEaten.put(newFood, foodCount); }
   
}//End Day