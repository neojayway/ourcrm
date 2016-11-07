package org.zhiqiang.lzw.web;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhiqiang.lzw.entity.CodeRule;
import org.zhiqiang.lzw.entity.Company;
import org.zhiqiang.lzw.service.ICodeRuleService;
import org.zhiqiang.lzw.service.ICompanyService;
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
	@Qualifier("iCodeRuleService")
	private ICodeRuleService iCodeRuleService;
	
	public void setiCodeRuleService(ICodeRuleService iCodeRuleService) {
		this.iCodeRuleService = iCodeRuleService;
	}

	/**
	 * 获取所有数据
	 * @return
	 */
	@RequestMapping(value="/getAllCompany", method=RequestMethod.GET)
	protected String getAllCompany(Model model) throws Exception{
		List<Company> list = companyService.getAllCompany();
		model.addAttribute("companys", list);
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
	@RequestMapping(value = "/fuzzySearchCompany/{data}", method = RequestMethod.GET)
	protected @ResponseBody TreeSet<Company> fuzzySearchCompany(Model model,
		@PathVariable("data") String data) throws Exception{
		// 获取到所有数据保存到list集合
		List<Company> list = companyService.getAllCompany();
		// 创建TreeMap对象
		Map<String, Company> map = new TreeMap<String, Company>();
		// 循环遍历list集合
		for (int i = 0; i < list.size(); i++) {
			// 创建StringBuilder对象，开始拼接资料
			StringBuilder str = new StringBuilder();
			str.append(list.get(i).getId());
			str.append(list.get(i).getCode());
			str.append(list.get(i).getName());
			str.append(list.get(i).getPycode());
			str.append(list.get(i).getGrade());
			str.append(list.get(i).getRegionname());
			str.append(list.get(i).getSource());
			str.append(list.get(i).getTrade());
			str.append(list.get(i).getScale());
			str.append(list.get(i).getProvince());
			str.append(list.get(i).getCity());
			str.append(list.get(i).getPostcode());
			str.append(list.get(i).getAddress());
			str.append(list.get(i).getEmail());
			str.append(list.get(i).getWeb());
			str.append(list.get(i).getTel1());
			str.append(list.get(i).getFax());
			str.append(list.get(i).getMobile());
			str.append(list.get(i).getTel2());
			str.append(list.get(i).getNexttouchdate());
			str.append(list.get(i).getQuality());
			str.append(list.get(i).getDealin());
			str.append(list.get(i).getKind());
			str.append(list.get(i).getArtificialperson());
			str.append(list.get(i).getRegistemoney());
			str.append(list.get(i).getBank());
			str.append(list.get(i).getAccount());
			str.append(list.get(i).getTaxcode());
			str.append(list.get(i).getCreater());
			str.append(list.get(i).getCreatetime());
			str.append(list.get(i).getUpdater());
			str.append(list.get(i).getUpdatetime());
			str.append(list.get(i).getOwneruser());
			str.append(list.get(i).getDispenseperson());
			str.append(list.get(i).getDispensedate());
			str.append(list.get(i).getRemark());
			// 将拼接好的字符串和对应对象放入map集合中
			map.put(str.toString(), list.get(i));
		}

		// 准备一个TreeSet，用来存放挑选好的对象，以及对对象进行排序
		TreeSet<Company> treeSet = new TreeSet<Company>(
			new Comparator<Company>() {
			// 排序方法
			@Override
			public int compare(Company c1, Company c2) {
				return c1.getId().compareTo(c2.getId());
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
				Company company = map.get(key);
				// 把对象放入TreeSet中
				treeSet.add(company);
			}
		}

		// 循环打印treeSet中对象的值
		/*for (Company company : treeSet) {
			System.out.println(company);
		}*/

		if (treeSet.size() > 0) return treeSet;
		else return null;
	}

	/**
	 * 保存客户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
	protected String saveCompany(Company company) throws Exception{
		int insertCompany = companyService.insertCompany(company);
		if (insertCompany > 0) return "redirect:/company/getAllCompany";
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
	@RequestMapping(value = "/getCompantById/{id}", method = RequestMethod.GET)
	protected String getCompanyById(Model model, @PathVariable("id") Integer id)
		throws Exception{
		Company company = companyService.getCompanyById(id);
		model.addAttribute("company", company);
		if (company != null) return "/edit";
		else return "/error";
	}

	/**
	 * 删除单个客户
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteCompanyById/{id}", method = RequestMethod.GET)
	protected String deleteCompanyById(@PathVariable("id") Integer id) 
		throws Exception{
		int deleteById = companyService.deleteById(id);
		if (deleteById > 0) return "redirect:/company/getAllCompany";
		else return "/error";
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
			System.out.println("准备删除的客户ID："+ids[i]);
			companyService.deleteById(ids[i]);
		}
		return "redirect:/company/getAllCompany";
	}

	/**
	 * 新增客户之前先得到客户对应的编码值
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addBefore", method=RequestMethod.POST)
	protected String addBefore(Model model) throws Exception{
		String tabName = "c_company";
		String nextSeq = "";
		CodeRule codeRule = iCodeRuleService.selectCodeRuleByTable(tabName);
		Integer glidebit = codeRule.getGlidebit();
		System.out.println(codeRule);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String curdate = simpleDateFormat.format(new Date());
		if(curdate.equals(codeRule.getCurdate())){
			nextSeq = SerialNumberUtil.geneNextGlideNumber(codeRule.getNextseq());
		}else{
			nextSeq = SerialNumberUtil.geneFirstGlideNumber(glidebit);
		}
		String companyCode = "C-"+curdate+"-"+
				SerialNumberUtil.geneFirstGlideNumber(glidebit);
		return null;
	}
	
}
