package org.zhiqiang.lzw.mapping;

import org.zhiqiang.lzw.entity.Menu;
import org.zhiqiang.lzw.entity.MenuKey;

public interface MenuMapper {
    int deleteByPrimaryKey(MenuKey key);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(MenuKey key);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKeyWithBLOBs(Menu record);

    int updateByPrimaryKey(Menu record);
}