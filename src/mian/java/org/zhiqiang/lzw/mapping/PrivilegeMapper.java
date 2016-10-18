package org.zhiqiang.lzw.mapping;

import org.zhiqiang.lzw.entity.Privilege;

public interface PrivilegeMapper {
    int deleteByPrimaryKey(Integer privilegeid);

    int insert(Privilege record);

    int insertSelective(Privilege record);

    Privilege selectByPrimaryKey(Integer privilegeid);

    int updateByPrimaryKeySelective(Privilege record);

    int updateByPrimaryKey(Privilege record);
}