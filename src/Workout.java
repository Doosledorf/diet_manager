import java.util.ArrayList;
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
public class Workout extends Exercise{
    
    private String workoutName;
    private Map<Exercise,Double> exercises;
    private List<Exercise> exerciseList= new ArrayList<>();
    
    public Workout(String workoutName, Map<Exercise,Double> ingredientsMap){
        
        super(workoutName);
        this.workoutName = workoutName;
        this.exercises=ingredientsMap;
        
    }
    
    public Workout(String workoutName){
        
        super(workoutName);
        this.workoutName = workoutName;
        this.exercises= new HashMap<>();
        
    }
   //Get list of ingredients
   public List<Exercise> getExerciseList(){

         for(Exercise exercise : exercises.keySet()){
            exerciseList.add(exercise);
         }
         return exerciseList;
      }
   
   public Double getExerciseTime(String ingredient){ 
   
      if (exercises.containsKey(ingredient)){ return exercises.get(ingredient); }
      else return 0.0;
   } 
   

   //Mutators

   public void addExercise(Exercise newExercise, Double time){ exercises.put(newExercise, time); }

   
}