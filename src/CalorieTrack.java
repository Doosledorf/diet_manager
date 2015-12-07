import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

//@author Roberto Ortiz
public class CalorieTrack extends View{

   JTextField goal, hit, burned, net;

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
      goal = new JTextField(8);
      hit = new JTextField();
      hit.setEditable(false);
      burned = new JTextField();
      burned.setEditable(false);
      net = new JTextField();
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
   
   //ACCESSORS
   public JTextField getGoal(){ return goal; }
   public JTextField getHit(){ return hit; }
   public JTextField getBurned(){ return burned; }
   public JTextField getNet(){ return net; }
   
   //MUTATORS
   public void setGoal(double newGoal){ goal.setText(String.valueOf(newGoal)); }
   public void setHit(double newHit){ hit.setText(String.valueOf(newHit)); }
   public void setBurned(double newBurned){ burned.setText(String.valueOf(newBurned)); }
   public void setNet(double newNet){ net.setText(String.valueOf(newNet)); }
   
}