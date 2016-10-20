package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.custom.UserCustom;

/**
 * 用户业务接口
 * @author LZW
 *
 */
public interface IUserService {
	
	//登录
	public UserCustom login(String name,String password);
	
}
