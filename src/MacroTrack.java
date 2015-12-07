import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class MacroTrack extends View{

   public MacroTrack(){
      
      init();
   }
   
   public void init(){
   
      //Main Layout
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      //Label Panel
      JPanel titlePanel = new JPanel();
      titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      
      //Its appropriate label
      JLabel title = new JLabel("Macros");
      
      //put it in
      titlePanel.add(title);
      add(titlePanel);
      
      //Now for the Stats panel
      JPanel statsPanel = new JPanel();
      statsPanel.setLayout(new GridLayout(4,3));
      
      //Our Labels
      JLabel blank = new JLabel("");
      JLabel proteinLabel = new JLabel("Protein");
      JLabel fatsLabel = new JLabel("Fats");
      JLabel carbsLabel = new JLabel("Carbs");
      JLabel macrosConsumedLabel = new JLabel("Total Consumed");
      JLabel percentageLabel = new JLabel ("Calorie Contribution");
      
      //Our Fields
      JTextField protein = new JTextField(8);
      protein.setEditable(false);
      JTextField proteinPct = new JTextField(4);
      proteinPct.setEditable(false);
      JTextField fats = new JTextField(8);
      fats.setEditable(false);
      JTextField fatsPct = new JTextField(4);
      fatsPct.setEditable(false);
      JTextField carbs = new JTextField(8);
      carbs.setEditable(false); 
      JTextField carbsPct = new JTextField(4);
      carbsPct.setEditable(false);
      
      //Add to panel
      statsPanel.add(blank);
      statsPanel.add(macrosConsumedLabel);
      statsPanel.add(percentageLabel);
      statsPanel.add(fatsLabel);
      statsPanel.add(fats);
      statsPanel.add(fatsPct);
      statsPanel.add(proteinLabel);
      statsPanel.add(protein);
      statsPanel.add(proteinPct);
      statsPanel.add(carbsLabel);
      statsPanel.add(carbs);
      statsPanel.add(carbsPct);
      
      //Add to main panel
      add(statsPanel);
   }
}