package org.zhiqiang.lzw.service;

import java.util.List;

import org.zhiqiang.lzw.entity.Log;
import org.zhiqiang.lzw.entity.custom.PageBean;

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
	 * 记录日志到指定日志表
	 * @param tableName
	 * @param log
	 */
	public void recordLogToSpecifiedLogTable(String tableName,Log log);
	
	/**
	 * 通过表名创建日志表
	 * @param tableName
	 * @throws Exception
	 */
	public void createLogTable(String tableName) throws Exception;
	
	/**
	 * 带条件查询操作日志总数
	 * @param tableName 动态指定表名（当前月对应日志表）
	 * @param cnname 操作人模糊查询
	 * @return 日志总数
	 */
    public Integer selectLogCount(String tableName,String cnname);
    
    /**
     * 带条件分页查询
     * @param tableName 动态指定表名（当前月对应日志表）
     * @param cnname 操作人模糊查询
     * @param pageBean 分页信息bean
     * @return 当前页日志集合
     */
    public List<Log> selectLogByPage(String tableName,String cnname,PageBean pageBean); 
}
