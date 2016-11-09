package org.zhiqiang.lzw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.PrivilegeCodeAndPos;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.mapping.PrivilegeMapper;
import org.zhiqiang.lzw.service.IPrivilegeService;

/**
 * 权限业务实现
 * @author LZW
 *
 */
@Service("privilegeService")
public class PrivilegeServiceImpl implements IPrivilegeService{
	
	//注入mapper
	@Autowired
	@Qualifier("privilegeMapper")
	private PrivilegeMapper privilegeMapper;
	
	/**
	 * 查询所有权限
	 */
	@Override
	public List<Privilege> selectAll() {
		return privilegeMapper.selectAll();
	}
	
	/**
	 * 新增权限
	 */
	@Override
	public void addPrivilege(Privilege privilege) {
		privilegeMapper.insertSelective(privilege);
	}
	
	public void setPrivilegeMapper(PrivilegeMapper privilegeMapper) {
		this.privilegeMapper = privilegeMapper;
	}

	/**
	 * 分页查询权限
	 * @param privilegeName
	 * @return
	 */
	@Override
	public List<Privilege> selectByPage(String privilegeName, PageBean pageBean) {
		if (privilegeName!=null) {
			privilegeName = "%"+privilegeName+"%";
		}
		//首先查询总记录数
		Integer count = privilegeMapper.selectCount(privilegeName);
		pageBean.setTotalRecords(count);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("privilegeName", privilegeName);
		map.put("pageBean", pageBean);
		return privilegeMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount(String privilegeName) {
		Integer selectCount = privilegeMapper.selectCount("%"+privilegeName+"%");
		return selectCount;
	}
	
	/**
	 * 查询当前最大的权限位以及最大权限为对应的最大权限
	 */
	@Override
	public PrivilegeCodeAndPos selectMaximumPos() {
		return privilegeMapper.selectMaximumPos();
	}
	
	/**
     * 批量删除权限
     * @param pids
	 * @throws Exception 
     */
	@Override
	public void deletePrivilegeByBatch(Integer[] pids) throws Exception {
		privilegeMapper.deletePrivilegeByBatch(pids);
	}
	
	/**
     * 根据主键更新部门列
     * @param privilege
     */
	@Override
	public void updateByPrimaryKeySelective(Privilege privilege) throws Exception{
		privilegeMapper.updateByPrimaryKeySelective(privilege);
	}
	
	/**
	 * 根据主键查询权限
	 * @param pid
	 * @return
	 */
	@Override
	public Privilege selectByPrimaryKey(Integer pid) {
		return privilegeMapper.selectByPrimaryKey(pid);
	}
	
	/**
	 * 根据角色Id查询角色所有权限
	 */
	@Override
	public List<Privilege> selectPrivilegeByRoleId(Integer rid) {
		return privilegeMapper.selectPrivilegeByRoleId(rid);
	}
	
	/**
     * 根据权限编号删除角色权限关系记录
     * @param pid
     */
	@Override
	public void deleteRolePrivilegeByPid(Integer pid) {
		privilegeMapper.deleteRolePrivilegeByPid(pid);
	}
	
	




	
	
	
	
}
