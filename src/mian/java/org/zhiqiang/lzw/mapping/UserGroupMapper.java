package org.zhiqiang.lzw.mapping;

import org.zhiqiang.lzw.entity.UserGroup;

public interface UserGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKeyWithBLOBs(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}