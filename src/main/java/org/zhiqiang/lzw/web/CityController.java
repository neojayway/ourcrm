package org.zhiqiang.lzw.web;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhiqiang.lzw.entity.City;
import org.zhiqiang.lzw.service.ICityService;

/**
 * 城市控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	@Qualifier("cityService")
	private ICityService cityService;
	
	public void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}
	
	/**
	 * 获取显示所有城市
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getAllCity",method=RequestMethod.GET)
	protected String getAllCity(Model model) throws Exception{
		List<City> allCity = cityService.getAllCity();
		model.addAttribute("allCity",allCity);
		if(allCity.size()>0) return "allCity";
		else return "error";
	}
	
	protected String getCityByPage() throws Exception {
		
		return null;
	}
	
	/**
	 * 根据省份获取对应的城市
	 * @param model
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getCitysByProvince/{pid}",method=RequestMethod.GET)
	protected @ResponseBody List<City> getCitysByProvince(Model model,
		@PathVariable("pid")Integer pid) throws Exception{
		List<City> list = cityService.getCitysByPid(pid);
		//model.addAttribute("citys",list);
		if(list.size()>0) return list;
		else throw new RuntimeException("未查询到值");
	}
	
	
	/**
	 * 根据ID获取城市详情
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getCityById/{id}",method=RequestMethod.GET)
	protected String getCityById(Model model,@PathVariable("id")Integer id) throws Exception{
		City city = cityService.getCityById(id);
		model.addAttribute("city", city);
		if(city!=null) return "city";
		else return "error";
	}
	
	/**
	 * 修改城市的信息
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCity",method=RequestMethod.POST)
	protected String updateCity(City city)throws Exception{
		int updateCity = cityService.updateCity(city);
		if(updateCity>0) return "ok";
		else return "error";
	}
	
	/**
	 * 删除单个城市
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteOneById/{id}",method=RequestMethod.GET)
	protected String deleteOneById(@PathVariable("id")Integer id)throws Exception{
		int deleteOneById = cityService.deleteOneById(id);
		if(deleteOneById>0) return "ok";
		else return "error";
	}
	
	/**
	 * 批量删除城市信息
	 * @param city_ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCitys",method=RequestMethod.POST)
	protected String deleteCitys(Integer[] city_ids)throws Exception{
		for (int i = 0; i < city_ids.length; i++) {
			cityService.deleteOneById(city_ids[i]);
		}
		return "ok";
	}
	
	/**
	 * 保存城市信息
	 * @param model
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveCity",method=RequestMethod.POST)
	protected String saveCity(Model model,City city)throws Exception{
		int insertCity = cityService.insertCity(city);
		if(insertCity>0) return "ok";
		else return "error";
	}
}
