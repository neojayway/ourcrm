package org.zhiqiang.lzw.mapping;

import org.zhiqiang.lzw.entity.MenuPrivilegeKey;

public interface MenuPrivilegeMapper {
    int deleteByPrimaryKey(MenuPrivilegeKey key);

    int insert(MenuPrivilegeKey record);

    int insertSelective(MenuPrivilegeKey record);
}