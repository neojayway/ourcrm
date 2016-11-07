package org.zhiqiang.lzw.entity.custom;

import java.util.List;

import org.zhiqiang.lzw.entity.Group;
import org.zhiqiang.lzw.entity.User;

/**
 * 部门扩展类
 * @author LZW
 *
 */
public class GroupCustom extends Group{
	
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
