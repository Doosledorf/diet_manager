/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
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

private Map<String,Food> foodMap;
    
    public FoodStore(List<List<String>> csv){
        
        this.csv = csv;
        foodMap = new HashMap<>();
        
    }
    
    public void createMap(){
        
        for(List<String> item : csv){
            
            foodName = item.get(1);
            
            if (foodMap.containsKey(foodName)==true){
                foodMap.remove(foodName);
                checkFlag(item);
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
                carb, protein, false);
            
            foodMap.put(foodName, aFood);
        }
        
        else if (item.get(0).equals("r")){
            
            String recName = item.get(1);
            
            Double ingCount;
            String ingName, ingCountString;
    
            Food recipe = new Food(recName, true);
            
            for(int i=2;i<item.size();i+=2){
                
                ingName = item.get(i);
                ingCountString = item.get(i+1);
                ingCount = Double.parseDouble(ingCountString);
                
                Food ingredient = foodMap.get(ingName);
                recipe.setCal((recipe.getCal() + ingredient.getCal())*ingCount);
                recipe.setFat((recipe.getFat() + ingredient.getFat())*ingCount);
                recipe.setCarbs((recipe.getCarbs() + ingredient.getCarbs())*ingCount);
                recipe.setProtein((recipe.getProtein() + ingredient.getProtein())*ingCount);
                recipe.addIngredient(ingName, ingCount);
            }
            
            foodMap.put(recName,recipe);
            
        }
    
    }
    
    public Map<String,Food> getLog(){
        
        return foodMap;
        
    }
    public void save(){
       
        File file = new File("foods.csv");
        
        CsvFoodWriter csvfw = new CsvFoodWriter(file,foodMap);
        csvfw.save();
        
        }
       
}
