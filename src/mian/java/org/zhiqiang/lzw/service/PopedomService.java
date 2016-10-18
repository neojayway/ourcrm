package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.Popedom;
import org.zhiqiang.lzw.entity.PopedomKey;

public interface PopedomService {
	int deleteByPrimaryKey(PopedomKey key);

    int insert(Popedom record);

    int insertSelective(Popedom record);

    Popedom selectByPrimaryKey(PopedomKey key);

    int updateByPrimaryKeySelective(Popedom record);

    int updateByPrimaryKeyWithBLOBs(Popedom record);

    int updateByPrimaryKey(Popedom record);
}
