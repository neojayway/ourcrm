package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.Role;

public interface RoleService {
	int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKeyWithBLOBs(Role record);

    int updateByPrimaryKey(Role record);
}
