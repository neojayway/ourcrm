package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.CodeRule;
import org.zhiqiang.lzw.mapping.CodeRuleMapper;
import org.zhiqiang.lzw.service.CodeRuleService;

@Service("codeRuleService")
public class CodeRuleServiceImpl implements CodeRuleService{

	@Autowired
	private CodeRuleMapper codeRuleMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return codeRuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CodeRule record) {
		// TODO Auto-generated method stub
		return codeRuleMapper.insert(record);
	}

	@Override
	public int insertSelective(CodeRule record) {
		// TODO Auto-generated method stub
		return codeRuleMapper.insertSelective(record);
	}

	@Override
	public CodeRule selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return codeRuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CodeRule record) {
		// TODO Auto-generated method stub
		return codeRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CodeRule record) {
		// TODO Auto-generated method stub
		return codeRuleMapper.updateByPrimaryKey(record);
	}
}