package org.zhiqiang.lzw.entity;

/**
 * 天气实体
 * @author LZW
 *
 */
public class Weather {
	
	private String temperature; //气温
	private String weatherType; //天气类型（晴、雨、多云）
	private String wind;        //风向
	
	public Weather() {}
	
	public Weather(String temperature, String weatherType, String wind) {
		super();
		this.temperature = temperature;
		this.weatherType = weatherType;
		this.wind = wind;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getWeatherType() {
		return weatherType;
	}
	public void setWeatherType(String weatherType) {
		this.weatherType = weatherType;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return "Weather [temperature=" + temperature + ", weatherType="
				+ weatherType + ", wind=" + wind + "]";
	}
	
	
	
}
