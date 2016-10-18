package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.Company;

public interface CompanyService {
	int deleteByPrimaryKey(Integer id);

	int insert(Company record);

	int insertSelective(Company record);

	Company selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Company record);

	int updateByPrimaryKeyWithBLOBs(Company record);

	int updateByPrimaryKey(Company record);
}
