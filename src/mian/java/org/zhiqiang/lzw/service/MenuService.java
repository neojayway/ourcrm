package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.Menu;
import org.zhiqiang.lzw.entity.MenuKey;

public interface MenuService {
	int deleteByPrimaryKey(MenuKey key);

	int insert(Menu record);

	int insertSelective(Menu record);

	Menu selectByPrimaryKey(MenuKey key);

	int updateByPrimaryKeySelective(Menu record);

	int updateByPrimaryKeyWithBLOBs(Menu record);

	int updateByPrimaryKey(Menu record);
}
