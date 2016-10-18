package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.MenuPrivilegeKey;
import org.zhiqiang.lzw.mapping.MenuPrivilegeMapper;
import org.zhiqiang.lzw.service.MenuPrivilegeService;

@Service("menuPrivilegeService")
public class MenuPrivilegeServiceImpl implements MenuPrivilegeService{

	@Autowired
	private MenuPrivilegeMapper menuPrivilegeMapper;
	
	public void setMenuPrivilegeMapper(MenuPrivilegeMapper menuPrivilegeMapper) {
		this.menuPrivilegeMapper = menuPrivilegeMapper;
	}
	
	@Override
	public int deleteByPrimaryKey(MenuPrivilegeKey key) {
		// TODO Auto-generated method stub
		return menuPrivilegeMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(MenuPrivilegeKey record) {
		// TODO Auto-generated method stub
		return menuPrivilegeMapper.insert(record);
	}

	@Override
	public int insertSelective(MenuPrivilegeKey record) {
		// TODO Auto-generated method stub
		return menuPrivilegeMapper.insertSelective(record);
	}
}
