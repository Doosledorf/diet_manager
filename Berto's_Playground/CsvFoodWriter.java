
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jake
 */
public class CsvFoodWriter {
    
    String fileName = "";
    File csv = null;
    BufferedWriter bw = null;
    Map<String,Food> foodMap;
    
    public CsvFoodWriter(File csv, Map<String,Food> foodMap){
        
        this.csv = csv;
        this.foodMap = foodMap;
                
    }
    
    public void save(){
        

        try{
            csv = new File(fileName);
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(fileName)));
            
            for(String name : foodMap.keySet()){

                Food foodObject = foodMap.get(name);
                
                if (foodObject.isRecipe()==false){

                    double calories = foodObject.getCal();
                    double fat = foodObject.getFat();
                    double carbs = foodObject.getCarbs();
                    double protein = foodObject.getProtein();
                    
                    pw.println("b,"+name+","+calories+","+
                            fat+","+carbs+","+protein);
                    
                }
                if (foodObject.isRecipe()){
                    
                    String recipeString = "r,"+name;
                    
                    List<String> ingredients = foodObject.getIngredientList();
                    
                    for (String ingredient : ingredients){
                        
                        double ingredientCount = 
                                foodObject.getIngredientAmount(ingredient);
                        recipeString += (","+ingredient+","+ingredientCount);                     
                        
                    }
                    
                    
                    pw.println(recipeString);
                    
                }
                
            }              
            
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        
    }
    
}
