package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.PopedomPrivilegeKey;

public interface PopedomPrivilegeService {
	int deleteByPrimaryKey(PopedomPrivilegeKey key);

    int insert(PopedomPrivilegeKey record);

    int insertSelective(PopedomPrivilegeKey record);
}
