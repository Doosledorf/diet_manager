/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyplanner;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author Jake
 */
public class CSVReader {
    
    List<List<String>> logObject;
    List<List<String>> foodObject;
    
    public void parseFoodCSV(){
        
        ParseFile open = new ParseFile("food.csv");
        foodObject = open.openFile();
        
    }
    
    public void parseLogCSV(){
        
        ParseFile open = new ParseFile("log.csv");
        logObject = open.openFile();
        
    }
    
    public void interpretFood(){
            
        if(){
            
        }
        else if (){
            
        }

        
    }
    
    public void interpretLog(){
            
        if(){
            
        }
        else if (){
            
        }
        
    }
    
}
