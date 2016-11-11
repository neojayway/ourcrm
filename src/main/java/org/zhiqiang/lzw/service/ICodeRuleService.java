package org.zhiqiang.lzw.service;

import java.util.List;
import org.zhiqiang.lzw.entity.CodeRule;
import org.zhiqiang.lzw.entity.custom.PageBean;

public interface ICodeRuleService {
	
	List<CodeRule> selectByPage(String module,PageBean pageBean) throws Exception;
	
	int selectTotalRecords(String module) throws Exception;
	
	void deleteByBatch(Integer[] ids) throws Exception;

	CodeRule selectCodeRuleByTable(String tabName) throws Exception;
	
	void insertCodeRule(CodeRule codeRule)throws Exception;
	
	void deleteCodeRuleByIds(Integer[] ids)throws Exception;
	
	CodeRule selectCodeRuleById(Integer id)throws Exception;
	
	void updateCodeRule(CodeRule codeRule)throws Exception;
	
	int updateByPrimaryKeySelective(CodeRule record) throws Exception;
	
	int updateSerialNumberByTable(String tableName, 
		String serialNumber, String curDate) throws Exception;
	
}
