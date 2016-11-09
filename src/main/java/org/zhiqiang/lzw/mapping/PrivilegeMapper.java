package org.zhiqiang.lzw.mapping;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.PrivilegeCodeAndPos;

public interface PrivilegeMapper {
    int deleteByPrimaryKey(Integer privilegeid);

    int insert(Privilege record);

    int insertSelective(Privilege record);
    
    //根据菜单编号查询权限
    Privilege selectByMunuId(String menuId);
    
    //查询所有权限
    List<Privilege> selectAll();
    
    //根据角色Id查询角色所有权限
    List<Privilege> selectPrivilegeByRoleId(Integer rid);
    
    //分页查询权限
    List<Privilege> selectByPage(Map<String, Object> map);
    
    //查询当前最大的权限位以及最大权限为对应的最大权限
    PrivilegeCodeAndPos selectMaximumPos();
    
    //批量删除权限
    public void deletePrivilegeByBatch(Integer[] pids) throws Exception;
    
    //根据权限编号删除角色权限关系记录
    public void deleteRolePrivilegeByPid(Integer pid);
    
    //带条件查询权限的数量
    Integer selectCount(String privilegeName);
    
    //根据主键查询权限
    Privilege selectByPrimaryKey(Integer privilegeid);
    
    //根据主键更新部分列
    void updateByPrimaryKeySelective(Privilege privilege);

    int updateByPrimaryKey(Privilege record);
}