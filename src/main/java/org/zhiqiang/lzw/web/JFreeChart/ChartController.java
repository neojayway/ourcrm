package org.zhiqiang.lzw.web.JFreeChart;

import java.awt.Font;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 该类用来生成图表
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("chart")
public class ChartController {

	/**
	 * 生成柱状图
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getBarChart")
	protected ModelAndView getBar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CategoryDataset dataSet1 = getDataSet();
		CategoryDataset dataSet2 = getDataSet2();
		
		//设置字体，避免乱码
		ChartFactory.setChartTheme(setStandardChartTheme());
		
		JFreeChart chart = ChartFactory.createBarChart("水果产量图", // 图表标题
				"水果", // 目录轴的显示标签
				"产量", // 数值轴的显示标签
				dataSet2, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);

		String fileName = ServletUtilities.saveChartAsJPEG(chart, 400, 300,
				null, request.getSession());
		String chartURL = request.getContextPath() + "/chart?filename="
				+ fileName;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("chartURL", chartURL);
		modelAndView.setViewName("textJFreeChart");
		return modelAndView;
	}

	/**
	 * 生成饼状图
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getPieChart")
	protected ModelAndView getPie(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DefaultPieDataset dataSet3 = getDataSet3();
		
		//设置字体，避免乱码
		ChartFactory.setChartTheme(setStandardChartTheme());
		
		// 创建一个JFreeChart的对象 createPieChart方法表示二维显示，
		// createPieChart3D方法表示三维显示
		JFreeChart chart = ChartFactory.createPieChart3D("某公司人员组织数据图",
				dataSet3, true, true, false);
		chart.setTitle(new TextTitle("某公司组织结构图", new Font("宋体", Font.BOLD
				+ Font.ITALIC, 20)));

		LegendTitle legend = chart.getLegend(0);// 设置Legend
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));
		PiePlot plot = (PiePlot) chart.getPlot();// 设置Plot
		plot.setLabelFont(new Font("隶书", Font.BOLD, 16));

		chart.setTitle(new TextTitle("某公司组织结构图", new Font("宋体", Font.BOLD
				+ Font.ITALIC, 20)));

		// 设置透明度
		plot.setForegroundAlpha(0.5f);

		String fileName = ServletUtilities.saveChartAsJPEG(chart, 400, 300,
				null, request.getSession());
		String chartURL = request.getContextPath() + "/chart?filename="
				+ fileName;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("chartURL", chartURL);
		modelAndView.setViewName("textJFreeChart");
		return modelAndView;
	}

	@RequestMapping(value="/getLineChart")
	protected ModelAndView getLine(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DefaultCategoryDataset dataSet4 = getDataSet4();
		
		//设置字体，避免乱码
		ChartFactory.setChartTheme(setStandardChartTheme());
		
		String title1 = "前三季度各大公司JavaEE AS 销量统计";
		String title2 = "季度";
		String title3 = "销量(单位:万台)";
		JFreeChart chart = ChartFactory.createLineChart(title1, title2, title3,
				dataSet4, PlotOrientation.VERTICAL, true, false, false);

		String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 600,
				null, request.getSession());
		String chartURL = request.getContextPath() + "/chart?filename="
				+ fileName;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("chartURL", chartURL);
		modelAndView.setViewName("textJFreeChart");
		return modelAndView;
	}

	/**
	 * 设置字体
	 * 
	 * @param chart
	 */
	private static void getChartByFont(JFreeChart chart) {
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.BOLD, 20));
		LegendTitle legend = chart.getLegend();
		if (legend != null) {
			legend.setItemFont(new Font("宋体", Font.BOLD, 20));
		}
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		CategoryAxis axis = plot.getDomainAxis();
		// 设置X轴坐标上标题的文字
		axis.setLabelFont(new Font("宋体", Font.BOLD, 22));
		// 设置X轴坐标上的文字，
		axis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));

		ValueAxis valueAxis = plot.getRangeAxis();
		// 设置Y轴坐标上标题的文字
		valueAxis.setLabelFont(new Font("宋体", Font.BOLD, 12));
		// 设置Y轴坐标上的文字
		valueAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));
	}
	
	/**
	 * 避免中文乱码
	 * @return
	 */
	private StandardChartTheme setStandardChartTheme(){
		// 创建主题样式，避免中文乱码
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		return standardChartTheme;
	}

	/**
	 * 获取一个演示用的简单数据集对象
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, " ", "苹果");
		dataset.addValue(200, " ", "梨子");
		dataset.addValue(300, " ", "葡萄");
		dataset.addValue(400, " ", "香蕉");
		dataset.addValue(500, " ", "荔枝");
		return dataset;
	}

	/**
	 * 获取一个演示用的组合数据集对象
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "北京", "苹果");
		dataset.addValue(100, "上海", "苹果");
		dataset.addValue(100, "广州", "苹果");
		dataset.addValue(200, "北京", "梨子");
		dataset.addValue(200, "上海", "梨子");
		dataset.addValue(200, "广州", "梨子");
		dataset.addValue(300, "北京", "葡萄");
		dataset.addValue(300, "上海", "葡萄");
		dataset.addValue(300, "广州", "葡萄");
		dataset.addValue(400, "北京", "香蕉");
		dataset.addValue(400, "上海", "香蕉");
		dataset.addValue(400, "广州", "香蕉");
		dataset.addValue(500, "北京", "荔枝");
		dataset.addValue(500, "上海", "荔枝");
		dataset.addValue(500, "广州", "荔枝");
		return dataset;
	}

	private static DefaultPieDataset getDataSet3() {
		DefaultPieDataset dpd = new DefaultPieDataset(); // 建立一个默认的饼图
		dpd.setValue("管理人员", 25); // 输入数据
		dpd.setValue("市场人员", 25);
		dpd.setValue("开发人员", 45);
		dpd.setValue("其他人员", 10);
		return dpd;
	}

	private static DefaultCategoryDataset getDataSet4() {
		DefaultCategoryDataset ds = new DefaultCategoryDataset();

		ds.addValue(5300, "IBM", "一季度");
		ds.addValue(2500, "Oracle", "一季度");
		ds.addValue(2200, "微软", "一季度");

		ds.addValue(3000, "IBM", "二季度");
		ds.addValue(7000, "Oracle", "二季度");
		ds.addValue(1000, "微软", "二季度");

		ds.addValue(3000, "IBM", "三季度");
		ds.addValue(5000, "Oracle", "三季度");
		ds.addValue(2000, "微软", "三季度");

		return ds;
	}

}
