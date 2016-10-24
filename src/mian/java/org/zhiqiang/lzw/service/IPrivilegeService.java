package org.zhiqiang.lzw.service;

import java.util.List;

import org.zhiqiang.lzw.entity.Privilege;

/**
 * 权限业务
 * @author LZW
 *
 */
public interface IPrivilegeService {
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<Privilege> selectAll();
	
	/**
	 * 新增权限
	 */
	public void addPrivilege(Privilege privilege);
}
