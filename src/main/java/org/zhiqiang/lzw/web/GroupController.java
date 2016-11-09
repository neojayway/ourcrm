package org.zhiqiang.lzw.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhiqiang.lzw.entity.Group;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.custom.GroupCustom;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.mapping.UserMapper;
import org.zhiqiang.lzw.service.IGroupService;
import org.zhiqiang.lzw.service.IUserService;

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
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	/**
	 * 查询所有部门
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/selectAllGroupByPage")
	public String selectAllGroupByPage(String groupName,PageBean pageBean,Model model) throws UnsupportedEncodingException{
		if (pageBean == null) {
			pageBean = new PageBean();
		}
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
			List<Integer> idList = new ArrayList<Integer>();
			idList.addAll(Arrays.asList(ids));
			Iterator<Integer> iterator = idList.iterator();
			while (iterator.hasNext()) {
				Integer integer = (Integer) iterator.next();
				if (integer.equals(10)) {
					iterator.remove();
				}
			}
			ids =  idList.toArray(ids);
			if (ids!=null && ids.length>0) {
				for (Integer id : ids) {
					if (id!=null && !id.equals(10)) {
						//删除部门之前，需要将该部门下所有用户的部门设置为待分配
						userService.updateUserByGid(id);
					}
				}
				logger.info("需要删除的部门有："+ids.length);
				groupService.deleteByBatch(ids);
			}
		}
		return "forward:/group/selectAllGroupByPage.do";
	}
	
	/**
	 * 展示部门所有用户数据以及存在的用户数据
	 * @param groupId
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUsersInGroup")
	public String showUsersInGroup(Integer groupId,Model model){
		//获得存在的所有用户
		List<User> userList = userService.selectAllUser();
		logger.info("存在的所有用户:"+userList);
		//获得部门
		GroupCustom groupCustom = groupService.selectGroupCustom(groupId);
		if (groupCustom==null) {
			groupCustom = new GroupCustom();
			groupCustom.setGroupid(groupId);
		}
		List<User> users = groupCustom.getUsers();
		//将部门下的用户编号拼接成字符串，用于保存在表单的隐藏域中，表示部门原有的用户
		String uidStr = "";
		if (users!=null) {
			for (User user : users) {
				uidStr += user.getId()+",";
			}
		}
		if (uidStr.endsWith(",")) {
			uidStr = uidStr.substring(0, uidStr.length()-1);
		}
		
		logger.info("部门下的用户:"+groupCustom);
		
		//将查询得到的所有用户要提出掉部门下的用户
		//保证左右下拉框中的下拉项不会重复
		if (userList!=null) {
			Iterator<User> iterator = userList.iterator();
			//用foreach循环遍历去删除list集合中值会出现并发修改异常，用list特有迭代器的remove（）可以避免这个问题 
			while (iterator.hasNext()) {
				User user = (User) iterator.next();
				Integer id = user.getId();
				if (groupCustom!=null && users!=null) {
					for (User user2 : users) {
						if (user2.getId() == id) {
							iterator.remove();
						}
					}
				}
			}
		}
		model.addAttribute("userList", userList);
		model.addAttribute("groupCustom", groupCustom);
		model.addAttribute("uidStr",uidStr);
		return "page/newPagePlan/sys/group/usersInGroup";
	}
	
	
	/**
	 * 为用户分配指定的部门
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updateUserOfGroup")
	public String updateUserOfGroup(Integer[] rselect,Integer groupId,String uidStr) throws Exception{
		System.out.println(uidStr+"++++++++++++++++");
		if (uidStr!=null && !uidStr.trim().isEmpty()) {
			String[] uidArray = uidStr.split(",");
			//遍历部门原有的员工，如果该员工在新提交过来的员工集合中没有找到，则将该员工的的部门更新为“待分配部门”
			for (int i = 0; i < uidArray.length; i++) {
				Integer uid = Integer.parseInt(uidArray[i]);
				boolean flag = false;
				if (rselect!=null) {
					for (int j = 0; j < rselect.length; j++) {
						if (rselect[j].equals(uid)) {
							flag = true;
							break;
						}
					}
				}
				if (!flag) {
					//在原有的部门下员工在新提交的用户编号数组中没有找到，需要剔除用户所属部门
					userService.updateGroupIdForUser(10, uid);
					logger.info("用户编号为："+uid+"的用户从部门："+groupId+"中剔除到10号待分配的部门");
				}
			}
		}
		
		if (rselect!=null) {
			//首先将下拉框中提交的用户分配到指定部门
			userService.updateBatchGroupIdForUser(groupId, rselect);
		}
		return "forward:/group/selectAllGroupByPage.do";
	}
	
	
	
	
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	
	
	
}
