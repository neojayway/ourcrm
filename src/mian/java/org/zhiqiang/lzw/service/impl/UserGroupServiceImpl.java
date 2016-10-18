package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.UserGroup;
import org.zhiqiang.lzw.mapping.UserGroupMapper;
import org.zhiqiang.lzw.service.UserGroupService;

@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService{

	@Autowired
	private UserGroupMapper userGroupMapper;
	
	public void setUserGroupMapper(UserGroupMapper userGroupMapper) {
		this.userGroupMapper = userGroupMapper;
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userGroupMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserGroup record) {
		// TODO Auto-generated method stub
		return userGroupMapper.insert(record);
	}

	@Override
	public int insertSelective(UserGroup record) {
		// TODO Auto-generated method stub
		return userGroupMapper.insertSelective(record);
	}

	@Override
	public UserGroup selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userGroupMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserGroup record) {
		// TODO Auto-generated method stub
		return userGroupMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(UserGroup record) {
		// TODO Auto-generated method stub
		return userGroupMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(UserGroup record) {
		// TODO Auto-generated method stub
		return userGroupMapper.updateByPrimaryKey(record);
	}

}
