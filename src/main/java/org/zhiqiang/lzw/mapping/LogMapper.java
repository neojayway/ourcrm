package org.zhiqiang.lzw.mapping;

import java.util.Map;

import org.zhiqiang.lzw.entity.Log;

public interface LogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Log record);
    
    /**
     * 插入日志到指定日志表
     * @param map
     */
    void insertToSpecifiedLogTable(Map< String, Object> map);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKeyWithBLOBs(Log record);

    int updateByPrimaryKey(Log record);
    
    /**
     * 创建日志表
     * @param tableName
     */
    void createLogTable(String tableName);
}