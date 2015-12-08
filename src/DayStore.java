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
public class DayStore {

    
private List<List<String>> csv;
private String date = "";
private Map<String,Day> dayMap;

public DayStore(List<List<String>> csv){

    this.csv = csv;
    dayMap = new HashMap<>();

}
    
    public void add(List<String> item){
        
            String year = item.get(0);
            String month = item.get(1);
            String day = item.get(2);

            date = year + "-" + month + "-" + day;

            if (dayMap.containsKey(date)==true){
                Day thisDay = dayMap.get(date);
                checkFlag(thisDay,item);
            }
            else{
                Day aDay = new Day();
                checkFlag(aDay,item);
                dayMap.put(date,aDay);
            }
    }
    
    public void createMap(){
        
        for(List<String> item : csv){

            String year = item.get(0);
            String month = item.get(1);
            String day = item.get(2);

            date = year + "-" + month + "-" + day;

            if (dayMap.containsKey(date)==true){
                Day thisDay = dayMap.get(date);
                checkFlag(thisDay,item);
            }
            else{
                Day aDay = new Day();
                checkFlag(aDay,item);
                dayMap.put(date,aDay);
            }

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
            String foodName = item.get(4);
            Food aFood = new Food(foodName);
            thisDay.addFood(aFood,count);
            
        }
    
    }
    
    public Map<String,Day> getLog(){
        
        return dayMap;
        
    }
    
    public void save(){
        
        File file = new File("log.csv");
        
        CsvLogWriter csvlw = new CsvLogWriter(file,dayMap);
        csvlw.save(); 
        
    }
       
    
}
