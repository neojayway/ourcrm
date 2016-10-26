package org.zhiqiang.lzw.util;

import java.util.Calendar;

/**
 * 日志工具类
 * @author LZW
 *
 */
public class LogUtil {
	
	/**
	 *  用于生成日志表名称(log_2016_10)：查询或者创建时均要使用
	 * @param offset 偏移量：-1：上个月；0：当前月；1：下个月
	 * @return
	 */
	public static String generateLogTableName(int offset){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		//月份0-11
		int month = calendar.get(Calendar.MONTH)+1+offset;
		
		if (month>12) {
			year++;
			month -= 12;
		}else if (month<1) {
			year--;
			month+=12;
		}
		return "sys_log_"+year+"_"+month;
	}
}
