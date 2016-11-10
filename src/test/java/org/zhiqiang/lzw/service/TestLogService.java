package org.zhiqiang.lzw.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhiqiang.lzw.entity.Log;
import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.util.LogUtil;

public class TestLogService {
		
	private ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}
	
	/**
	 * 测试日志总数查询
	 */
	@Test
	public void testCount() {
		PageBean pageBean = new PageBean();
		ILogService logService = (ILogService) context.getBean("logService");
		Integer count = logService.selectLogCount(LogUtil.generateLogTableName(0), null);
		System.out.println(count);
		
	}
	
	/**
	 * 测试日志分页查询
	 */
	@Test
	public void testLogByPage() {
		PageBean pageBean = new PageBean();
		pageBean.setCurrPage(2);
		ILogService logService = (ILogService) context.getBean("logService");
		List<Log> logList = logService.selectLogByPage(LogUtil.generateLogTableName(0), null, pageBean);
		for (Log log : logList) {
			System.out.println(log);
		}
	}
}
