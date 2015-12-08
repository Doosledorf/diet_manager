//import java.util.HashMap;
//import java.util.Map;
//import java.util.ArrayList;
//import java.util.List;

public class Food{
   
   ////ATTRIBUTES////
   String name;
   double calories, fat, carbs, protein;
   boolean recipe = false;

   
   ////CONSTRUCTOR(DEFAULT)////
   public Food(String name){
      this.name = name;
      calories = fat = carbs = protein = 0.0;
      
   }
   
   ////CONSTRUCTOR(WITH PARAMETERS)////
   public Food(String foodName, double foodCal, double foodFat, double foodCarbs, double foodPro){
         
      name = foodName;
      calories = foodCal;
      fat = foodFat;
      carbs = foodCarbs;
      protein = foodPro;
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

   
   //Gets count of that food eaten for the day 

}//END Food