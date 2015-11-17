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

List<List<String>> csv;
String name;

private Map<String,Food> foodCollection;
    
    public FoodStore(List<List<String>> csv){
        
        this.csv = csv;
        foodCollection = new HashMap<>();
        
    }
    
    public void addToCollection(){
        
        for(List<String> item : csv){
            
            name = item.get(1);
            
            if (foodCollection.containsKey(name)==true){
                System.out.println("This food is already in the "
                        + "collection.");
            }
            else{
                checkFlag(item);
            }
            
            checkFlag(item);
            
            
            
        }
        
    }
    
    public void checkFlag(List<String> item){
        
        if (item.get(0).equals("b")){
            
            String caloriesString = item.get(2);
            String fatString = item.get(3);
            String carbString = item.get(4);
            String proteinString = item.get(5);
            
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
