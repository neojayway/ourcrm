package org.zhiqiang.lzw.web;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.service.IPrivilegeService;
import org.zhiqiang.lzw.service.IRoleService;

/**
 * 角色后端控制器
 * @author LZW
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;
	
	@Autowired
	@Qualifier("privilegeService")
	private IPrivilegeService privilegeService;
	
	/**
	 * 新增角色
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addRole")
	public String addRole(Role role) throws Exception{
		if (role!=null) {
			roleService.insertSelective(role); 
		}
		return "forward:/role/showRoleByPage.do";
	}
	
	/**
	 * 分页显示角色记录
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/showRoleByPage")
	public String showRoleByPage(String roleName,PageBean pageBean,Model model) throws UnsupportedEncodingException{
		if (pageBean==null) {
			pageBean = new PageBean();
		}
		String roleNameLike = null;
		if (roleName!=null && !roleName.trim().isEmpty()) {
			roleName = new String(roleName.getBytes("iso-8859-1"),"utf-8");
			roleNameLike = "%"+roleName+"%";
			pageBean.setUrl("roleName="+roleName);
		}
		//首先查的总记录数
		Integer roleCount = roleService.selectRoleCount(roleNameLike);
		pageBean.setTotalRecords(roleCount);
		//查询分页
		List<Role> roleList = roleService.selectRoleByPage(roleNameLike, pageBean);
		model.addAttribute("roleList", roleList);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("roleName", roleName);
		return "page/newPagePlan/sys/privilege/list";
	}
	
	/**
	 * 批量删除角色
	 * @param rids
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/deleteRoleByBatch")
	public String deleteRoleByBatch(Integer[] rids) throws Exception{
		if (rids !=null && rids.length>0) {
			//-----------------------------------
			//删除角色是需要将中间表中的关联记录删除
			//-----------------------------------
			if (rids!=null && rids.length>0) {
				for (Integer rid : rids) {
					//删除用户角色关系表中的记录
					roleService.deleteUserRoleByRid(rid);
					//删除角色权限关系表中的记录
					roleService.deleteRolePrivilegeByRid(rid);
				}
				roleService.deleteRoleByBatch(rids);
				
			}
			
		}
		return "forward:/role/showRoleByPage.do";
	}
	
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updateRole")
	public String updateRole(Role role) throws Exception{
		if (role!=null) {
			roleService.updateByPrimaryKeySelective(role);
		}
		return "forward:/role/showRoleByPage.do";
	}
	
	/**
	 * 更新前的页面数据展示
	 * @param rid
	 * @return
	 */
	@RequestMapping("/updatePre")
	public String updatePre(Integer rid,Model model){
		Role role = null;
		if (rid!=null) {
			role = roleService.selectById(rid);
		}
		model.addAttribute("role", role);
		return "page/newPagePlan/sys/privilege/updatePre";
	}
	
	/**
	 * 展示角色所属权限以及所有权限
	 * @return
	 */
	@RequestMapping("/showPrivilegeOfRole")
	public String showPrivilegeOfRole(Integer rid,Model model){
		StringBuilder privilegeStr = new StringBuilder("");//保存
		//获得当前角色所拥有的权限
		List<Privilege> prililegeList = privilegeService.selectPrivilegeByRoleId(rid);
		if (prililegeList!=null) {
			for (Privilege privilege : prililegeList) {
				privilegeStr.append(privilege.getPrivilegeid()+",");
			}
		}
		//获得所有权限
		List<Privilege> privilegeAllList = privilegeService.selectAll();
		//但所有权限中不包含此角色所拥有的权限
		if (privilegeAllList!=null) {
			Iterator<Privilege> iterator = privilegeAllList.iterator();
			while (iterator.hasNext()) {
				Privilege privilege = (Privilege) iterator.next();
				boolean flag = false;
				if (prililegeList!=null) {
					for (Privilege priv : prililegeList) {
						if (privilege.getPrivilegeid().equals(priv.getPrivilegeid())) {
							flag = true;
						}
					}
					if (flag) {
						iterator.remove();//移除此元素;
					}
				}
			}
		}
		//将数据保存到request域中
		model.addAttribute("privilegeAllList", privilegeAllList);
		model.addAttribute("prililegeList", prililegeList);//当前角色所属权限
		model.addAttribute("privilegeStr", privilegeStr.toString().length()>0?privilegeStr.toString()
				.substring(0, privilegeStr.length()-1):null);
		model.addAttribute("rid", rid);
		return "page/newPagePlan/sys/privilege/privilegeInRole";
	}
	
	/**
	 * 保存角色设置的权限
	 * @return
	 */
	@RequestMapping("/savePrivilegeOfRole")
	public String savePrivilegeOfRole(Integer rid,String privilegeStr,Integer[] lselect){
		//角色原有权限
		String[] privilegeOrigin = new String[0];
		if (privilegeStr!=null && !privilegeStr.trim().isEmpty()) {
			privilegeOrigin = privilegeStr.split(",");
		}
		//比较角色的原有权限和新提交的权限，如果原有权限在新提交的权限集合中不存在，
		//那么就必须先将其移除，再为角色写入新权限
		for (String pOrigin : privilegeOrigin) {
			boolean flag = true;
			if (lselect!=null) {
				for (Integer pnew : lselect) {
					if (Integer.parseInt(pOrigin) == pnew) {
						flag = false;//证明这个权限是交集不用移除
					}
				}
			}
			if (flag) {
				//移除此角色原有权限
				roleService.deleteByRoleAndPrivilege(Integer.parseInt(pOrigin), rid);
			}
		}
		//保存新提交的角色所有权限（新提交的权限减去双方的交集就是要新增的权限）
		//遍历新提交的权限集合，如果在原有的权限集合中找不到就新增
		if (lselect!=null) {
			for (Integer pid : lselect) {
				boolean flag = true;
				for (String string : privilegeOrigin) {
					if (pid == Integer.parseInt(string)) {
						flag = false;
					}
				}
				if (flag) {
					//在原有权限中没有找到的就是需要新增的
					roleService.insertRoleAndPrivilegeByBatch(rid, new Integer[]{pid});
				}
			}
		}
		
		return "forward:/role/showRoleByPage.do";
	}
	
	
	
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public void setPrivilegeService(IPrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}
	
	
}
