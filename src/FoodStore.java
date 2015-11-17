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
String foodName;
String recName;

private Map<String,Food> foodCollection;
    
    public FoodStore(List<List<String>> csv){
        
        this.csv = csv;
        foodCollection = new HashMap<>();
        
    }
    
    public void addToCollection(){
        
        for(List<String> item : csv){
            
            foodName = item.get(1);
            
            if (foodCollection.containsKey(foodName)==true){
                System.out.println("This food is already in the "
                        + "collection.");
            }
            else{
                checkFlag(item);
            }
           
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
            
            Food aFood = new Food(foodName, calories, fat,
                carb, protein);
            
            foodCollection.put(foodName, aFood);
        }
        
        else if (item.get(0).equals("r")){
            
            recName = item.get(1);
            double totalCal = 0.0;
            double totalFat = 0.0;
            double totalCarb = 0.0;
            double totalPro = 0.0;
            
            for(int i=2;i<item.size();i+=2){
                
                String ingName = item.get(i);
                String ingCountString = item.get(i+1);
                Double ingCount = Double.parseDouble(ingCountString);
                
                Food ingredient = foodCollection.get(ingName);
                totalCal = (totalCal + ingredient.getCal())*ingCount;
                totalFat = (totalFat + ingredient.getFat())*ingCount;
                totalCarb = (totalCarb + ingredient.getCarbs())*ingCount;
                totalPro = (totalPro + ingredient.getProtein())*ingCount;
                
            }
            
            Food recipe = new Food(recName,totalCal,totalFat,totalCarb,totalPro);
            
            foodCollection.put(recName,recipe);
            
            Food recFromCollection =foodCollection.get(recName);
            System.out.println(recFromCollection.getName());
            System.out.println(recFromCollection.getCal());
            System.out.println(recFromCollection.getFat());
            System.out.println(recFromCollection.getCarbs());
            System.out.println(recFromCollection.getProtein());
        }
    
    }
    
    public Map<String,Food> getFoods(){
        
        return foodCollection;
        
    }
       
}
