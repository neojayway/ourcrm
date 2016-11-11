package org.zhiqiang.lzw.mapping;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.CodeRule;
import org.zhiqiang.lzw.entity.Company;

public interface CodeRuleMapper {
	
	 /**
     * 带条件分页查询
     * @param 
     * @return
     */
    List<CodeRule> selectByPage(Map<String, Object> map) throws Exception;
    
    /**
     * 查询记录数
     * @param 
     * @return
     */
    int selectTotalRecords(String module) throws Exception;
    
    List<CodeRule> getAllCodeRules() throws Exception;
    
    void deleteMoreByIds(Integer[] ids) throws Exception;
    
	CodeRule selectCodeRuleByTable(String tabName) throws Exception;
	
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(CodeRule record) throws Exception;

    int insertSelective(CodeRule record) throws Exception;

    CodeRule selectByPrimaryKey(Integer id) throws Exception;

    int updateSerialNumberByTable(Map map) throws Exception;
    
    int updateByPrimaryKeySelective(CodeRule record) throws Exception;

    int updateByPrimaryKey(CodeRule record) throws Exception;
}