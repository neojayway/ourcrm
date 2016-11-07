package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.CodeRule;

public interface ICodeRuleService {

	CodeRule selectCodeRuleByTable(String tabName);
	
}
