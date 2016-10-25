package org.zhiqiang.lzw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhiqiang.lzw.entity.custom.UserCustom;
import org.zhiqiang.lzw.exception.CustomException;
import org.zhiqiang.lzw.service.IUserService;

/**
 * 用户后端控制器
 * @author LZW
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	@RequestMapping("/login")
	public String login(String name,String password,HttpServletRequest request,HttpSession session) throws Exception{
		
		UserCustom userCustom =null;
		if (name!=null && !name.trim().isEmpty() 
			&& password!=null && !password.trim().isEmpty()) {
			userCustom = userService.login(name, password);//登录查询
		}
		if (userCustom!=null) {
			//登录成功，将用户信息保存至session域中
			session.setAttribute("userCustom", userCustom);
			return "page/newPagePlan/menu/main";
		}
		return "index";
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
}
