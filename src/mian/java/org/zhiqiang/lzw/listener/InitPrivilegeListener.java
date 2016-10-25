package org.zhiqiang.lzw.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.service.IPrivilegeService;

/**
 * 此监听器在IOC容器一初始化就启动执行，用于将所有权限保存到Application域中，
 * 因为service Bean被IOC容器管理，所有要监听IOC容器初始化完毕这个事件
 * @author LZW
 *
 */
@Component
public class InitPrivilegeListener implements ApplicationListener<ContextRefreshedEvent>,ServletContextAware{
	private static final Logger logger = Logger.getLogger(InitPrivilegeListener.class);
	//注入权限业务层
	@Autowired
	@Qualifier("privilegeService")
	private IPrivilegeService privilegeService;
	
	//接口spring注入的ServletContext对象
	private ServletContext application;
	
	/**
	 * 在运行期，ApplicationContext会自动在当前的所有bean中寻找ApplicationListener接口的实现，
	 * 并将其作为事件接收对象。当Application.publishEvent方法被调用时，所欲的ApplicationListener
	 * 接口都会被激发，发布的事件会被其捕获，ApplicationListener可根据事件的类型判断是否是自己需要处理的事件
	 * ，这里只处理ContextRefreshedEvent，该事件是IOC容器被初始化或者IOC被刷新时被发布。
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
<<<<<<< HEAD
=======
		logger.info("InitPrivilegeListener...监听器监听到IOC容器初始化完毕");
		application.setAttribute("user", "张三");
>>>>>>> branch 'master' of git@github.com:redmushroom1/ourcrm.git
		/*//得到IOC容器
		ApplicationContext context = event.getApplicationContext();
		List<Privilege> privilegeList = privilegeService.selectAll();
		if (privilegeList!=null && privilegeList.size()>0) {
			//将权限集合转换为map,url作为键，权限码作为值，权限码用于和user中的权限总和进行&位运算，判断是否具有权限
			Map<String, Privilege> privilegeMap = new HashMap<String,Privilege>();
			for (Privilege privilege : privilegeList) {
				privilegeMap.put(privilege.getPrivilegeurl(),privilege);
			}
			//将map保存至application域中让整个应用共享
			application.setAttribute("privilegeMap", privilegeMap);
		}*/
	}
	
	
	
	/**
	 * 实现ServletContextAware接口，该接口用于注入ServletContext对象的
	 */
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.application = servletContext;
	}

	
	
	public void setPrivilegeService(IPrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}
	
	
	
}
