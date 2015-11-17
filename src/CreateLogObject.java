/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Jake
 */
public class CreateLogObject {

List<String> csv;
Calendar date;

private Map<Calendar,Day> dayCollection;
    
    public CreateLogObject(List<String> csv){
        
        this.csv = csv;
        dayCollection = new HashMap<>();
    }
    
    public void setDate(){
        
        String yearString = csv.get(0);
        String monthString = csv.get(1);
        String dayString = csv.get(2);
        
        for (int i = 0;i < yearString.length(); i++){
        System.out.println(yearString.charAt(i));
        }
        
        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);
        
        date.set(year,month,day);
        
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
       
}
