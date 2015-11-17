/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
    BufferedReader br = null;
    List<String> parsedList;
    
    public ParseFile(String fileName){
        
        this.fileName = fileName;
        
    }
    
    public List<String> openFile(){
        
        try{
            csv = new File(fileName);

            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                            "log.csv"), "UTF-8"));

            
            String currentLine = br.readLine();            
            while (currentLine != null){
                
                parsedList = Arrays.asList(currentLine.split(","));
                System.out.println(parsedList);

                CreateLogObject clo = new CreateLogObject(parsedList);
                clo.setDate();
                
                currentLine = br.readLine(); 
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
