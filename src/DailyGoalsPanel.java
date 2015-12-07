import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

//@author Roberto Ortiz
public class DailyGoalsPanel extends View{
   
   CalorieTrack calPanel;
   MacroTrack macroPanel;
   
   public DailyGoalsPanel(){
   
      init();
   }
   
   public void init(){
      
      //Layout
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      
      //Instantiate the main panels
      calPanel = new CalorieTrack();
      macroPanel = new MacroTrack();
      
      //Add
      add(calPanel);
      add(macroPanel);
   }
   
   //ACCESSORS FOR PANELS
   public CalorieTrack getCalPanel(){ return calPanel; }
   public MacroTrack getMacroPanel(){ return macroPanel; }
}