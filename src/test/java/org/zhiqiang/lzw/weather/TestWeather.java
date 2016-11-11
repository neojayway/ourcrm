package org.zhiqiang.lzw.weather;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;











import org.junit.Before;
import org.junit.Test;
import org.zhiqiang.lzw.entity.Weather;
import org.zhiqiang.lzw.service.IWeatherService;
import org.zhiqiang.lzw.service.impl.WeatherServiceImpl;

public class TestWeather {

	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * 用通过wsdl2java.bat 批处理命令生成的.java文件就能调用成功
	 * 为什么用到CXF拿支持的省份和城市就没问题，根据城市获得天气就就报异常：
	 * No namespace on "html" element. You must send a SOAP message.
	 */
	@Test
	public void test() {
		/*JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		
		factory.setServiceClass(WeatherWebServiceSoap.class);
		factory.setAddress("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");
		WeatherWebServiceSoap client = (WeatherWebServiceSoap) factory.create();*/
		/*ArrayOfString weatherbyCityName = client.getWeatherbyCityName("长沙");
		List<String> weatherList = weatherbyCityName.getString();
		for (String string : weatherList) {
			System.out.println(string);
		}*/
		/*ArrayOfString supportProvince = client.getSupportProvince();
		List<String> weatherList = supportProvince.getString();
		for (String string : weatherList) {
			System.out.println(string);
		}*/
		
		URL wsdlUrl = WeatherWebService.WSDL_LOCATION;
		WeatherWebService webService = new WeatherWebService(wsdlUrl);
		WeatherWebServiceSoap client1 = webService.getWeatherWebServiceSoap();
		ArrayOfString provinceArray = client1.getSupportProvince();
		//支持的省份
		List<String> provinceList = provinceArray.getString();
		for (String string : provinceList) {
			System.out.println(string);
		}
		System.out.println("-------------------------------");
		//支持的城市
		ArrayOfString supportCityString = client1.getSupportCity("湖南");
		List<String> cityList = supportCityString.getString();
		for (String string : cityList) {
			System.out.println(string);
		}
		
		//得到天气
		ArrayOfString arrayOfString = client1.getWeatherbyCityName("海南");
		List<String> weatherList = arrayOfString.getString();
		System.out.println("-------------------天气数据--------------------");
		for (String string : weatherList) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testGetWeatherbyCityName() {
		IWeatherService weatherService = new WeatherServiceImpl();
		List<Weather> weatherList = weatherService.getWeatherbyCityName("长沙");
		for (Weather weather : weatherList) {
			System.out.println(weather);
		}
	}

}
