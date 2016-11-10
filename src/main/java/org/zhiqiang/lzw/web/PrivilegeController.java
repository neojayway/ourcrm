package org.zhiqiang.lzw.web;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.PrivilegeCodeAndPos;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.mapping.PrivilegeMapper;
import org.zhiqiang.lzw.service.IPrivilegeService;

/**
 * 权限的后端控制器
 * @author LZW
 *
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController {
	
	//注入权限mapper
	@Autowired
	@Qualifier("privilegeService")
	private IPrivilegeService privilegeService;
	
	/**
	 * 带条件分页查询权限
	 * @param privilegeName
	 * @param pageBean
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/selectPrivilegeByPage")
	public String selectPrivilegeByPage(String privilegeName,PageBean pageBean,Model model) throws UnsupportedEncodingException{
		if (privilegeName==null || privilegeName.trim().isEmpty()) {
			privilegeName = null;
		}
		if (pageBean == null) {
			pageBean = new PageBean();
		}
		//get请求转码
		if (privilegeName!=null) {
			privilegeName = new String(privilegeName.getBytes("iso-8859-1"),"utf-8");
			pageBean.setUrl("privilegeName="+privilegeName);
		}
		List<Privilege> privilegeList = privilegeService.selectByPage(privilegeName, pageBean);
		model.addAttribute("privilegeList", privilegeList);
		model.addAttribute("privilegeName", privilegeName);
		return "page/newPagePlan/sys/role/list";
	}
	
	
	/**
	 * 新增权限
	 * @return
	 */
	@RequestMapping("/addPrivilege")
	public String addPrivilege(Privilege privilege,HttpServletRequest request){
		//查询获得最大的权限位以及最大的权限位对应的权限码
		PrivilegeCodeAndPos privilegeCodeAndPos = privilegeService.selectMaximumPos();
		if (privilegeCodeAndPos!=null) {
			Integer pos = privilegeCodeAndPos.getPos();
			Long code = privilegeCodeAndPos.getCode();
			//Long类型在计算机中占用64个二进制位，除去一个符号位，那么1L最多向左移动62位
			if (code==1L<<62) {
				privilege.setPrivilegepos(++pos);
				privilege.setPrivilegecode(1L);
			}else {
				privilege.setPrivilegepos(pos);
				privilege.setPrivilegecode(code<<1);
			}
			//保存权限
			privilegeService.addPrivilege(privilege);
			//同时保存到application域中去
			ServletContext application = request.getSession().getServletContext();
			Object privilegeObj = application.getAttribute("privilegeMap");
			if (privilegeObj!=null) {
				Map<String, Privilege> privilegeMap = (Map<String, Privilege>) privilegeObj;
				if (privilege!=null) {
					//将权限保存到application域中
					privilegeMap.put(privilege.getPrivilegeurl(), privilege);
				}
			}
		}
		
		return "forward:/privilege/selectPrivilegeByPage.do";
	}
	
	/**
	 * 批量删除权限
	 * @param pids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deletePrivilegeByBatch")
	public String deletePrivilegeByBatch(Integer[] pids) throws Exception{
		if (pids!=null && pids.length>0) {
			for (Integer pid : pids) {
				//根据权限编号删除角色权限关系记录
				privilegeService.deleteRolePrivilegeByPid(pid);
			}
		}
		privilegeService.deletePrivilegeByBatch(pids);
		return "forward:/privilege/selectPrivilegeByPage.do";
	}
	
	/**
	 * 更新前的页面数据展示
	 * @return
	 */
	@RequestMapping("/updatePre")
	public String updatePre(Integer pid,Model model){
		Privilege privilege = privilegeService.selectByPrimaryKey(pid);
		model.addAttribute("privilege", privilege);
		return "page/newPagePlan/sys/role/updatePre";
	}
	
	/**
	 * 根据主键更新部分列
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updateByPrimaryKeySelective")
	public String updateByPrimaryKeySelective(Privilege privilege) throws Exception{
		privilegeService.updateByPrimaryKeySelective(privilege);
		return "forward:/privilege/selectPrivilegeByPage.do";
	}
	
	public void setPrivilegeService(IPrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}
	
	
	
	
	
}
