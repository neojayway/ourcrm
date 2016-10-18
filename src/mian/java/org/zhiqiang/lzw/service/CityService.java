package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.City;

public interface CityService {

	int deleteByPrimaryKey(Integer id);

	int insert(City record);

	int insertSelective(City record);

	City selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(City record);

	int updateByPrimaryKey(City record);
}
