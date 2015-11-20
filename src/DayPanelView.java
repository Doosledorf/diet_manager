import javax.swing.*;
import org.jfree.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

import java.awt.*;
import java.util.*;

public class DayPanelView extends View
{
   private MainController controller;

	private Panel graphPane = new Panel();
	private Panel wPanel = new Panel();
	private Panel cPanel = new Panel();
	private Label weight = new Label("Today's Weight");
	private Label calories = new Label("Today's Calorie Limit");
	private Button submit = new Button("Submit");
	private TextField weightbox = new TextField();
	private TextField calorieBox = new TextField();
	
	//external resources from JFree
	private JFreeChart graph;
	private ChartPanel chartPanel;

	public DayPanelView(MainController controller)
   {
      this.controller = controller;

		this.setSize(320,320);
		this.setBackground(new Color(100,100,100));
		this.setLayout(new GridLayout(0,1));
		graphPane.setPreferredSize(new java.awt.Dimension(400,300));
		graph = ChartFactory.createLineChart("Calories",
				"Days", "Calories",
				createDataset(),
				PlotOrientation.VERTICAL,
				true, true, false
      );
		chartPanel = new ChartPanel(graph);
		chartPanel.setPreferredSize(new java.awt.Dimension(400,300));
		graphPane.add(chartPanel);
      wPanel.add(weight);
      wPanel.add(weightbox);
      cPanel.add(calories);
      cPanel.add(calorieBox);
      graphPane.add(wPanel);
      graphPane.add(cPanel);
      graphPane.add(submit);
      this.add(graphPane);
	}
	
	public DefaultCategoryDataset createDataset()
   {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		data.addValue(150, "Calories", "11/11");
		data.addValue(110, "Calories", "11/12");
		data.addValue(116, "Calories", "11/13");
		data.addValue(100, "Calories", "11/14");
		data.addValue(250, "Calories", "11/15");
		data.addValue(120, "Weight", "11/11");
		data.addValue(122, "Weight", "11/12");
		data.addValue(122, "Weight", "11/13");
		data.addValue(125, "Weight", "11/14");
		data.addValue(150, "Weight", "11/15");

		return data;
	}
}
