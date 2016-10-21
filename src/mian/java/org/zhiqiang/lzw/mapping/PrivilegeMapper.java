package org.zhiqiang.lzw.mapping;

import java.util.List;

import org.zhiqiang.lzw.entity.Privilege;

public interface PrivilegeMapper {
    int deleteByPrimaryKey(Integer privilegeid);

    int insert(Privilege record);

    int insertSelective(Privilege record);
    
    //根据菜单编号查询权限
    Privilege selectByMunuId(String menuId);
    
    //查询所有权限
    List<Privilege> selectAll();
    
    Privilege selectByPrimaryKey(Integer privilegeid);

    int updateByPrimaryKeySelective(Privilege record);

    int updateByPrimaryKey(Privilege record);
}