/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.charts;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Goran-Goggy
 */
public class LineChart extends ApplicationFrame{

    private ChartPanel panel;
    private CategoryPlot plot;
    private final JPanel content;
    private final JFreeChart chart;
    private int secondaryDatasetIndex = 0;
    private CategoryDataset dataset1;

    public LineChart(final String title, String x, ArrayList<String>xCoord, String y, ArrayList<Double> yCoord) {
        super(title);
        dataset1 = createDataSet(xCoord, yCoord);
        chart = ChartFactory.createLineChart("", x, y, dataset1, PlotOrientation.VERTICAL, false, false, false);
        chart.setBackgroundPaint(Color.white);
        chart.setBorderStroke(new BasicStroke(1));
        chart.setBorderVisible(true);
        
        this.plot = chart.getCategoryPlot();
        this.plot.setBackgroundPaint(Color.WHITE);
        //this.plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 4, 4, 4, 4));

        final NumberAxis rangeAxis = (NumberAxis) this.plot.getRangeAxis();
        rangeAxis.setAutoRangeIncludesZero(false);
        content = new JPanel(new BorderLayout());

        final ChartPanel chartPanel = new ChartPanel(chart);
        content.add(chartPanel);
        setContentPane(content);
    }
//http://www.java2s.com/Code/Java/Chart/JFreeChartSecondaryDatasetDemo2.htm
    
    /*private CategoryDataset createRandomDataset(final String name) {
        final DefaultCategoryDataset result = new DefaultCategoryDataset();
        double value = 100.0;
        for (int i = 0; i < 10; i++) {
            final String key = "T" + i;
            value = value * (1.0 + Math.random() / 100);
            result.addValue(value, name, key);
        }
        return result;
    }*/
    
    public JPanel getContent() {
        return this.content;
    }

    public JFreeChart getChart() {
        return chart;
    }
    
    public CategoryDataset createDataSet(ArrayList<String>xCoord, ArrayList<Double>yCoord){
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        for(int i = 0; i < xCoord.size(); i++) {
            result.addValue(yCoord.get(i), "", xCoord.get(i));
            
            System.out.println("Ausgabe: X: " + xCoord.get(i) + "        " + "Ausgabe: Y: " + yCoord.get(i));
        }
        
        return result;
    }
}
