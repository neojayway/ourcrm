package org.zhiqiang.lzw.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhiqiang.lzw.entity.City;
import org.zhiqiang.lzw.entity.CodeRule;
import org.zhiqiang.lzw.entity.Company;
import org.zhiqiang.lzw.entity.Province;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.service.ICityService;
import org.zhiqiang.lzw.service.ICodeRuleService;
import org.zhiqiang.lzw.service.ICompanyService;
import org.zhiqiang.lzw.service.IDictionaryTypeService;
import org.zhiqiang.lzw.service.IProvinceService;
import org.zhiqiang.lzw.util.PinYinUtil;
import org.zhiqiang.lzw.util.SerialNumberUtil;

/**
 * 客户控制器
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService;

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}
	
	@Autowired
	@Qualifier("codeRuleService")
	private ICodeRuleService codeRuleService;
	
	public void setiCodeRuleService(ICodeRuleService iCodeRuleService) {
		this.codeRuleService = iCodeRuleService;
	}
	
	@Autowired
	@Qualifier("dictionaryTypeService")
	private IDictionaryTypeService dictionaryTypeService;
	
	public void setDictionaryTypeService(
			IDictionaryTypeService dictionaryTypeService) {
		this.dictionaryTypeService = dictionaryTypeService;
	}
	
	@Autowired
	@Qualifier("provinceService")
	private IProvinceService provinceService;
	
	public void setProvinceService(IProvinceService provinceService) {
		this.provinceService = provinceService;
	}
	
	@Autowired
	@Qualifier("cityService")
	private ICityService cityService;
	
	public void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}

	/**
	 * 分页查询数据
	 * @return
	 */
	@RequestMapping(value="/selectCompanyByPage", method=RequestMethod.GET)
	protected String selectCompanyByPage(Model model, PageBean pageBean) 
		throws Exception{
		if(pageBean==null) pageBean = new PageBean();
		pageBean.setTotalRecords(companyService.selectTotalRecords());
		List<Company> list = companyService.selectByPage(pageBean);
		model.addAttribute("companys", list);
		model.addAttribute("pageBean", pageBean);
		return "page/newPagePlan/crm/customer/base/list";
	}
	
	/**
	 * 获取 今天需要联系的客户
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getCompanyWhereTodayNeedTouch", method=RequestMethod.GET)
	protected String getCompanyWhereTodayNeedTouch(Model model) throws Exception{
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String str = simple.format(new Date());
		List<Company> list = companyService.getCompanyWhereTodayNeedTouch(str);
		model.addAttribute("companys", list);
		return "page/newPagePlan/crm/customer/base/list";
	}
	
	/**
	 * 获取 已过期未联系的客户   
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getCompanyWhereForgetTouch", method=RequestMethod.GET)
	protected String getCompanyWhereForgetTouch(Model model) throws Exception{
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String str = simple.format(new Date());
		List<Company> list = companyService.getCompanyWhereForgetTouch(str);
		model.addAttribute("companys", list);
		return "page/newPagePlan/crm/customer/base/list";
	}
	
	/**
	 * 模糊查询
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fuzzySearchCompany", method = RequestMethod.GET)
	protected @ResponseBody Map<String, Object> fuzzySearchCompany(Model model,
		String data, PageBean pageBean) throws Exception{
		if(data!=null){
			data = new String(data.getBytes("iso-8859-1"),"utf-8");
			pageBean.setUrl("data="+data);	
		}
		return companyService.fuzzySearchCompany(data, pageBean);
	}

	/**
	 * 保存客户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
	protected String saveCompany(Company company) throws Exception{
		
		Integer pid = new Integer(company.getProvince());
		Province province = provinceService.getProvinceById(pid);
		String name = province.getName();
		company.setProvince(name);
		
		int insertCompany = companyService.insertCompany(company);
		String code = company.getCode();
		String nextseq = SerialNumberUtil.geneNextGlideNumber
			(code.substring(code.length()-3));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = simpleDateFormat.format(new Date());
		codeRuleService.updateSerialNumberByTable("c_company", 
			nextseq,curDate);
		
		if (insertCompany > 0) return "redirect:/company/selectCompanyByPage";
		else return "/error";
	}

	/**
	 * 根据ID获取详情
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCompantById", method = RequestMethod.GET)
	protected String getCompanyById(Model model, Integer id)
		throws Exception{
		Company company = companyService.getCompanyById(id);
		model.addAttribute("company", company);
		
		String province = company.getProvince();
		
		//获取到所有省份
		List<Province> allProvince = provinceService.getAllProvince();
		//将省份资料放入model
		model.addAttribute("allProvince", allProvince);
		
		int pid = 0;
		for (int i = 0; i < allProvince.size(); i++) {
			if(province.equals(allProvince.get(i).getName())){
				pid = allProvince.get(i).getId();
			}
		}
		
		//获取到客户所在省所有市的基础数据
		List<City> cityList = cityService.getCitysByPid(pid);
		model.addAttribute("cityList", cityList);
		
		return "/page/newPagePlan/crm/customer/base/edit";
	}

	/**
	 * 修改客户信息
	 * @param model
	 * @param company
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateAfter", method = RequestMethod.POST)
	protected String updateAfter(Model model, Company company) throws Exception{
		System.out.println("进入控制层！");
		Integer pid = new Integer(company.getProvince());
		Province province = provinceService.getProvinceById(pid);
		String name = province.getName();
		company.setProvince(name);
		
		companyService.updateCompany(company);
		
		return "redirect:/company/selectCompanyByPage";
	}
	
	/**
	 * 批量删除客户
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCompanysByIds", method=RequestMethod.POST)
	protected String deleteCompanysByIds(Integer[] ids) 
		throws Exception{
		for (int i = 0; i < ids.length; i++) {
			companyService.deleteById(ids[i]);
		}
		return "redirect:/company/selectCompanyByPage";
	}

	/**
	 * 新增客户之前先得到客户对应的编码值
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addBefore", method=RequestMethod.GET)
	protected String addBefore(Model model, HttpSession session) throws Exception{
		//定义客户编码规则对应的表名
		String tabName = "c_company";
		//定义下一次产生的流水号
		String nextSeq = "";
		//得到客户对应的编码规则
		CodeRule codeRule = codeRuleService.selectCodeRuleByTable(tabName);
		//得到客户对应的流水号的流水位
		Integer glidebit = codeRule.getGlidebit();
		//打印编码规则信息
		//System.out.println(codeRule);
		//获取到一个格式化后的当前日期字符串
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String curdate = simpleDateFormat.format(new Date());
		//把当前日期与编码规则里面的最后一次更改日期进行对比
		if(curdate.equals(codeRule.getCurdate())){
			//如果日期相同，把编码规则的流水号赋值
			nextSeq = codeRule.getNextseq();
		}else{
			//如果日期不同，生成流水位长度的初始流水号
			nextSeq = SerialNumberUtil.geneFirstGlideNumber(glidebit);
		}
		//查看生成后的客户编码规则
		String companyCode = "C-"+curdate+"-"+nextSeq;
		//从session域里面拿到登录的用户信息
		User user = (User)session.getAttribute("userCustom");
		//得到登录用户的中文名和ID
		String cnname = user.getCnname();
		Integer userID = user.getId();
		//得到当前系统时间
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(new Date());
		//将客户编码、登录用户名、系统时间放入model里面
		model.addAttribute("companyCode", companyCode);
		model.addAttribute("cnname", cnname);
		model.addAttribute("userID", userID);
		model.addAttribute("date", date);
		
		//获取到所有省份
		List<Province> allProvince = provinceService.getAllProvince();
		//将省份资料放入model
		model.addAttribute("allProvince", allProvince);
		
		//获取到北京市的基础数据
		List<City> cityList = cityService.getCitysByPid(1);
		model.addAttribute("cityList", cityList);
		
		return "page/newPagePlan/crm/customer/base/add";
	}

	/**
	 * 把页面传过来的客户名翻译成首字母拼音
	 * @param model
	 * @param pinyin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doPinYin", method=RequestMethod.GET)
	protected @ResponseBody String doPinYin(Model model, 
		String companyName) throws Exception{
		companyName = new String(companyName.getBytes("iso-8859-1"),"utf-8");
		String firstSpell = PinYinUtil.converterToFirstSpell(companyName);
		return firstSpell;
	}
	
	/**
	 * 根据省份获得对应城市
	 * @param model
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doGetCitysByPid", method=RequestMethod.GET)
	protected @ResponseBody List<City> doGetCitysByPid(Model model, 
		Integer pid)throws Exception{
		List<City> cityList = cityService.getCitysByPid(pid);
		if(cityList.size()>0) return cityList;
		else return null;
	}
	
	/**
	 * 把要修改的客户ID传给页面
	 * @param ids
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doUpdateNextTouchDateBefore", method=RequestMethod.GET)
	protected String doUpdateNextTouchDateBefore(Integer[] ids, Model model)
		throws Exception{
		model.addAttribute("ids", ids);
		return "/page/newPagePlan/crm/customer/base/nextTouchTime";
	}
	
	/**
	 * 批量修改下次联系时间
	 * @param ids
	 * @param date
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doUpdateNextTouchDate", method=RequestMethod.POST)
	protected String doUpdateNextTouchDate(Integer[] ids, String nexttouchdate) 
		throws Exception{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date nextTouchDate = simpleDateFormat.parse(nexttouchdate);
		for (int i = 0; i < ids.length; i++) {
			companyService.updateNextTouchTime(ids[i], nextTouchDate);
		}
		return "redirect:/company/selectCompanyByPage";
	}
	
}
