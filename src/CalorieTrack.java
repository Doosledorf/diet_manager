import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class CalorieTrack extends View{

   public CalorieTrack(){
   
      init();
   }
   
   public void init(){
   
      //Main Layout
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      //Label Panel
      JPanel titlePanel = new JPanel();
      titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      
      //Its appropriate label
      JLabel title = new JLabel("Calories");
      
      //put it in
      titlePanel.add(title);
      add(titlePanel); 
      
      //Now for the Stats panel
      JPanel statsPanel = new JPanel();
      statsPanel.setLayout(new GridLayout(4,2));
      
      //Create our Labels
      JLabel goalLabel = new JLabel("Goal:  ");
      JLabel hitLabel = new JLabel("Hit: ");
      JLabel burnedLabel = new JLabel("Burned: ");
      JLabel netLabel = new JLabel("Net Gain: ");
      
      //Create the fields accompanying them
      JTextField goal = new JTextField();
      goal.setColumns(8);
      JTextField hit = new JTextField();
      hit.setEditable(false);
      JTextField burned = new JTextField();
      burned.setEditable(false);
      JTextField net = new JTextField();
      net.setEditable(false);
      
      //Add em
      statsPanel.add(goalLabel);
      statsPanel.add(goal);
      statsPanel.add(hitLabel);
      statsPanel.add(hit);
      statsPanel.add(burnedLabel);
      statsPanel.add(burned);
      statsPanel.add(netLabel);
      statsPanel.add(net);
      
      //Add statsPanel on to the main panel
      add(statsPanel);
   }
}