import java.util.*;

public class Food{
   
   ////ATTRIBUTES////
   String name;
   double calories, fat, carbs, protein;
   Map<String, Double> ingredients;
   boolean recipe;

   ////CONSTRUCTOR(DEFAULT)////
   public Food(boolean isRecipe){

      calories = fat = carbs = protein = 0.0
      if (isRecipe == true){
         ingredients = new Hashmap<>();
         recipe = isRecipe;
      }    
   }
   
   ////CONSTRUCTOR(WITH PARAMETERS)////
   public Food(String foodName, double foodCal, double foodFat, double foodCarbs, double foodPro, boolean isRecipe){
         
      name = foodName;
      calories = foodCal;
      fat = foodFat;
      carbs = foodCarbs;
      protein = foodPro;
      if (isRecipe == true){ 
         ingredients = new Hashmap<>();
         recipe = isRecipe; 
      }
   }
   
   ////ACCESSORS////
   public String getName(){ return name; }
   public double getCal(){ return calories; }
   public double getFat(){ return fat; }
   public double getCarbs(){ return carbs; }
   public double getProtein(){ return protein; } 
   
   ////MUTATORS///
   public void setName(String newName){ name = newName; }
   public void setCal(double newCal){ calories = newCal; }
   public void setFat(double newFat){ fat = newFat; }
   public void setCarbs(double newCarbs){ carbs = newCarbs; }
   public void setProtein(double newProtein){ protein = newProtein; }
   
   ///TOOLBOX///
   
   //Get list of ingredients
   public List<String> getIngredientList(){
   
      if recipe{
         List<String> ingredientList = new ArrayList<>(); 
         for(String ingredient : ingredients.keySet()){
            ingredientList.add(ingredient);
         }
         return ingredientList;
      }else:{ return null; }
   }
   
   //Gets count of that food eaten for the day 
   public Double getIngredientAmount(String ingredient){ 
   
      if (ingredients.containsKey(ingredient) && recipe){ return ingredients.get(ingredient); }
      else return 0.0;
   } 
   
   //Creates a single tuple of food and count
   public String[] getIngredientTuple(String ingredient){
      if (ingredients.containsKey(ingredient) && recipe){ 
         return new String[]{ingredient, getIngredientAmount(ingredient)}; 
      }
      else return new String[]{};
   }
   
   //Mutators
   public void setName(String newName){ name = newName; }
   public void addIngredient(String newIngredient, Double newMeasure){ ingredients.put(newIngredient, newMeasure); }

}//END Food