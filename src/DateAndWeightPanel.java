import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

//huehue it rhymes
public class DateAndWeightPanel extends View{
   
   JButton forward, backward;
   JSpinner date;
   
   public DateAndWeightPanel(){
   
      init();
   }
   
   public void init(){
      
      //Set layout
      setLayout(new FlowLayout(FlowLayout.CENTER));
      
      //Need a Calendar to work with dates
      Calendar calendar = new GregorianCalendar();
      
      //Get current time (default)
      Date initDate = calendar.getTime();
      
      //Go back 100 years and set it as the earliest date possible on the spinner
      calendar.add(Calendar.YEAR, -100);
      Date earliestDate = calendar.getTime();
      
      //Add 200 (to compensate) and set it as the latest date possible on the spinner
      calendar.add(Calendar.YEAR, 200);
      Date latestDate = calendar.getTime();
      
      //Use those values to set up the spinnerMocel
      SpinnerDateModel model = new SpinnerDateModel(initDate,
                                   earliestDate,
                                   latestDate,
                                   Calendar.YEAR);
                                   
      //Create the Spinner using the model above                             
      date = new JSpinner(model);
      
      //This helps format it the way we want it
      JSpinner.DateEditor de = new JSpinner.DateEditor(date, "yyyy-MM-dd");
      date.setEditor(de);
          
      //give it a label
      JLabel dateLabel = new JLabel("Date: ");
      
      //Add to the panel
      add(dateLabel);
      add(date);
      
      //now for the weight
      JLabel weightLabel = new JLabel("Weight: ");
      JTextField weight = new JTextField();
      
      //alter the length of the textfield
      weight.setColumns(6);
      
      //add em
      add(weightLabel);
      add(weight);
   }
}
