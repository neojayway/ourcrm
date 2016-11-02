package org.zhiqiang.lzw.service;

import java.util.Map;

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
	
	/**
	 * 通过表名创建日志表
	 * @param tableName
	 * @throws Exception
	 */
	public void createLogTable(String tableName) throws Exception;
	
	/**
     * 插入日志到当前月对应的表中
     * @param map
     */
    void insertToMonthTable(Log log);
}
