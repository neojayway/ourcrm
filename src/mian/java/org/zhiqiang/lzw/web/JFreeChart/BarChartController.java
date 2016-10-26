package org.zhiqiang.lzw.web.JFreeChart;

import java.awt.Font;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 该类用来生成柱状图表
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("chart")
public class BarChartController {
	
	@RequestMapping(value = "/getMajorChart")
	protected ModelAndView getMajor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("我就看你进来没有");
		CategoryDataset dataSet1 = getDataSet();
		CategoryDataset dataSet2 = getDataSet2();
		JFreeChart chart = ChartFactory.createBarChart("水果产量图", // 图表标题
			"水果", // 目录轴的显示标签
			"产量", // 数值轴的显示标签
			dataSet2, // 数据集
			PlotOrientation.VERTICAL, // 图表方向：水平、垂直
			true, // 是否显示图例(对于简单的柱状图必须是false)
			false, // 是否生成工具
			false // 是否生成URL链接
		);
		// 解决乱码问题
		getChartByFont(chart);
		String fileName = ServletUtilities.saveChartAsJPEG(chart, 400, 300,
				null, request.getSession());
		String chartURL = request.getContextPath() + "/chart?filename="
				+ fileName;
		System.out.println("进入/getMajorChart的方法-------");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("chartURL", chartURL);
		modelAndView.setViewName("textJFreeChart");
		return modelAndView;
	}

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
		System.out.println("生成DataSet-------");
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
}
