package org.zhiqiang.lzw.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

/**
 * 日期类型转换器
 * @author LZW
 *
 */
public class DateConverter implements Converter<String, Date>{
	
	private static final Logger logger = Logger.getLogger(DateConverter.class);
	
	@Override
	public Date convert(String source) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			logger.info("正在进行日期转换...");
			//转换成功直接返回
			return dateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("日期转换失败！",e);
		}
		return null;
	}

}
