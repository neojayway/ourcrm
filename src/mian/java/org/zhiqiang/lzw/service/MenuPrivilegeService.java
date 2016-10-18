package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.MenuPrivilegeKey;

public interface MenuPrivilegeService {

	int deleteByPrimaryKey(MenuPrivilegeKey key);

    int insert(MenuPrivilegeKey record);

    int insertSelective(MenuPrivilegeKey record);
	
}
