package org.zhiqiang.lzw.service;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.User;
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
	
}
