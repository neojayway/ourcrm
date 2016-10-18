package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.CodeRule;

public interface CodeRuleService {
	
	int deleteByPrimaryKey(Integer id);

	int insert(CodeRule record);

	int insertSelective(CodeRule record);

	CodeRule selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CodeRule record);

	int updateByPrimaryKey(CodeRule record);
}
