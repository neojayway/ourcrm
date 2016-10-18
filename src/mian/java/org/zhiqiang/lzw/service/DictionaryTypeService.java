package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.DictionaryType;

public interface DictionaryTypeService {
	int deleteByPrimaryKey(Integer id);

	int insert(DictionaryType record);

	int insertSelective(DictionaryType record);

	DictionaryType selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DictionaryType record);

	int updateByPrimaryKeyWithBLOBs(DictionaryType record);

	int updateByPrimaryKey(DictionaryType record);
}
