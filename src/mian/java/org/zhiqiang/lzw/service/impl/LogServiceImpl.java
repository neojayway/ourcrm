package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Log;
import org.zhiqiang.lzw.mapping.LogMapper;
import org.zhiqiang.lzw.service.ILogService;

/**
 * 日志业务实现
 * @author LZW
 *
 */
@Service("logService")
public class LogServiceImpl implements ILogService{
	
	@Autowired
	@Qualifier("logMapper")
	private LogMapper logMapper;
	
	/**
	 * 记录日志
	 */
	@Override
	public void recordLog(Log log) throws Exception {
		logMapper.insert(log);
	}
	
	
	
	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}
	
	
}
