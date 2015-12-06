
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jake
 */
public class CsvLogWriter {
    
    String fileName = "";
    File csv = null;
    BufferedWriter bw = null;
    Map<String,Day> dayMap;
    
    public CsvLogWriter(File csv, Map<String,Day> dayMap){
        
        this.csv = csv;
        this.dayMap = dayMap;
                
    }
    
    public void save(){
        

        try{
            csv = new File(fileName);
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(fileName)));
            
            for(String date : dayMap.keySet()){

                String year = date.substring(0, 4);
                String month = date.substring(5, 7);
                String day = date.substring(7, 9);
                String dateString = (year+","+month+","+day);
                
                Day log = dayMap.get(date);
                double weight = log.getWeight();
                double goal = log.getGoal();
                
                pw.println(dateString+",w,"+weight);
                pw.println(dateString+",c,"+goal);
                
                List<String> foodList = log.getFoodList();
                for(String food: foodList){
                    double count = log.getFoodCount(food);
                    pw.println(dateString+",f,"+food+","+count);
                }
            }              
            
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        
    }
    
}
