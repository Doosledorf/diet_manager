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
public class DayLog {

List<String> csv;
String date = "";

private Map<String,Day> dayCollection;
    
    public DayLog(List<String> csv){
        
        this.csv = csv;
        dayCollection = new HashMap<>();
        
    }
    
    public void setDate(){
        
        String year = csv.get(0);
        String month = csv.get(1);
        String day = csv.get(2);
        
        date = year + "-" + month + "-" + day;
        
        Day aDay = new Day();
        
        if (dayCollection.containsKey(date)){
            Day thisDay = dayCollection.get(date);
            checkFlag(thisDay);
        }
        else{
            checkFlag(aDay);
            dayCollection.put(date,aDay);
        }

    }
    
    public void checkFlag(Day thisDay){
        
        if (csv.get(3).equals("w")){
            
            double weight = Double.parseDouble(csv.get(4));
            thisDay.setWeight(weight);
            
        }
        if (csv.get(3).equals("c")){
            
            double goal = Double.parseDouble(csv.get(4));
            thisDay.setGoal(goal);
            
        }
        if (csv.get(3).equals("f")){
            
            int count = Integer.parseInt(csv.get(5));
            thisDay.addFood(csv.get(4),count);
            
        }
    
    }
    
    public Map<String,Day> getLog(){
        
        return dayCollection;
        
    }
       
}
