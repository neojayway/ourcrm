package org.zhiqiang.lzw.web;

import java.util.List;
import java.util.Map;

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
import org.zhiqiang.lzw.entity.custom.PageBean;
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
	
	/**
	 * 根据省份获取对应的城市
	 * @param model
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getCitysByProvince",method=RequestMethod.GET)
	protected @ResponseBody Map<String, Object> getCitysByProvince(Model model,
		Integer pid, PageBean pageBean) throws Exception{
		Map<String, Object> dataMap = cityService.getByPage(pid, pageBean);
		return dataMap;
	}
	
	
	/**
	 * 根据ID获取城市详情
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getCityById/{id}",method=RequestMethod.GET)
	protected String getCityById(Model model,@PathVariable("id")Integer id) 
		throws Exception{
		System.out.println(id);
		City city = cityService.getCityById(id);
		model.addAttribute("city", city);
		return "/page/newPagePlan/sys/city/edit";
	}
	
	/**
	 * 修改城市的信息
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCity",method=RequestMethod.POST)
	protected String updateCity(City city)throws Exception{
		System.out.println(city);
		cityService.updateCity(city);
		return "/page/newPagePlan/sys/city/list";
	}
	
	/**
	 * 批量删除城市信息
	 * @param city_ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCitys",method=RequestMethod.POST)
	protected String deleteCitys(Integer[] ids)throws Exception{
		for (int i = 0; i < ids.length; i++) {
			cityService.deleteOneById(ids[i]);
		}
		return "/page/newPagePlan/sys/city/list";
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
		cityService.insertCity(city);
		return "/page/newPagePlan/sys/city/list";
	}
}
