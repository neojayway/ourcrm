package org.zhiqiang.lzw.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.entity.custom.UserCustom;

/**
 * 测试json的控制器
 * @author LZW
 *
 */
@Controller
@RequestMapping("/")
public class JsonTestController {
	
	/**
	 * 请求的是json串，返回的也是json串
	 * requestBody将用户信息的json串转换成userCustom的java对象
	 * responseBody将java对象转换成json串
	 * @param userCustom
	 * @return
	 */
	@RequestMapping("/requestJson")
	public @ResponseBody Role requestJson(@RequestBody Role role){
		return role;
	}
	
	@RequestMapping("/requestKeyValue")
	public @ResponseBody Role requestKeyValue(Role role){
		return role;
	}
}
