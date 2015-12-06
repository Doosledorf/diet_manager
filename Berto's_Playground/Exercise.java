import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Exercise{

   private String name;
   private double burnedCal = 0;
   private boolean hasSubEx;
   private Map<String, Double> subExList;

   public Exercise(String newName, boolean hasSub){
      name = newName;
      hasSubEx = hasSub;
      if (hasSubEx = false){ subExList = new HashMap<>(); }
   }
   
   //ACCESSCORS
   public String getName(){ return name; }
   public double getBurnedCal(){ return burnedCal; }
   public boolean doesHasSubEx(){ return hasSubEx; }
   public Map<String, Double> getSubExes(){ return subExList; }
   
   public Double getExTime(String subEx){
   
      if (subExList.containsKey(subEx) && hasSubEx){ return subExList.get(subEx); }
      else return 0.0;
   }
   
   public List<String> getSubExList(){
   
      if (hasSubEx){
         List<String> subExArr = new ArrayList<>(); 
         for(String subEx : subExList.keySet()){
            subExArr.add(subEx);
         }
         return subExArr;
      }else{ return null; }
   }
   
   //MUTATORS
   public void setName(String newName){ name = newName; }
   public void setBurnedCal(double newlyBurnedCal){ burnedCal = newlyBurnedCal; }
   public void setIsSub(boolean nowItsASub){ hasSubEx = nowItsASub; }

}