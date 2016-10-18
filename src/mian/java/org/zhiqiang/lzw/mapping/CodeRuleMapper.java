package org.zhiqiang.lzw.mapping;

import org.zhiqiang.lzw.entity.CodeRule;

public interface CodeRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeRule record);

    int insertSelective(CodeRule record);

    CodeRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeRule record);

    int updateByPrimaryKey(CodeRule record);
}