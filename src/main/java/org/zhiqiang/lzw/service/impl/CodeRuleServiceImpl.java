package org.zhiqiang.lzw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.CodeRule;
import org.zhiqiang.lzw.entity.custom.PageBean;
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
	public CodeRule selectCodeRuleByTable(String tabName) throws Exception{
		return codeRuleMapper.selectCodeRuleByTable(tabName);
	}

	@Override
	public int updateByPrimaryKeySelective(CodeRule record) throws Exception{
		return codeRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateSerialNumberByTable(String tableName, String serialNumber, 
		String curDate) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("tableName", tableName);
		map.put("serialNumber", serialNumber);
		map.put("curDate", curDate);
		return codeRuleMapper.updateSerialNumberByTable(map);
	}

	@Override
	public List<CodeRule> selectByPage(String module, PageBean pageBean)
		throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("module", module);
		map.put("pageBean", pageBean);
		return codeRuleMapper.selectByPage(map);
	}

	@Override
	public int selectTotalRecords(String module) throws Exception {
		return codeRuleMapper.selectTotalRecords(module);
	}

	@Override
	public void deleteByBatch(Integer[] ids) throws Exception {
		codeRuleMapper.deleteMoreByIds(ids);
	}

	@Override
	public void insertCodeRule(CodeRule codeRule) throws Exception {
		codeRuleMapper.insertSelective(codeRule);
	}

	@Override
	public void deleteCodeRuleByIds(Integer[] ids) throws Exception {
		codeRuleMapper.deleteMoreByIds(ids);
	}

	@Override
	public CodeRule selectCodeRuleById(Integer id) throws Exception {
		return codeRuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateCodeRule(CodeRule codeRule) throws Exception {
		codeRuleMapper.updateByPrimaryKeySelective(codeRule);
	}

}
