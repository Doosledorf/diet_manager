import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Jake
 */
public class FoodStore {

private List<List<String>> csv;
private String foodName;
private String recName;

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
    //
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
            
            foodMap.put(foodName, aFood);
        }
        
        else if (item.get(0).equals("r")){
            
            recName = item.get(1);
            
            Double ingCount;
            String ingName, ingCountString;
    
            Recipe recipe = new Recipe(recName);
            
            for(int i=2;i<item.size();i+=2){
                
                ingName = item.get(i);
                ingCountString = item.get(i+1);
                ingCount = Double.parseDouble(ingCountString);
                
                Food ingredient = foodMap.get(ingName);
                
                recipe.addIngredient(ingredient, ingCount);
            }
            
            foodMap.put(recName,recipe);
            
        }
    
    }
    
    public void addRecipe(Recipe aRecipe){

        foodMap.put(aRecipe.getName(),aRecipe);
        
    }
    
    public void addFood(Food aFood){
        
        foodMap.put(aFood.getName(), aFood);
        
        
    }
    
    public Map<String,Food> getLog(){
        
        return foodMap;
        
    }
    public void save(){
        
        CsvFoodWriter csvfw = new CsvFoodWriter(foodMap);
        csvfw.save();
        
        }
       
}