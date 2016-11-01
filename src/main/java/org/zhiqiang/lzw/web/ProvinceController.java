package org.zhiqiang.lzw.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhiqiang.lzw.entity.Province;
import org.zhiqiang.lzw.service.IProvinceService;

/**
 * 省份控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/province")
public class ProvinceController {
	
	@Autowired
	@Qualifier("provinceService")
	private IProvinceService provinceService;
	
	public void setProvinceService(IProvinceService provinceService) {
		this.provinceService = provinceService;
	}
	
	/**
	 * 获取所有省份信息
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getAllProvince",method=RequestMethod.GET)
	protected @ResponseBody List<Province> getAllProvince() throws Exception{
		List<Province> list = provinceService.getAllProvince();
		if(list.size()>0) return list;
		else throw new RuntimeException("没有数据");
	}
	
	/**
	 * 根据id获取详情
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getProvinceById/{id}",method=RequestMethod.GET)
	protected String getProvinceById(Model model,@PathVariable("id")Integer id) throws Exception{
		Province province = provinceService.getProvinceById(id);
		model.addAttribute("province", province);
		if(province!=null) return "ok";
		else return "error";
	}
	
	/**
	 * 保存省份信息
	 * @param model
	 * @param province
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveProvince",method=RequestMethod.POST)
	protected String saveProvince(Model model,Province province) throws Exception{
		int i = provinceService.insertProvince(province);
		if(i>0) return "ok";
		else return "error";
	}
	
	/**
	 * 修改城市信息
	 * @param province
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateProvince",method=RequestMethod.POST)
	protected String updateProvince(Province province) throws Exception{
		int i = provinceService.updateProvince(province);
		if(i>0) return "ok";
		else return "error";
	}
	
	/**
	 * 删除单个省份对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteOneById/{id}",method=RequestMethod.GET)
	protected String deleteOneById(Integer id) throws Exception{
		int i = provinceService.deleteProvince(id);
		if(i>0) return "ok";
		else return "error";
	}
	
	/**
	 * 批量删除省份
	 * @param province_ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCitysByIds",method=RequestMethod.POST)
	protected String deleteCitysByIds(int[] province_ids) throws Exception{
		for (int i = 0; i < province_ids.length; i++) {
			provinceService.deleteProvince(province_ids[i]);
		}
		return "ok";
	}

}
