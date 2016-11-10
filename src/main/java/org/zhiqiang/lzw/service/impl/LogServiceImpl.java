package org.zhiqiang.lzw.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Log;
import org.zhiqiang.lzw.entity.custom.PageBean;
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
	
	/**
	 * 记录日志到指定日志表
	 */
	@Override
	public void recordLogToSpecifiedLogTable(String tableName, Log log) {
		Map<String, Object> map = new HashMap<String,Object>();
		if (tableName!=null && log!=null) {
			map.put("tableName", tableName);
			System.out.println(log);
			map.put("log", log);
		}
		logMapper.insertToSpecifiedLogTable(map);
	}
	
	
	
	/**
	 * 生成日志表
	 */
	@Override
	public void createLogTable(String tableName) throws Exception {
		String sql = "create table if not exists "+tableName+" like sys_log";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ourcrm", "root", "123");
		Statement stmt = connection.createStatement();
		boolean execute = stmt.execute(sql);
		try {
			stmt.close();
		} catch (Exception e) {
			throw e;
		}finally{
			connection.close();
		}
	}
	
	/**
	 * 带条件查询操作日志总数
	 * @param tableName 动态指定表名（当前月对应日志表）
	 * @param cnname 操作人模糊查询
	 * @return 日志总数
	 */
	@Override
	public Integer selectLogCount(String tableName, String cnname) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("tableName", tableName);
		map.put("cnname", cnname);
		return logMapper.selectLogCount(map);
	}
	
	
	/**
     * 带条件分页查询
     * @param tableName 动态指定表名（当前月对应日志表）
     * @param cnname 操作人模糊查询
     * @param pageBean 分页信息bean
     * @return 当前页日志集合
     */
	@Override
	public List<Log> selectLogByPage(String tableName, String cnname,
			PageBean pageBean) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("tableName", tableName);
		map.put("cnname", cnname);
		map.put("pageBean", pageBean);
		return logMapper.selectLogByPage(map);
	}

	
	
	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}



	
	
}
