package org.zhiqiang.lzw.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhiqiang.lzw.entity.CodeRule;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.service.ICodeRuleService;
import org.zhiqiang.lzw.util.SerialNumberUtil;

@Controller
@RequestMapping("/codeRule")
public class CodeRuleController {

	@Autowired
	@Qualifier("codeRuleService")
	private ICodeRuleService codeRuleService;
	
	public void setCodeRuleService(ICodeRuleService codeRuleService) {
		this.codeRuleService = codeRuleService;
	}
	
	@RequestMapping(value="/selectCodeRuleByPage", method=RequestMethod.GET)
	protected String selectCodeRuleByPage(Model model,String module,
		PageBean pageBean)throws Exception{
		if (pageBean == null) {
			pageBean = new PageBean();
		}
		if(module!=null){
			module = new String(module.getBytes("iso-8859-1"),"utf-8");
			pageBean.setUrl("module="+module);
		}
		int totalRecords = codeRuleService.selectTotalRecords(module==null?null:"%"+module+"%");
		pageBean.setTotalRecords(totalRecords);
		List<CodeRule> codeRuleList = codeRuleService.selectByPage(module==null?null:"%"+module+"%", pageBean);
		model.addAttribute("codeRuleList", codeRuleList);
		model.addAttribute("module", module);
		return "page/newPagePlan/sys/code/list";
	}
	
	@RequestMapping(value="/insertCodeRule",method=RequestMethod.POST)
	protected String insertCodeRule(CodeRule codeRule)throws Exception{
		String currentcode = "";
		currentcode += codeRule.getAreaprefix();
		
		if(codeRule.getAreatime() != null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(codeRule.getAreatime());
			currentcode += "-"+simpleDateFormat.format(new Date());
			
		}
		
		if(codeRule.getGlidebit() != null) {
			String seq = SerialNumberUtil.geneFirstGlideNumber(codeRule.getGlidebit());
			currentcode += "-"+seq;
		}
		
		codeRule.setCurrentcode(currentcode);
		
		codeRuleService.insertCodeRule(codeRule);
		return "redirect:/codeRule/selectCodeRuleByPage.do";
	}
	
	@RequestMapping("/deleteCodeRule")
	protected String deleteCodeRule(Integer[] ids)throws Exception{
		if(ids!=null && ids.length>0)
			codeRuleService.deleteByBatch(ids);		
		return "redirect:/codeRule/selectCodeRuleByPage.do";
	}
	
	@RequestMapping("/getCodeRuleById")
	protected String getCodeRuleById(Model model,Integer id)
		throws Exception{
		CodeRule codeRule = codeRuleService.selectCodeRuleById(id);
		model.addAttribute("codeRule", codeRule);
		return "page/newPagePlan/sys/code/edit";
	}
	
	@RequestMapping("/updateCodeRule")
	protected String updateCodeRule(CodeRule codeRule)throws Exception{
		String currentcode = "";
		currentcode += codeRule.getAreaprefix();
		
		if(codeRule.getAreatime() != null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(codeRule.getAreatime());
			currentcode += "-"+simpleDateFormat.format(new Date());
			
		}
		
		if(codeRule.getGlidebit() != null) {
			String seq = SerialNumberUtil.geneFirstGlideNumber(codeRule.getGlidebit());
			currentcode += "-"+seq;
		}
		
		codeRule.setCurrentcode(currentcode);
		codeRuleService.updateCodeRule(codeRule);
		return "redirect:/codeRule/selectCodeRuleByPage.do";
	}
	
	@RequestMapping("/previewCode")
	protected String previewCode(Model model,String areaprefix,String areatime,
		Integer glidebit)throws Exception{
		String code = areaprefix;
		if(areatime != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(areatime);
			code += "-"+simpleDateFormat.format(new Date());
		}
		if(glidebit != null) {
			String seq = SerialNumberUtil.geneFirstGlideNumber(glidebit);
			code += "-"+seq;
		}
		model.addAttribute("code", code);
		return "page/newPagePlan/sys/code/preview";
	}
}
