package org.zhiqiang.lzw.service;

import java.util.Map;

import org.zhiqiang.lzw.entity.CodeRule;

public interface ICodeRuleService {

	CodeRule selectCodeRuleByTable(String tabName);
	
	int updateByPrimaryKeySelective(CodeRule record);
	
	int updateSerialNumberByTable(String tableName, String serialNumber, String curDate);
	
}
