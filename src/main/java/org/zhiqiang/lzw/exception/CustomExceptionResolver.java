package org.zhiqiang.lzw.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器：
 * 异常逐层往上抛时，到dispacherServlet(springMVC的前端控制器)时被捕获，
 * 交由全局的异常处理器处理
 * @author LZW
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{
	
	private static final Logger logger = Logger.getLogger(CustomExceptionResolver.class);
	/**
	 * 其中handler就是处理器适配器要执行的handler（只有一个controller中映射的方法）
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		//构建ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		//错误信息
		String message = ex.getMessage();
		
		//进行异常处理
		if (ex instanceof CustomException) {
			logger.info("全局异常处理器捕获到自定义异常CustomException...");
		}else if (ex instanceof NoOwnPrivilegeException) {
			logger.info("全局异常处理器捕获到自定义异常NoOwnPrivilegeException...");
		}else {
			logger.info("全局异常处理器捕获到其他系统异常...");
			ex.printStackTrace();
			message = "未知错误";
		}
		
		//将异常信息保存到request域中
		modelAndView.addObject("errorInfo", message);
		//指向错误页面
		modelAndView.setViewName("page/newPagePlan/error");
		
		return modelAndView;
	}

}
