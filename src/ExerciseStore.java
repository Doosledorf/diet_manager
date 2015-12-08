
import java.io.File;
import java.util.HashMap;
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
public class ExerciseStore {
    
List<List<String>> csv;
String exerciseName;
String recName;

private Map<String,Exercise> exerciseMap;
    
    public ExerciseStore(List<List<String>> csv){
        
        this.csv = csv;
        exerciseMap = new HashMap<>();
        
    }
    
    public void createMap(){
        
        for(List<String> item : csv){
            
            exerciseName = item.get(1);
            
            if (exerciseMap.containsKey(exerciseName)==true){
                exerciseMap.remove(exerciseName);
                checkFlag(item);
            }
            else{
                checkFlag(item);
            }
           
        }
        
    }
    
    public void checkFlag(List<String> item){
        
        if (item.get(0).equals("e")){
            
            String caloriesString = item.get(2);
            
            Double calories = Double.parseDouble(caloriesString);
            
            Exercise anExercise = new Exercise(exerciseName);
            anExercise.setBurnedCal(calories);
            
            exerciseMap.put(exerciseName, anExercise);
        }
        
        else if (item.get(0).equals("w")){
            
            String workoutName = item.get(1);
            
            Double burnCount;
            String excName, burnCountString;
    
            Workout workout = new Workout(workoutName);
            
            for(int i=2;i<item.size();i+=2){
                
                excName = item.get(i);
                burnCountString = item.get(i+1);
                burnCount = Double.parseDouble(burnCountString);
                
                Exercise anExercise = exerciseMap.get(excName);
                anExercise.setBurnedCal(burnCount);
                
                
                
            }
            
            exerciseMap.put(workoutName,workout);
            
        }
    
    }
    
    public Map<String,Exercise> getLog(){
        
        return exerciseMap;
        
    }
    
    public void addWorkout(Workout aWorkout){
        
        exerciseMap.put(aWorkout.getName(),aWorkout);
        
    }
    
    public void addExercise(Exercise anExercise){
        
        exerciseMap.put(anExercise.getName(), anExercise);
        
    }
    
    public void save(){
       
        File file = new File("exercise.csv");
        
        //this may change with project 2 requirements.
        CsvExerciseWriter csvew = new CsvExerciseWriter(file,exerciseMap);
        csvew.save();
        
        }
    
}
