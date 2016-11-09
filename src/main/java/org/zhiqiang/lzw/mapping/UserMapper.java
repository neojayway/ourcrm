package org.zhiqiang.lzw.mapping;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.custom.UserCustom;

/**
 * 用户mapper接口
 * @author LZW
 *
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);
    
    //新增用户插入部分列
    public void insertSelective(User user);
    
    //查询所有用户
    List<User> selectAllUser();
    
    //带条件查询查询用户的数量（用户名称模糊查询）
    public Integer selectCountLikeUname(String cnname);
    
    //分页查询带条件查询
    public List<User> selectUserByPage(Map<String, Object> map);
    
    //查询用户所有的角色
    public List<Role> selectRoleByUid(Integer uid);
    
    
    //根据主键查询，关联查询角色，权限
    UserCustom selectByPrimaryKey(Integer id);
    
    //根据用户名和密码进行登录查询
    UserCustom selectByNameAndPassword(Map<String, String> map);
    
    //修改用户所在部门
    void updateGroupIdForUser(Map<String, Integer> map) throws Exception;
    
    //批量修改用户所在部门
    void updateBatchGroupIdForUser(Map<String, Object> map) throws Exception;
    
    //批量删除用户
    public void deleteUserByBatch(Integer[] uids);
    
    //删除指定用户和角色的用户角色记录
    public void deleteUserRole(Map<String, Integer> map);
    
    //新增用户角色记录
    public void insertUserRole(Map<String, Integer> map);
    
    //删除指定的用户角色记录
    public void deleteUserRoleByUid(Integer uid);
    
    //根据部门编号修改用户的部门为“未分配”
    public void updateUserByGid(Integer gid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}