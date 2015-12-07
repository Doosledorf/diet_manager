import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class DailyGoalsPanel extends View{
   
   public DailyGoalsPanel(){
   
      init();
   }
   
   public void init(){
      
      //Layout
      setLayout(new FlowLayout());
      
      //Instantiate the main panels
      CalorieTrack calPanel = new CalorieTrack();
      MacroTrack macroPanel = new MacroTrack();
      
      //Add
      add(calPanel);
      add(macroPanel);
   }
}