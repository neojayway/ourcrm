package org.zhiqiang.lzw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.mapping.RoleMapper;
import org.zhiqiang.lzw.service.IRoleService;

/**
 * 角色业务实现
 * @author LZW
 *
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService{
	
	
	@Autowired
	@Qualifier("roleMapper")
	private RoleMapper roleMapper;
	
	/**
     * 带条件查询角色数量
     * @param roleName
     * @return
     */
	@Override
	public Integer selectRoleCount(String roleName) {
		if (roleName==null || roleName.trim().isEmpty()) {
			roleName = null;
		}
		return roleMapper.selectRoleCount(roleName);
	}

	/**
     * 带条件分页查询角色
     * @param map
     * @return
     */
	@Override
	public List<Role> selectRoleByPage(String roleName,PageBean pageBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleName", roleName);
		map.put("pageBean", pageBean);
		return roleMapper.selectRoleByPage(map);
	}
	
	/**
     * 批量删除角色
     * @param rids
     */
	@Override
	public void deleteRoleByBatch(Integer[] rids) throws Exception {
		roleMapper.deleteRoleByBatch(rids);
	}
	
	/**
     * 根据主键更新角色
     * @param record
     * @return
     */
	@Override
	public void updateByPrimaryKeySelective(Role record) throws Exception {
		 roleMapper.updateByPrimaryKeySelective(record); 
	}
	
	/**
     * 新增角色
     * @param record
     */
	@Override
	public void insertSelective(Role record) throws Exception {
		roleMapper.insertSelective(record);
	}
	
	
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
	/**
     * 根据主键查询角色
     * @param roleid
     * @return
     */
	@Override
	public Role selectByPrimaryKey(Integer roleid) {
		return roleMapper.selectByPrimaryKey(roleid);
	}
	
	/**
     * 根据Id查询指定角色
     * @param rid
     * @return
     */
	@Override
	public Role selectById(Integer rid) {
		return roleMapper.selectById(rid);
	}
	
	 /**
     * 删除指定角色的指定权限
     * @param map
     */
	@Override
	public void deleteByRoleAndPrivilege(Integer pid, Integer rid) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("pid", pid);
		map.put("rid", rid);
		roleMapper.deleteByRoleAndPrivilege(map);
	}

	/**
     * 根据角色Id删除角色权限记录
     * @param rid
     */
	@Override
	public void deleteByRole(Integer rid) {
		roleMapper.deleteByRole(rid);
	}
	
	/**
     * 批量插入角色权限
     * @param map
     */
	@Override
	public void insertRoleAndPrivilegeByBatch(Integer rid, Integer[] pids) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("rid", rid);
		map.put("pids", pids);
		roleMapper.insertRoleAndPrivilegeByBatch(map);
	}
	
	/**
	 * 根据用户Id查询用户所有角色
	 */
	@Override
	public List<Role> selectRoleByUid(Integer uid) {
		return roleMapper.selectRoleByUid(uid);
	}
	
	/**
	 * 查询所有角色
	 */
	@Override
	public List<Role> selectAllRole() {
		return roleMapper.selectAllRole();
	}
	
	/**
	 * 根据角色编号删除用户角色关系记录
	 */
	@Override
	public void deleteUserRoleByRid(Integer rid) {
		roleMapper.deleteUserRoleByRid(rid);
	}
	
	/**
	 * 根据角色编号删除角色权限关系记录
	 */
	@Override
	public void deleteRolePrivilegeByRid(Integer rid) {
		roleMapper.deleteRolePrivilegeByRid(rid);
	}
	
	

}
