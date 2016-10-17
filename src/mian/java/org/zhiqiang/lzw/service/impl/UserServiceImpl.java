package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.mapping.UserMapper;
import org.zhiqiang.lzw.service.IUserService;

@Service
@Qualifier("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	@Override
	public User login(Integer userid) {
		User user = userMapper.selectByPrimaryKey(userid);
		return user;
	}

	
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	

}
