package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.OperateLog;
import org.zhiqiang.lzw.mapping.OperateLogMapper;
import org.zhiqiang.lzw.service.OperateLogService;

@Service("operateLogService")
public class OperateLogServiceImpl implements OperateLogService{

	@Autowired
	private OperateLogMapper operateLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return operateLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OperateLog record) {
		// TODO Auto-generated method stub
		return operateLogMapper.insert(record);
	}

	@Override
	public int insertSelective(OperateLog record) {
		// TODO Auto-generated method stub
		return operateLogMapper.insertSelective(record);
	}

	@Override
	public OperateLog selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return operateLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(OperateLog record) {
		// TODO Auto-generated method stub
		return operateLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(OperateLog record) {
		// TODO Auto-generated method stub
		return operateLogMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(OperateLog record) {
		// TODO Auto-generated method stub
		return operateLogMapper.updateByPrimaryKey(record);
	}

}
