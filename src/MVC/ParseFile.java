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
public class ParseFile
{ 
   String fileName = "";
   File csv = null;
   BufferedReader br = null;

   List<List<String>> splitLists;//all of the lines
      
   public ParseFile(String fileName){
      
      this.fileName = fileName;
   
      openFile();
   }
   
   public void openFile(){
      
      splitLists = new ArrayList<>();
   
      try{
         csv = new File(fileName);
      
         br = new BufferedReader(
                new InputStreamReader(new FileInputStream(
                        fileName), "UTF-8"));
      
         List<String> splitList;
         String currentLine = br.readLine();            
         while (currentLine != null){
            
            //splits current line by comma, then creates a list out of the array.
            splitList = Arrays.asList(currentLine.split(","));
            
            //add to the lines list
            splitLists.add(splitList);
                          
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