package org.zhiqiang.lzw.aspect;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.zhiqiang.lzw.entity.Log;
import org.zhiqiang.lzw.entity.custom.UserCustom;
import org.zhiqiang.lzw.service.ILogService;

/**
 * 日志切面（定义了一个记录日志的环绕通知）
 * @author LZW
 *
 */
public class LoggerAspect {
	private static final Logger logger = Logger.getLogger(LoggerAspect.class);
	
	@Autowired
	@Qualifier("logService")
	private ILogService logService;
	/**
	 * 记录
	 * @param joinPoint
	 * @return
	 * @throws Exception 
	 */
	public Object record(ProceedingJoinPoint joinPoint) throws Exception{
		logger.info("进入日志环绕通知...");
		//得到request对象
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = null;
		if (request!=null) {
			session = request.getSession();
		}
		//构建日志实体
		Log log = new Log();
		try {
			if (session!=null) {
				UserCustom userCustom = (UserCustom) session.getAttribute("userCustom");
				if (userCustom!=null) {
					//设置登录用户名称
					log.setUsername("用户编号："+userCustom.getId()+"用户登录名:"+userCustom.getName());
					//设置用户中文名称
					log.setCnname(userCustom.getCnname());
				}
			}
			//操作名称（切点方法名称即可）
			String mname = joinPoint.getSignature().getName();
			log.setActiontype(mname);
			//设置操作日期
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = dateFormat.format(new Date());
			log.setActiondate(dateStr);
			
			
			//设置操作内容
			Object[] args = joinPoint.getArgs();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				sb.append(args[i].toString());
				logger.info("操作参数..."+args[i].toString());
			}
			log.setActioncontent(sb.toString());
			
			//调用切点目标方法
			Object ret = joinPoint.proceed();
			//设置操作结果
			log.setResult("success");
			logger.info("日志切面记录日志成功！");
			return ret;//环绕通知返回切点结果
			
		} catch (Throwable e) {
			logger.info("日志切面记录日志失败！！！");
			log.setResult("failure");
			logger.error(e.getMessage());
		}finally{
			//无论失败与成功都要保存日志
			try {
				//logService.recordLog(log);
				logService.insertToMonthTable(log);
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw e;
			}
		}
		return null;
	}
	
	
	public void setLogService(ILogService logService) {
		this.logService = logService;
	}
	
	
}
