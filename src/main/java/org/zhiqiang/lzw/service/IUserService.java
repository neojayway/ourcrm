package org.zhiqiang.lzw.service;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.entity.custom.UserCustom;

/**
 * 用户业务接口
 * @author LZW
 *
 */
public interface IUserService {
	
	//登录
	public UserCustom login(String name,String password);
	
	//修改用户所在部门
    void updateGroupIdForUser(Integer groupId,Integer userId) throws Exception;
    
    //批量修改用户所在部门
    void updateBatchGroupIdForUser(Integer groupId,Integer[] ids) throws Exception;
    
    //查询所有用户
    List<User> selectAllUser();
    
    //查询用户所有的角色
    public List<Role> selectRoleByUid(Integer uid);
    
    //带条件查询查询用户的数量（用户名称模糊查询）
    public Integer selectCountLikeUname(String cnname);
    
    //分页查询带条件查询
    public List<User> selectUserByPage(String cnname,PageBean pageBean); 
    
    //新增用户插入部分列
    public void insertSelective(User user);
    
    //批量删除用户
    public void deleteUserByBatch(Integer[] uids);
    
    //删除指定用户和角色的用户角色记录
    public void deleteUserRole(Integer uid,Integer rid);
    
    //删除指定的用户角色记录
    public void deleteUserRoleByUid(Integer uid);
    
    //新增用户角色记录
    public void insertUserRole(Integer uid,Integer rid);
    
    //根据部门编号修改用户的部门为“未分配”
    public void updateUserByGid(Integer gid);
	
}
