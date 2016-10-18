package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Menu;
import org.zhiqiang.lzw.entity.MenuKey;
import org.zhiqiang.lzw.mapping.MenuMapper;
import org.zhiqiang.lzw.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public int deleteByPrimaryKey(MenuKey key) {
		// TODO Auto-generated method stub
		return menuMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.insert(record);
	}

	@Override
	public int insertSelective(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.insertSelective(record);
	}

	@Override
	public Menu selectByPrimaryKey(MenuKey key) {
		// TODO Auto-generated method stub
		return menuMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKeySelective(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.updateByPrimaryKey(record);
	}
}
