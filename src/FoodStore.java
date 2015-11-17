/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Jake
 */
public class FoodStore {

List<String> csv;
String date = "";

private Map<String,Food> foodCollection;
    
    public FoodStore(List<String> csv){
        
        this.csv = csv;
        foodCollection = new HashMap<>();
        
    }
    
    public void checkFlag(){
        
        if (csv.get(0).equals("b")){
            
            String name = csv.get(1);
            String caloriesString = csv.get(2);
            String fatString = csv.get(3);
            String carbString = csv.get(4);
            String proteinString = csv.get(5);
            
            Double calories = Double.parseDouble(caloriesString);
            Double fat = Double.parseDouble(fatString);
            Double carb = Double.parseDouble(carbString);
            Double protein = Double.parseDouble(proteinString);
            
            Food aFood = new Food(name, calories, fat,
                carb, protein);
            
            foodCollection.put(name, aFood);
        }
        
        if (csv.get(0).equals("r")){
            
            //not done yet
            
        }
    
    }
    
    public Map<String,Food> getFoods(){
        
        return foodCollection;
        
    }
       
}
