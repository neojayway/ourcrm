package org.zhiqiang.lzw.mapping;


import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Group;

public interface GroupMapper {
    void deleteByPrimaryKey(Integer id) throws Exception;
    
    void insert(Group record) throws Exception;

    void insertSelective(Group record) throws Exception;
    
    /**
     * 带条件分页查询
     * @param groupName
     * @return
     */
    List<Group> selectByPage(Map<String, Object> map);
    
    /**
     * 带条件查询总记录数
     * @param groupName
     * @return
     */
    int selectTotalRecords(String groupName);
    
    /**
     * 批量删除部门
     * @param ids
     */
    void deleteByBatch(Integer[] ids) throws Exception;
    
    
    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKeyWithBLOBs(Group record);

    int updateByPrimaryKey(Group record);
}