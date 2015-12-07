import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

//@author Roberto Ortiz
//Admittedly there are a lot of things we can do here. But Im unsure how it would interact.
public class DataPanel extends View{
   
   Checkbox selected;
   
   public DataPanel(String type){
   
      init(type);
   }
   
   public void init(String type){
      
      //Layout
      setLayout(new GridLayout());
      
      //first the checkbox
      selected = new Checkbox();
      add(selected);
      
      //then the information
   }
}