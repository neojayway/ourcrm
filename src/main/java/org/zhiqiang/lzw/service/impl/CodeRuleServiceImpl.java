package org.zhiqiang.lzw.service.impl;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public int updateByPrimaryKeySelective(CodeRule record) {
		return codeRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateSerialNumberByTable(String tableName, String serialNumber, String curDate) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("tableName", tableName);
		map.put("serialNumber", serialNumber);
		map.put("curDate", curDate);
		return codeRuleMapper.updateSerialNumberByTable(map);
	}

}
