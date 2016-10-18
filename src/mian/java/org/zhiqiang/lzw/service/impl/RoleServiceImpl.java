package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.mapping.RoleMapper;
import org.zhiqiang.lzw.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKey(record);
	}
}
