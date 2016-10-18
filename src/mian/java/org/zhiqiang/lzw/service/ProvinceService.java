package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.Province;

public interface ProvinceService {
	int deleteByPrimaryKey(Integer id);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}
