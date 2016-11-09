package org.zhiqiang.lzw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.entity.custom.UserCustom;
import org.zhiqiang.lzw.mapping.UserMapper;
import org.zhiqiang.lzw.service.IUserService;
import org.zhiqiang.lzw.util.MD5keyBean;

/**
 * 用户业务实现
 * @author LZW
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	//用户登录
	@Override
	public UserCustom login(String name, String password) {
		//将密码进行MD5加密
		MD5keyBean md5 = new MD5keyBean();
		password = md5.getkeyBeanofStr(password);
		Map<String, String> map = new HashMap<String,String>();
		map.put("name", name);
		map.put("password", password);
		return userMapper.selectByNameAndPassword(map);
	}
	
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 修改用户所在部门
	 */
	@Override
	public void updateGroupIdForUser(Integer groupId, Integer userId)
			throws Exception {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("groupId", groupId);
		map.put("id", userId);
		userMapper.updateGroupIdForUser(map);
	}
	
	/**
	 * 批量修改用户所在部门
	 */
	@Override
	public void updateBatchGroupIdForUser(Integer groupId,Integer[] ids)
			throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("groupId", groupId);
		map.put("ids", ids);
		userMapper.updateBatchGroupIdForUser(map);
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<User> selectAllUser() {
		return userMapper.selectAllUser();
	}

	/**
	 * //带条件查询查询用户的数量（用户名称模糊查询）
	 */
	@Override
	public Integer selectCountLikeUname(String cnname) {
		return userMapper.selectCountLikeUname(cnname);
	}

	
	/**
	 * 分页查询带条件查询
	 */
	@Override
	public List<User> selectUserByPage(String cnname,PageBean pageBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cnname", cnname);
		map.put("pageBean", pageBean);
		return userMapper.selectUserByPage(map);
	}

	
	/**
	 * 新增用户插入部分列
	 */
	@Override
	public void insertSelective(User user) {
		if (user!=null) {
			userMapper.insertSelective(user);
		}
	}

	/**
	 * 批量删除用户
	 */
	@Override
	public void deleteUserByBatch(Integer[] uids) {
		userMapper.deleteUserByBatch(uids);
	}

	
	/**
	 * 查询用户所有的角色
	 */
	@Override
	public List<Role> selectRoleByUid(Integer uid) {
		return userMapper.selectRoleByUid(uid);
	}

	/**
	 * 删除指定用户和角色的用户角色记录
	 */
	@Override
	public void deleteUserRole(Integer uid,Integer rid) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("uid", uid);
		map.put("rid", rid);
		userMapper.deleteUserRole(map);
	}

	
	/**
	 * 新增用户角色记录
	 */
	@Override
	public void insertUserRole(Integer uid,Integer rid) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("uid", uid);
		map.put("rid", rid);
		userMapper.insertUserRole(map);
	}

	
	/**
	 * 删除指定的用户角色记录
	 */
	@Override
	public void deleteUserRoleByUid(Integer uid) {
		userMapper.deleteUserRoleByUid(uid);
	}

	/**
	 * 根据部门编号修改用户的部门为“未分配”
	 */
	@Override
	public void updateUserByGid(Integer gid) {
		userMapper.updateUserByGid(gid);
	}
	

	
	
	
}
