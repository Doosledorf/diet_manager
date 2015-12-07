import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.PropertyChangeEvent;

public class MainView extends View{
 
   public MainView(){
   
      //Config
      mainFrame.setTitle("Diet Manager");
      mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      
      //Sizing
      mainFrame.setSize(800,600);
      mainFrame.setResizable(false);
      
      //Layout
      //getContentPane is crucial for some reason...
      
      //Render
      init();
      mainFrame.setVisible(true);
   }
   
   public void init(){
      
      mainFrame.setLayout(new BorderLayout());
      
      //Instantiate the parts.
      ListLogPanel listLog = new ListLogPanel();
      
      //Config those that need it.
      
      //Pull em together.
      mainFrame.add(listLog, BorderLayout.CENTER);  
   }
      
   public static void main (String[]args){
   
      MainView mv = new MainView();
   }
}