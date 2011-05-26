/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.charts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
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
public class LineChart extends ApplicationFrame {

    private ChartPanel panel;
    private CategoryPlot plot;
    private int secondaryDatasetIndex = 0;

    public LineChart(final String title) {
        super(title);
        final CategoryDataset dataset1 = createRandomDataset("Series 1");
        final JFreeChart chart = ChartFactory.createLineChart(
                "Secondary Dataset Demo 2", "Category", "Value",
                dataset1, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.white);

        this.plot = chart.getCategoryPlot();
        this.plot.setBackgroundPaint(Color.lightGray);
        this.plot.setDomainGridlinePaint(Color.white);
        this.plot.setRangeGridlinePaint(Color.white);
//        this.plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 4, 4, 4, 4));

        final NumberAxis rangeAxis = (NumberAxis) this.plot.getRangeAxis();
        rangeAxis.setAutoRangeIncludesZero(false);

        final JPanel content = new JPanel(new BorderLayout());

        final ChartPanel chartPanel = new ChartPanel(chart);
        content.add(chartPanel);
    }
//http://www.java2s.com/Code/Java/Chart/JFreeChartSecondaryDatasetDemo2.htm
    
    private CategoryDataset createRandomDataset(final String name) {
        final DefaultCategoryDataset result = new DefaultCategoryDataset();
        double value = 100.0;
        for (int i = 0; i < 10; i++) {
            final String key = "T" + i;
            value = value * (1.0 + Math.random() / 100);
            result.addValue(value, name, key);
        }
        return result;
    }
    
    public ChartPanel getPanel() {
        return this.panel;
    }
}
