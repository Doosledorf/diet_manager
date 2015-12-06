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
   private String mode = "READ"; //Might do something with this.
   
   private File csv = null;
   private BufferedReader br = null;
   private List<List<String>> splitLists;//all of the lines
      
   public Director(String fileName){
      
      direct();
   }
   
   public void direct( String filename ){
      
      List<List<String>> primedData = openfile(fileName);
      
      switch(filename){
         
         case "log.csv" : break;
         
         case "exercise.csv" :break;
         
         case "foods.csv" : break;
      }
   }
   
   public List<List<String>> openFile( String filename ){
      
      try{
         
         Filecsv = new File(fileName);
      
         BufferedReader br = new BufferedReader(
                             new InputStreamReader(
                             new FileInputStream(fileName), "UTF-8"));
      
         List<String> readLineHolder;
         String currentLine = br.readLine();
                     
         while (currentLine != null){
            
            //splits current line by comma, then creates a list out of the array.
            List<String> readLine = Arrays.asList(currentLine.split(","));
            
            //add to the lines list
            readLineHolder.add(readLine);
                          
            currentLine = br.readLine();
            
            return readLineHolder();
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