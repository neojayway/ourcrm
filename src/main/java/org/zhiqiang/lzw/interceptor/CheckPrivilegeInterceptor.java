package org.zhiqiang.lzw.interceptor;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.custom.UserCustom;
import org.zhiqiang.lzw.exception.CustomException;
import org.zhiqiang.lzw.exception.NoOwnPrivilegeException;

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
		String requestURI = request.getRequestURI();
		String privilegeURL = requestURI.replace("/ourcrm", "");
		logger.info("privilegeURL"+privilegeURL);
		
		//提取当前访问的url
		String servletPath = request.getServletPath();
		//用户url这个键去application域中的privilegeMap中得到对应的权限
		ServletContext application = request.getSession().getServletContext();
		
		Object privilegeObj = application.getAttribute("privilegeMap");
		Map<String, Privilege> privilegeMap = null;
		Privilege privilege = null;
		if (privilegeObj!=null) {
			privilegeMap = (Map<String, Privilege>) privilegeObj;
		}
		if (privilegeMap!=null) {
			//通过请求的URL获得当前访问的权限
			privilege = privilegeMap.get(privilegeURL);
		}
		if (privilege!=null) {
			logger.info("拦截器从application域中拿到privilege.....privilegeCode:"
					+privilege.getPrivilegecode()+"\tprivilegePos:"+privilege.getPrivilegepos());
			if (!privilege.getPrivalegecomm()) {//非公共资源
				Long code = privilege.getPrivilegecode();//当前请求的权限码
				Integer pos = privilege.getPrivilegepos();//权限位
				//从session中拿到保存的userCutom
				HttpSession session = request.getSession();
				Object userCustomObj = session.getAttribute("userCustom");
				if (userCustomObj!=null) {
					UserCustom userCustom = (UserCustom) userCustomObj; //用户对象
					Long[] privilegeSum = userCustom.getPrivilegeSum(); //用户权限总和（一个个权限位的权限总和）
					//当前登录用户的权限总和与当前请求URL对应的权限码做&运算，得出是否具有权限
					Long codeSum = privilegeSum[pos];
					if (codeSum==null) {
						throw new NoOwnPrivilegeException("很遗憾，您不具备‘"+privilege.getPrivilegename()+"’的权限!!!"); 
					}
					if ((codeSum & code)>0) {//有权限
						return true;
					}else {//没有权限
						throw new NoOwnPrivilegeException("很遗憾，您不具备‘"+privilege.getPrivilegename()+"’的权限!!!");
					}
				}else {
					//当前没有登录
					throw new CustomException("当前未登录！");
				}
			}else {//公共资源直接放行
				return true;
			}
		}else {
			//当前请求在application域中没有找到匹配的权限
			throw new NoOwnPrivilegeException("当前权限未被创建!!!");
		}
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
