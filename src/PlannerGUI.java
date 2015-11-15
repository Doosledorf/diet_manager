/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyplanner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.util.*;



public class PlannerGUI {
    
private JFrame mainFrame = new JFrame();
    
        public PlannerGUI(){
            
        }
        
        public void setFrame(){
            mainFrame.setPreferredSize(new Dimension(640, 480));
            mainFrame.setVisible(true);
        }
        
        public JTabbedPane createTabs(){
            
            JTabbedPane tabbedPane = new JTabbedPane();
            
            tabbedPane.addTab("Daily Log",createLogLeftColumn());
            tabbedPane.addTab("Add Foods",createLogRightColumn());
            
            return(tabbedPane);
            
        }
        
        public JPanel createLogLeftColumn(){
            
            JPanel dailyLogLeftColumn = new JPanel(new BorderLayout());
            JLabel header = new JLabel("Today's Foods:");
            JTextArea todaysFoods;
            
            
            
            dailyLogLeftColumn.add(header);
            
            return(dailyLogLeftColumn);
        }
        
        public JPanel createLogRightColumn(){
            
            JPanel dailyLogRightColumn = new JPanel(new BorderLayout());
            JLabel header = new JLabel("This Week:");
            
            Image calGraph;
            
            return(dailyLogRightColumn);
        }
        
        public JPanel createDailyLog(){
            
            JPanel logPanel = new JPanel(new BorderLayout());
            
            JPanel left = createLogLeftColumn();
            JPanel right = createLogRightColumn();
            
            logPanel.add(left);
            logPanel.add(right);
            
            return(logPanel);
        }
}