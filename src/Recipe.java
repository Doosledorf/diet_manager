
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jake
 */
public class Recipe extends Food{
    
    private String recipeName;
    private Map<Food,Double> ingredients;
    private List<Food> ingredientList= new ArrayList<>();
    
    public Recipe(String recName, Map<Food,Double> ingredientsMap){
        
        super(recName);
        recipeName = recName;
        this.ingredients=ingredientsMap;
        
    }
    
    public Recipe(String recName){
        
        super(recName);
        recipeName = recName;
        this.ingredients= new HashMap<>();
        
    }
   //Get list of ingredients
   public List<Food> getIngredientList(){

         for(Food ingredient : ingredients.keySet()){
            ingredientList.add(ingredient);
         }
         return ingredientList;
      }
   
   public Double getIngredientAmount(String ingredient){ 
   
      if (ingredients.containsKey(ingredient)){ return ingredients.get(ingredient); }
      else return 0.0;
   } 
   

   //Mutators

   public void addIngredient(Food newIngredient, Double newMeasure){ ingredients.put(newIngredient, newMeasure); }

   
}