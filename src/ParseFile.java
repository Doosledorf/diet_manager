/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Jake
 */
public class ParseFile {
    
    String fileName = "";
    File csv = null;
    BufferedReader br = null;
    List<String> splitList;
    
    public ParseFile(String fileName){
        
        this.fileName = fileName;
        
    }
    
    public void openFile(){
        
        try{
            csv = new File(fileName);

            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                            fileName), "UTF-8"));

            
            String currentLine = br.readLine();            
            while (currentLine != null){
                
                splitList = Arrays.asList(currentLine.split(","));
                        
                switch (fileName) {
                    case "log.csv":
                        DayLog dl = new DayLog(splitList);
                        dl.setDate();
                        break;
                    case "foods.csv":
                        FoodStore fs = new FoodStore(splitList);
                        fs.checkFlag();
                        break;
                }
                
                currentLine = br.readLine(); 
            }
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
       
}
