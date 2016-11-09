package org.zhiqiang.lzw.service;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.entity.custom.PageBean;

/**
 * 角色业务接口
 * @author LZW
 *
 */
public interface IRoleService {
	/**
     * 带条件查询角色数量
     * @param roleName
     * @return
     */
    public Integer selectRoleCount(String roleName);
    
    /**
     * 带条件分页查询角色
     * @param map
     * @return
     */
    public List<Role> selectRoleByPage(String roleName,PageBean pageBean);
    
    /**
     * 根据Id查询指定角色
     * @param rid
     * @return
     */
    public Role selectById(Integer rid);
    
    /**
     * 根据主键查询角色
     * @param roleid
     * @return
     */
    public Role selectByPrimaryKey(Integer roleid);
    
    /**
     * 批量删除角色
     * @param rids
     */
    public void deleteRoleByBatch(Integer[] rids) throws Exception;
    
    /**
     * 删除指定角色的指定权限
     * @param map
     */
    public void deleteByRoleAndPrivilege(Integer pid,Integer rid);
    
    
    /**
     * 根据角色Id删除角色权限记录
     * @param rid
     */
    public void deleteByRole(Integer rid);
    
    /**
     * 根据角色编号删除用户角色关系记录
     * @param rid
     */
    public void deleteUserRoleByRid(Integer rid);
    
    /**
     * 根据角色编号删除角色权限关系记录
     * @param rid
     */
    public void deleteRolePrivilegeByRid(Integer rid);
    
    
    /**
     * 根据主键更新角色
     * @param record
     * @return
     */
    void updateByPrimaryKeySelective(Role record) throws Exception;
    
    /**
     * 新增角色
     * @param record
     */
    public void insertSelective(Role record) throws Exception;
    
    /**
     * 批量插入角色权限
     * @param map
     */
    public void insertRoleAndPrivilegeByBatch(Integer rid,Integer[] pids);
    
    /**
     * 根据用户Id查询用户所有角色
     * @param uid
     * @return
     */
    public List<Role> selectRoleByUid(Integer uid);
    
    /**
     * 查询所有角色
     * @return
     */
    public List<Role> selectAllRole();
    
    
}
