package org.zhiqiang.lzw.service;

import java.util.List;

import org.zhiqiang.lzw.entity.Weather;

/**
 * 天气业务接口
 * @author LZW
 *
 */
public interface IWeatherService {
	
	/**
	 * 得到支持的省份
	 * @return
	 */
	public List<String> getSupportProvince();
	
	/**
	 * 得到支持的城市
	 * @param province
	 * @return
	 */
	public List<String> getSupportCity(String province);
	
	/**
	 * 得到城市的天气
	 */
	public List<Weather> getWeatherbyCityName(String city);
}
