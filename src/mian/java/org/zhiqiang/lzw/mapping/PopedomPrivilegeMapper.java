package org.zhiqiang.lzw.mapping;

import org.zhiqiang.lzw.entity.PopedomPrivilegeKey;

public interface PopedomPrivilegeMapper {
    int deleteByPrimaryKey(PopedomPrivilegeKey key);

    int insert(PopedomPrivilegeKey record);

    int insertSelective(PopedomPrivilegeKey record);
}