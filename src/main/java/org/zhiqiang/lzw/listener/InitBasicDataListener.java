package org.zhiqiang.lzw.listener;

import java.util.List;
import javax.servlet.ServletContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.zhiqiang.lzw.entity.DictionaryType;
import org.zhiqiang.lzw.service.IDictionaryTypeService;

/**
 * 此监听器在IOC容器一初始化就启动执行，用于将所有权限保存到Application域中，
 * 因为service Bean被IOC容器管理，所有要监听IOC容器初始化完毕这个事件
 * @author LZW
 *
 */
@Component
public class InitBasicDataListener implements ApplicationListener<ContextRefreshedEvent>,ServletContextAware{
	
	private static final Logger logger = Logger.getLogger(InitBasicDataListener.class);
	
	//注入基础数据业务层
	@Autowired
	@Qualifier("dictionaryTypeService")
	private IDictionaryTypeService dictionaryTypeService;
	
	public void setDictionaryTypeService(
			IDictionaryTypeService dictionaryTypeService) {
		this.dictionaryTypeService = dictionaryTypeService;
	}
	
	//接口spring注入的ServletContext对象
	private ServletContext application;
	
	/**
	 * 实现ServletContextAware接口，该接口用于注入ServletContext对象的
	 */
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.application = servletContext;
		
	}

	/**
	 * 在运行期，ApplicationContext会自动在当前的所有bean中寻找ApplicationListener接口的实现，
	 * 并将其作为事件接收对象。当Application.publishEvent方法被调用时，所欲的ApplicationListener
	 * 接口都会被激发，发布的事件会被其捕获，ApplicationListener可根据事件的类型判断是否是自己需要处理的事件
	 * ，这里只处理ContextRefreshedEvent，该事件是IOC容器被初始化或者IOC被刷新时被发布。
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		//得到IOC容器
		//ApplicationContext context = event.getApplicationContext();
		
		//得到客户所属行业对应的数据字典
		List<DictionaryType> tradeList = dictionaryTypeService.
			selectDictionaryTypesByCode("trade");
		//将map保存至application域中让整个应用共享
		application.setAttribute("tradeList", tradeList);
		//得到客户所属区域对应的数据字典
		List<DictionaryType> regionNameList = dictionaryTypeService.
			selectDictionaryTypesByCode("regionName");
		application.setAttribute("regionNameList", regionNameList);
		//得到客户所属等级对应的数据字典
		List<DictionaryType> gradeList = dictionaryTypeService.
			selectDictionaryTypesByCode("grade");
		application.setAttribute("gradeList", gradeList);
		//得到客户所属来源对应的数据字典
		List<DictionaryType> sourceList = dictionaryTypeService.
			selectDictionaryTypesByCode("source");
		application.setAttribute("sourceList", sourceList);
		//得到客户所属规模对应的数据字典
		List<DictionaryType> scaleList = dictionaryTypeService.
			selectDictionaryTypesByCode("scale");
		application.setAttribute("scaleList", scaleList);
		//得到客户所属性质对应的数据字典
		List<DictionaryType> qualityList = dictionaryTypeService.
			selectDictionaryTypesByCode("quality");
		application.setAttribute("qualityList", qualityList);
		//得到客户所属经营范围对应的数据字典
		List<DictionaryType> busineScopeList = dictionaryTypeService.
			selectDictionaryTypesByCode("busine_scope");
		application.setAttribute("busineScopeList", busineScopeList);
		//得到客户所属企业性质对应的数据字典
		List<DictionaryType> kindList = dictionaryTypeService.
			selectDictionaryTypesByCode("kind");
		application.setAttribute("kindList", kindList);
		
		List<DictionaryType> glidebitList = 
			dictionaryTypeService.selectDictionaryTypesByCode("glidebit");
		application.setAttribute("glidebitList", glidebitList);
		List<DictionaryType> areatimeList = 
				dictionaryTypeService.selectDictionaryTypesByCode("areatime");
			application.setAttribute("areatimeList", areatimeList);
	}
}
