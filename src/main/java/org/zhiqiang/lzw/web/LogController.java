package org.zhiqiang.lzw.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhiqiang.lzw.entity.Log;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.service.ILogService;
import org.zhiqiang.lzw.util.LogUtil;

/**
 * 日志后端控制器
 * @author LZW
 *
 */
@Controller
@RequestMapping("/log")
public class LogController {
	
	private static final Logger logger = Logger.getLogger(LogController.class);
	
	@Autowired
	@Qualifier("logService")
	private ILogService logService;

	/**
	 * 分页查询日志
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/selectLogByPage")
	public String selectLogByPage(String cnname,PageBean pageBean,Model model) 
			throws UnsupportedEncodingException{
		if (pageBean==null) {
			pageBean = new PageBean();
		}
		if (cnname!=null && !cnname.trim().isEmpty()) {
			cnname = new String(cnname.getBytes("iso-8859-1"),"utf-8"); 
			//保存条件参数，用于分页超链接的条件参数
			pageBean.setUrl("cnname="+cnname);
		}else {
			cnname = null;
		}
		//查询总记录数
		Integer logCount = logService.selectLogCount(LogUtil.generateLogTableName(0), 
					cnname==null?null:"%"+cnname+"%");
		pageBean.setTotalRecords(logCount);//设置总记录数
		//分页查询
		List<Log> logList = logService.selectLogByPage(LogUtil.generateLogTableName(0), 
				cnname==null?null:"%"+cnname+"%", pageBean);
		//设置模型数据
		model.addAttribute("logList", logList);
		model.addAttribute("cnname", cnname);
		model.addAttribute("pageBean", pageBean);
		return "page/newPagePlan/sys/log/list";
	}
	
	
	
	public void setLogService(ILogService logService) {
		this.logService = logService;
	}
	
	
}
