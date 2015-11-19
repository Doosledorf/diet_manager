/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Jake
 */
public class DayLog {

private List<List<String>> csv;
private String date = "";
private Map<String,Day> dayCollection;
    
    public DayLog(List<List<String>> csv){
        
        this.csv = csv;
        dayCollection = new HashMap<>();
        
    }
    
    public void addToCollection(){
        
        for(List<String> item : csv){

            String year = item.get(0);
            String month = item.get(1);
            String day = item.get(2);

            date = year + "-" + month + "-" + day;

            if (dayCollection.containsKey(date)==true){
                System.out.println("Date is already in table");
                Day thisDay = dayCollection.get(date);
                checkFlag(thisDay,item);
            }
            else{
                Day aDay = new Day();
                checkFlag(aDay,item);
                dayCollection.put(date,aDay);
            }

        }
        
        System.out.println(dayCollection.keySet());
        
        for(String dat : dayCollection.keySet()){
               System.out.println(dayCollection.get(dat).getWeight());
               System.out.println(dayCollection.get(dat).getGoal());
               System.out.println(dayCollection.get(dat).getFoodList());
        }
    }
    
    public void checkFlag(Day thisDay, List<String> item){
        
        if (item.get(3).equals("w")){
            
            double weight = Double.parseDouble(item.get(4));
            thisDay.setWeight(weight);
            
        }
        if (item.get(3).equals("c")){
            
            double goal = Double.parseDouble(item.get(4));
            thisDay.setGoal(goal);
            
        }
        if (item.get(3).equals("f")){
            
            int count = Integer.parseInt(item.get(5));
            thisDay.addFood(item.get(4),count);
            
        }
    
    }
    
    public Map<String,Day> getLog(){
        
        return dayCollection;
        
    }
       
}
