package org.zhiqiang.lzw.entity.custom;

import java.util.List;

import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.Role;

/**
 * 角色自定义
 * @author LZW
 *
 */
public class RoleCustom extends Role{
	//角色拥有的权限
	private List<Privilege> privileges;

	
	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}
