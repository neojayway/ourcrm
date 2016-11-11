package org.zhiqiang.lzw.web;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhiqiang.lzw.entity.Province;
import org.zhiqiang.lzw.entity.custom.PageBean;
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
	protected String getAllProvince(Model model) throws Exception{
		System.out.println("获取所有省份信息...");
		List<Province> list = provinceService.getAllProvince();
		model.addAttribute("provinces", list);
		if(list.size()>0) return "/page/newPagePlan/sys/province/list";
		else return "error";
	}
	
	/**
	 * 获取所有省份信息给城市模块
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getAllProvinceForCity",method=RequestMethod.GET)
	protected @ResponseBody List<Province> getAllProvinceForCity(Model model) 
		throws Exception{
		List<Province> list = provinceService.getAllProvince();
		if(list.size()>0) return list;
		else return null;
	}
	
	/**
	 * 分页查询数据
	 * @return
	 */
	@RequestMapping(value="/selectProvinceByPage", method=RequestMethod.GET)
	protected String selectProvinceByPage(Model model, PageBean pageBean)
		throws Exception{
		if(pageBean==null) pageBean = new PageBean();
		pageBean.setTotalRecords(provinceService.getCounts());
		List<Province> provinceList = provinceService.selectByPage(pageBean);
		model.addAttribute("provinceList", provinceList);
		model.addAttribute("pageBean", pageBean);
		return "page/newPagePlan/sys/province/list";
	}
	
	/**
	 * 省份模糊查询
	 * @param model
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fuzzySearchProvince", method = RequestMethod.GET)
	protected @ResponseBody Map<String, Object> fuzzySearchProvince(Model model,
			String data, PageBean pageBean) throws Exception{
		if(data!=null){
			data = new String(data.getBytes("iso-8859-1"),"utf-8");
			pageBean.setUrl("data="+data);	
		}
		
		return provinceService.fuzzySearchCompany(data, pageBean);
	}
	
	/**
	 * 根据id获取详情
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getProvinceById",method=RequestMethod.GET)
	protected String getProvinceById(Model model,Integer id) throws Exception{
		Province province = provinceService.getProvinceById(id);
		model.addAttribute("province", province);
		return "page/newPagePlan/sys/province/edit";
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
		provinceService.insertProvince(province);
		return "redirect:/province/selectProvinceByPage";
	}
	
	/**
	 * 修改城市信息
	 * @param province
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateProvince",method=RequestMethod.POST)
	protected String updateProvince(Province province) throws Exception{
		provinceService.updateProvince(province);
		return "redirect:/province/selectProvinceByPage";
	}
	
	/**
	 * 批量删除省份
	 * @param province_ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteProvincesByIds",method=RequestMethod.POST)
	protected String deleteProvincesByIds(Integer[] ids) throws Exception{
		for (int i = 0; i < ids.length; i++) {
			provinceService.deleteProvince(ids[i]);
		}
		return "redirect:/province/selectProvinceByPage";
	}

}
