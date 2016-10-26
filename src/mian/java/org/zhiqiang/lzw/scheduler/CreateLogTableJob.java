package org.zhiqiang.lzw.scheduler;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.zhiqiang.lzw.service.ILogService;
import org.zhiqiang.lzw.util.LogUtil;

/**
 * 创建日志表的任务,每个月定时定点生成下三个月的日志表
 * @author LZW
 *
 */
//@Component("createLogTableJob")
public class CreateLogTableJob extends QuartzJobBean{
	private static final Logger logger = Logger.getLogger(CreateLogTableJob.class);
	//注入日志业务层
	//@Autowired
	//@Qualifier("logService")
	private ILogService logService;
	
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		//通过工具类获得要创建的表名称(下一月)
		try {
			String tableName1 = LogUtil.generateLogTableName(1);
			logService.createLogTable(tableName1);
			logger.info("CreateLogTableJob-->创建下一月日志表成功！！！");
			String tableName2 = LogUtil.generateLogTableName(2);
			logService.createLogTable(tableName2);
			logger.info("CreateLogTableJob-->创建下二月日志表成功！！！");
			String tableName3 = LogUtil.generateLogTableName(3);
			logService.createLogTable(tableName3);
			logger.info("CreateLogTableJob-->创建下三月日志表成功！！！");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	
	public void setLogService(ILogService logService) {
		this.logService = logService;
	}
	
	
	
}
