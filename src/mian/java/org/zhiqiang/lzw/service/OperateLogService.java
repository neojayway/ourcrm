package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.OperateLog;

public interface OperateLogService {
	int deleteByPrimaryKey(Integer id);

    int insert(OperateLog record);

    int insertSelective(OperateLog record);

    OperateLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperateLog record);

    int updateByPrimaryKeyWithBLOBs(OperateLog record);

    int updateByPrimaryKey(OperateLog record);
}
