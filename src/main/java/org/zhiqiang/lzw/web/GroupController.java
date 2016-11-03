package org.zhiqiang.lzw.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhiqiang.lzw.entity.Group;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.service.IGroupService;

/**
 * 部门后端控制器
 * @author LZW
 *
 */
@Controller
@RequestMapping("/group")
public class GroupController {
	private static final Logger logger = Logger.getLogger(GroupController.class);
	@Autowired
	@Qualifier("groupService")
	private IGroupService groupService;

	/**
	 * 查询所有部门
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/selectAllGroupByPage")
	public String selectAllGroupByPage(String groupName,PageBean pageBean,Model model) throws UnsupportedEncodingException{
		//get请求转码
		if (groupName!=null) {
			groupName = new String(groupName.getBytes("iso-8859-1"),"utf-8");
			pageBean.setUrl("groupName="+groupName);
		}
		//获得总记录数
		int totalRecords = groupService.selectTotalRecords(groupName==null?null:"%"+groupName+"%");
		logger.info("totalRecords:-------------"+totalRecords);
		pageBean.setTotalRecords(totalRecords);
		//带条件查询部门
		List<Group> groupList = groupService.selectByPage(groupName==null?null:"%"+groupName+"%", pageBean);
		logger.info("groupList的长度："+groupList.size());
		model.addAttribute("groupList", groupList);
		model.addAttribute("groupName", groupName);
		return "page/newPagePlan/sys/group/list";
	}
	
	/**
	 * 新增部门
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/insertGroup")
	public String insertGroup(Group group) throws Exception{
		if (group!=null) {
			groupService.insert(group);
			logger.info("新增部门成功！！！");
		}
		return "forward:/group/selectAllGroupByPage.do";
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/deleteGroup")
	public String deleteGroup(Integer[] ids) throws Exception{
		if (ids!=null && ids.length>0) {
			logger.info("需要删除的部门有："+ids.length);
			groupService.deleteByBatch(ids);
		}
		return "forward:/group/selectAllGroupByPage.do";
	}
	
	
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	
	
}
