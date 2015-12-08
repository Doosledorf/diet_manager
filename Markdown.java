import java.util.*;
import java.io.*;

public class Markdown {
	//Basic outline
	String date =   "*  Date: ";
	String summ = 	"  * Summary";
	String weight = "    * Weight: ";
	String callim = "    * Calorie Limit: ";
	String calcon = "    * Calories Consumed: ";
	String calExp = "    * Calories Expended: ";
	String calNet = "    * Calories Net: ";
	String foods = 	"  * Food\n";
	String exer = 	"  * Exercise\n";
	
	//File Reader and Writer
	String file = "log.md";
	FileReader fr;
	FileWriter fw;
	public Markdown(FoodStore fs, DayStore ds, ExerciseStore es, String d){
		String day = ds.getLog().get(d).date;
		date=date+day;
		weight=weight+ds.getLog().get(day).getWeight();
		callim = callim+ds.getLog().get(day).getGoal();
		double consume;
		String[] foodie = ds.getLog().get(day).getFoodTuple();
		for(int i = 0;i<foodie.length;i++){
			if(i%2!=0){
				consume=consume+Double.parseDouble(foodie[i]);
			}
			else{}
		}
		double expend;
		String[] exers = es.getLog().get(day).getExerciseTuple();
		for(int i = 0;i<exers.length;i++){
			if(i%2!=0){
				expend=expend+Double.parseDouble(exers[i]);
			}
			else{}
		}
		
		calcon = calcon+consume;
		calExp = calExp+expend;
		calNet = calNet+(consume-expend);
		for(int i = 0; i<foodie.length;i++){
			if(i%2==0){
				foods=foods+"\n"+foodie[i];
			}
			else if(i%2!=0){
				foods=foods+": "+foodie[i];
			}
		}
		for(int i = 0; i<exers.length;i++){
			if(i%2==0){
				exer=exer+"\n"+exers[i];
			}
			else if(i%2!=0){
				exer=exer+": "+exers[i];
			}
		}
		String output = date+"\n"+summ+"\n"+weight+"\n"+callim+
						"\n"+calcon+"\n"+calExp+"\n"+calNet+"\n"+foods+"\n"+exer;
		try{
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			fw = new FileWriter(file);
			fw.append(output);
		}catch (Exception ex){
			System.out.println("Error: "+ex.printStackTrace());
		}
	}
}
