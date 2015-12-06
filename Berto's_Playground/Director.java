import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * The purpose of this file is to read in a csv file, separate each line into 
 * a list of it's parts, then send a list of the lines to another class to be 
 * stored as objects.
 * @author Jake
 */
public class Director
{ 
   
   private String mode; //Might do something with this.
         
   public Director(){
      
      mode = "READ";
   }
   
   public void direct( String fileName ){
      
      List<List<String>> primedData = openFile(fileName);
      
      switch(fileName){
         
         case "log.csv" : break;
         
         case "exercise.csv" :break;
         
         case "foods.csv" : break;
      }
   }
   
   public List<List<String>> openFile( String fileName ){
   
      List<List<String>> readLineHolder = new ArrayList<List<String>>();
      
      try{
         
         File csv = new File(fileName);
      
         BufferedReader br = new BufferedReader(
                             new InputStreamReader(
                             new FileInputStream(fileName), "UTF-8"));
      
         String currentLine = br.readLine();
                     
         while (currentLine != null){
            
            //splits current line by comma, then creates a list out of the array.
            List<String> readLine = Arrays.asList(currentLine.split(","));
            
            //add to the lines list
            readLineHolder.add(readLine);
                          
            currentLine = br.readLine();
         }
      }
      catch(FileNotFoundException fnfe){
         fnfe.printStackTrace();
         return null;
      }
      catch(IOException ioe){
         ioe.printStackTrace();
         return null;
      }
      
      return readLineHolder;
   }
}