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
    List<String> parsedList;
    
    public ParseFile(String fileName){
        
        this.fileName = fileName;
        
    }
    
    public List<String> openFile(){
        
        try{
            csv = new File(fileName);

            
            fis = new FileInputStream(csv);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            
            while (dis.available() != 0){
                
                String currentLine = dis.readLine();
                parsedList = Arrays.asList(currentLine.split(","));
                CreateLogObject clo = new CreateLogObject(parsedList);
                clo.setDate();
                
            }
            
        } 
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return(parsedList);
    }
    
}
