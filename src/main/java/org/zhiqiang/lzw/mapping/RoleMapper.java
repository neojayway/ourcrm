package org.zhiqiang.lzw.mapping;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);
    
    /**
     * 根据Id查询指定角色
     * @param rid
     * @return
     */
    public Role selectById(Integer rid);
    
    /**
     * 查询所有角色
     * @return
     */
    public List<Role> selectAllRole();
    
    /**
     * 根据主键查询角色
     * @param roleid
     * @return
     */
    Role selectByPrimaryKey(Integer roleid);
    
    /**
     * 根据主键更新角色
     * @param record
     * @return
     */
    void updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
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
    public List<Role> selectRoleByPage(Map<String, Object> map);
    
    /**
     * 批量删除角色
     * @param rids
     */
    public void deleteRoleByBatch(Integer[] rids);
    
    /**
     * 删除指定角色的指定权限
     * @param map
     */
    public void deleteByRoleAndPrivilege(Map<String, Integer> map);
    
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
     * 根据角色Id删除角色权限记录
     * @param rid
     */
    public void deleteByRole(Integer rid);
    
    /**
     * 批量插入角色权限
     * @param map
     */
    public void insertRoleAndPrivilegeByBatch(Map<String, Object> map);
    
    /**
     * 根据用户Id查询用户所有角色
     * @param uid
     * @return
     */
    public List<Role> selectRoleByUid(Integer uid);
    
    
}