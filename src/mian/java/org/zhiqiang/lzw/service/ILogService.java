package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.Log;

/**
 * 日志业务接口
 * @author LZW
 *
 */
public interface ILogService {
	
	/**
	 * 记录日志
	 * @param log
	 */
	public void recordLog(Log log) throws Exception;
}
