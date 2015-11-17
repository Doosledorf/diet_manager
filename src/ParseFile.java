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
public class ParseFile {
    
    String fileName = "";
    File csv = null;
    BufferedReader br = null;
    List<String> splitList;//list of the pieces of one line
    List<List<String>> splitLists;//all of the lines
       
    public ParseFile(String fileName){
        
        this.fileName = fileName;
        
    }
    
    public void openFile(){
        
        splitLists = new ArrayList<>();
    
        try{
            csv = new File(fileName);

            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                            fileName), "UTF-8"));

            
            String currentLine = br.readLine();            
            while (currentLine != null){
                
                //splits current line by comma, then creates a list out of the array.
                splitList = Arrays.asList(currentLine.split(","));
                
                //add to the lines list
                splitLists.add(splitList);
                              
                currentLine = br.readLine();
            }
            chooseFileDestination();
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    /*
    Uses a switch statement to determine whether to send the list to 
    FoodStore or DayLog 
    */
    
    public void chooseFileDestination(){
        
        switch (fileName) {
            case "log.csv":
                DayLog dl = new DayLog(splitLists);
                dl.addToCollection();
                dl.getLog();
                break;
            case "foods.csv":
                FoodStore fs = new FoodStore(splitLists);
                fs.addToCollection();
                fs.getFoods();
                break;
        }
        
    }
       
}
