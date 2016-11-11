package org.zhiqiang.lzw.service.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Weather;
import org.zhiqiang.lzw.service.IWeatherService;
import org.zhiqiang.lzw.weather.ArrayOfString;
import org.zhiqiang.lzw.weather.WeatherWebService;
import org.zhiqiang.lzw.weather.WeatherWebServiceSoap;

@Service("weatherService")
public class WeatherServiceImpl implements IWeatherService{
	
	private URL wsdlUrl = WeatherWebService.WSDL_LOCATION;
	
	/**
	 * 得到支持的省份
	 * @return
	 */
	@Override
	public List<String> getSupportProvince() {
		WeatherWebService webService = new WeatherWebService(wsdlUrl);
		WeatherWebServiceSoap client1 = webService.getWeatherWebServiceSoap();
		ArrayOfString provinceArray = client1.getSupportProvince();
		return provinceArray.getString();
	}
	
	/**
	 * 得到支持的城市
	 * @param province
	 * @return
	 */
	@Override
	public List<String> getSupportCity(String province) {
		WeatherWebService webService = new WeatherWebService(wsdlUrl);
		WeatherWebServiceSoap client1 = webService.getWeatherWebServiceSoap();
		//支持的城市
		ArrayOfString supportCityString = client1.getSupportCity(province);
		return supportCityString.getString();
	}
	
	/**
	 * 得到城市的天气
	 */
	@Override
	public List<Weather> getWeatherbyCityName(String city) {
		List<Weather> weatherList = new ArrayList<Weather>();
		WeatherWebService webService = new WeatherWebService(wsdlUrl);
		WeatherWebServiceSoap client1 = webService.getWeatherWebServiceSoap();
		//得到天气
		ArrayOfString arrayOfString = client1.getWeatherbyCityName(city);
		List<String> WeatherStr = arrayOfString.getString();
		Weather weather1 = new Weather(WeatherStr.get(5), WeatherStr.get(6), WeatherStr.get(7));
		Weather weather2 = new Weather(WeatherStr.get(12), WeatherStr.get(13), WeatherStr.get(14));
		Weather weather3 = new Weather(WeatherStr.get(17), WeatherStr.get(18), WeatherStr.get(19));
		weatherList.add(weather1);
		weatherList.add(weather2);
		weatherList.add(weather3);
		return weatherList;
	}

}
