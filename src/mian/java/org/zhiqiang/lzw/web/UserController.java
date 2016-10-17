package org.zhiqiang.lzw.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.service.IUserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	

	@RequestMapping("/login")
	public String login(Integer userid,Model model){
		User user = userService.login(userid);
		model.addAttribute("user", user);
		return "login_success";
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
