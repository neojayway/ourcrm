package org.zhiqiang.lzw.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限验证拦截器：验证所有请求的权限当前用户是否持有
 * @author LZW
 *
 */
public class CheckPrivilegeInterceptor implements HandlerInterceptor{
	private static final Logger logger = Logger.getLogger(CheckPrivilegeInterceptor.class);
	/**
	 * 预处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("拦截器preHandle...");
		logger.info("拦截路劲---》"+request.getRequestURI());
		
		//提取当前访问的url
		String servletPath = request.getServletPath();
		//用户url这个键去application域中的privilegeMap中得到对应的权限
		ServletContext application = request.getSession().getServletContext();
		logger.info("拦截器从application域中拿到数据user....."+application.getAttribute("user"));
		//判断用户是否具有指定的权限
		
		return true;
	}
	
	/**
	 * 后处理：执行时机在controller方法执行结束，在视图渲染之前
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
	/**
	 * 后完成：执行时机在视图渲染之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	
}
