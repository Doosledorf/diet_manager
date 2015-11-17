public class Recipe{
   
   //Attributes
   String name; 
   Map<String, String> ingredients; //Component + Amount w/ Units
   
   //Constructor 
   public Recipe(String recName, recIngredients){
      
        name = recName;
        ingredients = recIngredients;
   }
   
   //Accessors
   public String getName(){ return name; }
   
   //Get list of ingredients
   public List<String> getIngredientList(){
   
      List<String> ingredientList = new ArrayList<String>(); 
      for(String ingredient : ingredients.keySet()){
         ingredientList.add(ingredient);
      }
      return ingredientList;
   }
   
   //Gets count of that food eaten for the day 
   public String getIngredientAmount(String ingredient){ 
   
      if (ingredients.containsKey(ingredient)){ return ingredients.get(ingredient); }
      else return "No measure available.";
   } 
   
   //Creates a single tuple of food and count
   public String[] getIngredientTuple(String ingredient){
      if (ingredients.containsKey(ingredient)){ 
         return new String[]{ingredient, getIngredientAmount(ingredient)}; 
      }
      else return new String[]{};
   }
   
   //Mutators
   public void setName(String newName){ name = newName; }
   public void addIngredient(String newIngredient, String newMeasure){ ingredients.put(newIngredient, newMeasure); } 
      

}//END Recipe