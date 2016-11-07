package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.CodeRule;
import org.zhiqiang.lzw.mapping.CodeRuleMapper;
import org.zhiqiang.lzw.service.ICodeRuleService;

/**
 * 编码规则业务实现类
 * @author Administrator
 *
 */
@Service("codeRuleService")
public class CodeRuleServiceImpl implements ICodeRuleService{

	@Autowired
	@Qualifier("codeRuleMapper")
	private CodeRuleMapper codeRuleMapper;
	
	public void setCodeRuleMapper(CodeRuleMapper codeRuleMapper) {
		this.codeRuleMapper = codeRuleMapper;
	}
	
	/**
	 * 根据表名找到对应的编码规则
	 */
	@Override
	public CodeRule selectCodeRuleByTable(String tabName) {
		return codeRuleMapper.selectCodeRuleByTable(tabName);
	}

}
