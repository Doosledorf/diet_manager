import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class MacroTrack extends View
{
   private JTextField fats, fatsPct, protein, proteinPct, carbs, carbsPct;

   public MacroTrack(MainController controller)
   {
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
      JLabel proteinLabel = new JLabel("Protein: ", JLabel.RIGHT);
      JLabel fatsLabel = new JLabel("Fats: ", JLabel.RIGHT);
      JLabel carbsLabel = new JLabel("Carbs: ", JLabel.RIGHT);
      JLabel macrosConsumedLabel = new JLabel("Total Consumed");
      JLabel percentageLabel = new JLabel ("Calorie Contribution");
            
      //Fats
      fats = new JTextField(8);
      fats.setEditable(false);
      fatsPct = new JTextField(4);
      fatsPct.setEditable(false);
      
      //Protein
      protein = new JTextField(8);
      protein.setEditable(false);
      proteinPct = new JTextField(4);
      proteinPct.setEditable(false);
      
      //carbs
      carbs = new JTextField(8);
      carbs.setEditable(false);
      carbsPct = new JTextField(4);
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

   //ACCESSORS
   public JTextField getFats(){ return fats; }
   public JTextField getFatsPct(){ return fatsPct; }
   public JTextField getProtein(){ return protein; }
   public JTextField getProteinPct(){ return proteinPct; }
   public JTextField getCarbs(){ return carbs; }
   public JTextField getCarbsPct(){ return carbsPct; }
   
   //MUTATORS
   public void setFats(double newFats){ fats.setText(String.valueOf(newFats)); }
   public void setFatsPct(double newFatsPct){ fatsPct.setText(String.valueOf(newFatsPct)); }
   public void setProtein(double newProtein){ protein.setText(String.valueOf(newProtein)); }
   public void setProteinPct(double newProteinPct){ proteinPct.setText(String.valueOf(newProteinPct)); }
   public void setCarbs(double newCarbs){ carbs.setText(String.valueOf(newCarbs)); }
   public void setCarbsPct(double newCarbsPct){ carbsPct.setText(String.valueOf(newCarbsPct)); }
}