public class Food{
   
   //Attributes
   String name;
   double calories, fat, carbs, protein;

   //Constructor
   public Food(String foodName, double foodCal, double foodFat, double foodCarbs, double foodPro){
      
         calories = foodCal;
         fat = foodFat;
         carbs = foodCarbs;
         protein = foodPro;
   }
   
   //Accessors
   public String getName(){ return name; }
   public double getCal(){ return calories; }
   public double getFat(){ return fat; }
   public double getCarbs(){ return carbs; }
   public double getProtein(){ return protein; } 
   
   //Mutators
   public void setName(String newName){ name = newName; }
   public void setCal(double newCal){ calories = newCal; }
   public void setFat(double newFat){ fat = newFat; }
   public void setCarbs(double newCarbs){ carbs = newCarbs; }
   public void setProtein(double newProtein){ protein = newProtein; }

}//END Food