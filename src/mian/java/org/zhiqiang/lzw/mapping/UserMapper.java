package org.zhiqiang.lzw.mapping;

import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.UserWithBLOBs;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);
}