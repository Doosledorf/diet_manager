/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyplanner;

import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author Jake
 */
public class ParseFile {
    
    String fileName = "";
    File csv = null;
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
    List<List<String>> itemList;
    
    public ParseFile(String fileName){
        
        this.fileName = fileName;
        
    }
    
    public List<List<String>> openFile(){
        
        try{
            csv = new File(fileName);
            itemList = new ArrayList<>();
            
            fis = new FileInputStream(csv);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            
            while (dis.available() != 0){
                
                String currentLine = dis.readLine();
                List<String> parsedList = Arrays.asList(currentLine.split(","));
                
                itemList.add(parsedList);
                System.out.println(parsedList);
                
            }
            
        } 
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println(itemList);
        return(itemList);
        
    }
    
}
