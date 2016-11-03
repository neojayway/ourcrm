package org.zhiqiang.lzw.web;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
	 * 省份模糊查询
	 * @param model
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fuzzySearchProvince/{data}", method = RequestMethod.GET)
	protected @ResponseBody TreeSet<Province> fuzzySearchProvince(Model model,
		@PathVariable("data") String data) throws Exception{
		List<Province> list = provinceService.getAllProvince();
		Map<String, Province> map = new TreeMap<String, Province>();
		for (int i = 0; i < list.size(); i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(list.get(i).getId());
			sb.append(list.get(i).getName());
			sb.append(list.get(i).getPycode());
			map.put(sb.toString(), list.get(i));
		}
		TreeSet<Province> treeSet = new TreeSet<Province>(
			new Comparator<Province>() {
			// 排序方法
			@Override
			public int compare(Province p1, Province p2) {
				return p1.getId().compareTo(p2.getId());
			}
		});
		// 判断传入的参数是否为空
		if (data.equals("-1")) {
			// 如果为空就查所有
			data = "";
		}
		// 循环遍历map集合中所有的key
		for (String key : map.keySet()) {
			// 定义一个正则表达式 接收来自页面的参数
			String regEx = data;
			// 创建Pattern对象
			Pattern pattern = Pattern.compile(regEx);
			// 创建Matcher对象
			Matcher matcher = pattern.matcher(key);
			// 重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。
			boolean b = matcher.find();
			// 判断匹配结果
			if (b) {
				// 根据key，获取到对应的value值，即对象
				Province province = map.get(key);
				// 把对象放入TreeSet中
				treeSet.add(province);
			}
		}
		if (treeSet.size() > 0) return treeSet;
		else return null;
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
